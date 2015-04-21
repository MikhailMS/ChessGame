package uk.ac.sheffield.aca14mm;
/*
Author - Mikhail Molotkov.
Last update - 28/03/2015.
*/

/*
    Class Move represents a possible move for a piece, consist of :
        which piece we move,
        initial coordinates of a piece,
        new(to) coordinates of a piece,
        boolean to represent if this move defeat enemy's piece.
*/
public class Move {
    
    //Initialization of variables.
    private Piece piece;
    private int x,y;
    private boolean occupied;
    private int newX, newY;
    
    //Constructor for move.
    public Move(Piece fig, int xInit, int yInit, int xNew, int yNew, boolean move){
        piece = fig;
        x = xInit;
        y = yInit;
        newX = xNew;
        newY = yNew;
        occupied = move;
    }
    
    //return initial(from) coordinates of move.
    public int getFromX(){return x;}
    public int getFromY(){return y;}
    
    //return new(to) coordinates of move.
    public int getToX(){return newX;}
    public int getToY(){return newY;} 
    
    //return true if cell is occupied.
    public boolean isTaken(){return occupied;}
    
    public String toString(){
        return "From:"+x+"|"+y+", to:"+newX+"|"+newY+" .";
    }
    
}