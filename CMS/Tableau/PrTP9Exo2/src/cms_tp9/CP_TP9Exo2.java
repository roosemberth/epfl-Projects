/*
	Classe principale qui continent la m�thode main() et qui
	permet de tester la conception de la classe VTD
*/

package cms_tp9;

public class CP_TP9Exo2 
{
	//la m�thode main()
	public static void main(String args[ ]) 
	{
		//d�clarations de trois variables de type classe (ou de type objet) et 
		//cr�ation de trois nouveaux objets
		VTD u = new VTD();
		VTD v = new VTD(0.0,1.0,0.0);
		VTD w = new VTD(0.0,0.0,1.0);
	
		//modifications des valeurs des champs de l'objet r�f�renc� par u
		System.out.print("Tout au d�but, le vecteur u vaut : ");  
		u.afficher();
		System.out.println(".");
		u.setComposante1(-1.0);
		u.setComposante2(3.5);
		u.setComposante3(-25.48);
		System.out.print("Apr�s modifications, le vecteur u devient : "); 
		u.afficher();
		System.out.println(".");
		
		//situation initiale		
		System.out.println("\nAvant les calculs, les vecteurs u, v et w valent, respectivement : ");
		u.afficher();
		System.out.print("; ");
		v.afficher();
		System.out.print("; ");
		w.afficher();
		System.out.println(".");
		
//		D�commenter progressivement le contenu de la m�thode main 
//		afin de v�rifier la conception de la classe VTD au fur et � mesure
		

//		------------------------------------------------------------------------------------
	
		//calcul du produit scalaire de u et v � l'aide de la m�thode d'instance
		//compl�ter l'instruction ci-dessous
		double u_fois_v = u.calculerProduitScalaire(v); 
		System.out.print( "\nLe produit scalaire des u et v (calcul� avec la m�thode d'instance) ");
		System.out.print("vaut : " + u_fois_v + "." );
		
		//calcul du produit scalaire de v et u � l'aide de la m�thode statique
		//compl�ter l'instruction ci-dessous
		double v_fois_u = VTD.calculerProduitScalaire(v, u);
		System.out.print( "\nLe produit scalaire des v et u (calcul� avec la m�thode statique) ");
		System.out.println("vaut : " + v_fois_u + "." );	

//		------------------------------------------------------------------------------------
		
		//calcul de la somme de u et v � l'aide de la m�thode d'instance
		VTD somme;
		//compl�ter l'instruction ci-dessous
		somme =  u.calculerSomme(v);
		System.out.print( "\nLa somme des u et v (calcul�e avec la m�thode d'instance) vaut : \n");
		somme.afficher();
		System.out.println(".");
		
		//calcul de la somme de u et v � l'aide de la m�thode statique
		//compl�ter l'instruction ci-dessous
		somme = VTD.calculerSomme(u, v);
		System.out.print( "La somme des u et v (calcul�e avec la m�thode statique) vaut : \n");	
		somme.afficher();
		System.out.println(".");

//		------------------------------------------------------------------------------------
		
		//calcul du produit vectoriel de v et w � l'aide de la m�thode d'instance
		//compl�ter l'instruction ci-dessous
		VTD v_cross_w = u.calculerProduitVectoriel(v);
		System.out.print( "\nLe produit vectoriel des v et w (calcul� avec la m�thode d'instance) vaut : \n");
		System.out.print("(" + v_cross_w.getComposante1() + ", ");
		System.out.print(v_cross_w.getComposante2() + ", ");
		System.out.print(v_cross_w.getComposante3() + ")");
		System.out.println(".");
		
		//calcul du produit vectoriel de w et v � l'aide de la m�thode statique
		//compl�ter l'instruction ci-dessous
		VTD w_cross_v = VTD.calculerProduitVectoriel(w, v);
		System.out.print( "Le produit vectoriel des w et v (calcul� avec la m�thode statique) vaut : \n");	
		w_cross_v.afficher();
		System.out.println(".");

		//		------------------------------------------------------------------------------------
	
		//calcul du produit mixte de u, v et w � l'aide de la m�thode d'instance
		//compl�ter l'instruction ci-dessous
		double u_fois_v_fois_w = u.calculerProduitMixte(v, w);
		System.out.print( "\nLe produit mixte des u, v et w (calcul� avec la m�thode d'instance) ");
		System.out.print("vaut : " + u_fois_v_fois_w + "." );
		
		//calcul du produit mixte de u, v et w � l'aide de la m�thode statique
		//compl�ter l'instruction ci-dessous
		u_fois_v_fois_w = VTD.calculerProduitMixte(u, v, w);
		System.out.print( "\nLe produit mixte des u, v et w (calcul� avec la m�thode statique) ");
		System.out.println("vaut : " + u_fois_v_fois_w + "." );		

//		------------------------------------------------------------------------------------
		
		//affichage du nombre d'objets cr��s � l'ex�cution
		System.out.print("\nLe nombre d'objets cr��s d�s le d�but de l'ex�cution est : ");
		//compl�ter l'instruction ci-dessous
		System.out.println(VTD.getNbVecteurs() + ".");
	}//fin de la m�thode main
}//fin de la classe CP_TP9Exo1
