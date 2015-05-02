package uk.ac.sheffield.aca14mm;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

/*
Author - Mikhail Molotkov.
Last update - 02/05/2015
*/
public class MainWindow extends JFrame {
    
    private final static int WIDTH = 800;
    private final static int HEIGHT = 700;
    private Board board = new Board();
    private Pieces blackSet = new Pieces(board,0),whiteSet = new Pieces(board,1);
    private HumanPlayer player1 = new HumanPlayer("Player1",null,board);
    private HumanPlayer opponent1 = new HumanPlayer("HumanOpponent",null,null);
    private RandomPlayer opponent2 = new RandomPlayer("RandomOpponent",null,null);
    private AggressivePlayer opponent3 = new AggressivePlayer("AggressiveOpponent",null,null);
    private GraphicDisplay display;
    private boolean start = false,colour=false;
    private JTextField inputText;
    private JLabel playerTurn;
    private JButton startButton;
    private JRadioButton humanPlayer,randomPlayer,aggressivePlayer,whiteColour,blackColour;
    private ButtonGroup playerType, colourSecondPlayer;
    
    //Constructor for main game window.
    public MainWindow(GraphicDisplay disp)   {
        
    	//Create instance of container object.
        Container pane = new Container();
        pane = getContentPane();
        //Set layout for container.
        pane.setLayout(new BorderLayout());
        
        //Create text field and label for writing move and place it into container.
        JLabel inputLabel = new JLabel("Enter your move ");
        inputText = new JTextField(5);
        //Button to confirm move.
        JButton makeMoveButton = new JButton("Make your move");
        makeMoveButton.addActionListener(new MakeMove());
        //Then create panel to add these into.
        JPanel move = new JPanel(new GridLayout(3,0));
        move.add(inputLabel);
        move.add(inputText);
        move.add(makeMoveButton);
        
        //Create group of buttons
        JLabel playerLabel = new JLabel("Choose your opponent.");
        playerType = new ButtonGroup();        
        humanPlayer = new JRadioButton("Human player");
        randomPlayer = new JRadioButton("Random player");
        aggressivePlayer = new JRadioButton("Aggressive player");
        aggressivePlayer.setSelected(true);
        //Connect all buttons which create player into one group.
        playerType.add(humanPlayer);
        playerType.add(randomPlayer);
        playerType.add(aggressivePlayer);
        //Then add them to the panel.
        JPanel playerButtons = new JPanel();
        playerButtons.setLayout(new GridLayout(9,0));
        playerButtons.add(playerLabel);
        playerButtons.add(humanPlayer);
        playerButtons.add(randomPlayer);
        playerButtons.add(aggressivePlayer);
        
        //Create labels and buttons to chose colour for opponent.
        JLabel colourSecondLabel = new JLabel("Choose opponent's colour.");
        colourSecondPlayer = new ButtonGroup();      
        //whiteColour = new JRadioButton("White colour");
        blackColour = new JRadioButton("Black colour"); 
        blackColour.setSelected(true);
        colourSecondPlayer.add(whiteColour);
        colourSecondPlayer.add(blackColour);      
        //Add buttons to the panel
        playerButtons.add(colourSecondLabel);
       // playerButtons.add(whiteColour);
        playerButtons.add(blackColour);
        
        //Button to start game.
        startButton = new JButton("Start the game!");
        startButton.addActionListener(new StartGame());
        playerButtons.add(startButton);
        
        //Button to exit game.
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new Exit());
        playerButtons.add(exitButton);
        
        //Setting up a window.
        display = disp;
        playerTurn = new JLabel("Please, set up your game first.");
        pane.add(playerTurn, BorderLayout.NORTH);
        pane.add(playerButtons, BorderLayout.EAST); 
        pane.add(display,BorderLayout.CENTER);
        pane.add(move, BorderLayout.SOUTH);
        setTitle("Chess Game");
        setSize(WIDTH,HEIGHT);       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);              
    }
    //method return true if player object has no board connected.
    private boolean isNull(Player p) {
    	return (p.getBoard()==null);
    }  
    //Method returns selected button from a group of radio buttons.
    private JRadioButton isSelected(ButtonGroup bg) {
    	Enumeration<AbstractButton> buttons = bg.getElements();
	    JRadioButton selectedButton = null;
	    while (buttons.hasMoreElements()) {
	        selectedButton = (JRadioButton) buttons.nextElement();
	        if (selectedButton.isSelected()) 
	            break;
	    }
	    return selectedButton;
    }
    
    //Method sets a colour for players.
    private void setColour(Player player) {
		switch(isSelected(colourSecondPlayer).getActionCommand()) {
			case "White colour":
				player.setPieces(whiteSet);
				player1.setPieces(blackSet);
				playerTurn.setText(player.toString()+", it is your turn.");
				colour = true;
				break;
			case "Black colour":
				player.setPieces(blackSet);
				player1.setPieces(whiteSet);
				playerTurn.setText(player1.toString()+", it is your turn.");
				colour = true;
				break;
			default:
				JOptionPane.showMessageDialog(null,"You did not choose opponent's colour!");
				break;
		}
		player1.setOpponent(player);
		player.setOpponent(player1);
    }
    
    //Method runs game against second human player.
    private boolean p1 = true;
    private boolean p2 = false;
    private void runGameAgainstHum(Player pl1, Player pl2) {
    	int player1Coll = pl1.getPieces().getNumPieces()-1;
    	int opponentColl = pl2.getPieces().getNumPieces()-1;
        char player1Col = pl1.getPieces().getPiece(0).getColourChar();
        char opponentCol = pl2.getPieces().getPiece(0).getColourChar();
    	if (start) {
	    	String move = inputText.getText();
	    	if(p1) {
	    		pl1.getMove(move);
	    		if(pl1.isMoveOK()) {
	    			display.setPieces(pl1.getBoard().getData());
	    			pl1.setMoveBack();
	    			p1 = false;
	    			p2 = true;
	    			opponentColl = pl2.getPieces().getNumPieces()-1;
	    			if(opponentCol=='b')	{
	    	    		if(pl2.getPieces().getPiece(opponentColl).getChar()!='K') {
	    		    		JOptionPane.showMessageDialog(null,pl2.toString()+" is defeated!");
	    		    		System.exit(0);
	    	    		}
	    	    	}	
	    	    	else {
	    	    		if(pl2.getPieces().getPiece(opponentColl).getChar()!='k') {
	    	    			JOptionPane.showMessageDialog(null,pl2.toString()+" is defeated!");
	    		    		System.exit(0);
	    	    		}		    				
	    	    	}
	    			playerTurn.setText(pl2.toString()+", it is your turn.");	    			
	    		}   			
	    	}
	    	else if(p2) {
	    		pl2.getMove(move);
	    		if(pl2.isMoveOK()) {
	    			display.setPieces(pl1.getBoard().getData());
	    			pl2.setMoveBack();
	    			p1 = true;
	    			p2 = false;
	    			player1Coll = pl1.getPieces().getNumPieces()-1;
	    			if(player1Col=='w') {
	    	    		if(pl1.getPieces().getPiece(player1Coll).getChar()!='k') {
	    		    		JOptionPane.showMessageDialog(null,"Player1 is defeated!");
	    		    		System.exit(0);
	    	    		}
	    	    	}
	    	    	else {
	    	    		if(pl1.getPieces().getPiece(player1Coll).getChar()!='K') {
	    	    			JOptionPane.showMessageDialog(null,"Player1 is defeated!");
	    		    		System.exit(0);
	    	    		}		    				
	    	    	}
	    			playerTurn.setText(pl1.toString()+", it is your turn.");
	    		}
	    	}
	    	inputText.setText("");
    	}
    	else
			JOptionPane.showMessageDialog(null,"You did not set up your game!");
    	
    }
    //Method runs main logic of the game against computer.
    private void runGameAgainstComp(Player opponent) {
    	//escape values
    	display.setPieces(player1.getBoard().getData());
		if (start) {
    		String move = "";   		
			move = inputText.getText();
			player1.getMove(move);
			inputText.setText("");
			if(player1.isMoveOK()) {
				player1.setMoveBack();
				display.setPieces(player1.getBoard().getData());
				opponent.getMove("");
				display.setPieces(player1.getBoard().getData());
				opponent.setMoveBack();
				}
	    	int player1Coll = player1.getPieces().getNumPieces()-1;
	    	int opponentColl = opponent.getPieces().getNumPieces()-1;
	        char player1Col = player1.getPieces().getPiece(0).getColourChar();
	        char opponentCol = opponent.getPieces().getPiece(0).getColourChar();
	    	if(player1Col=='w') {
	    		if(player1.getPieces().getPiece(player1Coll).getChar()!='k') {
		    		JOptionPane.showMessageDialog(null,"Player1 is defeated!");
		    		System.exit(0);
	    		}
	    	}
	    	else {
	    		if(player1.getPieces().getPiece(player1Coll).getChar()!='K') {
	    			JOptionPane.showMessageDialog(null,"Player1 is defeated!");
		    		System.exit(0);
	    		}		    				
	    	}
	    	if(opponentCol=='b')	{
	    		if(opponent.getPieces().getPiece(opponentColl).getChar()!='K') {
		    		JOptionPane.showMessageDialog(null,opponent.toString()+" is defeated!");
		    		System.exit(0);
	    		}
	    	}	
	    	else {
	    		if(opponent.getPieces().getPiece(opponentColl).getChar()!='k') {
	    			JOptionPane.showMessageDialog(null,opponent.toString()+" is defeated!");
		    		System.exit(0);
	    		}		    				
	    	}
		}
		else
			JOptionPane.showMessageDialog(null,"You did not set up your game!");
    }
    
    //Creates opponent for the player, makes use of setColour method to set colours for players.
    private class StartGame implements ActionListener {
    	public void actionPerformed(ActionEvent evt) {
    		boolean player = false;
    		colour = false;
    		if(!start) {
    			//create the player.
    			switch(isSelected(playerType).getActionCommand()) {
    				case "Human player":
    					opponent1.setBoard(board);
    					player = true;
    					break;
    				case "Random player":
    					opponent2 .setBoard(board);
    					player = true;
    					break;
    				case "Aggressive player":
    					opponent3.setBoard(board);
    					player = true;
    					break; 
    				default:
    					JOptionPane.showMessageDialog(null,"You did not choose opponent!");
    					break;
    			} 
    			if (!isNull(opponent1))
    				setColour(opponent1);
    			else if(!isNull(opponent2))
    				setColour(opponent2);
    			else if(!isNull(opponent3))
    				setColour(opponent3);
    			System.out.println(isSelected(colourSecondPlayer).getActionCommand());
    			if (player&&colour) {
    				display.setPieces(player1.getBoard().getData());
        			JOptionPane.showMessageDialog(null,"Good luck in the game of chess!");
        			start = true;        			
        		}
    		}
    		else 
    			JOptionPane.showMessageDialog(null,"Game is already started!");
    	}
    } 
    //Class connects button with runGame() method depending on player's choice.
    private class MakeMove implements ActionListener {
    	public void actionPerformed(ActionEvent evt) {
            if(!isNull(opponent1)) {
            	System.out.println("Game running against human player");
            	runGameAgainstHum(player1,opponent1);
            }
            else if(!isNull(opponent2)) {
            	System.out.println("Game running against random player");
            	runGameAgainstComp(opponent2);
            }
            else if(!isNull(opponent3)) {
            	System.out.println("Game running against aggressive player");
            	runGameAgainstComp(opponent3);
            }
            else
            	JOptionPane.showMessageDialog(null,"!!!!!BE AWARE!!!!SOMETHING IS DEFINETLY WRONG HERE!!!!!");
            	
    	}
    }   
    //Exit game.
    private class Exit implements ActionListener    {
        public void actionPerformed(ActionEvent evt)    {
            System.exit(0);
        }
    }
}
