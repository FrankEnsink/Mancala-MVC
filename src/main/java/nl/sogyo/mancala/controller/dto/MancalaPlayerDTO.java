package nl.sogyo.mancala.controller.dto;

public class  MancalaPlayerDTO {
	private String namePlayerOne; 
	private String namePlayerTwo;
	
	public  MancalaPlayerDTO() {}
	public  MancalaPlayerDTO(String namePlayerOne, String namePlayerTwo) {
		this.namePlayerOne = namePlayerOne;
		this.namePlayerTwo = namePlayerTwo;
	}
	
	public String getNamePlayerOne() {
		return namePlayerOne;
	}
	public String getNamePlayerTwo() {
		return namePlayerTwo;
	}
	
	
	
}
