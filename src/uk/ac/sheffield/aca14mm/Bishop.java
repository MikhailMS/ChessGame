package uk.ac.sheffield.aca14mm;
/*
Author - Mikhail Molotkov.
Last update - 12/04/2015.
*/
/*
    Bishop class represent a piece - bishop, extends Piece super class.
*/

import java.util.*;

public class Bishop extends Piece {

    // constructor of Bishop piece.
    // params : initial coordinates(x,y); colour of a piece(c); which board contains that piece(b).
    public Bishop (int ix, int iy, int c, Board b) {
        super(PieceCode.BISHOP, ix, iy, c, b);
    }

    // method implements abstract method in Piece class
    // returns a list of available moves.
    @Override
    public ArrayList<Move> availableMoves() {
        if (getColour()==PieceCode.WHITE) return whiteBishop();
        else return blackBishop();
    }

    // method returns Vector of legal moves for a white Bishop
    private ArrayList<Move> whiteBishop() {
        int x = getX();
        int y = getY();

        //create a new vector to store legal moves
        ArrayList<Move> v = new ArrayList<Move>();

        // set up m to refer to a Move object  
        Move m = null;

        //first set of legal moves - from x,y, to x+i,y+i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x+i, y+i))
                break;
            else if (getBoard().occupied(x+i,y+i)&&(getBoard().getPiece(x+i,y+i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x+i, y+i)) {
                m = new Move(this, x,y, x+i,y+i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x+i,y+i)&&(getBoard().getPiece(x+i,y+i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+i,y+i, true);
                v.add(m);
                break;
            }
        }
        //second set of legal moves - from x,y, to x+i,y-i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x+i,y-i))
                break;
            else if (getBoard().occupied(x+i,y-i)&&(getBoard().getPiece(x+i,y-i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x+i,y-i)) {
                m = new Move(this, x,y, x+i,y-i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x+i,y-i)&&(getBoard().getPiece(x+i,y-i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+i,y-i, true);
                v.add(m);
                break;
            }
        }
        //third set of legal moves - from x,y, to x-i,y-i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x-i,y-i))
                break;
            else if (getBoard().occupied(x-i,y-i)&&(getBoard().getPiece(x-i,y-i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x-i,y-i)) {
                m = new Move(this, x,y, x-i,y-i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x-i,y-i)&&(getBoard().getPiece(x-i,y-i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-i,y-i, true);
                v.add(m);
                break;
            }
        }
        //fourth set of legal moves - from x,y, to x-i,y+i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x-i,y+i))
                break;
            else if (getBoard().occupied(x-i,y+i)&&(getBoard().getPiece(x-i,y+i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x-i,y+i)) {
                m = new Move(this, x,y, x-i,y+i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x-i,y+i)&&(getBoard().getPiece(x-i,y+i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-i,y+i, true);
                v.add(m);
                break;
            }
        }    
        //add null move if vector is empty.
        if (v.isEmpty()) v.add(null);
        return v;
    }

    // method returns Vector of legal moves for a black Bishop
    private ArrayList<Move> blackBishop() {
        int x = getX();
        int y = getY();

        //create a new vector to store legal moves
        ArrayList<Move> v = new ArrayList<Move>();

        // set up m to refer to a Move object  
        Move m = null;

        //first set of legal moves - from x,y, to x+i,y+i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x+i, y+i))
                break;
            else if (getBoard().occupied(x+i,y+i)&&(getBoard().getPiece(x+i,y+i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x+i, y+i)) {
                m = new Move(this, x,y, x+i,y+i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x+i,y+i)&&(getBoard().getPiece(x+i,y+i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+i,y+i, true);
                v.add(m);
                break;
            }
        }
        //second set of legal moves - from x,y, to x+i,y-i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x+i,y-i))
                break;
            else if (getBoard().occupied(x+i,y-i)&&(getBoard().getPiece(x+i,y-i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x+i,y-i)) {
                m = new Move(this, x,y, x+i,y-i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x+i,y-i)&&(getBoard().getPiece(x+i,y-i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x+i,y-i, true);
                v.add(m);
                break;
            }
        }
        //third set of legal moves - from x,y, to x-i,y-i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x-i,y-i))
                break;
            else if (getBoard().occupied(x-i,y-i)&&(getBoard().getPiece(x-i,y-i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x-i,y-i)) {
                m = new Move(this, x,y, x-i,y-i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x-i,y-i)&&(getBoard().getPiece(x-i,y-i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-i,y-i, true);
                v.add(m);
                break;
            }
        }
        //fourth set of legal moves - from x,y, to x-i,y+i, if cell is/isn't occupied
        for (int i=1;i<=6;++i){
            if (getBoard().outOfRange(x-i,y+i))
                break;
            else if (getBoard().occupied(x-i,y+i)&&(getBoard().getPiece(x-i,y+i).getColour()==this.getColour()))
                break;
            else if (!getBoard().occupied(x-i,y+i)) {
                m = new Move(this, x,y, x-i,y+i, false);
                v.add(m);
            }
            else if (getBoard().occupied(x-i,y+i)&&(getBoard().getPiece(x-i,y+i).getColour()!=this.getColour())) {
                m = new Move(this, x,y, x-i,y+i, true);
                v.add(m);
                break;
            }
        }    
        //add null move if vector is empty.
        if (v.isEmpty()) v.add(null);
        return v;
    }
}
