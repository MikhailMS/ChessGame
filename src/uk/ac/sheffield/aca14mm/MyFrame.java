package uk.ac.sheffield.aca14mm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame {
	
	private GraphicDisplay drawingPanel; // a panel to draw polygons
	
	public MyFrame() {
		// set size, position and location, write your own code for this
	
		// designate centre panel for drawing and add it to the frame
		Container contentPane = this.getContentPane();
		drawingPanel = new GraphicDisplay();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
	
		// create a column of buttons to the right (east) of the frame.
		// we don�t need any extra functionality for this panel so just use JPanel
		// without extending it, and we can use the GridLayout to specify the way
		// the eight buttons are laid out
		
		JPanel columnOfButtons = new JPanel(new GridLayout(8,1));
		for (int i=3; i<10; i++)
			makeButton(columnOfButtons, String.valueOf(i), new GetNumberFromClick());
		
		makeButton(columnOfButtons, "Exit", new ExitButtonAction());
		contentPane.add(columnOfButtons, BorderLayout.EAST);
        setTitle("Funny polygons");
		setSize(600,600);
	}
	 
	 private void makeButton(JPanel p, String name, ActionListener target) {
		 JButton b = new JButton(name); // make a new button and give it a name
		 p.add(b); // add it to the JPanel
		 b.addActionListener(target);
	 }
        private class ExitButtonAction implements ActionListener   {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        }
        private class GetNumberFromClick implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                //drawingPanel.setPolygon(Integer.parseInt(evt.getActionCommand()));
            }
        } 
	 public static void main(String args[]) {
		JFrame frm = new MyFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	 }
}
