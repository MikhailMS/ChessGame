package uk.ac.sheffield.aca14mm;

import java.util.*;
/*
 * Pawn.java  	1.1 26/01/2015
 *
 * Copyright (c) University of Sheffield 2015
 */

/**
* Pawn.java 
*
* Concrete class to represent a pawn
*
* @version 1.1 26 January 2015
*
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk), Steve Maddock (s.c.maddock@sheffield.ac.uk)
*/


public class Pawn extends Piece {
  
    public Pawn (int ix, int iy, int c, Board b) {
        super(PieceCode.PAWN, ix, iy, c, b);
    }

    // method implements abstract method in Piece class
    // returns a list of available moves of a piece.
    @Override
    public ArrayList<Move> availableMoves() {
        if (getColour()==PieceCode.WHITE) return whitePawn();
        else return blackPawn();
    }

    // method to return Vector of legal moves for a white pawn
    private ArrayList<Move> whitePawn() {  
        int x = getX();
        int y = getY();

        // create a new vector to store legal moves
        ArrayList<Move> v = new ArrayList<Move>();

        // set up m to refer to a Move object  
        Move m = null;

        // first legal move is to go from x,y to x,y+1 if x,y+1 is unoccupied  
        if (!getBoard().occupied(x,y+1)) {
          m = new Move(this, x,y,x,y+1,false);
          v.add(m);
        }

        // second legal move is to go from x,y to x+1,y+1 if x+1,y+1 is occupied 
        // by a black piece
        if (!getBoard().outOfRange(x+1, y+1)
           && getBoard().occupied(x+1, y+1)
           && (getBoard().getPiece(x+1, y+1).getColour()
               !=this.getColour())) {
           m = new Move(this, x,getY(),x+1,y+1,true);
           v.add(m);
        }

        // third legal move is to go from x,y to x-1,y+1 if x-1,y+1 is occupied 
        // by a black piece  
        if (!getBoard().outOfRange(x-1, y+1)
           && getBoard().occupied(x-1, y+1)
           && (getBoard().getPiece(x-1, y+1).getColour()
               !=this.getColour())) {
           m = new Move(this, x,y,x-1,y+1,true);
           v.add(m);
        }

        //fourth legal move if it is a first move of pawn, then it can advance
        //by two cells forward, from x,y to x,y+2 if cell is not occupied
        if (!getBoard().occupied(x,y+2)&&!getBoard().occupied(x, y+1)&&(y==1)) {
            m = new Move(this, x, y, x, y+2, false);
            v.add(m);
        }

        //add null move if vector is empty, otherwise return vector of moves.
        if (v.isEmpty()) v.add(null);
        return v;
  }

    // method to return Vector of legal moves for a black pawn
    private ArrayList<Move> blackPawn() {
        int x = getX();
        int y = getY();

        // create a new vector to store legal moves  
        ArrayList<Move> v = new ArrayList<Move>();

        // set up m to refer to a Move object        
        Move m = null;

        // first legal move is to go from x,y to x,y-1 if x,y-1 is unoccupied  
        if (!getBoard().occupied(x,y-1)) {
          m = new Move(this, x,y,x,y-1,false);
          v.add(m);
        }

        // second legal move is to go from x,y to x+1,y-1 if x+1,y-1 is occupied 
        // by a white piece      
        if (!getBoard().outOfRange(x+1, y-1)
           && getBoard().occupied(x+1, y-1)
           && (getBoard().getPiece(x+1, y-1).getColour()
              !=this.getColour())) {
           m = new Move(this, x,y,x+1,y-1,true);
           v.add(m);
        }

        // third legal move is to go from x,y to x-1,y-1 if x-1,y-1 is occupied 
        // by a white piece       
        if (!getBoard().outOfRange(x-1, y-1)
           && getBoard().occupied(x-1, y-1)
           && (getBoard().getPiece(x-1, y-1).getColour()
              !=this.getColour())) {
           m = new Move(this, x,y,x-1,y-1,true);
           v.add(m);
        }

        //fourth legal move if it is a first move of pawn, then it can advance
        //by two cells forward, from x,y to x,y-2 if cell is not occupied
        if (!getBoard().occupied(x,y-2)&&!getBoard().occupied(x, y-1)&&(y==6)) {
            m = new Move(this, x, y, x, y-2, false);
            v.add(m);
        }

        //add null move if vector is empty, otherwise return vector of moves.
        if (v.isEmpty()) v.add(null);
        return v;
    }
}