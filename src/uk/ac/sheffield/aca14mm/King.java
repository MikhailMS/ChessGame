package uk.ac.sheffield.aca14mm;
/*
Author - Mikhail Molotkov.
Last update - 28/03/2015.
*/
/*
    King class represent a piece - king, extends Piece super class.
*/

import java.util.*;

public class King extends Piece {
    
    //constructor of King piece.
    //parameters: initial coordinates(x,y); colour(c); board, where piece is hold(b).
    public King (int ix, int iy, int c, Board b) {
        super(PieceCode.KING, ix, iy, c, b);
    }
    // method implements abstract method in Piece class
    // returns a list of available moves of a piece.
    @Override
    public ArrayList<Move> availableMoves() {
        if (getColour()==PieceCode.WHITE) return whiteKing();
        else return blackKing();
    }

    // method to return Vector of legal moves for a white King
    private ArrayList<Move> whiteKing() {
        int x = getX();
        int y = getY();

        //create a new vector to store legal moves
        ArrayList<Move> v = new ArrayList<Move>();

        // set up m to refer to a Move object  
        Move m = null;

        //first set of legal moves - forward, if cell is/isn't occupied
        if (getBoard().outOfRange(x, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x, y+1)) {
                m = new Move(this, x,y, x,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x, y+1)&&(getBoard().getPiece(x, y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x,y+1, true);
                v.add(m);
            }
        }
        //second set of legal moves - forward right, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y+1)) {
                m = new Move(this, x,y, x+1,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y+1)&&(getBoard().getPiece(x+1,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y+1, true);
                v.add(m);
            }
        }
        //third set of legal moves - right, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y)) {
                m = new Move(this, x,y, x+1,y, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y)&&(getBoard().getPiece(x+1,y).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y, true);
                v.add(m);
            }
        }
        //fourth set of legal moves - backward and right, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y-1)) {
                m = new Move(this, x,y, x+1,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y-1)&&(getBoard().getPiece(x+1, y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y-1, true);
                v.add(m);
            }
        }
        //fifth set of legal moves - backward, if cell is/isn't occupied
        if (getBoard().outOfRange(x, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x, y-1)) {
                m = new Move(this, x,y, x,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x, y-1)&&(getBoard().getPiece(x, y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x,y-1, true);
                v.add(m);
            }
        }
        //sixth set of legal moves - backward and left, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1,y-1)) {
                m = new Move(this, x,y, x-1,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y-1)&&(getBoard().getPiece(x-1, y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1, y-1, true);
                v.add(m);
            }
        }
        //seventh set of legal moves - left, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1, y)){
                m = new Move(this, x,y, x-1,y, false);
                v.add(m);
            }
            if(getBoard().occupied(x-1, y)&&(getBoard().getPiece(x-1, y).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y, true);
                v.add(m);
            }
        }
        //eighth set of legal moves - forward and left, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1, y+1)) {
                m = new Move(this, x,y, x-1,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y+1)&&(getBoard().getPiece(x-1,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y+1, true);
                v.add(m);
            }
        }
        return v;
    }

    // method to return Vector of legal moves for a black king
    private ArrayList<Move> blackKing() {
        int x = getX();
        int y = getY();

        //create a new vector to store legal moves
        ArrayList<Move> v = new ArrayList<Move>();     
        // set up m to refer to a Move object  
        Move m = null;

        //first set of legal moves - backward, if cell is/isn't occupied
        if (getBoard().outOfRange(x, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x, y+1)) {
                m = new Move(this, x,y, x,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x, y+1)&&(getBoard().getPiece(x, y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x,y+1, true);
                v.add(m);
            }
        }
        //second set of legal moves - backward left, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y+1)) {
                m = new Move(this, x,y, x+1,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y+1)&&(getBoard().getPiece(x+1,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y+1, true);
                v.add(m);
            }
        }
        //third set of legal moves - left, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y)) {
                m = new Move(this, x,y, x+1,y, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y)&&(getBoard().getPiece(x+1,y).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y, true);
                v.add(m);
            }
        }
        //fourth set of legal moves - forward and left, if cell is/isn't occupied
        if (getBoard().outOfRange(x+1, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x+1, y-1)) {
                m = new Move(this, x,y, x+1,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x+1, y-1)&&(getBoard().getPiece(x+1, y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+1,y-1, true);
                v.add(m);
            }
        }
        //fifth set of legal moves - forward, if cell is/isn't occupied
        if (getBoard().outOfRange(x, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x, y-1)) {
                m = new Move(this, x,y, x,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x, y-1)&&(getBoard().getPiece(x, y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x,y-1, true);
                v.add(m);
            }
        }
        //sixth set of legal moves - forward and right, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y-1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1,y-1)) {
                m = new Move(this, x,y, x-1,y-1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y-1)&&(getBoard().getPiece(x-1, y-1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1, y-1, true);
                v.add(m);
            }
        }
        //seventh set of legal moves - right, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1, y)){
                m = new Move(this, x,y, x-1,y, false);
                v.add(m);
            }
            if(getBoard().occupied(x-1, y)&&(getBoard().getPiece(x-1, y).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y, true);
                v.add(m);
            }
        }
        //eighth set of legal moves - backward and right, if cell is/isn't occupied
        if (getBoard().outOfRange(x-1, y+1))
            v.add(null);
        else {
            if (!getBoard().occupied(x-1, y+1)) {
                m = new Move(this, x,y, x-1,y+1, false);
                v.add(m);
            }
            if (getBoard().occupied(x-1,y+1)&&(getBoard().getPiece(x-1,y+1).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-1,y+1, true);
                v.add(m);
            }
        }
        return v;
    }
}