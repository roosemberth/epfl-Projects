package cms_tp9;

import java.awt.Color;

//une classe pour instancier des objets PMD_Private
//qui ont des champs priv�s 
public class PMD_Private {
	// les champs de la classe sont priv�s
	// ils peuvent �tre modifi�s ou lus � l'aide des m�thodes publiques
	private char	nomPoint	= 'Z';
	private double	posX		= 0;
	private Color	couleur		= Color.BLUE;

	// m�thode publique qui permet la modification du champ priv� "nomPoint"
	public void setNomPoint(char nouveauNom) {
		nomPoint = nouveauNom;
	}

	public Color getColeur() {
		return couleur;
	}

	public void setColeur(Color newColor) {
		couleur = newColor;
	}

	// m�thode publique qui permet la lecture du champ priv� "nomPoint"
	public char getNomPoint() {
		return nomPoint;
	}

	// m�thode publique qui permet la modification du champ priv� "posX"
	public void setPosX(double nouvellePosition) {
		posX = nouvellePosition;
	}

	// m�thode publique qui permet la lecture du champ priv� "posX"
	public double getPosX() {
		return posX;
	}

	// m�thode publique qui affiche les informations sur chaque point
	public void afficher() {

		String nomColeur = "";
		if (couleur == Color.WHITE) {
			nomColeur = "White";
		} else if (couleur == Color.LIGHT_GRAY) {
			nomColeur = "Light Gray";
		} else if (couleur == Color.GRAY) {
			nomColeur = "Gray";
		} else if (couleur == Color.DARK_GRAY) {
			nomColeur = "Dark Gray";
		} else if (couleur == Color.BLACK) {
			nomColeur = "Black";
		} else if (couleur == Color.RED) {
			nomColeur = "Red";
		} else if (couleur == Color.PINK) {
			nomColeur = "Pink";
		} else if (couleur == Color.ORANGE) {
			nomColeur = "Orange";
		} else if (couleur == Color.YELLOW) {
			nomColeur = "Yellow";
		} else if (couleur == Color.GREEN) {
			nomColeur = "Green";
		} else if (couleur == Color.MAGENTA) {
			nomColeur = "Magenta";
		} else if (couleur == Color.CYAN) {
			nomColeur = "Cyan";
		} else if (couleur == Color.BLUE) {
			nomColeur = "Blue";
		}

		System.out.println("Mon nom est : " + nomPoint + ".");
		System.out.println("Mon abcisse est : " + posX + ".");
		System.out.println("Ma Couleur est : " + (nomColeur==""?couleur:nomColeur) + ".");
	}

	public void translate(double Mouvement) {
		posX += Mouvement;
	}

	// @Override
	// public String toString(){
	// return "(" + nomPoint + ":" + posX + ", " + couleur + ")";
	// }
}
