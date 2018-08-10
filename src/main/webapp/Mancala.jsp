<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Mancala</title>
<style>
h2, h3{
	color: rgb(0,121,54);
    text-align: center;}

.center{
	display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;}
body {
    font-size:2vw;          
    font-family: monospace;
    text-align: center;}
    
#game {
	text-align: center;
    display: flex;
    position: relative;
    flex-direction: column;
    justify-content: center;
    display: inline-block;
    width: 70%;
    min-width: 1000px;
    margin: auto;
    height: auto;
    padding-top: 5%;      
   
    }
.board {
	display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;}    
.endGameScreen {

	margin-left: auto;
    margin-right: auto;
    margin-top: 40px;
	text-align: center;
	color: rgb(0,121,54);
	background-color: white;
	width: 800px;
	height: 200px;
	border: 4px solid black;
	border-color: rgb(0,121,54);
}    

.kalahap1 {
	text-align: center;
    height: 400px;
    color: rgb(0,121,54);
    line-height: 133px; 
    width: 240px;
    margin-top: 100px;
    float: right;
    border: 1px solid black;
    color: white;
    background-color: rgb(0,121,54);}
    
.kalahap2 {
	text-align: center;
	height: 400px;
    background-color: rgb(0,121,54);
    text-align: center;
	vertical-align: middle;
	line-height: 133px; 
    width: 200px;
    float: left;
    margin-top: 100px;
    color: white;    
    display: inline-block;
    border: 1px solid black;
}    
.hole {
    font-size: large;
    height: 180px;
    width: 180px;
    float: left;
    border: 1px solid black;
    background-color: green;
    border-color: white;
    color: white;
    }
.hole:hover {
    cursor: pointer;}
    
.left {
    border-left: none;}
    
.right {
    border-right: none;}
    
.middle{
	border-left: none;
	}
	
.top {
    border-top: none;}

.bottom {
    border-bottom: none;}    


    
</style>
</head>
<body>
	
	<h2>Mancala</h2>
	<form action="play.do" method="post">
		<jsp:useBean id="mancalaBoardBean"
		class="nl.sogyo.mancala.controller.dto.MancalaBoardDTO" scope="request" /> 
		<jsp:useBean id="mancalaPlayerBean"	class="nl.sogyo.mancala.controller.dto.MancalaPlayerDTO" scope="session" /> 
		  
		 <div id="board center" >
				<div class = "kalahap1 " ><jsp:getProperty name="mancalaPlayerBean" property="namePlayerOne" /><br><jsp:getProperty name="mancalaBoardBean"
					property="kalahap1Content"/></div>
				<div class = "kalahap2"><jsp:getProperty name="mancalaPlayerBean" property="namePlayerTwo"/><br><jsp:getProperty name="mancalaBoardBean"
					property="kalahap2Content"/>
					</div>
			<div id="game">	
				
				
				<button class = "hole" name="action" value="makeAMove 13" type="submit" ><jsp:getProperty name="mancalaBoardBean"
					property="hole12Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 12" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole11Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 11" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole10Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 10" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole9Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 9" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole8Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 8" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole7Content"/></button>	
						 
			</div>			
							
			<div id="game">
				
				<button class = "hole " name="action" value="makeAMove 1" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole1Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 2" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole2Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 3" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole3Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 4" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole4Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 5" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole5Content"/></button>
				<button class = "hole middle" name="action" value="makeAMove 6" type="submit"><jsp:getProperty name="mancalaBoardBean"
					property="hole6Content"/></button>					 
			
			</div>	
				<div>
					<jsp:useBean id="mancalaEndGameBean"
					class="nl.sogyo.mancala.controller.dto.MancalaEndGameDTO" scope="request"/>	
					<div class = "endGameScreen "><jsp:getProperty name="mancalaEndGameBean" property="gameStateText"/>	
										
					</div>
					
					
				</div>
		</div>	
		</form>	
	<div>
	
	</div>
	
		
		
	
		
	
</body>
</html>