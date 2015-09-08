package cms_tp15;
/*
 La classe non abstraite Carres d�rive de la classe de base Rectangles et permet 
 d'instancier et de travailler avec des objets Java qui correspondent � des carr�s 
 d�crits par un nom, l'abscisse et l'ordonn�e du coin sup�rieur gauche et la longueur du c�t�.
*/

public class Carres extends Rectangles
{
	//il n'y a pas de champ sp�cifique
	
	//constructeur surcharg� sans argument
	//l'instance cr��e avec ce constructeur correspond a un carr� de nom "sans_nom",
	//ayant le coin sup�rieur gauche � l'origine et la longueur du c�t� nulle
	Carres( )
	{
		super("sans_nom", 0, 0, 0, 0);
	}
	
	//constructeur surcharg� avec 4 arguments
	Carres(String nom, double x, double y, double cote)
	{
		super(nom, x, y, cote, cote);
	}
	
	//red�finitions de 3 m�thodes
	//(la m�thode afficher() doit indiquer le nom du carr� correspondant et la longueur de son c�t�)
	public void afficher(){
		System.out.println("Bonjour, je suis un carré de nom " + this.nom + " avec un coté de " + this.gethauteur());
	}
}
