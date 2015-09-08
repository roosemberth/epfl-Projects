/*
	Classe de base qui permet de creer des objets correspondant e des  
	points dans le plan (precises par leurs coordonnees cartesiennes)	 
*/
package cms_tp14;

public class PBD	//PointBiDim 
{
	//champs d'instance prives
	private double x, y ;
	//champ statique prive
	private static int nbPoints=0;
	
	//constructeur sans arguments
	//(surcharge dans la classe de base)
	PBD( )
	{
		this(0.0,0.0);
	}
	
	//constructeur avec deux arguments
	//(surcharge dans la classe de base)
	PBD(double x, double y)
	{
		this.x=x;
		this.y=y;
		nbPoints++;
	}
	
	//methodes d'acces aux champs prives
	public void setX(double x)
	{
		this.x=x;
	}
	
	public void setY(double y)
	{
		this.y=y;
	}
	
	public double getX( )
	{
		return x;
	}
	
	public double getY( )
	{
		return y;
	}
	
	public static int getNbPoints( )
	{
		return nbPoints;
	}
	
	//methode d'instance pour verifier l'egalite de deux points
	//(surchargee dans la classe de base)
	public boolean verifierEgalite(PBD deuxiemePoint)
	{
		if(x!=deuxiemePoint.x)
			return false;
		if(y!=deuxiemePoint.y)
			return false;
		return true;		
	}										  
	
	//methode statique pour verifier l'egalite de deux points
	//(surchargee dans la classe de base) 
	public static boolean verifierEgalite(PBD premierPoint,
										  PBD deuxiemePoint)
	{
		if(premierPoint.x!=deuxiemePoint.x)
			return false;
		if(premierPoint.y!=deuxiemePoint.y)
			return false;
		return true;		
	}	

	//methode d'instance qui retourne le clone d'un point
	//(surchargee dans la classe de base)
	public PBD creerClone( )
	{
		return new PBD(x,y);
	}	
	
	//methode statique qui retourne le clone d'un point
	//(surchargee dans la classe de base)
	public static PBD creerClone(PBD pointSource)
	{
		return new PBD(pointSource.x,pointSource.y);
	}
	
	//methode d'instance pour afficher les coordonnees d'un point
	public void afficher( )
	{
		System.out.print("Bonjour!, Je suis un Point Tridimensional, avec composantes ");
		System.out.print(x +", " + y);
	}
	
	static public double calculerDistance(PBD Point1, PBD Point2){
		double dx = Point1.getX()-Point2.getX();
		double dy = Point1.getY()-Point2.getY();
		//double dz = Point1.getZ()-Point2.getZ();
		return Math.pow((Math.pow(dx, 2)+Math.pow(dy, 2)), 1/2);
	}
}
	
	
	
	
	
	