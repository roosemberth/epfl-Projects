package cms_tp5;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class CP_TP5Exo1 {

	public static void main(String[] args) {
		int Age=-1;
		Scanner IStream = new Scanner(System.in);
		System.out.println("Introduisez votre nom, svp:");
		String Nom = IStream.next();
		System.out.println("Introduisez votre pr�nom, svp:");
		String Prenom = IStream.next();
		
		int errors = 0;
		GregorianCalendar gc = new GregorianCalendar();
		int anneactual = gc.get(java.util.GregorianCalendar.YEAR);
		do{
			System.out.println("Introduisez votre Ann� de Naissance, svp:");
			int AnneNaissance = IStream.nextInt();
			if (AnneNaissance <= 1910 || AnneNaissance >= anneactual){
				System.out.println("Anné Naissance Invalide!");
				++errors;
			} else {
				System.out.println("\nSalut " + Prenom + ' ' + Nom + " !\n");
				Age= anneactual - AnneNaissance;
				System.out.println("Vous avez " + Age + " ans!");
				System.out.println("Au revoir!");
				IStream.close();
				return;
			}
		} while(errors <= 3);
		System.out.println("Désolé! Vous avez fait trop de fautes!, Au Revoir!");
		IStream.close();
	}
}
