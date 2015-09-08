package cms_tp20;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Calculette  extends JFrame{
	JButton Touches[] = new JButton[16];
	JPanel DisplayAreaPanel = new JPanel(new BorderLayout(10, 10));
	JPanel MessageDisplayAreaPanel = new JPanel(new BorderLayout());
	JLabel MessageLabel = new JLabel();
	JLabel LastResultLabel = new JLabel();
	JLabel MainPanelLabel = new JLabel();
	JPanel KeyAreaPanel = new JPanel(new GridLayout(4,4));
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension Ecran = tk.getScreenSize();
	String[] BottonNames = {"7", "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "0", ".", "=", "+"};
	String FirstOperand = "";
	String SecondOperand = "";
	String LastResultString = "";
	char Operation = ' ';
	boolean OperationKnown = false;
	boolean UsingDecimalPoint = false;
	char tmp1;
	double LastResult = 0;
	
	public Calculette(){
		setTitle("Ma Calculette");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds((Ecran.width-258)/2, (Ecran.height-281)/2, 258, 281+21);
		setResizable(false);
		getContentPane().setPreferredSize(new Dimension(258, 281));
		
		add(DisplayAreaPanel, BorderLayout.NORTH);
		add(KeyAreaPanel, BorderLayout.CENTER);
		
		DisplayAreaPanel.setVisible(true);
		DisplayAreaPanel.setBackground(Color.WHITE);
		DisplayAreaPanel.setPreferredSize(new Dimension(258,50));
		
		DisplayAreaPanel.add(MessageDisplayAreaPanel, BorderLayout.NORTH);
		DisplayAreaPanel.add(MainPanelLabel, BorderLayout.CENTER);
		MessageDisplayAreaPanel.setVisible(true);
		MessageDisplayAreaPanel.add(MessageLabel, BorderLayout.WEST);
		MessageDisplayAreaPanel.add(LastResultLabel, BorderLayout.EAST);
		
		MessageLabel.setFont(new Font("Arial", Font.PLAIN, 8));
		LastResultLabel.setFont(new Font("Arial", Font.PLAIN, 8));
		
		KeyAreaPanel.setVisible(true);
		
		for (int i=0; i<16; ++i){
			Touches[i] = new JButton(BottonNames[i]);
			Touches[i].setVisible(true);
			KeyAreaPanel.add(Touches[i]);
			if (i%4==3||i==13||i==14){
				Touches[i].setBackground(Color.GREEN);
			}
			Touches[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					tmp1 = ((JButton)e.getSource()).getText().charAt(0);
					requestFocusInWindow();
					parseCommand(tmp1);
				} // End (overriden) actionPerformed method
			}); // End addActionListener
			
			setFocusable(true);
			requestFocusInWindow();
			
		}	// End of for (every drawn "key") Loop

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				char tmp1 = e.getKeyChar();
				//System.out.println("Pressed character: '" + tmp1 + "':" + (tmp1+0));
				
				if (tmp1==27) System.exit(0);
				else if (tmp1=='*') tmp1 = 'x';
				else if (tmp1==10) tmp1 = '=';

				parseCommand(tmp1);
			}
		});  // End addKeyListener		
		
		setVisible(true);
		
	}	// End of Builder
	
	void parseCommand(char tmp1){
		switch (tmp1){
			case 'x':
			case '-':
			case '/':
			case '+':
				if (OperationKnown){
					reprintOnError("une Operation", null);
					break;
				}
				if (FirstOperand==""){
					reprintOnError(null, "Veuillez preciser le " + "Première" + " Operand!");
					break;
				}
				System.out.print(tmp1);
				Operation = tmp1;
				OperationKnown = true;
				printOnScreen(null);
				break;
			case '=':
				if (FirstOperand==""){
					reprintOnError(null, "Veuillez preciser le " + "Première" + " Operand!");
					break;
				} else if (!OperationKnown){
					reprintOnError(null, "Veuillez preciser une Operation binaire à realizer!");
					break;
				} else if (SecondOperand==""){
					reprintOnError(null, "Veuillez preciser le " + "Deuxième" + " Operand!");
					break;
				}
				System.out.print(tmp1);
				UsingDecimalPoint = false;
				OperationKnown = false;
				LastResultString = Calculate();
				System.out.println(LastResultString);
				printOnScreen(LastResultString);
				break;
			case '.':
				if (UsingDecimalPoint){
					reprintOnError("une virgule", null);
					printOnScreen(null);
					break;
				}
				UsingDecimalPoint = true;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				System.out.print(tmp1);
				if (!OperationKnown){
					FirstOperand = new String(FirstOperand + tmp1);
				} else {
					SecondOperand = new String(SecondOperand + tmp1);
				}
				printOnScreen(null);
				break;
			default:
		}// End switch 
	}
	
	String Calculate(){
		double FirstNumber=Double.parseDouble(FirstOperand);
		double SecondNumber=Double.parseDouble(SecondOperand);
		LastResult = 0;
		switch (Operation) {
			case '+':
				LastResult = (FirstNumber + SecondNumber);
				break;
			case '-':
				LastResult = (FirstNumber - SecondNumber);
				break;
			case '/':
				if (SecondNumber==0){
					reprintOnError(null, "Vous ne pouvez pas diviser par zero!, veuillez precisez une autre nombre!");
					SecondOperand="";
					break;
				}
				LastResult = (FirstNumber /  SecondNumber);
				break;
			case 'x':
				LastResult = (FirstNumber * SecondNumber);
				break;				
			default:
				break;
		}
		if (LastResult!=0){
			FirstOperand = "";
			SecondOperand = "";
			Operation=' ';
			LastResultLabel.setText(LastResult + "");
			return new String(LastResult + "");
		}
		return "";
	}
	
	void reprintOnError(String offendingOperation, String errorString){
		if (errorString==null&&offendingOperation!=null){
			System.out.print(" " + "Vous aviez déjà precisé " + offendingOperation + ", veuillez prendre une autre option");
			MessageLabel.setText("Vous aviez déjà precisé " + offendingOperation + ", veuillez prendre une autre option");
		} else if (errorString!=null) {
			System.out.print("\n"+" " + errorString);
			MessageLabel.setText(errorString);
			System.out.flush();
		} else{
			System.out.println("Error Getting the error string! BUG!" );
		}
		System.out.print("\n" + FirstOperand + (Operation==' '?"":Operation) + SecondOperand);
	}
	
	void printOnScreen(String Message){
		if (Message==null){
			MessageLabel.setText(FirstOperand + (Operation==' '?"":Operation) + SecondOperand);
		} else {
			MessageLabel.setText(Message);
		}
	}
	
}	// End of Class
