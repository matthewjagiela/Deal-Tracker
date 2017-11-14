import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialSetup {

	public int numberOfKeywords;
	public int timeInterval;
	private JFrame frame;
	private JTextField amountOfItemsTextField;
	private JLabel mainLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialSetup window = new InitialSetup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialSetup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 142);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		mainLabel = DefaultComponentFactory.getInstance().createLabel("How Many Items Do You Want To Track?");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setBounds(6, 6, 437, 16);
		frame.getContentPane().add(mainLabel);
		handleAmountOfItems();
		
		
	}
	
	private void handleAmountOfItems() {
		//Deal with the amountOfItemsTextField and getting the data right here....
				amountOfItemsTextField = new JTextField();
				amountOfItemsTextField.addActionListener(new ActionListener() { //Upon the user pressing enter.... 
					public void actionPerformed(ActionEvent e) {
						numberOfKeywords = Integer.parseInt(amountOfItemsTextField.getText()); //Take the number that is in the text field and parse it into an int so we can get it later... 
						amountOfItemsTextField.setVisible(false);
						handleTimeInterva();
					}
				});
				amountOfItemsTextField.setBounds(148, 34, 130, 26);
				frame.getContentPane().add(amountOfItemsTextField);
				amountOfItemsTextField.setColumns(10);
				
	}
	private void handleTimeInterva() {
		//Do things with the label:
		mainLabel.setText("How often do you want to check for deals? (Minutes)");
		//Do things with a textBox to get the interval we need to check
		JTextField amountOfTime = new JTextField();
		amountOfTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeInterval = Integer.parseInt(amountOfTime.getText());
				amountOfTime.setVisible(false); //Hide The TextField so we can generate another one
				System.out.println(timeInterval);
			}
		});
		amountOfTime.setBounds(148, 34, 130, 26);
		frame.getContentPane().add(amountOfTime);
		
	}
}
