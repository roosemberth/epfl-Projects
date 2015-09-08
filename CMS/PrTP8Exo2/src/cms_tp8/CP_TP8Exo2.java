package cms_tp8;

import java.util.Scanner;

public class CP_TP8Exo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner In = new Scanner(System.in);
		char errors = 0;
		while (errors < 3){
			System.out.print("Introduire une lettre (sans accent ni cédille et suivie par ENTER:");
			char lettre = In.nextLine().charAt(0);
			if (lettre >= 65 && lettre <= 90) {
				System.out.printf("La lettre %s est une Majuscule!\n", lettre);
				In.close();
				System.exit(0);
			} else if (lettre >= 97 && lettre <= 122){
				System.out.printf("La lettre %s est une Minuscule!\n", lettre);
				In.close();
				System.exit(0);
			} else {
				if (++errors < 3){
					System.out.printf("Le caractêre %s n'est pas une lettre!\nSon code unicode est %d.\nRecommencez s.v.p!\n", lettre, (int) lettre);
				} else {
					System.out.printf("Le caractêre %s n'est pas une lettre!\nSon code unicode est %d.\n", lettre, (int) lettre);
					System.out.print("Vous avez fait trop de fautes!\n Au revoir!\n");
				}
			}
		}
		In.close();
		System.exit(1);
	}

}
