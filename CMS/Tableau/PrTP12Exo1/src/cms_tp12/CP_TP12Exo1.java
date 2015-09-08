package cms_tp12;

import java.util.Scanner;

public class CP_TP12Exo1 {

	public static void main(String[] args) {
		if (args.length==0){
			System.out.print("Pas d'argument sur la ligne de commande!\n");
			System.out.println("Erreur fatale!");
			System.exit(-1);
		}
		
		int Argument = 0;
		
		try {
			Argument = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.print("Argument non valide!\n");
			System.out.println("Erreur fatale!");
			System.exit(-2);
		}
		
		if (Argument < 9 || Argument > 13){
			System.out.print("Argument non valide!\n");
			System.out.println("Erreur fatale!");
			System.exit(-2);
		}
		
		Scanner scan = new Scanner(System.in);
		
		String varChaine="";
		int longueurChaine=0;
		
		while (true) {
			System.out.println("Introduisez une chaîne de maximun " + Argument + " caractères");
			varChaine = scan.nextLine();
			longueurChaine=varChaine.length();
			if (longueurChaine<=Argument) break;
			System.out.println("Chaîne de caractères trop long!");
		}
		
		System.out.println("La longueur de la chaîne est: " + longueurChaine + ".");
		System.out.print("La chaìne écrite à l'invers est: ");
		
		for (int i=varChaine.length()-1; i>=0; --i){
			System.out.print(varChaine.charAt(i));
		}
		System.out.println();
		
		System.out.println("La chaîne en majuscule: " + varChaine.toUpperCase());
		System.out.println("La chaîne en majuscule: " + varChaine.toLowerCase());
		
		System.out.println("Introduisez un caractère à rechercher :");
		char charRecherche = scan.nextLine().charAt(0);
		
		int nbOccurences = 0;
		if (varChaine.indexOf(charRecherche) < 0){
			System.out.println("La chaîne ne contient pas le caractère recherché !");
			System.exit(1);
		}
		
		System.out.println("Introduisez le caractère de remplacement :");
		char charRemplacement = scan.nextLine().charAt(0);
		
		for (int i=0; i < varChaine.length(); ++i){
			if (varChaine.charAt(i)==charRecherche){
				nbOccurences++;

			}
		}
		System.out.println("Le caractère " + charRecherche + " apparaît " + nbOccurences + " fois.");
		System.out.println("la chaîne modifiée: " + varChaine.replace(charRecherche, charRemplacement));
		
//		for (int i=0; i < varChaine.length(); ++i){
//			
//		}
		
		System.out.println("Au revoir!");		
	}

}
