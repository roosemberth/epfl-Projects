package cms_tp16;

/*Classe d�riv�e de la classe de base UneDate 
 * Elle  r�alise une sp�cialisation des dates par l'encapsulation suppl�mentaire 
 * de l'heure et de la minute, ainsi que d'un nom de personne.
 */

public class DateNaissance extends UneDate
{
	//champs propres (sp�cifiques) priv�s avec des valeurs initiales indiqu�es
	private int heure=0, minute=0;
	private String nom="Sans_nom";

//	*******************************************************************************************
	//Constructeur sans argument
	public DateNaissance( ) 
	{
	}
	
	//Constructeur avec 5 arguments
	public DateNaissance(int jour, int mois, int an, int heure, int minute, String nom) 
	{
		//A compl�ter
		super(jour, mois, an);
		this.heure=heure%24;
		this.minute=minute%60;
	}

//	*******************************************************************************************
	//M�thodes d'alt�ration (Setters and Getters) pour les 3 champs propres (sp�cifiques)
	
	//L'heure est valide si sa valeur est comprise entre 0 et 23.
	public void setHeure(int heure) 
	{
		//A compl�ter
		this.heure=heure%24;
	}
	
	public int getHeure() 
	{
		//A compl�ter
		return this.heure;
	}
	
	//La minute est valide si sa valeur est comprise entre 0 et 59.
	public void setMinute(int minute) 
	{
		//A compl�ter
		this.minute=minute%60;
	}
	
	public int getMinute() 
	{
		//A compl�ter
		return this.minute;
	}
	
	public void setNom(String nom) 
	{
		//A compl�ter
		this.nom=nom;
	}
	
	public String getNom() 
	{
		//A compl�ter
		return this.nom;
	}

//	*******************************************************************************************
	//Red�finition de la m�thode equals h�rit�e de la classe m�re UneDate
	@Override
	public boolean equals(Object deuxiemeObjet) 
	{
		if (!super.equals(deuxiemeObjet)) return false;
		if (this.hashCode()!=deuxiemeObjet.hashCode()) return false;
		return true;
	}

	//Red�finition de la m�thode hashCode h�rit�e de la classe racine Object
	@Override
	public int hashCode( ) 
	{
		return super.hashCode()+(this.heure*100+this.minute)*100000000;
	}

	//Red�finition de la m�thode toString h�rit�e de la classe racine Object
	@Override
	public String toString( )
	{
		return super.toString() + " à " + this.heure + (this.heure==1?" heure ": " heures ") + "et " + this.minute + (this.minute==1?" minute ": " minutes "); 
	}
}
