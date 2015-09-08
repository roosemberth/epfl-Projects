package cms_tp6;

import java.util.Scanner;

public class CP_TP6Exo1 {

	public static void main(String[] args) {
		System.out.print("Bonjour! Ce programme calcule l'aire totale et le volume d'un cylindre circulaire droit.\n");
		Scanner IStream = new Scanner(System.in);
		System.out.print("Donner la valeur du rayon du Cylindre:\n");
		double CylR = IStream.nextDouble();
		System.out.print("Donner la valeur de la hauteur du Cylindre:\n");
		double CylH = IStream.nextDouble();
		double CylA = 2*Math.PI*Math.pow(CylR, 2) + 2*Math.PI*CylR*CylH;
		double CylV = Math.PI*Math.pow(CylR, 2)*CylH;
		System.out.print("\nL'aire totale du Cylindre vaut: " + CylA + ".\n");
		System.out.print("Le volume totale du Cylindre vaut: " + CylV + ".\n");
		IStream.close();
	}

}
