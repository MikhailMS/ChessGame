package uk.ac.sheffield.aca14mm;

import java.util.*;
/*
 * Player.java  	1.1 26/01/2015
 *
 * Copyright (c) University of Sheffield 2015
 */
/*
 * Some extra methods were placed into this class
 * getMove(String) - method to produce a move in a final version.
 * isPieceTaken() - method returns true if the move defeats opponent's piece
 * isMoveOK() - method returns value of moveStart variable.
 * setMove() - method sets moveStart to be true.
 * setMoveBack() - methods sets initial value of moveStart.
 */
/**
* Player.java 
*
* Abstract class to represent a chess player
*
* @version 1.1 26 January 2015
*
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk), Steve Maddock (s.c.maddock@sheffield.ac.uk)
*/
public abstract class Player {

	  public static final int BLACK = 0;
	  public static final int WHITE = 1;
	  
	  private boolean moveStart = false;
	  private String name;
	  private Pieces pieces;
	  private Board board;
	  private Player opponent;
	  
	  //Player constructor
	  public Player (String n, Pieces p, Board b, Player o) {
	    name = n;
	    pieces = p;
	    board = b;
	    opponent = o;
	  }
	  
	  //method returns board
	  public Board getBoard() {
	    return board;
	  }	  
	  //method returns opponent
	  public Player getOpponent() {
	    return opponent;
	  }
	//method returns pieces
	  public Pieces getPieces() {
	    return pieces;
	  }
	  
	  //method sets opponent
	  public void setOpponent(Player p) {
	    opponent = p;
	  }
	  //method sets pieces
	  public void setPieces(Pieces p) {
		  pieces = p;
	  }
	  //method sets board.
	  public void setBoard(Board b) {
		  board = b;
	  }
	  //New methods to control flow of the game in window.
	  public boolean isMoveOK(){return moveStart;}
	  public void setMove(){moveStart = true;}
	  public void setMoveBack(){moveStart = false;}
	  
	  //abstract method returns true if there is at least one legal move.
	  public abstract boolean makeMove();
	  //abstract method set moves.
	  public abstract void getMove(String m);
	  //abstract methods returns if the move will defeat opponents piece.
	  public abstract boolean isPieceTaken();
	  
	  //method deletes piece
	  public void deletePiece(Piece p) {
	    pieces.delete(p);
	  }
	  
	  //method returns name
	  public String toString() {
	    return name;
	  }
	
}