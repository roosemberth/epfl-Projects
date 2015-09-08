package cms_tp15;

public abstract class Quadrilateres implements IAireCalculable
{
	protected String nom;
	
	//Constructeur surchargé sans argument
	Quadrilateres( )
	{
		this("Sans_nom");
	}
	
	//Constructeur surchargé avec un argument
	Quadrilateres(String nom)
	{
		this.nom = new String(nom);
	}
	
	//Méthode abstraite
	abstract double calculerPerimetre();
}
