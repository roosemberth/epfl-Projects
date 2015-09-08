package cms_tp15;

public class CP_TP15Exo2 
{
	public static void main(String args[]) 
	{
		Quadrilateres tabMixte[ ] = new Quadrilateres[4];
		
		tabMixte[0] = new Rectangles( );
		tabMixte[2] = new Rectangles("rectangle_2", 1.0, 2.0, 2.5,4.0);
		
		tabMixte[0].nom = "rectangle_1";
		//L'instruction ci-dessous produit une erreur de compilation 
		//tabMixte[0].setLongueur(1.5);		
		//"The method setLongueur(double) is undefined for the type Quadrilateres"
		((Rectangles)tabMixte[0]).setLongueur(1.5);
		//L'instruction ci-dessous produit une erreur de compilation
		//tabMixte[0].setHauteur(10);		
		//"The method setHauteur(int) is undefined for the type Quadrilateres"		
		((Rectangles)tabMixte[0]).setHauteur(10);
		
		tabMixte[1] = new Carres();		
		tabMixte[3] = new Carres("carre_2",10.0, 10.0, 2.5);	
		
		//L'instruction commentée ci-dessous produit une erreur de compilation 
		//tabMixte[1].setLongueur(1.5);
		//"The method setLongueur(double) is undefined for the type Quadrilateres"		
		((Carres)tabMixte[1]).setLongueur(1.5);
		//L'instruction ci-dessous produit une erreur de compilation
		//tabMixte[1].setHauteur(10);		
		//"The method setHauteur(int) is undefined for the type Quadrilateres"		
		((Carres)tabMixte[1]).setHauteur(10);		

		for(int i=0; i<tabMixte.length; i++)
		{
			System.out.println("Je suis " + tabMixte[i] +" (appel implicite à toString()) !");
			System.out.println("Je suis une instance de la classe "+tabMixte[i].getClass().getName()+" (appel à getClass().getName()) !");
			System.out.println();
			
			//L'instruction ci-dessous produit une erreur de compilation	:
			//"The method afficher() is undefined for the type Quadrilateres"
			//tabMixte[i].afficher();		
			((IAffichable)tabMixte[i]).afficher();
			((Rectangles)tabMixte[i]).afficher();
			System.out.println();
			
			System.out.println("Mon aire vaut : " + tabMixte[i].calculerAire() + ".");
			System.out.println("Mon perimetre vaut : " + tabMixte[i].calculerPerimetre() + ".");	
			System.out.println();
			
			if(tabMixte[i] instanceof Quadrilateres)
			{
				System.out.print("Je suis une instance de la classe Quadrilateres ! ");
			}
			System.out.println();
			if(tabMixte[i] instanceof Rectangles)
			{
				System.out.print("Je suis une instance de la classe Rectangles ! ");
			}
			if(tabMixte[i] instanceof Carres)
			{
				System.out.print("Je suis une instance de la classe Carres ! ");
			}else
			{
				System.out.print("Je ne suis pas une instance de la classe Carres ! ");
			}
			System.out.println();
			if(tabMixte[i] instanceof IAffichable)
			{
				System.out.print("Je suis une instance d'une classe qui implémente l'interface IAffichable ! ");
			}
			System.out.println();
			if(tabMixte[i] instanceof IAireCalculable)
			{
				System.out.print("Je suis une instance d'une classe qui implémente l'interface IAireCalculable ! ");
			}			
			
			System.out.println("\n--------------------------------------------------------------------------------------");
		}	
	}
}































