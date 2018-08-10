package nl.sogyo.mancala.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.sogyo.mancala.Mancala;
import nl.sogyo.mancala.controller.dto.MancalaBoardDTO;
import nl.sogyo.mancala.controller.dto.MancalaEndGameDTO;
import nl.sogyo.mancala.controller.dto.MancalaPlayerDTO;

public class MancalaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String action = request.getParameter("action");
						
		String resource = null;
		if ("newGame".equalsIgnoreCase(action)) {
			resource = this.processNewGame(request);
		} else {
			doPostAction(request, response);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(resource);
		requestDispatcher.forward(request, response);
	}

	protected void doPostAction(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String action = request.getParameter("action");
		String[] makeAMoveEnHoleNummer = action.split(" ");
		int holenumber = Integer.parseInt(makeAMoveEnHoleNummer[1]);
		
		
		String resource = null;
		resource = this.processMakeAMove(request, holenumber);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(resource);
		requestDispatcher.forward(request, response);
	}
	
	
	
	private String processMakeAMove(HttpServletRequest request, int holeNumber) {
		HttpSession session = request.getSession();
		Mancala facade = (Mancala) session.getAttribute("bord");
		facade.makeAMove(holeNumber);
		MancalaBoardDTO status = new MancalaBoardDTO(facade.getContentOfEveryPitt());
		
		determineIfEndGame(request);
		
		
		request.setAttribute("mancalaBoardBean", status);
		return "./Mancala.jsp";
	}

	private String processNewGame(HttpServletRequest request) {
		String namePlayerOne = request.getParameter("Player1");
		String namePlayerTwo = request.getParameter("Player2");
		
		MancalaPlayerDTO mancalaPlayerDTO = new MancalaPlayerDTO(namePlayerOne, namePlayerTwo);
		makeBoard(request);

		HttpSession session = request.getSession();

		session.setAttribute("mancalaPlayerBean", mancalaPlayerDTO);

		return "./Mancala.jsp";

	}

	private void determineIfEndGame(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Mancala facade = (Mancala) session.getAttribute("bord");
		
		if(facade.didIWin() == true) {
			String namePlayerOne = ((MancalaPlayerDTO) session.getAttribute("mancalaPlayerBean")).getNamePlayerOne();
			MancalaEndGameDTO endGameStatus = new MancalaEndGameDTO(namePlayerOne +" won the game!");
			request.setAttribute("mancalaEndGameBean", endGameStatus);
		}
		else if(facade.didMyOpponentWin() == true) {
			String namePlayerTwo = ((MancalaPlayerDTO) session.getAttribute("mancalaPlayerBean")).getNamePlayerTwo();
			MancalaEndGameDTO endGameStatus = new MancalaEndGameDTO(namePlayerTwo + " won the game!");
			request.setAttribute("mancalaEndGameBean", endGameStatus);
		}
		else if(facade.ItisATie() == true) {
			MancalaEndGameDTO endGameStatus = new MancalaEndGameDTO(" The game ended in a tie!");
			request.setAttribute("mancalaEndGameBean", endGameStatus);
		}else {
		MancalaEndGameDTO endGameStatus = new MancalaEndGameDTO("Wat een spanning, wie zal er winnen?"); 
		request.setAttribute("mancalaEndGameBean", endGameStatus);
		
		}
		;
	}
	
	private void makeBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Mancala facade = new Mancala();
		session.setAttribute("bord", facade);
		mancalaBoardStatus(request);
	}

	private void mancalaBoardStatus(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Mancala facade = (Mancala) session.getAttribute("bord");
		MancalaBoardDTO status = new MancalaBoardDTO(facade.getContentOfEveryPitt());
		request.setAttribute("mancalaBoardBean", status);
	}

}
