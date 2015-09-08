/*
	Classe derivee de la classe de base PBD et qui permet  
	de creer des objets correspondant e des points dans l'espace
	(precises par leurs coordonnees cartesiennes)	 
*/

package cms_tp14;

public class PTD extends PBD 
{
	//champ d'instance prive propre (supplementaire ou specifique)
	//e preciser ci-dessous
	private static int nbPoints=0;
	
	//champ statique prive redefini
	//e preciser ci-dessous
	private double z;
		
	//constructeur sans arguments 
	//(preciser s'il est surcharge ou non)
	//et qui n'appelle pas explicitement un constructeur "mere"
	PTD()
	{
		this(0.0,0.0,0.0);
	}
	
	//constructeur  avec trois arguments
	//(preciser s'il est surcharge ou non)
	//et qui appelle explicitement un constructeur "mere"
	PTD(double x, double y, double z)
	{
		//preciser le corps
		super(x, y);
		this.z=z;
		nbPoints++;
	}
	
	//methodes d'acces aux champs prives propres	
	public void setZ(double z)
	{
		this.z=z;
		//preciser le corps
	}
		
	public double getZ()
	{
		//preciser le corps
		return this.z;
	}
	
	public static int getNbPoints()
	{
		//preciser le corps
		return nbPoints;
	}
	
	//methode d'instance pour verifier l'egalite de deux points
	//(preciser si elle est surchargee ou redefinie)
	public boolean verifierEgalite(PTD deuxiemePoint)
	{
		//preciser le corps
		if (z!=deuxiemePoint.z)
			return false;
		return PBD.verifierEgalite(this, deuxiemePoint);
	}										  
	
	//methode statique  pour verifier l'egalite de deux points
	//(preciser si elle est surchargee ou "hidden")
	public static boolean verifierEgalite(PTD premierPoint,
										  PTD deuxiemePoint)
	{
		//preciser le corps
		if (premierPoint.z!=deuxiemePoint.z)
			return false;
		return PBD.verifierEgalite(premierPoint, deuxiemePoint);
	}	

	//methode d'instance qui retourne le clone d'un point
	//Attention : e partir du JDK 5.0, elle peut s'appeler creerClone !
	public PTD creerClone( )

	{
		//preciser le corps
		return new PTD(this.getX(),this.getY(),this.getZ());
	}	
	
	//methode statique qui retourne le clone d'un point
	//(preciser si elle est surchargee ou "hidden")
	public static PTD creerClone(PTD pointSource)
	{
		//preciser le corps
		return new PTD(pointSource.getX(),pointSource.getY(),pointSource.getZ());		
	}
	
	//methode d'instance pour afficher les coordonnees d'un point  
	//(preciser si elle est surchargee ou redefinie) 
	//et qui appelle la methode d'origine
	public void afficher()
	{
		//preciser le corps
		System.out.print("Bonjour!, Je suis un Point Tridimensional, avec composantes ");
		System.out.print(this.getX() +", " + this.getY() + ", " + z);
	}

	static public double calculerDistance(PTD Point1, PTD Point2){
//		if (Point1 instanceof PBD)
		double dx = Point1.getX()-Point2.getX();
		double dy = Point1.getY()-Point2.getY();
		double dz = Point1.getZ()-Point2.getZ();
		return Math.pow((Math.pow(dx, 2)+Math.pow(dy, 2)+Math.pow(dz,2)), 1/2);
	} 
}
	
	
	
	
	
	
