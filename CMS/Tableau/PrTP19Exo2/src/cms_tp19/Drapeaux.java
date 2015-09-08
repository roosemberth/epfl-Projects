package cms_tp19;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Drapeaux extends JFrame {
	/* Rectangles[] will hold two Rectangles forming the white part of the Swiss flag */
	JPanel Rectangles[] = new JPanel[2];
	Dimension TailleDrapeaux = getContentPane().getSize();
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension Ecran = tk.getScreenSize();

	public Drapeaux(){
		setTitle("Drapeaux");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		PosisionateFlag();
		setResizable(true);
		setVisible(true);
		/* The background wil from the back part of the Swiss flag */
		getContentPane().setBackground(Color.RED);
		getContentPane().setPreferredSize(new Dimension(600, 600));
		//System.out.println("CP " + getContentPane().getSize() );
		
		setLayout(null);
		TailleDrapeaux = getContentPane().getSize();
		
		Rectangles[0]=new JPanel();
		add(Rectangles[0]);
		Rectangles[0].setVisible(true);
		Rectangles[0].setBackground(Color.WHITE);

		Rectangles[1]=new JPanel();
		add(Rectangles[1]);
		Rectangles[1].setVisible(true);
		Rectangles[1].setBackground(Color.WHITE);

		UpdateFlagSize();

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				/* Keep Aspect Ratio */
//				int W = 4;  
//			    int H = 3;  
//			    Rectangle b = e.getComponent().getBounds();
//			    e.getComponent().setBounds(b.x, b.y, b.width, b.width*H/W);
				UpdateFlagSize();
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				PosisionateFlag();
			}
		});
	}
	
	public void PosisionateFlag(){
		setBounds((Ecran.width-900)/2, (Ecran.height-600)/2, 900, 600+21);
	}
	
	public void UpdateFlagSize(){
		TailleDrapeaux = getContentPane().getSize();
		Rectangles[0].setVisible(true);
		Rectangles[1].setVisible(true);
		/* Get a "Properly Dimensioned" Swiss Flag */
		Rectangles[0].setBounds((TailleDrapeaux.width*07)/24, (TailleDrapeaux.height*13)/32, (TailleDrapeaux.width*5)/12, (TailleDrapeaux.height*3)/16);
		Rectangles[1].setBounds((TailleDrapeaux.width*07)/16, (TailleDrapeaux.height*03)/16, (TailleDrapeaux.width*1)/8, (TailleDrapeaux.height*5)/8);
	}
}