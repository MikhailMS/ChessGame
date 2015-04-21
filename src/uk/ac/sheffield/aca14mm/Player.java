package uk.ac.sheffield.aca14mm;

import java.util.*;
/*
 * Player.java  	1.1 26/01/2015
 *
 * Copyright (c) University of Sheffield 2015
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
  
  //method sets opponent
  public void setOpponent(Player p) {
    opponent = p;
  }
  
  //method returns pieces
  public Pieces getPieces() {
    return pieces;
  }
  
  //abstract method returns move
  public abstract boolean makeMove();
  
  //method deletes piece
  public void deletePiece(Piece p) {
    pieces.delete(p);
  }
  
  //method returns name
  public String toString() {
    return name;
  }

}