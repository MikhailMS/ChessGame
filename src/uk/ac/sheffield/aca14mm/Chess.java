package uk.ac.sheffield.aca14mm;
/*
Author - Mikhail Molotkov.
Last update - 12/04/2015.
*/
/*
    Main class to run a Chess game. 
*/
public class Chess {
    
    public static void main(String[] args) {
        
        //Initialization of new board.
        Board board = new Board();
        //Initialization of new collections of pieces.
        Pieces blackSet = new Pieces(board,0);
        Pieces whiteSet = new Pieces(board,1);
        //board display
        TextDisplay display = new TextDisplay();
        //Initialization of new HumanPlayers.
        HumanPlayer player1 = new HumanPlayer("Player1",whiteSet,board);        
        AgressivePlayer player2 = new AgressivePlayer("Player2",blackSet,board);        
        //setting opponents
        player1.setOpponent(player2);
        player2.setOpponent(player1);
        //escape values
        int whiteColl = 15;
        int blackColl = 15;
        
        //display the board.
        display.showPiecesOnBoard(player1.getBoard().getData());
        
        //if one of the players loses king, while loop stops.
        while ((player1.getPieces().getPiece(whiteColl).getChar()=='k')&&(player2.getPieces().getPiece(blackColl).getChar()=='K')) {                                 
            System.out.println(player1.toString()+" it is your turn!");
            
            //Getting coordinates from player1.
            player1.getMove();
            //if the move will defeat the opponent's piece then piece will be deleted from the board.
            if (player1.isPieceTaken())
                player1.defeatPiece(player2);
            //otherwise we just move piece.
            else
                player1.justMove();
            
            //check if the first player took opponent's king
            blackColl = player2.getPieces().getNumPieces()-1;             
            if (!(player2.getPieces().getPiece(blackColl).getChar()=='K')){
                System.out.println("Player1 won!");
                break;
            }            
            display.showPiecesOnBoard(player2.getBoard().getData());
            System.out.println(player2.toString()+" it is your turn!");            
            player2.getMove();
            if (player2.isPieceTaken())
                player2.defeatPiece(player1);
            else 
                player2.justMove();
            
            //check if second player took opponent's king.
            whiteColl = player1.getPieces().getNumPieces()-1;           
            if ((player1.getPieces().getPiece(whiteColl).getChar()!='k')){
                System.out.println("Player2 won!");
                break;
            }
            
            display.showPiecesOnBoard(player1.getBoard().getData());
            System.out.print("\nPlayer 1 has "+player1.getPieces().getNumPieces()+" pieces.");
            System.out.println("Player 2 has "+player2.getPieces().getNumPieces()+" pieces.\n");
        }
    }
}