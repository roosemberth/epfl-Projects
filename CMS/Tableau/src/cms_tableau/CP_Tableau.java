package cms_tableau;

import java.util.Scanner;
import cms_tableau.Auxiliaire;

public class CP_Tableau {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double tab[];
		
		System.out.println("Introduire des valeurs reéles ...");
		System.out.print("Combien des valeurs? ");
		
		int nbValeurs = scan.nextInt();
		
		System.out.println();
		
		tab = new double[nbValeurs];
		
		for (int i=0; i<nbValeurs; ++i){
			System.out.println("Introduire la valeur numéro " + (i+1) + ":");
			tab[i] = scan.nextDouble();
		}
		
		double moyenne = Auxiliaire.calculerMoyenne(tab);
		
		System.out.print("La moyenne des notes est: " + moyenne + ".\n\n");
		
		int tabQuality[] = Auxiliaire.testerQualite(tab);
		
		System.out.println("Nombre de valeurs plus petites que la moyenne: " + tabQuality[0] + ".");
		System.out.println("Nombre de valeurs plus grandes que la moyenne: " + tabQuality[1] + ".");
		System.out.println("Nombre de valeurs égales à la moyenne: " + tabQuality[2] + ".");
		
		System.out.println("Merci et Au Revoir!");
		scan.close();		
	}

}
