import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class PaymentApp
{
    public static void main(String[] args)
    {
        JFrame frame = new PaymentFrame();
        frame.setVisible(true);
    }
}


class PaymentFrame extends JFrame
{
    public PaymentFrame()
    {
        setTitle("Payment Application");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new PaymentPanel();
        this.add(panel);
        this.pack();
        centerWindow(this);
    }

    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
}


class PaymentPanel extends JPanel implements ActionListener
{
    private JRadioButton creditCardRadioButton,

                         billCustomerRadioButton;

    
    private JList        cardTypeList;
    private JTextField   cardNumberTextField;
    private JComboBox    monthComboBox,
                         yearComboBox;
    private JCheckBox    verifiedCheckBox;
    private JButton      acceptButton,
                         exitButton;
    private JLabel       cardTypeLabel,
                         cardNumberLabel,
                         expirationDateLabel;

    public PaymentPanel()
    {
        setLayout(new GridBagLayout());

        Border loweredBorder
            = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        // radio button panel
        JPanel radioPanel = new JPanel();
        ButtonGroup billingGroup = new ButtonGroup();
        radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        radioPanel.setBorder(
            BorderFactory.createTitledBorder(loweredBorder, "Billing:"));

        // credit card radio button
        creditCardRadioButton = new JRadioButton("Credit card", true);
        creditCardRadioButton.addActionListener(this);
        billingGroup.add(creditCardRadioButton);
        radioPanel.add(creditCardRadioButton);

        // bill customer radio button
        billCustomerRadioButton = new JRadioButton("Bill customer");
        billCustomerRadioButton.addActionListener(this);
        billingGroup.add(billCustomerRadioButton);
        radioPanel.add(billCustomerRadioButton);

        add(radioPanel, getConstraints(0,0,3,1, GridBagConstraints.WEST));

        // card type label
        cardTypeLabel = new JLabel("Card type:");
        add(cardTypeLabel, getConstraints(0,1,1,1, GridBagConstraints.EAST));

        // card type list
        String[] cardNames = {"Visa", "Master Card", "American Express", "Other"};
        cardTypeList = new JList(cardNames);
        cardTypeList.setFixedCellWidth(170);
        cardTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cardTypeList.setVisibleRowCount(3);
        JScrollPane cardTypeScrollPane = new JScrollPane(cardTypeList);
        add(cardTypeScrollPane, getConstraints(1,1,2,1, GridBagConstraints.WEST));

        // card number label
        cardNumberLabel = new JLabel("Card number:");
        add(cardNumberLabel, getConstraints(0,2,1,1, GridBagConstraints.EAST));

        // card number text field
        cardNumberTextField = new JTextField(15);
        add(cardNumberTextField, getConstraints(1,2,2,1, GridBagConstraints.WEST));

        // expiration date label
        expirationDateLabel= new JLabel("Expiration date:");
        add(expirationDateLabel, getConstraints(0,3,1,1, GridBagConstraints.EAST));

        // month combo box
        String[] months = { "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December" };
        monthComboBox = new JComboBox(months);
        add(monthComboBox, getConstraints(1,3,1,1, GridBagConstraints.WEST));

        // year combo box
        String[] years = { "2011", "2012", "2013", "2014", "2015", "2016" };
        yearComboBox = new JComboBox(years);
        add(yearComboBox, getConstraints(2,3,1,1, GridBagConstraints.WEST));

        // verified check box
        verifiedCheckBox = new JCheckBox("Verified");
        add(verifiedCheckBox, getConstraints(1,4,1,1, GridBagConstraints.WEST));

        // calculate button
        acceptButton = new JButton("Accept");
        acceptButton.addActionListener(this);
        add(acceptButton, getConstraints(1,5,1,1, GridBagConstraints.EAST));

        // exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton, getConstraints(2,5,1,1, GridBagConstraints.CENTER));
    }

    
    // a  method for setting grid bag constraints
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

    
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == exitButton)
            System.exit(0);
        else if (source == acceptButton)
        {
            String msg = "";
            if (creditCardRadioButton.isSelected())
            {
                msg = "Bill " + (String)cardTypeList.getSelectedValue() +
                    "\nNumber + " + cardNumberTextField.getText() +
                    "\nExpiration date: " +
                    (String)monthComboBox.getSelectedItem() +
                    ", " + (String)yearComboBox.getSelectedItem();
                if (verifiedCheckBox.isSelected())
                    msg+= "\nCard has been verified.";
                else
                    msg+= "\nCard has not been verified.";
            }
            else
            {
                msg = "Customer will be billed.";
            }
            JOptionPane.showMessageDialog(this, msg);
            cardTypeList.setSelectedIndex(0);
            cardNumberTextField.setText("");
            monthComboBox.setSelectedIndex(0);
            yearComboBox.setSelectedIndex(0);
            verifiedCheckBox.setSelected(false);
        }
        else if (source == creditCardRadioButton || source == billCustomerRadioButton)
        {
            if (creditCardRadioButton.isSelected())
                enableCreditCardControls(true);
            else if (billCustomerRadioButton.isSelected())
                enableCreditCardControls(false);
        }
    }

    
    private void enableCreditCardControls(boolean enable)
    {
        cardTypeLabel.setEnabled(enable);
        cardTypeList.setEnabled(enable);
        cardNumberLabel.setEnabled(enable);
        cardNumberTextField.setEnabled(enable);
        expirationDateLabel.setEnabled(enable);
        monthComboBox.setEnabled(enable);
        yearComboBox.setEnabled(enable);
        verifiedCheckBox.setEnabled(enable);
    }

}