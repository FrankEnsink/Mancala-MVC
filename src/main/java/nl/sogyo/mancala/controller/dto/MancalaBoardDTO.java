package nl.sogyo.mancala.controller.dto;

import java.util.ArrayList;

public class MancalaBoardDTO {

	private ArrayList<Integer> staatVanHetBord;

	public MancalaBoardDTO() {
	}

	public MancalaBoardDTO(ArrayList<Integer> bordStatus) {

		this.staatVanHetBord = bordStatus;
	}

	public ArrayList<Integer> getStaatVanHetBord() {

		return staatVanHetBord;
	}

	public String getHole1Content() {
		return Integer.toString(staatVanHetBord.get(0));

	}

	public String getHole2Content() {
		return Integer.toString(staatVanHetBord.get(1));
	}

	public String getHole3Content() {
		return Integer.toString(staatVanHetBord.get(2));

	}

	public String getHole4Content() {
		return Integer.toString(staatVanHetBord.get(3));
	}

	public String getHole5Content() {
		return Integer.toString(staatVanHetBord.get(4));

	}

	public String getHole6Content() {
		return Integer.toString(staatVanHetBord.get(5));
	}

	public String getHole7Content() {
		return Integer.toString(staatVanHetBord.get(7));

	}

	public String getHole8Content() {
		return Integer.toString(staatVanHetBord.get(8));
	}

	public String getHole9Content() {
		return Integer.toString(staatVanHetBord.get(9));

	}

	public String getHole10Content() {
		return Integer.toString(staatVanHetBord.get(10));
	}

	public String getHole11Content() {
		return Integer.toString(staatVanHetBord.get(11));

	}

	public String getHole12Content() {
		return Integer.toString(staatVanHetBord.get(12));
	}

	public String getKalahap1Content() {
		return Integer.toString(staatVanHetBord.get(6));

	}

	public String getKalahap2Content() {
		return Integer.toString(staatVanHetBord.get(13));

	}

}