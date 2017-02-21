/**
 * Title: Calculator.java
 * Abstract: This program implements a GUI Calculator. It does simple operations such as:
 * 			 +, -, *, and /.
 * Author: Eduardo Trejo
 * ID: 6787
 * Date: 11/14/2014
 */

// Libraries used.
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame implements ActionListener {
	
	// Variables used.
	final static boolean RIGHT_TO_LEFT = false;
	JPanel pane = new JPanel();
	JTextArea text, text2;
	JButton button, button2, button3, button4, button5, button6, button7,
			button8, button9, button10, button11, button12, button13, button14,
			button15, button16, button17;
	double temp, temp2, total;
	int testing;
	String total2, newValue;

	JMenuBar bar = new JMenuBar();
	JMenuItem help = new JMenuItem("Help");
	
	boolean operation = false;
	int times = 0;
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setVisible(true);
		
	}

	// Calculator Constructor.
	public Calculator() {

		pack();
		setTitle("Calculator");
		setSize(275, 370);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets Menu.
		bar.add(help);
		help.addActionListener(this);
		setJMenuBar(bar);

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		
		// Sets the layout.
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		d.fill = GridBagConstraints.HORIZONTAL;

		setContentPane(pane);

		c.insets = new Insets(5, 5, 5, 5);
		// Text Area.
		text = new JTextArea();
		text.setEditable(false);
		d.gridx = 0;
		d.gridy = 0;
		d.ipady = 20;
		d.ipadx = 30;
		d.gridwidth = 5;
		pane.add(text, d);
		Font font = new Font("Verdana", Font.BOLD, 16);
		text.setFont(font);
		text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		text2 = new JTextArea();
		text2.setEditable(false);
		
		d.gridx = 0;
		d.gridy = 1;
		d.ipady = 20;
		d.ipadx = 30;
		d.gridwidth = 5;
		pane.add(text2, d);
		text2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		text2.setText("0");
		
		text2.setFont(font);
		
		// Sets up all the buttons with coordinates.
		button = new JButton("7");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 20;
		pane.add(button, c);
		button.addActionListener(this);

		button2 = new JButton("8");
		c.gridx = 1;
		c.gridy = 2;
		c.ipady = 20;
		pane.add(button2, c);
		button2.addActionListener(this);
		
		button3 = new JButton("9");
		c.gridx = 2;
		c.gridy = 2;
		c.ipady = 20;
		pane.add(button3, c);
		button3.addActionListener(this);
		
		button4 = new JButton("/");
		c.gridx = 3;
		c.gridy = 2;
		c.ipady = 20;
		pane.add(button4, c);
		button4.addActionListener(this);
		
		button5 = new JButton("4");
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 20;
		pane.add(button5, c);
		button5.addActionListener(this);
		
		button6 = new JButton("5");
		c.gridx = 1;
		c.gridy = 3;
		c.ipady = 20;
		pane.add(button6, c);
		button6.addActionListener(this);
		
		button7 = new JButton("6");
		c.gridx = 2;
		c.gridy = 3;
		c.ipady = 20;
		pane.add(button7, c);
		button7.addActionListener(this);
		
		button8 = new JButton("*");
		c.gridx = 3;
		c.gridy = 3;
		c.ipady = 20;
		pane.add(button8, c);
		button8.addActionListener(this);
		
		button9 = new JButton("1");
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 20;
		pane.add(button9, c);
		button9.addActionListener(this);
		
		button10 = new JButton("2");
		c.gridx = 1;
		c.gridy = 4;
		c.ipady = 20;
		pane.add(button10, c);
		button10.addActionListener(this);
		
		button11 = new JButton("3");
		c.gridx = 2;
		c.gridy = 4;
		c.ipady = 20;
		pane.add(button11, c);
		button11.addActionListener(this);
		
		button12 = new JButton("-");
		c.gridx = 3;
		c.gridy = 4;
		c.ipady = 20;
		pane.add(button12, c);
		button12.addActionListener(this);
		
		button13 = new JButton("0");
		c.gridx = 0;
		c.gridy = 5;
		c.ipady = 20;
		c.gridwidth = 2;
		pane.add(button13, c);
		button13.addActionListener(this);
		
		button14 = new JButton(".");
		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 1;
		pane.add(button14, c);
		button14.addActionListener(this);
		
		button15 = new JButton("+");
		c.gridx = 3;
		c.gridy = 5;
		c.ipady = 20;
		c.gridwidth = 1;
	    c.gridheight = 1;
		pane.add(button15, c);
		button15.addActionListener(this);
		
		button16 = new JButton("C");
		c.gridx = 4;
		c.gridy = 2;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		pane.add(button16, c);
		button16.addActionListener(this);
		
		button17 = new JButton("=");
		c.gridx = 4;
		c.gridy = 4;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		pane.add(button17, c);
		button17.addActionListener(this);
	}

	// Checks when a button was clicked. Performs checks as well.
	// Contains temporary variables to create a total and display later on.
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {
			
			if(operation == true)
			{
				text2.setText("7");
				text.append("7");
			}
			else 
			{		
				if(times == 0)
				{
					text2.setText("7");
					text.append("7");	
					times++;
				}
				else
				{
					text2.append("7");
					text.append("7");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button2) {
			if(operation == true)
			{
				text2.setText("8");
				text.append("8");
			}
			else
			{	
				if(times == 0)
				{
					text2.setText("8");
					text.append("8");	
					times++;
				}
				else
				{
					text2.append("8");
					text.append("8");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button3)
		{
			if(operation == true)
			{
				text2.setText("9");
				text.append("9");
			}
			else 
			{
				
				if(times == 0)
				{
					text2.setText("9");
					text.append("9");	
					times++;
				}
				else
				{
					text2.append("9");
					text.append("9");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button4) {
			temp = Double.parseDouble(text2.getText());
			text.append("/");
			testing = 1;
			operation = true;
		}
		if (e.getSource() == button5) {

			if(operation == true)
			{
				text2.setText("4");
				text.append("4");
			}
			else
			{			
				if(times == 0)
				{
					text2.setText("4");
					text.append("4");	
					times++;
				}
				else
				{
					text2.append("4");
					text.append("4");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button6) {
			if(operation == true)
			{
				text2.setText("5");
				text.append("5");
			}
			else
			{		
				if(times == 0)
				{
					text2.setText("5");
					text.append("5");	
					times++;
				}
				else
				{
					text2.append("5");
					text.append("5");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button7) {
			if(operation == true)
			{
				text2.setText("6");
				text.append("6");
			}
			else 
			{	
				if(times == 0)
				{
					text2.setText("6");
					text.append("6");	
					times++;
				}
				else
				{
					text2.append("6");
					text.append("6");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button8) {
			temp = Double.parseDouble(text2.getText());
			text.append("*");
			testing = 2;
			operation = true;
		}
		if (e.getSource() == button9) {
			if(operation == true)
			{
				text2.setText("1");
				text.append("1");
			}
			else
			{			
				if(times == 0)
				{
					text2.setText("1");
					text.append("1");	
					times++;
				}
				else
				{
					text2.append("1");
					text.append("1");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button10) {
			if(operation == true)
			{
				text2.setText("2");
				text.append("2");
			}
			else
			{	
				if(times == 0)
				{
					text2.setText("2");
					text.append("2");	
					times++;
				}
				else
				{
					text2.append("2");
					text.append("2");	
				}
			}
			operation = false;	
		}
		if (e.getSource() == button11) {
			if(operation == true)
			{
				text2.setText("3");
				text.append("3");
			}
			else
			{
				if(times == 0)
				{
					text2.setText("3");
					text.append("3");	
					times++;
				}
				else
				{
					text2.append("3");
					text.append("3");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button12) {
			temp = Double.parseDouble(text2.getText());
			text.append("-");
			testing = 3;
			operation = true;
		}
		if (e.getSource() == button13) {
			if(operation == true)
			{
				text2.setText("0");
				text.append("0");
			}
			else
			{
				if(times == 0)
				{
					text2.setText("0");
					text.append("0");	
					times++;
				}
				else
				{
					text2.append("0");
					text.append("0");	
				}
			}
			operation = false;
		}
		if (e.getSource() == button14) {
			text2.append(".");
			text.append(".");
		}
		if (e.getSource() == button15) {
			temp = Double.parseDouble(text2.getText());
			text.append("+");
			testing = 4;
			operation = true;
		}
		if (e.getSource() == button16) {

			text2.setText("0");
			text.setText("");
			times = 0;
			testing = 0;	

		}
		if (e.getSource() == button17) {
		
			temp2 = Double.parseDouble(text2.getText());
			
			// Depending on operation.
			if(testing == 0)
			{
				total = temp2;
				total2 = String.valueOf(total);
			}
			else if(testing == 1)
			{
				total = temp / temp2;
				total2 = String.valueOf(total);
			}
			else if(testing == 2)
			{
				total = temp * temp2;
				total2 = String.valueOf(total);	
			}
			else if(testing == 3)
			{
				total = temp - temp2;
				total2 = String.valueOf(total);
			}
			else if(testing == 4)
			{
				total = temp + temp2;
				total2 = String.valueOf(total);
			}
			text2.setText(total2);
			text.setText("");
		}
		// Creates a new window for help information.
		if(e.getSource() == help)
		{
			JOptionPane.showMessageDialog(this, "Eduardo Trejo\n" + "CST 338: Software Design\n" +
										  "This program implements a Calculator GUI\n" + "It is able to handle "
										  		+ "simpleOperations like + - * /\n");
		}
	}
}