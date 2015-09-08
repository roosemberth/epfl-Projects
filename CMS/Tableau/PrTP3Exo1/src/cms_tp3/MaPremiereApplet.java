package cms_tp3;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JApplet;


public class MaPremiereApplet extends JApplet{
	public void paint(Graphics g){
		g.drawString("Bonjour! C'est ma premiere applet Java!", 100, 50);
		
		Font police = new Font("arial", Font.BOLD | Font.ITALIC, 20);
		g.setFont(police);
		
		g.setColor(Color.blue);
		g.drawString("Bonne Preparation pour le QCM!",  50,  40);
		
		g.setColor(Color.red);
		g.drawString("Bons resultats au QCM!",  50,  100);
		
		g.setColor(Color.green);
		g.drawLine(50, 105, 285, 105);
		
		AudioClip chanson = getAudioClip(getCodeBase(), "spacemusic.au");
		chanson.loop();
	}
}
