package cms_tp16;

/*Classe de base d�finie par le programmeur afin de travailler avec des objets encapsulant des dates
 * indiqu�es par le jour, le mois et l'ann�e
 */
public class UneDate 
{
	//Champs priv�s avec des valeurs initiales indiqu�es
	private int jour=1, mois=1, an=1970;
	
//*******************************************************************************************	
	//Constructeur sans argument
	public UneDate( )
	{
	}

	//Constructeur avec trois arguments de type entier
	//Il utilise les m�thodes Setters de cette m�me classe.
	public UneDate(int jour, int mois, int an) 
	{
		this.jour=jour;
		this.mois=mois;
		this.an=an;
	}
	
	//Constructeur avec un argument de type cha�ne de caract�res
	//Il utilise la m�thode parseTabInt et les m�thodes Setters de cette m�me classe.
	public UneDate(String strDate)
	{
		int [] tableDate;
		tableDate = parseTabInt(strDate);
		this.jour=tableDate[0];
		this.mois=tableDate[1];
		this.an	=tableDate[2];
	}
	
//	*******************************************************************************************	
	//6 m�thodes d'alt�ration (Setters et Getters) pour les 3 champs priv�s

	//L'an est valide si sa valeur est comprise entre 1800 et 2500.
	public void setAn(int an) 
	{
		if(an>=1800 && an<=2500)
		{
			this.an = an;
		}else
		{
			System.out.println("An non valide !");
		}
	}

	public int getAn( ) 
	{
		return an;
	}

	//Le mois est valide si sas valeur est comprise entre 1 et 12.
	public void setMois(int mois) 
	{
		if(mois>0 && mois<13)
		{
			this.mois = mois;
		}else
		{
			System.out.println("Mois non valide !");
		}
	}
	
	public int getMois() 
	{
		return mois;
	}

	//Le jour est valide en fonction des valeurs du mois et, �ventuellement, de l'an.
	public void setJour(int jour) 
	{
		if(jour<1 || jour>31)
		{
			System.out.println("Jour non valide !");
		}
		else if(mois==2 && jour <29)
		{
			this.jour=jour;
		}else if(mois ==2 && jour==29 && (an%400==0 || (an%4==0 && an%100!=0)))
		{
			this.jour=jour;
		}else if(mois==2 && (jour==29 || jour==30 || jour == 31))
		{
			System.out.println("Jour non valide !");			
		}else if(jour<=30) 
		{
			this.jour=jour;
		}else if(jour ==31 && (mois==1 || mois==3 || mois==5 || mois==7 || mois==8 || mois ==10 || mois==12))
		{
			this.jour = jour;
		}else
		{
			System.out.println("Jour non valide !");
		}
	}
	
	public int getJour() 
	{
		return jour;
	}

//	*******************************************************************************************
	//M�thode statique qui v�rifie si son argument de type cha�ne de caract�es 
	//respecte rigoureusement le masque "jj.mm.aaaa".
	static boolean masqueValide(String strDate)
	{
		if ((strDate.length()!=10)||(strDate.length()!=8)) return false;	// strDate = yy.mm.anne
		for (int x=0; x<10; ++x){
			switch (x){
				case 2:
				case 5:
					if (strDate.charAt(x)!='.') return false;
					break;
				default:
					if ((strDate.charAt(x)<'0')||(strDate.charAt(x)>'9')) return false;
			}
		}
		return true;
	}
	
	//M�thode statique qui retourne l'adresse d'un tableau de 3 entiers correspondant au jour, au mois et � l'an,
	//cr�� � partir de son argument de type cha�ne de caract�res.
	//Elle utilise la m�thode masqueValide de cette m�me classe.
	//Si la cha�ne argument n'est pas valide, le tableau de trois entiers cr�� doit correspondre aux valeurs initiales
	//indiqu�es explicitement pour les trois champs priv�s de la classe
	static int[ ] parseTabInt(String strDate)
	{
		int [] table = new int[3];
		table[0] = Integer.parseInt(strDate.substring(0, 1))%31;
		table[1] = Integer.parseInt(strDate.substring(3, 4))%12;
		table[2] = Integer.parseInt(strDate.substring(6, strDate.length()-1));
		return table;
	}
	
	//M�thode statique qui retourne l'adresse d'un objet de type UneDate obtenu 
	//� partir de la date indiqu�e par son argument de type cha�ne de caract�res.
	static UneDate valueOf(String strDate)
	{
		int [] tableDate;
		tableDate = parseTabInt(strDate);
		return new UneDate(tableDate[0], tableDate[1], tableDate[2]);
	}
	
//	*******************************************************************************************
	//Red�finition de la m�thode equals h�rit�e de la classe racine Object
	@Override
	public boolean equals(Object deuxiemeObjet) 
	{
		if (this.hashCode()!=(deuxiemeObjet.hashCode()))
			return false;
		return true;
	}

	//Red�finition de la m�thode hashCode h�rit�e de la classe racine Object	
	@Override
	public int hashCode() 
	{
		return this.an*10000+(this.mois*100)+this.jour;
	}

	//Red�finition de la m�thode toString h�rit�e de la classe racine Object
	@Override
	public String toString( )
	{
		return "Le " + this.jour + "." + this.mois + "." + this.an;
	}
}
