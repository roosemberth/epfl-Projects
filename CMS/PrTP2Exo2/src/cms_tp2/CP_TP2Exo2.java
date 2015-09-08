package cms_tp2;

import java.util.GregorianCalendar;
import java.util.Scanner;


public class CP_TP2Exo2 {
	public static void main(String[] args){
		Scanner IStream = new Scanner(System.in);
		System.out.println("Salut! C'est ma premi�re application Java!\n");
		System.out.println("Introduisez votre nom, svp:");
		String Nom = IStream.next();
		System.out.println("Introduisez votre pr�nom, svp:");
		String Prenom = IStream.next();
		System.out.println("Introduisez votre Ann� de Naissance, svp:");
		int AnneNaissance = IStream.nextInt();
		System.out.println("\nSalut " + Prenom + ' ' + Nom + " !\n");
		GregorianCalendar gc = new GregorianCalendar();
		int anneactual = gc.get(java.util.GregorianCalendar.YEAR);
		
		System.out.println("Vous avez " + (anneactual - AnneNaissance) + " ans!");
		System.out.println("Au revoir!");
		IStream.close();
	}
}
