package uk.ac.sheffield.aca14mm;

import java.util.ArrayList;

/*
Author - Mikhail Molotkov.
Last update - 11/05/2015

	RandomPlayer class extends Player class and represents random player,
	who makes random move.

*/

public class RandomPlayer extends Player {
	
	//Declaration of variables.
	private ArrayList<Move> moves = new ArrayList<Move>();
	private int xI,yI,xN,yN;
	private boolean pieceTaken;
	
	//Constructor for RandomPlayer.
	public RandomPlayer(String name, Pieces p, Board b){
        super(name, p, b, null);
    }
	//Method gets the possible move of a randomly chosen piece.
	public void getMove(String m) {
		makeMove();
		int moveNum = (int)(Math.random()*(moves.size()-1));
		setCoor(moveNum);
		setMove();
		if(pieceTaken)
			defeatPiece(this.getOpponent());
		else
			justMove();
		moves.clear();
	}
	//Method creates a list of all moves which are not null.
	@Override
	public boolean makeMove() {
		for(int i=0;i<getPieces().getNumPieces();++i) {
			for(Move m : getPieces().getPiece(i).availableMoves()) {
				if (m != null)
					moves.add(m);				
			}
		}
		return false;
	}
	//Accessor returns true if player can take a piece.
    public boolean isPieceTaken() {return pieceTaken;}
	//Method sets coordinates of a move and boolean variable if opponents piece will be taken.
    private void setCoor(int indexMove) {
		xI = moves.get(indexMove).getFromX();
		yI = moves.get(indexMove).getFromY();
		xN = moves.get(indexMove).getToX();
		yN = moves.get(indexMove).getToY();
		pieceTaken = moves.get(indexMove).isTaken();
	}
	//Method moves piece.
	private void justMove() {	
		this.getBoard().getPiece(xI, yI).setPosition(xN, yN);
        this.getBoard().setPosition(xN, yN, this.getBoard().getPiece(xI, yI));                
        this.getBoard().remove(xI, yI);
	}
    //Method takes opponent's piece.
	private void defeatPiece(Player op) {
		op.deletePiece(op.getBoard().getPiece(this.xN, this.yN));
        justMove();
	}
}