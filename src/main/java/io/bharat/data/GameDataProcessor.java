package io.bharat.data;

import org.springframework.batch.item.ItemProcessor;

import io.bharat.model.*;

public class GameDataProcessor implements ItemProcessor<GameData, Game>{

	@Override
	public Game process(GameData gameData) throws Exception {
		Game processedGameData = new Game();
		
		long rank = Long.parseLong(gameData.getRank()) + 1;
		processedGameData.setRank(String.valueOf(rank));
		processedGameData.setBacklogs(gameData.getBacklogs());
		processedGameData.setGenres(gameData.getGenres());
		processedGameData.setNumberOfReviews(gameData.getNumber_of_reviews());
		processedGameData.setPlaying(gameData.getPlaying());
		processedGameData.setPlays(gameData.getPlays());
		processedGameData.setRating(gameData.getRating());
		processedGameData.setTimesListed(gameData.getTimes_listed());
		processedGameData.setTeam(gameData.getTeam());
		processedGameData.setWishlist(gameData.getWishlist());
		processedGameData.setTitle(gameData.getTitle());
		
		return processedGameData;
	}
	
}
