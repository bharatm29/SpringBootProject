package io.bharat.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.bharat.model.Game;
import io.bharat.mvc.GameRepository;
import jakarta.persistence.EntityManager;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  @Autowired
  private final EntityManager em;

  @Autowired
  private GameRepository gameRepository; 
  
  @Autowired
  public JobCompletionNotificationListener(EntityManager em) {
    this.em = em;
  }
  
  //This will runs after the job is complete and will give the status of the job.
  @Override
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results"); //This is just for verification
      
      List<Game> games = em.createNativeQuery("SELECT * FROM Game", Game.class).getResultList();
      games.forEach(gameRepository::save);
    }
  }
}