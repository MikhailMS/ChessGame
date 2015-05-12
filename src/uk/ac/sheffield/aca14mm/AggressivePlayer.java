package uk.ac.sheffield.aca14mm;

import java.util.*;

import javax.swing.JOptionPane;

/*
Author - Mikhail Molotkov.
Last update - 12/05/2015
	
	AggressivePlayer class extends Player class and represents aggressive player,
	who makes moves accordingly to their cost or, if cost is 0, makes random move.
	
*/

public class AggressivePlayer extends Player {
	
	/*Declaration of variables.
	 * moves - contains all possible moves for turn.
	 * biggestCost - holds the biggest cost of an opponent's piece.
	 * costIndex - index of the pieces in moves with biggest cost.
	 * xI,yI - initial coordinates.
	 * xN,yN - coordinates where piece moves.
	 * pieceTaken - contains true if the piece will defeat opponent's piece.
	 */
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
		if (moves.isEmpty())
			JOptionPane.showMessageDialog(null,"Something went wrong, start new game!");
		else {
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
			if(biggestCost==0) {
				int move = (int)(Math.random()*(moves.size()-1));
				System.out.println("Random move: "+moves.get(move).toString());
				setCoor(move);
				setMove();
				if(pieceTaken)
					defeatPiece(this.getOpponent());
				else
					justMove();
			}
			else if(biggestCost>=1) {
				System.out.println("Aggressive move: "+moves.get(costIndex).toString());
				setCoor(costIndex);
				setMove();
				if(pieceTaken)
					defeatPiece(this.getOpponent());
				else
					justMove();
			}
			costIndex = 0;
			moves.clear();
		}
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
//Methods below can be moved to Player.java
	//Method sets coordinates of a move and boolean variable if opponents piece will be taken.
    private void setCoor(int indexMove) {
		xI = moves.get(indexMove).getFromX();
		yI = moves.get(indexMove).getFromY();
		xN = moves.get(indexMove).getToX();
		yN = moves.get(indexMove).getToY();
		pieceTaken = moves.get(indexMove).isTaken();
	}
	//Accessor returns true if player can take a piece
    public boolean isPieceTaken() {return pieceTaken;}
	//Method moves random player's piece
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
