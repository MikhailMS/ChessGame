package uk.ac.sheffield.aca14mm;

import java.util.*;

public class AgressivePlayer extends Player {
	
	private ArrayList<Move> moves = new ArrayList<Move>();
	private int biggestCost = 0;
	private int costIndex;
	private int xI,yI,xN,yN;
	private boolean pieceTaken;
	//Constructor for RandomPlayer.
	public AgressivePlayer(String name, Pieces p, Board b){
		super(name, p, b, null);
	}
	
	public void getMove() {
		makeMove();
		for(int i=0;i<moves.size();++i) {
			int x = moves.get(i).getToX();
			int y = moves.get(i).getToY();
			pieceTaken = moves.get(i).isTaken();
			if (pieceTaken) {
				int tempCost = pieceCost(getBoard().getPiece(x, y).getChar());
				if(tempCost>biggestCost) {
					biggestCost = tempCost;
					costIndex = i;
				}
			}
		}
		if(biggestCost==0) {
			int move = (int)(Math.random()*(moves.size()-1));
			xI = moves.get(move).getFromX();
			yI = moves.get(move).getFromY();
			xN = moves.get(move).getToX();
			yN = moves.get(move).getToY();
			pieceTaken = moves.get(move).isTaken();
		}
		else {
			xI = moves.get(costIndex).getFromX();
			yI = moves.get(costIndex).getFromY();
			xN = moves.get(costIndex).getToX();
			yN = moves.get(costIndex).getToY();
			pieceTaken = moves.get(costIndex).isTaken();
		}	
		moves.clear();
	}
	
	@Override
	public boolean makeMove() {
		for(int i=0;i<getPieces().getNumPieces();++i) {
			for(Move m : getPieces().getPiece(i).availableMoves()) {
				if(m == null)
					System.out.print("");
				else if (m != null)
					moves.add(m);				
			}
		}
		return false;
	}
	
	//method returns cost of each piece
	private int pieceCost(char piece) {
		switch(Character.toLowerCase(piece)) {
		case 'p':
			return 1;
		case 'r':
			return 2;
		case 'n':
			return 3;
		case 'b':
			return 4;
		case 'q':
			return 5;
		case 'k':
			return 6;
		default:
			return 0;
		}
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
		return " ";
	}
}
