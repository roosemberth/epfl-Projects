package cms_tp2;

import java.awt.Font;

import javax.swing.* ;

public class CP_TP2Exo1 {
	public static void main(String[ ] args) { 
		JFrame myFrame = new JFrame("Mon Premier Swing");
		
//		myFrame.setSize(200,150) ;
		myFrame.setBounds(400, 400, 550, 200);

		final JLabel myLabel = new JLabel("Bons r�sultats au QCM !", SwingConstants.CENTER) ;		
//		myFrame.getContentPane( ).add(myLabel) ;
		myFrame.add(myLabel) ;		
		
		Font PolicePPal = new Font("Arial", Font.BOLD | Font.ITALIC, 24);
		myLabel.setFont(PolicePPal);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
//		myFrame.pack() ;
		myFrame.setVisible(true) ;
	}
}
