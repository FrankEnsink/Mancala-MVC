package nl.sogyo.mancala.controller.dto;



public class MancalaEndGameDTO {

	private String gameStateText;
		
	public MancalaEndGameDTO() {}
	
	public MancalaEndGameDTO(String gameStateText) {
	
	this.gameStateText = gameStateText;
	}
	
	public String getGameStateText() {
		return gameStateText;
	}
}