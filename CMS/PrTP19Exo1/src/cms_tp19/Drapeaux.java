package cms_tp19;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class Drapeaux extends JFrame {
	JPanel Carres[] = new JPanel[25];
	Dimension TailleDrapeaux = getContentPane().getSize();
	public Drapeaux(){
		setTitle("Drapeaux");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension Ecran = tk.getScreenSize();
		setBounds((Ecran.width-600)/2, (Ecran.height-600)/2, 600, 600+21);
		setResizable(true);
		setVisible(true);
		getContentPane().setBackground(Color.RED);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		getContentPane().setPreferredSize(new Dimension(600, 600));
		System.out.println("CP " + getContentPane().getSize() );
		TailleDrapeaux = getContentPane().getSize();
		
		for (int i=0; i<25; ++i){
			Carres[i]=new JPanel();
			Carres[i].setPreferredSize(new Dimension((int)((TailleDrapeaux.height-1)/5), (int)((TailleDrapeaux.width-1)/5)));
			switch (i){
			case 7: 
			case 11:
			case 12: 
			case 13: 
			case 17:
					Carres[i].setBackground(Color.WHITE);
					break;
				default:
					Carres[i].setBackground(Color.RED);				
			}
			add(Carres[i]);
			Carres[i].setVisible(true);
		}
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				super.componentResized(e);
				UpdateFlagSize();
				System.out.println("Recieved Event! : " + e);
			}
		});
		
	}
	
	public void UpdateFlagSize(){
		TailleDrapeaux = getContentPane().getSize();
		for (int i=0; i<25; ++i){
			Carres[i].setPreferredSize(new Dimension((int)((TailleDrapeaux.height-5)/5), (int)((TailleDrapeaux.width-5)/5)));
		}
	}
}
