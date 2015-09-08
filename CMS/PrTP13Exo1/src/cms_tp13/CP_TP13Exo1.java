/*
	Classe principale pour tester la hierarchie de classes creee
	(la classe de base PBD et la classe derivee PTD)
*/
package cms_tp13;

import cms_tp13.PBD;
import cms_tp13.PTD;

public class CP_TP13Exo1 
{
	public static void main(String args[]) 
	{
		PBD refBi0 = new PBD();
		PBD refBi1 = new PBD(10.0,20.0);
		PBD refBi2 = new PBD(10.0,20.0);
		
		PTD tabTri[ ] = {new PTD(), new PTD(10.0,20.0,30.0), new PTD(10.0,20.0,30.0)};			
			
		System.out.println("Les points du plan references par refBi0, refBi1 et refbi2 sont :");
		System.out.print("(");		refBi0.afficher();			System.out.print(")   (");
		refBi1.afficher( );		System.out.print(")   (");	refBi2.afficher();
		System.out.println(")\n");
		
		System.out.println("Les points de l'espace references dans le tableau tabTri sont :");
		System.out.print("(");		tabTri[0].afficher();			System.out.print(")   (");
		tabTri[1].afficher();		System.out.print(")   (");	tabTri[2].afficher();
		System.out.println(")\n");		
		
		
		if(refBi0.verifierEgalite(refBi1))
			System.out.println( "Les points references par refBi0 et refBi1 ont les memes coordonnees !");
		else 
			System.out.println( "Les points references par refBi0 et refBi1 sont differents !");
			
		if(PBD.verifierEgalite(refBi1, refBi2))
			System.out.println( "Les points references par refBi1 et refBi2 ont les memes coordonnees !");
		else 
			System.out.println( "Les points references par refBi1 et refBi2 sont differents !");
		
			
		if(tabTri[0].verifierEgalite(tabTri[1]))
			System.out.println( "\nLes points references par tabTri[0] et tabTri[1] ont les memes coordonnees !");
		else 
			System.out.println( "\nLes points references par tabTri[0] et tabTri[1] sont differents !");
			
		if(PBD.verifierEgalite(tabTri[1], tabTri[2]))
			System.out.println( "Les points references par tabTri[1] et tabTri[2] ont les memes coordonnees !");
		else 
			System.out.println( "Les points references par tabTri[1] et tabTri[2] sont differents !");			
		
		
		if(refBi1.verifierEgalite(tabTri[1]))
		{
			System.out.println( "\nLes points references par refBi1 et tabTri[1] ont les memes coordonnees !");
			System.out.println( "(Ceci est FAUX !)");
		}
		else
		{ 
			System.out.println( "\nLes points references par refBi1 et tabTri[1] sont differents !");
			System.out.println( "(Ceci est VRAI !)");
		}		
		
		if(tabTri[1].verifierEgalite(refBi1))
		{
			System.out.println( "\nLes points references par tabTri[1] et refBi1 ont les memes coordonnees !");
			System.out.println( "(Ceci est FAUX !)");
		}
		else
		{ 
			System.out.println( "\nLes points references par tabTri[1] et refBi1 sont differents !");
			System.out.println( "(Ceci est VRAI !)");
		}


		if(PBD.verifierEgalite(refBi1,tabTri[1]))
		{
			System.out.println( "\nLes points references par refBi1 et tabTri[1] ont les memes coordonnees !");
			System.out.println( "(Ceci est FAUX !)");
		}
		else
		{ 
			System.out.println( "\nLes points references par refBi1 et tabTri[1] sont differents !");
			System.out.println( "(Ceci est VRAI !)");
		}
		
		
		if(PTD.verifierEgalite(refBi1,tabTri[1]))
		{
			System.out.println( "\nLes points references par tabTri[1] et refBi1 ont les memes coordonnees !");
			System.out.println( "(Ceci est FAUX !)");
		}
		else
		{ 
			System.out.println( "\nLes points references par tabTri[1] et refBi1 sont differents !");
			System.out.println( "(Ceci est VRAI !)");
		}		
		
		
		System.out.println("\nOn fait : refBi0 = tabTri[1];");			
		
		refBi0 = tabTri[1];
		if(refBi0.verifierEgalite(refBi1))
			System.out.println( "\nLes points references par refBi0 et refBi1 ont maintenant les memes coordonnees !");
		else 
			System.out.println( "\nLes points references par refBi0 et refBi1 sont maintenant differents !");
		
				
		System.out.println("\n"+PBD.getNbPoints()+" points dans le plan ont ete crees durant l'execution !");
		System.out.println(PTD.getNbPoints()+" points dans l'espace ont ete crees durant l'execution !");
	}
}



