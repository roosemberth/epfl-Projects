package cms_tp3;

import java.util.Scanner;

public class CP_TP3Exo2 {
	public static void main(String[] args){
		Scanner IStream = new Scanner(System.in);
		System.out.println("Salut! C'est ma premiere application Java!\n");
		System.out.println("Introduisez votre nom, svp:");
		String Nom = IStream.next();
		System.out.println("Introduisez votre prenom, svp:");
		String Prenom = IStream.next();
		System.out.println("Introduisez votre Anne de Naissance, svp:");
		int AnneNaissance = IStream.nextInt();
		System.out.println("\nSalut " + Prenom + ' ' + Nom + " !\n");
		
		int age = AuxTP3Exo2.CalculerAge(AnneNaissance); 
		System.out.println("Vous avez " + age + " ans!");
		System.out.println("Au revoir!");
		IStream.close();
	}
}
