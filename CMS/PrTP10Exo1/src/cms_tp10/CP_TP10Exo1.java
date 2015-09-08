/*
	Classe principale qui continet la m�thode main() et qui
	permet de tester la conception de la classe VTD
*/

package cms_tp10;

public class CP_TP10Exo1 
{
	//la methode main()
	public static void main(String args[]) 
	{
		//d�clarations de trois variables de type objet
		VTD u = new VTD();
		VTD v = new VTD(2.0,2.0,2.0);
		VTD w = new VTD(3.0,3.0,3.0);

//		------------------------------------------------------------------------------------
	
		//modifications des valeurs des champs de l'objet u
		u.setComposante1(1.0);
		u.setComposante2(1.0);
		u.setComposante3(1.0);
		
		//situation initiale		
		System.out.println("Au debut, les vecteurs u, v et w valent, respectivement : ");
		u.afficher();
		System.out.print(", ");
		v.afficher();
		System.out.print(", ");
		w.afficher();
		System.out.println(".");
		
//D�commenter progressivement le contenu de la m�thode main 
//afin de v�rifier la conception de la classe VTD au fur et � mesure
///*		
//--------------------------------------------------------------------------------------------------------
		//utilisation de l'op�rateur d'affectation
		u=v;
		v=w;
		w=u;
		System.out.println("\nApres les affectations, les vecteurs u, v et w valent, respectivement : ");
		u.afficher();
		System.out.print(", ");
		v.afficher();
		System.out.print(", ");
		w.afficher();
		System.out.println(".");				
		
//--------------------------------------------------------------------------------------------------------
		
		//calcul avec la m�thode d'instance calculerPlusEgal
		u.calculerPlusEgal(v);		
		System.out.print( "\nApres le calcul de u += v,  u devient : ");
		u.afficher();
		System.out.print(", \ntandis que v vaut toujours : ");
		v.afficher(); 
		System.out.println(".");	
		
//--------------------------------------------------------------------------------------------------------
			
		//v�rification de l'�galit� (en profondeur) de deux vecteurs � l'aide d'une m�thode d'instance
		if(u.verifierEgalite(v))
		{
			System.out.print("\nLes vecteurs u et v sont egaux (en profondeur), a savoir ");
			u.afficher();
			System.out.println(" !");	
		}
		else
			System.out.println("\nLes vecteurs u et v ne sont pas egaux (en profondeur) !");

//--------------------------------------------------------------------------------------------------------
			
		//clonage d'un vecteur avec la m�thode statique creerClone
		System.out.println("\nOn clone le vecteur u et on stocke la reference du clone en v !");
		v=VTD.creerClone(u);					

//--------------------------------------------------------------------------------------------------------
		
		//v�rification de l'�galit� (en profondeur) de deux vecteurs � l'aide d'une m�thode statique
		if(VTD.verifierEgalite(u,v))
		{
			System.out.print("\nLes vecteurs u et v sont egaux (en profondeur), a savoir ");
			u.afficher();
			System.out.println(" !");	
		}
		else
			System.out.println("\nLes vecteurs u et v ne sont pas egaux (en profondeur) !");		

//--------------------------------------------------------------------------------------------------------
		
		//v�rification de "l'�galit�" de deux vecteurs � l'aide de l'op�rateur de comparaison ==
		if(u==v)
			System.out.println("\nu et v referencent le meme objet !");
		else
			System.out.println("\nu et v ne referencent pas le meme objet !");

//--------------------------------------------------------------------------------------------------------
		
		//calcul  de la norme du vecteur w avec la m�thode d'instance calculerNorme
		double norme=w.calculerNorme();
		System.out.print("\nLe vecteur w vaut : ");
		w.afficher();
		System.out.println(" et sa norme est : "+ norme +".");	

//--------------------------------------------------------------------------------------------------------
		
		//cr�ation d'un nouvel objet
		VTD uu = new VTD(7.0,8.0,9.0);

//--------------------------------------------------------------------------------------------------------
		
		//copie du contenu du vecteur uu dans le vecteur v avec la methode statique  faireCopie
		VTD.faireCopie(uu,v);
		System.out.print("\nLe vecteur v vaut : ");
		v.afficher();
		System.out.println(" et sa norme est : "+ v.calculerNorme() +".");		

//--------------------------------------------------------------------------------------------------------
		
		//comparaison des vecteur v et w avec la methode statique comparerPlusGrand
		if(VTD.comparerPlusGrand(v,w))
			System.out.println("\nLe vecteur v  est (strictement) plus grand que le vecteur w !");
		else
			System.out.println("\nLe vecteur v n'est pas (strictement) plus grand que le vecteur w !");

//--------------------------------------------------------------------------------------------------------
		
		//affichage du nombre d'objets cr��s � l'ex�cution
		System.out.print("\nLe nombre d'objets crees des le debut de l'execution est : ");
		System.out.println(VTD.getNbVecteurs() + ".");
//*/					
	}
}


















