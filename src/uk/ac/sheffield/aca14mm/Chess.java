package uk.ac.sheffield.aca14mm;

/*
	Author - Mikhail Molotkov.
	Last update - 11/05/2015.
	
	Main class to run a Chess game. 
*/

public class Chess {
    
    public static void main(String[] args) {
    	//Initialization of new board.
        Board board = new Board();
        //Initialization of graphic display.
        GraphicDisplay disp = new GraphicDisplay();
        //Setting up a graphic representation of chess board.
        disp.setPieces(board.getData());
        //Initialization of main game window.
        new MainWindow(disp);       
    }
}