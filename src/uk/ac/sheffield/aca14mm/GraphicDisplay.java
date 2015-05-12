package uk.ac.sheffield.aca14mm;

import java.awt.*;
import javax.swing.JPanel;

/*
Author - Mikhail Molotkov.
Last update - 28/04/2015
*/
public class GraphicDisplay extends JPanel implements Display {
	
	//Instances of class.
	private Graphics2D cell ;
	private Piece[][] piecesOnBoard;
	private int swapColour = 1;
	private int cellSize = 50;
	private int xI=Toolkit.getDefaultToolkit().getScreenSize().height/10;
	private int yI=Toolkit.getDefaultToolkit().getScreenSize().width/20;
	
	//Constructor of a board
	public GraphicDisplay() {}	
	@Override
	public void showPiecesOnBoard(Piece[][] data) {}
	
	//Method changes cell's colour from step to step.
	private void swapColourCell(int i) {
		if (swapColour == 1) {
			cell.setColor(Color.lightGray);
			swapColour = -swapColour;
		}
		else {
			cell.setColor(new Color(255,165,0));
			swapColour = -swapColour;
		}
		if (i==7) 
			swapColour = -swapColour;
	}
	//Method adds graphic representation of pieces on board
	@Override
	public void paintComponent(Graphics g) {
		cell = (Graphics2D)g;
		super.paintComponents(cell);		
		int i=-1;
		int j=0;
		cell.setFont(new Font("Serif",Font.BOLD,30));
		for (i=-1;i<9;++i) {
            if(i==-1|i==8) {  
            }
            else {
            	//Left side letters
	            String str = ""+intToChar(i+1);
	            cell.setColor(Color.blue);
				cell.drawString(str, xI-cellSize/2-10, yI+cellSize*i+cellSize/2+8);   
            }
            for (j=0;j<8;++j) {
            	//Top side integers
                if (i==-1) {
                    String str = ""+(j+1);
                    cell.setColor(Color.blue);
    				cell.drawString(str, xI+cellSize*j+cellSize/2-8, yI+cellSize*i/2+8);
                }
                //Bottom side integers
                else if(i==8) {
                	String str = ""+(j+1);
	                cell.setColor(Color.blue);
					cell.drawString(str, xI+cellSize*j+cellSize/2-8, yI+cellSize*i+cellSize/2+8);
                }
                else {
                	swapColourCell(j);
                	Rectangle rect = new Rectangle(xI+cellSize*j, yI+cellSize*i, cellSize, cellSize);
    				cell.fill(rect);
    				cell.draw(rect);  
    				if (piecesOnBoard[i][j]!=null) {
    					String str = ""+charToPiece(piecesOnBoard[i][j].getChar());
    					if(piecesOnBoard[i][j].getColour()==0) {
    						cell.setColor(Color.black);
    						cell.drawString(str, xI+cellSize*j+cellSize/4-2, yI+cellSize*i+cellSize/2+5);
    					}
    					if(piecesOnBoard[i][j].getColour()==1) {
    						cell.setColor(Color.yellow);
    						cell.drawString(str, xI+cellSize*j+cellSize/4-2, yI+cellSize*i+cellSize/2+5);
    					}
    				}     				
    				xI=Toolkit.getDefaultToolkit().getScreenSize().height/10;
    				yI=Toolkit.getDefaultToolkit().getScreenSize().width/20;
                }
            }
            if(i==-1|i==8){  
            }
            else {
            	//Right side letters
                String str = ""+intToChar(i+1);
                cell.setColor(Color.blue);
				cell.drawString(str, xI+cellSize*j+cellSize/2-10, yI+cellSize*i+cellSize/2+8);
            }
        }
	}
	//Method sets pieces for a graphic representation and repaint board.
	public void setPieces(Piece[][] p) {
		piecesOnBoard = p;
		this.repaint();
	}
	//Method converts numbers to letters to make display look more like real game board.   
	private char intToChar(int num) {
        switch(num){
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            default:
                return 'e';
        }
    }
	//Method converts piece's name to a Unicode representation.
	private char charToPiece(char ch) {
		switch(ch) {
		case 'p':
			return '\u2659';
		case 'r':
			return '\u2656';
		case 'n':
			return '\u2658';
		case 'b':
			return '\u2657';
		case 'q':
			return '\u2655';
		case 'k':
			return '\u2654';
		case 'P':
			return '\u265F';
		case 'R':
			return '\u265C';
		case 'N':
			return '\u265E';
		case 'B':
			return '\u265D';
		case 'Q':
			return '\u265B';
		case 'K':
			return '\u265A';
		default:
			return '.';	
		}
	}
}
