import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankBalanceGui extends JFrame implements ActionListener {
   private JLabel balanceLabel;
   private JLabel amountLabel;
   private JTextField totalBalance;
   private JTextField amount;
   private JButton setBalanceButton;
   private JButton depositButton;
   private JButton withdrawButton;

   BankBalanceGui() {
      GridBagConstraints positionConst = null;
      setTitle("Salary");
      balanceLabel = new JLabel("Balance:");
      amountLabel = new JLabel("Amount:");

      totalBalance = new JTextField(15);
      totalBalance.setEditable(false);
      totalBalance.setText("0");
      
      amount = new JTextField(15);
      amount.setEditable(true);
      amount.setText("0");

      setBalanceButton = new JButton("Set Balance");
      setBalanceButton.addActionListener(this);
      
      depositButton = new JButton("Deposit");
      depositButton.addActionListener(this);
      
      withdrawButton = new JButton("Withdraw");
      withdrawButton.addActionListener(this);


      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      positionConst.gridx = 0;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      
      add(balanceLabel, positionConst);

      positionConst.gridx = 2;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(totalBalance, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(amountLabel, positionConst);

      positionConst.gridx = 2;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(amount, positionConst);
      
      positionConst.gridx = 0;
      positionConst.gridy = 2;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(setBalanceButton, positionConst);
      
      positionConst.gridx = 1;
      positionConst.gridy = 2;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(depositButton, positionConst);
      
      positionConst.gridx = 2;
      positionConst.gridy = 2;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(withdrawButton, positionConst);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      String userInput;
      String balanceAmount;
      double outputAmount = 0;
      
      if(event.getSource() == setBalanceButton) {
    	  userInput = amount.getText();
    	  outputAmount = Double.parseDouble(userInput);
    	  amount.setText("0");
    	  
      }
      if(event.getSource() == depositButton) {
    	  userInput = amount.getText();
    	  balanceAmount = totalBalance.getText();
    	  outputAmount = Double.parseDouble(balanceAmount) + Double.parseDouble(userInput);
    	  amount.setText("0");
      }
      if(event.getSource() == withdrawButton) {
    	  userInput = amount.getText();
    	  balanceAmount = totalBalance.getText();
    	  outputAmount = Double.parseDouble(balanceAmount) - Double.parseDouble(userInput);
    	  amount.setText("0");
      }
      
      totalBalance.setText(Double.toString(outputAmount));

   }

   public static void main(String[] args) {
	   
	  BankBalanceGui myFrame = new BankBalanceGui();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}