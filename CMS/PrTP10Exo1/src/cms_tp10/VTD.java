/*
	Classe qui permet � la fois de cr�er des objets correspondant � des vecteurs 
	tridimensionnels et de faire des calculs usuels avec les vecteurs (par exemple
	la somme, le produit scalaire, le produit vectoriel et le produit mixte)
	 
*/

package cms_tp10;

public class VTD 
{
	//champs d'instance priv�s (les composantes du vecteur tridimensionnel)
	private double composante1, composante2, composante3;
	//champ statique priv� (pour stocker le nombre d'objets cr��s � l'ex�cution)
	private static int nbVecteurs=0;	

//---------------------------------------------------------------------------------------
			
	//constructeur sans arguments
	VTD()
	{
		composante1=0.0;
		composante2=0.0;
		composante3=0.0;
		//ajouter une instruction afin de compter le nombre d'objets cr��s
		nbVecteurs++;

	}
	
	//constructeur (surcharg�) avec trois arguments
	VTD(double compo1, double compo2, double compo3)
	{
		composante1=compo1;
		composante2=compo2;
		composante3=compo3;
		//ajouter une instruction afin de compter le nombre d'objets cr��s	
		nbVecteurs++;
	}

//---------------------------------------------------------------------------------------
			
	//m�thodes d'acc�s aux champs priv�s
	public void setComposante1(double composante1)
	{
		this.composante1=composante1;
	}
	
	public void setComposante2(double composante2)
	{
		this.composante2=composante2;
	}
	
	public void setComposante3(double composante3)
	{
		this.composante3=composante3;
	}
	
	public double getComposante1()
	{
		return composante1;
	}
	
	public double getComposante2()
	{
		return composante2;
	}
	
	public double getComposante3()
	{
		return composante3;
	}
	
	public static int getNbVecteurs()
	{
		return nbVecteurs;
	}

//---------------------------------------------------------------------------------------

	//m�thode d'instance pour le calcul du produit scalaire
	public double calculerProduitScalaire(VTD deuxiemeVecteur)
	{
	 	double produitScalaire;
	 	produitScalaire	 =	composante1*deuxiemeVecteur.composante1+
	 						composante2*deuxiemeVecteur.composante2+
	 						composante3*deuxiemeVecteur.composante3;
	 	return produitScalaire;				
	}
	
	//m�thode statique (surcharg�e) pour le calcul du produit scalaire
	public static double calculerProduitScalaire(VTD premierVecteur, VTD deuxiemeVecteur)
	{
		double produitScalaire	 =	premierVecteur.composante1*deuxiemeVecteur.composante1+
									premierVecteur.composante2*deuxiemeVecteur.composante2+
									premierVecteur.composante3*deuxiemeVecteur.composante3;
		return produitScalaire;
	}

//---------------------------------------------------------------------------------------
	
	//m�thode d'instance pour le calcul de la somme
	public VTD calculerSomme(VTD deuxiemeVecteur)
	{
		VTD somme = new VTD();
		somme.composante1 = composante1 + deuxiemeVecteur.composante1 ;
		somme.composante2 = composante2 + deuxiemeVecteur.composante2 ;
		somme.composante3 = composante3 + deuxiemeVecteur.composante3 ;
		return somme;																	
	}	
	
	//m�thode statique (surcharg�e) pour le calcul de la somme
	public static VTD calculerSomme(VTD premierVecteur, VTD deuxiemeVecteur)
	{
		VTD somme = new VTD();
		somme.composante1 = premierVecteur.composante1 + deuxiemeVecteur.composante1 ;
		somme.composante2 = premierVecteur.composante2 + deuxiemeVecteur.composante2 ;
		somme.composante3 = premierVecteur.composante3 + deuxiemeVecteur.composante3 ;
		return somme;																			
	}

//---------------------------------------------------------------------------------------
	
	//m�thode d'instance pour le calcul du produit vectoriel
	public VTD calculerProduitVectoriel(VTD deuxiemeVecteur)
	{
		VTD produitVectoriel = new VTD();
		produitVectoriel.composante1  =	this.composante2*deuxiemeVecteur.composante3-
										composante3*deuxiemeVecteur.composante2;
		produitVectoriel.composante2  =	composante3*deuxiemeVecteur.composante1-
										composante1*deuxiemeVecteur.composante3;
		produitVectoriel.composante3  =	composante1*deuxiemeVecteur.composante2-
										composante2*deuxiemeVecteur.composante1;
		return produitVectoriel;																	
	}
	
	//m�thode statique (surcharg�e) pour le calcul du produit vectoriel
	public static VTD calculerProduitVectoriel(VTD premierVecteur, VTD deuxiemeVecteur)
	{
		VTD produitVectoriel = new VTD();
		produitVectoriel.composante1  =	premierVecteur.composante2*deuxiemeVecteur.composante3-
										premierVecteur.composante3*deuxiemeVecteur.composante2;
		produitVectoriel.composante2  =	premierVecteur.composante3*deuxiemeVecteur.composante1-
										premierVecteur.composante1*deuxiemeVecteur.composante3;
		produitVectoriel.composante3  =	premierVecteur.composante1*deuxiemeVecteur.composante2-
										premierVecteur.composante2*deuxiemeVecteur.composante1;
		return produitVectoriel;															
	}	

//---------------------------------------------------------------------------------------
	
	//m�thode d'instance pour le calcul du produit mixte 
	//(on utilise l'expression explicite alg�brique du produit mixte)
	public double calculerProduitMixte(VTD deuxiemeVecteur, VTD troisiemeVecteur)
	{
		return calculerProduitScalaire(calculerProduitVectoriel(deuxiemeVecteur, troisiemeVecteur));
	}
		
	//m�thode statique (surcharg�e) pour le calcul du produit mixte
	//(on calcule le produit mixte � l'aide des produits scalaire et vectoriel)
	public static double calculerProduitMixte(VTD premierVecteur, VTD deuxiemeVecteur, VTD troisiemeVecteur)
	{
		return calculerProduitScalaire(premierVecteur, calculerProduitVectoriel(deuxiemeVecteur, troisiemeVecteur));
	}

//---------------------------------------------------------------------------------------
	//m�thode pour afficher les composantes d'un vecteur
	public void afficher()
	{
		System.out.print("("+ composante1 +", " + composante2 +", " + composante3 + ")");
	}
	
	public void calculerPlusEgal(VTD deuxiemeVecteur){
		composante1 += deuxiemeVecteur.composante1;
		composante2 += deuxiemeVecteur.composante2;
		composante3 += deuxiemeVecteur.composante3;
	}
	public boolean verifierEgalite(VTD deuxiemeVecteur){
		if (composante1!=deuxiemeVecteur.composante1) return false;
		if (composante2!=deuxiemeVecteur.composante2) return false;
		if (composante3!=deuxiemeVecteur.composante3) return false;
		return true;
	}
	public static boolean verifierEgalite(VTD premiereVecteur, VTD deuxiemeVecteur){
		if (premiereVecteur.composante1!=deuxiemeVecteur.composante1) return false;
		if (premiereVecteur.composante2!=deuxiemeVecteur.composante2) return false;
		if (premiereVecteur.composante3!=deuxiemeVecteur.composante3) return false;
		return true;
	}
	public VTD creerClone(){
		return new VTD(composante1, composante2, composante3);
	}
	public static VTD creerClone(VTD Vecteur){
		return new VTD(Vecteur.composante1, Vecteur.composante2, Vecteur.composante3);
	}
	public double calculerNorme(){
		return Math.sqrt(Math.pow(composante1, 2)+Math.pow(composante2, 2)+Math.pow(composante3, 2));
	}
	public static double calculerNorme(VTD Vecteur){
		return Math.sqrt(Math.pow(Vecteur.composante1, 2)+Math.pow(Vecteur.composante2, 2)+Math.pow(Vecteur.composante3, 2));
	}
	public void faireCopie(VTD deuxiemeVecteur){
		deuxiemeVecteur.setComposante1(composante1);
		deuxiemeVecteur.setComposante2(composante2);
		deuxiemeVecteur.setComposante3(composante3);
	}
	public static void faireCopie(VTD premiereVecteur, VTD deuxiemeVecteur){
		deuxiemeVecteur.setComposante1(premiereVecteur.composante1);
		deuxiemeVecteur.setComposante2(premiereVecteur.composante2);
		deuxiemeVecteur.setComposante3(premiereVecteur.composante3);
	}
	public static boolean comparerPlusGrand(VTD premiereVecteur, VTD deuxiemeVecteur){
		return (VTD.calculerNorme(premiereVecteur)>VTD.calculerNorme(deuxiemeVecteur));
	}
}

//---------------------------------------------------------------------------------------
