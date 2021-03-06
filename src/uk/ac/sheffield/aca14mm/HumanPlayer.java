package uk.ac.sheffield.aca14mm;

import java.util.Iterator;
import javax.swing.*;

/*
Author - Mikhail Molotkov.
Last update - 22/04/2015

HumanPlayer class extends Player class to implement a player in a game Chess.
Consists of methods:
    HumanPlayer - constructor,
    getMove - gets user input and check if this coordinates are legal.
    makeMove - returns true if the user input is a legal move for a piece.
    getXFrom,getYFrom,getXTo,getYTo - return coordinates of a move.
    isPieceTaken - return true, if the next player's move will defeat the opponent's piece.
    isThereAPiece - returns true if user input tries to move a piece.
    chatToInt - converts letter from input to an integer value.
*/
public class HumanPlayer extends Player {
    
    //private variables - moves array stores players move coordinates;
    //pieceTaken - boolean variable helps to know if the opponent's piece is taken.
    private int[] moves = new int[4];
    private boolean pieceTaken = false;
    
    //Constructor of HumanPlayer class.
    public HumanPlayer(String name, Pieces p, Board b){
        super(name, p, b, null);
    }

    //method obtains user input, checks it for validity, and if move is legal - proceed further.
    public void getMove(String m){
        String coordinates;
        int x=0,xMove=0;
        coordinates = m;
        if (coordinates.length()==5){
            moves[0]= x = charToInt(coordinates.charAt(0));
            moves[2]= xMove = charToInt(coordinates.charAt(3));
            if (x==8||xMove==8)
            	JOptionPane.showMessageDialog(null,"Your coordinates are outside the range!");
            else {
                moves[1]= Integer.parseInt(coordinates.substring(1, 2))-1;
                moves[3]= Integer.parseInt(coordinates.substring(4))-1;
            }
            if (!isThereAPiece()||!makeMove()) 
            	JOptionPane.showMessageDialog(null,"Your coordinates are incorrect!");
            else {
                setMove();
                if(isMoveOK()) {
                	if(pieceTaken)
                    	defeatPiece(this.getOpponent());
                    else
                    	justMove();
                }                    	
            }
        }           
        else 
        	JOptionPane.showMessageDialog(null,"Your move is not full!");
    }
    
    //return true if it is possible to make a move
    @Override
    public boolean makeMove(){
        for (Iterator<Move> it = getBoard().getPiece(moves[0], moves[1]).availableMoves().iterator(); it.hasNext();) {
            Move item = it.next();
            if (item==null)
                System.out.print("");
            else if((item.getToX()==moves[2]&&item.getToY()==moves[3])&&((getBoard().getPiece(moves[0],moves[1]).getColourChar()==getPieces().getPiece(0).getColourChar()))){
                System.out.print("");
                if(item.isTaken())
                    pieceTaken = true;
                return true;
            }
            else
                System.out.print("");
        }
        return false;
    }
    
    //private accessors return coordinates of movement.
    private int getXFrom(){return moves[0];}
    private int getYFrom(){return moves[1];}
    private int getXTo() {return moves[2];}
    private int getYTo() {return moves[3];}
    //accessor returns true if player can take a piece
    public boolean isPieceTaken() {return pieceTaken;}
    
    //return true if initial coordinates contain piece.
    private boolean isThereAPiece(){
        return !(getBoard().getPiece(moves[0], moves[1]) == null);
    }
    
    //return an integer value for a letter input;
    private int charToInt(char letter) {
        switch(Character.toLowerCase(letter)){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                return 8;
        }
    }  
    
    //method moves player's piece
    private void justMove() {
        this.getBoard().getPiece(this.getXFrom(), this.getYFrom()).setPosition(this.getXTo(), this.getYTo());
        this.getBoard().setPosition(this.getXTo(), this.getYTo(), this.getBoard().getPiece(this.getXFrom(), this.getYFrom()));                
        this.getBoard().remove(this.getXFrom(), this.getYFrom());
    }
    //method defeats opponent's piece
    private void defeatPiece(Player op) {
        op.deletePiece(op.getBoard().getPiece(this.getXTo(), this.getYTo()));
        justMove();
    }
}