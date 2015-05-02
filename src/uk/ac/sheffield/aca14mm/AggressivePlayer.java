package uk.ac.sheffield.aca14mm;

import java.util.*;

/*
Author - Mikhail Molotkov.
Last update - 02/05/2015
*/

public class AggressivePlayer extends Player {
	
	//Declaration of variables.
	private ArrayList<Move> moves = new ArrayList<Move>();
	private int biggestCost = 0;
	private int costIndex;
	private int xI,yI,xN,yN;
	private boolean pieceTaken;
	
	//Constructor for AggressivePlayer.
	public AggressivePlayer(String name, Pieces p, Board b){
		super(name, p, b, null);
	}
	//Method looks through all possible moves and pick one with highest cost, otherwise makes random move.
	public void getMove(String m) {
		makeMove();
		int tempCost = 0;
		for(int i=0;i<moves.size();++i) {
			int x = moves.get(i).getToX();
			int y = moves.get(i).getToY();
			pieceTaken = moves.get(i).isTaken();
			if (pieceTaken) {
				tempCost = pieceCost(getBoard().getPiece(x, y).getChar());
				if(tempCost>biggestCost) {
					biggestCost = tempCost;
					costIndex = i;
				}
			}
		}
		//Can be placed into method.
		if(biggestCost==0) {
			int move = (int)(Math.random()*(moves.size()-1));
			System.out.println("Random move: "+moves.get(move).toString());
			xI = moves.get(move).getFromX();
			yI = moves.get(move).getFromY();
			xN = moves.get(move).getToX();
			yN = moves.get(move).getToY();
			pieceTaken = moves.get(move).isTaken();
			setMove();
			if(pieceTaken)
				defeatPiece(this.getOpponent());
			else
				justMove();
		}
		else if(biggestCost>=1) {
			System.out.println("Aggressive move: "+moves.get(costIndex).toString());
			xI = moves.get(costIndex).getFromX();
			yI = moves.get(costIndex).getFromY();
			xN = moves.get(costIndex).getToX();
			yN = moves.get(costIndex).getToY();
			pieceTaken = moves.get(costIndex).isTaken();
			setMove();
			if(pieceTaken)
				defeatPiece(this.getOpponent());
			else
				justMove();
		}
		costIndex = 0;
		moves.clear();
	}
	//Method creates a list of all moves which are not null.
	//Method creates a new list of all possible moves.
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
	
	//Method returns cost of each piece
	//Method returns cost of a piece.
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
	//methods below can be moved to player.java
	//Accessor returns true if player can take a piece
    public boolean isPieceTaken() {return pieceTaken;}
	//Method moves a piece.
	//Method moves random player's piece
	private void justMove() {	
		this.getBoard().getPiece(xI, yI).setPosition(xN, yN);
        this.getBoard().setPosition(xN, yN, this.getBoard().getPiece(xI, yI));                
        this.getBoard().remove(xI, yI);
	}
    //Method takes opponent's piece
	//Method takes opponent's piece.
	private void defeatPiece(Player op) {
		op.deletePiece(op.getBoard().getPiece(this.xN, this.yN));
        justMove();
	}
}
