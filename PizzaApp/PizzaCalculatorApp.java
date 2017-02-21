import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;
import javax.swing.border.*;


public class PizzaCalculatorApp {
	public static void main(String args[]) { 
		JFrame frame = new PaymentFrame();
		frame.setVisible(true);
	}
}

class PaymentFrame extends JFrame{ 
	
	public PaymentFrame() { 
		this.setTitle("Pizza Calculator");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new PaymentPanel();
		this.add(panel);
		this.pack();
		centerWindow(this);	
	}
	
	private void centerWindow(Window w) { 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width - w.getWidth())/2, (d.height-w.getHeight())/2);
	}
}

class PaymentPanel extends JPanel implements ActionListener {
	
	private JRadioButton small, medium, large;
	private JCheckBox sausage, olives, pepperoni, mushrooms, salami, anchovies;
	private JLabel price;
	private JTextField finalPrice;
	private JButton calculate, exit;
	
	public PaymentPanel() { 
		// A GridBagLayout places components in a grid of rows and columns,
		// allowing specified components to span multiple rows or columns.
		
		this.setLayout(new GridBagLayout());
		
		// Used for design.
        Border loweredBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		
        // Panel serves as a content pane.
        // Size Panel for the size selection.
		JPanel sizePanel = new JPanel();
		// Group up Buttons.
		ButtonGroup sizeGroup = new ButtonGroup();
		sizePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		sizePanel.setBorder(BorderFactory.createTitledBorder(loweredBorder, "Size:"));
		
		small = new JRadioButton("Small", true);
		small.addActionListener(this);
		sizePanel.add(small);
		sizeGroup.add(small);
		
		medium = new JRadioButton("Medium");
		medium.addActionListener(this);
		sizePanel.add(medium);
		sizeGroup.add(medium);
		
		large = new JRadioButton("Large");
		large.addActionListener(this);
		sizePanel.add(large);
		sizeGroup.add(large);
		
		this.add(sizePanel, getConstraints(0,0,2,1, GridBagConstraints.WEST));

		JPanel toppingsPanel = new JPanel();
		toppingsPanel.setLayout(new GridLayout(3,2));
		toppingsPanel.setBorder(BorderFactory.createTitledBorder(loweredBorder, "Toppings:"));
		
		sausage = new JCheckBox("Sausage");
		toppingsPanel.add(sausage);
		
		olives = new JCheckBox("Olives");
		toppingsPanel.add(olives);
		
		pepperoni = new JCheckBox("Pepperoni");
		toppingsPanel.add(pepperoni);
		
		mushrooms = new JCheckBox("Mushrooms");
		toppingsPanel.add(mushrooms);
		
		salami = new JCheckBox("Salami");
		toppingsPanel.add(salami);
		
		anchovies = new JCheckBox("Anchioves");
		toppingsPanel.add(anchovies);
		
		this.add(toppingsPanel, getConstraints(0,1,2,1, GridBagConstraints.WEST));
		
		// Create a flow layout for price.
		JPanel pricePanel = new JPanel();
		pricePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		price = new JLabel("Price: ");
		pricePanel.add(price);
		
		finalPrice = new JTextField(10);
		finalPrice.setEditable(false);
		finalPrice.setFocusable(false);
		pricePanel.add(finalPrice);
		
		this.add(pricePanel, getConstraints(0,2,2,1, GridBagConstraints.WEST));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		buttonPanel.add(calculate);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		buttonPanel.add(exit);
		
		this.add(buttonPanel, getConstraints(0,3,2,1, GridBagConstraints.EAST));
		
	}
	
    // A  method for setting grid bag constraints.
    private GridBagConstraints getConstraints(int gridx, int gridy,
                                              int gridwidth, int gridheight, 
                                              int anchor)
    {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = anchor;
        
        return c;
    }
   
    // Listens to the actions performed.
	public void actionPerformed(ActionEvent e) {
		
		double smallsize = 6.99, mediumsize = 8.99, largesize = 10.99;
		double  sausageP = 0, pepperoniP = 0, salamiP = 0, olivesP = 0,
				mushroomsP = 0, anchoviesP = 0;
		
		Object source = e.getSource();
		if (source == exit) { 
			System.exit(0);
		} 
		// Calculates the prizes of the selections.
		else if (source == calculate) { 
			if (small.isSelected())
			{
				if(sausage.isSelected())
				{
					sausageP = 1.49;
				}
				if(pepperoni.isSelected())
				{
					pepperoniP = 1.49;
				}
				if(salami.isSelected())
				{
					salamiP = 1.49;
				}
				if(olives.isSelected())
				{
					olivesP = 0.99;
				}
				if(mushrooms.isSelected())
				{
					mushroomsP = 0.99;
				}
				if(anchovies.isSelected())
				{
					anchoviesP = 0.99;
				}
				
				double futureValue = smallsize + sausageP + pepperoniP + salamiP +
						olivesP + mushroomsP + anchoviesP;
				NumberFormat currency = NumberFormat.getCurrencyInstance();
                finalPrice.setText(currency.format(futureValue));
			}
			else if (medium.isSelected())
			{
				if(sausage.isSelected())
				{
					sausageP = 1.49;
				}
				if(pepperoni.isSelected())
				{
					pepperoniP = 1.49;
				}
				if(salami.isSelected())
				{
					salamiP = 1.49;
				}
				if(olives.isSelected())
				{
					olivesP = 0.99;
				}
				if(mushrooms.isSelected())
				{
					mushroomsP = 0.99;
				}
				if(anchovies.isSelected())
				{
					anchoviesP = 0.99;
				}
				
				double futureValue = mediumsize + sausageP + pepperoniP + salamiP +
						olivesP + mushroomsP + anchoviesP;
				NumberFormat currency = NumberFormat.getCurrencyInstance();
                finalPrice.setText(currency.format(futureValue));
			}  	
			else if (large.isSelected())
			{
				if(sausage.isSelected())
				{
					sausageP = 1.49;
				}
				if(pepperoni.isSelected())
				{
					pepperoniP = 1.49;
				}
				if(salami.isSelected())
				{
					salamiP = 1.49;
				}
				if(olives.isSelected())
				{
					olivesP = 0.99;
				}
				if(mushrooms.isSelected())
				{
					mushroomsP = 0.99;
				}
				if(anchovies.isSelected())
				{
					anchoviesP = 0.99;
				}
				
				double futureValue = largesize + sausageP + pepperoniP + salamiP +
						olivesP + mushroomsP + anchoviesP;
				NumberFormat currency = NumberFormat.getCurrencyInstance();
                finalPrice.setText(currency.format(futureValue));
			}
		}	
	}	
}