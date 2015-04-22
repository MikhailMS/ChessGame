package uk.ac.sheffield.aca14mm;

import java.util.ArrayList;

public class RandomPlayer extends Player {
	
	//Declaration of variables.
	private int moveStop = -1;
	private ArrayList<Move> moves = new ArrayList<Move>();
	private int pieceNum,moveNum;
	private int xI,yI,xN,yN;
	private boolean pieceTaken;
	
	//Constructor for RandomPlayer.
	public RandomPlayer(String name, Pieces p, Board b){
        super(name, p, b, null);
    }
	
	//Method gets the possible move of a randomly chosen piece.
	public void getMove() {
		while(moveStop<=0)
			makeMove();
		moveNum = (int)(Math.random()*(moves.size()-1));
		xI = moves.get(moveNum).getFromX();
		yI = moves.get(moveNum).getFromY();
		xN = moves.get(moveNum).getToX();
		yN = moves.get(moveNum).getToY();
		pieceTaken = moves.get(moveNum).isTaken();
		moveStop = -1;
		moves.clear();
	}
	
	//Method returns true if move is possible
	@Override
	public boolean makeMove() {
		pieceNum = (int)(Math.random()*(getPieces().getNumPieces()-1));
		int i = 0;
		for (Move move : getPieces().getPiece(pieceNum).availableMoves()) {			
			if (move == null)
				System.out.print("");
			else if(move != null) {
				moveStop = i;
				moves.add(move);
			}
			++i;
		}
		return false;
	}
	
	//accessor returns true if player can take a piece
    public boolean isPieceTaken() {return pieceTaken;}
	
	//method moves random player's piece
	public void justMove() {	
		this.getBoard().getPiece(xI, yI).setPosition(xN, yN);
        this.getBoard().setPosition(xN, yN, this.getBoard().getPiece(xI, yI));                
        this.getBoard().remove(xI, yI);
	}
    //method takes opponent's piece
	public void defeatPiece(Player op) {
		op.deletePiece(op.getBoard().getPiece(this.xN, this.yN));
        justMove();
	}
	
	@Override
	public String toString() {
		return "Piece "+pieceNum+", Move "+moveNum+", From "+xI+"|"+yI+", To "+xN+"|"+yN;
	}
	
}
