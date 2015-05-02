package uk.ac.sheffield.aca14mm;

/*
	Author - Mikhail Molotkov.
	Last update - 02/05/2015.
	Main class to run a Chess game. 
*/

public class Chess {
    
    public static void main(String[] args) {
    	//Initialization of new board.
        Board board = new Board();
        //Initialization of new HumanPlayers.
        HumanPlayer player1 = new HumanPlayer("Player1",null,board);
        //Initialization of graphic display.
        GraphicDisplay disp = new GraphicDisplay();
        //Setting up a graphic represantion of chess board.
        disp.setPieces(player1.getBoard().getData());
        //Initialization of main game window.
        new MainWindow(disp);       
    }
}