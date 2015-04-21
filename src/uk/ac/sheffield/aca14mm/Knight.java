package uk.ac.sheffield.aca14mm;
/*
Author - Mikhail Molotkov.
Last update - 12/04/2015.
*/
/*
    Knight class represent a piece - knight, extends Piece super class.
*/

import java.util.*;

public class Knight extends Piece {

    public Knight (int ix, int iy, int c, Board b) {
      super(PieceCode.KNIGHT, ix, iy, c, b);
    }

    // method implements abstract method in Piece class
    @Override
    public ArrayList<Move> availableMoves() {
      if (getColour()==PieceCode.WHITE) return whiteKnight();
      else return blackKnight();
    }

    // method to return Vector of legal moves for a white Knight
    private ArrayList<Move> whiteKnight() {
        int x = getX();
        int y = getY();

        //create a new vector to store legal moves
        ArrayList<Move> v = new ArrayList<Move>();

        // set up m to refer to a Move object  
        Move m = null;

        //first set of legal moves - from x,y, to x+1,y+2, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y+2))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y+2)) {
                m = new Move(this, x,y, x+1,y+2, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y+2)&&(getBoard().getPiece(x+1, y+2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y+2, true);
                v.add(m);
            }
        }
        //second set of legal moves - from x,y, to x+2,y+1, if cell is/isn't occupied
        if (getBoard().outOfRange(x+2, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+2,y+1)) {
                m = new Move(this, x,y, x+2,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+2,y+1)&&(getBoard().getPiece(x+2,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+2,y+1, true);
                v.add(m);
            }
        }
        //third set of legal moves - from x,y, to x+2,y-1, if cell is/isn't occupied
        if (getBoard().outOfRange(x+2, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+2,y-1)) {
                m = new Move(this, x,y, x+2,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+2,y-1)&&(getBoard().getPiece(x+2,y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+2,y-1, true);
                v.add(m);
            }
        }
        //fourth set of legal moves - from x,y, to x+1,y-2, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y-2))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1,y-2)) {
                m = new Move(this, x,y, x+1,y-2, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1,y-2)&&(getBoard().getPiece(x+1,y-2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y-2, true);
                v.add(m);
            }
        }
        //fifth set of legal moves - from x,y, to x-1,y-2, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y-2))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1,y-2)) {
                m = new Move(this, x,y, x-1,y-2, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y-2)&&(getBoard().getPiece(x-1,y-2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y-2, true);
                v.add(m);
            }
        }
        //sixth set of legal moves - from x,y, to x-2,y-1, if cell is/isn't occupied
        if (getBoard().outOfRange(x-2, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-2,y-1)) {
                m = new Move(this, x,y, x-2,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-2,y-1)&&(getBoard().getPiece(x-2,y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-2,y-1, true);
                v.add(m);
            }
        }
        //seventh set of legal moves - from x,y, to x-2,y+1, if cell is/isn't occupied
        if (getBoard().outOfRange(x-2, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-2,y+1)) {
                m = new Move(this, x,y, x-2,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-2,y+1)&&(getBoard().getPiece(x-2,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-2,y+1, true);
                v.add(m);
            }
        }
        //eighth set of legal moves - from x,y, to x-1,y+2, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y+2))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1,y+2)) {
                m = new Move(this, x,y, x-1,y+2, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y+2)&&(getBoard().getPiece(x-1,y+2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y+2, true);
                v.add(m);
            }
        }
        return v;
    }

    // method to return Vector of legal moves for a black Knight
    private ArrayList<Move> blackKnight() {
        int x = getX();
        int y = getY();

        //create a new vector to store legal moves
        ArrayList<Move> v = new ArrayList<Move>();

        // set up m to refer to a Move object  
        Move m = null;

        //first set of legal moves - from x,y, to x+1,y+2, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y+2))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y+2)) {
                m = new Move(this, x,y, x+1,y+2, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y+2)&&(getBoard().getPiece(x+1, y+2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y+2, true);
                v.add(m);
            }
        }
        //second set of legal moves - from x,y, to x+2,y+1, if cell is/isn't occupied
        if (getBoard().outOfRange(x+2, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+2,y+1)) {
                m = new Move(this, x,y, x+2,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+2,y+1)&&(getBoard().getPiece(x+2,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+2,y+1, true);
                v.add(m);
            }
        }
        //third set of legal moves - from x,y, to x+2,y-1, if cell is/isn't occupied
        if (getBoard().outOfRange(x+2, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+2,y-1)) {
                m = new Move(this, x,y, x+2,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+2,y-1)&&(getBoard().getPiece(x+2,y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+2,y-1, true);
                v.add(m);
            }
        }
        //fourth set of legal moves - from x,y, to x+1,y-2, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y-2))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1,y-2)) {
                m = new Move(this, x,y, x+1,y-2, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1,y-2)&&(getBoard().getPiece(x+1,y-2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y-2, true);
                v.add(m);
            }
        }
        //fifth set of legal moves - from x,y, to x-1,y-2, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y-2))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1,y-2)) {
                m = new Move(this, x,y, x-1,y-2, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y-2)&&(getBoard().getPiece(x-1,y-2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y-2, true);
                v.add(m);
            }
        }
        //sixth set of legal moves - from x,y, to x-2,y-1, if cell is/isn't occupied
        if (getBoard().outOfRange(x-2, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-2,y-1)) {
                m = new Move(this, x,y, x-2,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-2,y-1)&&(getBoard().getPiece(x-2,y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-2,y-1, true);
                v.add(m);
            }
        }
        //seventh set of legal moves - from x,y, to x-2,y+1, if cell is/isn't occupied
        if (getBoard().outOfRange(x-2, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-2,y+1)) {
                m = new Move(this, x,y, x-2,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-2,y+1)&&(getBoard().getPiece(x-2,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-2,y+1, true);
                v.add(m);
            }
        }
        //eighth set of legal moves - from x,y, to x-1,y+2, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y+2))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1,y+2)) {
                m = new Move(this, x,y, x-1,y+2, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y+2)&&(getBoard().getPiece(x-1,y+2).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y+2, true);
                v.add(m);
            }
        }
        return v;
    }
}