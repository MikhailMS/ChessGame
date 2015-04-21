package uk.ac.sheffield.aca14mm;
/*
Author - Mikhail Molotkov.
Last update - 28/03/2015.
*/
/*
    Queen class represent a piece - queen, extends Piece super class.
*/

import java.util.*;

public class Queen extends Piece {

  public Queen (int ix, int iy, int c, Board b) {
    super(PieceCode.QUEEN, ix, iy, c, b);
  }

 // method implements abstract method in Piece class
  @Override
  public ArrayList<Move> availableMoves() {
    if (getColour()==PieceCode.WHITE) return whiteQueen();
    else return blackQueen();
  }
  
  // method to return Vector of legal moves for a white Queen
  private ArrayList<Move> whiteQueen() {
    int x = getX();
    int y = getY();
    
    //create a new vector to store legal moves
    ArrayList<Move> v = new ArrayList<Move>();
      
    // set up m to refer to a Move object  
    Move m = null;
    
   //first set of legal moves - from x,y, to x,y+i, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x,y+i))
            break;
        else if (getBoard().occupied(x,y+i)&&(getBoard().getPiece(x,y+i).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x,y+i)) {
            m = new Move(this, x,y, x,y+i, false);
            v.add(m);
        }
        else if (getBoard().occupied(x,y+i)&&(getBoard().getPiece(x,y+i).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x,y+i, true);
            v.add(m);
            break;
        }
    }
    //second set of legal moves - from x,y, to x+i,y, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x+i,y))
            break;
        else if (getBoard().occupied(x+i,y)&&(getBoard().getPiece(x+i,y).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x+i,y)) {
            m = new Move(this, x,y, x+i,y, false);
            v.add(m);
        }
        else if (getBoard().occupied(x+i,y)&&(getBoard().getPiece(x+i,y).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x+i,y, true);
            v.add(m);
            break;
        }
    }
    //third set of legal moves - from x,y, to x,y-i, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x,y-i))
            break;
        else if (getBoard().occupied(x,y-i)&&(getBoard().getPiece(x,y-i).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x,y-i)) {
            m = new Move(this, x,y, x,y-i, false);
            v.add(m);
        }
        else if (getBoard().occupied(x,y-i)&&(getBoard().getPiece(x,y-i).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x,y-i, true);
            v.add(m);
            break;
        }
    }
    //fourth set of legal moves - from x,y, to x-i,y, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x-i,y))
            break;
        else if (getBoard().occupied(x-i,y)&&(getBoard().getPiece(x-i,y).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x-i,y)) {
            m = new Move(this, x,y, x-i,y, false);
            v.add(m);
        }
        else if (getBoard().occupied(x-i,y)&&(getBoard().getPiece(x-i,y).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x-i,y, true);
            v.add(m);
            break;
        }
    }
    //fifth set of legal moves - from x,y, to x+i,y+i, if cell is/isn't occupied
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
    //sixth set of legal moves - from x,y, to x+i,y-i, if cell is/isn't occupied
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
    //seventh set of legal moves - from x,y, to x-i,y-i, if cell is/isn't occupied
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
    //eighth set of legal moves - from x,y, to x-i,y+i, if cell is/isn't occupied
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
  
  // method to return Vector of legal moves for a black Queen
  private ArrayList<Move> blackQueen() {
    int x = getX();
    int y = getY();
    
    //create a new vector to store legal moves
    ArrayList<Move> v = new ArrayList<Move>();
      
    // set up m to refer to a Move object  
    Move m = null;
    
     //first set of legal moves - from x,y, to x,y+i, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x,y+i))
            break;
        else if (getBoard().occupied(x,y+i)&&(getBoard().getPiece(x,y+i).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x,y+i)) {
            m = new Move(this, x,y, x,y+i, false);
            v.add(m);
        }
        else if (getBoard().occupied(x,y+i)&&(getBoard().getPiece(x,y+i).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x,y+i, true);
            v.add(m);
            break;
        }
    }
    //second set of legal moves - from x,y, to x+i,y, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x+i,y))
            break;
        else if (getBoard().occupied(x+i,y)&&(getBoard().getPiece(x+i,y).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x+i,y)) {
            m = new Move(this, x,y, x+i,y, false);
            v.add(m);
        }
        else if (getBoard().occupied(x+i,y)&&(getBoard().getPiece(x+i,y).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x+i,y, true);
            v.add(m);
            break;
        }
    }
    //third set of legal moves - from x,y, to x,y-i, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x,y-i))
            break;
        else if (getBoard().occupied(x,y-i)&&(getBoard().getPiece(x,y-i).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x,y-i)) {
            m = new Move(this, x,y, x,y-i, false);
            v.add(m);
        }
        else if (getBoard().occupied(x,y-i)&&(getBoard().getPiece(x,y-i).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x,y-i, true);
            v.add(m);
            break;
        }
    }
    //fourth set of legal moves - from x,y, to x-i,y, if cell is/isn't occupied
    for (int i=1;i<=7;++i){
        if (getBoard().outOfRange(x-i,y))
            break;
        else if (getBoard().occupied(x-i,y)&&(getBoard().getPiece(x-i,y).getColour()==this.getColour()))
            break;
        else if (!getBoard().occupied(x-i,y)) {
            m = new Move(this, x,y, x-i,y, false);
            v.add(m);
        }
        else if (getBoard().occupied(x-i,y)&&(getBoard().getPiece(x-i,y).getColour()!=this.getColour())) {
            m = new Move(this, x,y, x-i,y, true);
            v.add(m);
            break;
        }
    }
    //fifth set of legal moves - from x,y, to x+i,y+i, if cell is/isn't occupied
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
    //sixth set of legal moves - from x,y, to x+i,y-i, if cell is/isn't occupied
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
    //seventh set of legal moves - from x,y, to x-i,y-i, if cell is/isn't occupied
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
    //eighth set of legal moves - from x,y, to x-i,y+i, if cell is/isn't occupied
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