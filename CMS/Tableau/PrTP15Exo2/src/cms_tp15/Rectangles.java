package cms_tp15;

/*
La classe non abstraite Rectangles est la descendante directe de la classe de base Quadrilateres;
elle impl�mente l'interface IAffichable et permet d'instancier et de travailler avec des objets Java 
qui correspondent � des rectangles d�crits par un nom, l'abscisse et l'ordonn�e du coin sup�rieur gauche 
ainsi que la longueur et la hauteur.
*/

public class Rectangles extends Quadrilateres implements IAffichable
{
	//champs priv�s sp�cifiques
	private double x, y, longueur, hauteur;
	
	//constructeur surcharg� sans argument
	//l'instance cr��e avec ce constructeur correspond a un rectangle de nom "sans_nom",
	//ayant le coin sup�rieur gauche � l'origine et la longueur et la hauteur nulles
	Rectangles( )
	{
		super("sans_nom");
		x=y=0;
	}
	
	//constructeur surcharg� avec 5 arguments
	Rectangles(String nom, double x, double y, double longueur, double hauteur)
	{
		super(nom);
		this.x=x;
		this.y=y;
		this.longueur=longueur;
		this.hauteur=hauteur;
	}

	//8 d�finitions des m�thodes "d'alt�ration" (Getters and Setters) pour les champs priv�s
	//(conform�ment au m�canisme d'encapsulation)
	
	public double getx(){
		return x;
	}
	public double gety(){
		return y;
	}
	public double getlongueur(){
		return longueur;
	}
	public double gethauteur(){
		return hauteur;
	}
	
	public void setX(double val){
		x=val;
	}
	public void setY(double val){
		y=val;
	}
	public void setLongueur(double val){
		longueur=val;
	}
	public void setHauteur(double val){
		hauteur=val;
	}
	//(re)d�finitions de toutes les m�thodes abstraites
	//(la m�thode afficher() doit indiquer le nom du rectangle correspondant, 
	//sa longueur et sa hauteur)
	@Override
	public void afficher(){
		System.out.print("Bonjour, je suis le rectangle de nom " + this.nom + " avec un hauteur de " + hauteur);
		System.out.print(" et une longueur de " + longueur + ".\n");
	}

	@Override
	public double calculerAire() {
		return hauteur*longueur;
	}

	@Override
	double calculerPerimetre() {
		return 2*hauteur+2*longueur;
	}
	
	
}
