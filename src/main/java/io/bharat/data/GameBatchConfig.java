package io.bharat.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import io.bharat.model.Game;
import io.bharat.model.GameData;

@Configuration
public class GameBatchConfig {
	
	@Bean
	public FlatFileItemReader<GameData> reader() {
	  return new FlatFileItemReaderBuilder<GameData>()
	    .name("personItemReader")
	    .resource(new ClassPathResource("gamesupdated.csv"))
	    .delimited()
	    .names(new String[]{"rank", "title", "team", "rating", "times_listed", "number_of_reviews", "genres", "plays", "playing", "backlogs", "wishlist"})
	    .fieldSetMapper(new BeanWrapperFieldSetMapper<GameData>() {{
	      setTargetType(GameData.class);
	    }}).linesToSkip(1)
	    .build();
	}
	
	@Bean
	public GameDataProcessor processor() {
	  return new GameDataProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<Game> writer(DataSource dataSource) {
		//Since the table will be created by JPA and JPA uses underscore rather than camel case in it's tables, we have to define column name as underscores.
	  return new JdbcBatchItemWriterBuilder<Game>()
	    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	    .sql("INSERT INTO game (rank, title, team, rating, times_listed, number_of_reviews, genres, plays, playing, backlogs, wishlist) "
	       + "VALUES (:rank, :title, :team, :rating, :timesListed, :numberOfReviews, :genres, :plays, :playing, :backlogs, :wishlist)")
	    .dataSource(dataSource)
	    .build();
	}
	
	@Bean
	public Job importUserJob(JobRepository jobRepository,
	    JobCompletionNotificationListener listener, Step step1) {
	  return new JobBuilder("importUserJob", jobRepository)
	    .incrementer(new RunIdIncrementer())
	    .listener(listener)
	    .flow(step1)
	    .end()
	    .build();
	}

	//The step which the job will perform
	@Bean
	public Step step1(JobRepository jobRepository,
	    PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Game> writer) {
	  return new StepBuilder("step1", jobRepository)
	    .<GameData, Game> chunk(10, transactionManager)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer)
	    .build();
	}
}
