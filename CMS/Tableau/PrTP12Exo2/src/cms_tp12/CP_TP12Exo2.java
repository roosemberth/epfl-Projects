package cms_tp12;

import java.util.Scanner;

public class CP_TP12Exo2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String varChaine;
		while(true){
			System.out.println("Bonjour!, Veuillez introduire une chaîne de caractères formée de deux mots séparés par une et une seule espace (et qui ne commence ni ne finit par des espaces)");
			varChaine = scan.nextLine();
			if (varChaine.contains(" ") && varChaine.charAt(0)!=' ' && varChaine.charAt(varChaine.length()-1)!=' ' && countMatches(varChaine, ' ')==1) break;
			System.out.println("La chaîne introduite ne respecte pas les consignes !");
		}
		System.out.println("La nouvelle chaîne, après avoir inversé l'ordre des mots, est :");
		System.out.println(varChaine.substring(varChaine.indexOf(' ')+1, varChaine.length()) + " " + varChaine.substring(0, varChaine.indexOf(' ')));
	}
	
	static int countMatches(String string, char character){
		int matches = 0;
		for (int i=0; i<string.length(); ++i){
			if (string.charAt(i)==character) ++matches;
		}
		return matches;
	}

}
