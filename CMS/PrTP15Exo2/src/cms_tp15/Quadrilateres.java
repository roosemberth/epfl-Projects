package cms_tp15;

public abstract class Quadrilateres implements IAireCalculable
{
	protected String nom;
	
	//Constructeur surcharg� sans argument
	Quadrilateres( )
	{
		this("Sans_nom");
	}
	
	//Constructeur surcharg� avec un argument
	Quadrilateres(String nom)
	{
		this.nom = new String(nom);
	}
	
	//M�thode abstraite
	abstract double calculerPerimetre();
}
