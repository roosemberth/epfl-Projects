package cms_tp6;

import java.util.Scanner;

public class CP_TP6Exo3 {

	public static void main(String[] args) {
		Scanner IStream = new Scanner(System.in);
		boolean Continue = true;
		int accumulator = 0;
		int curr = 0;
		int counter = -1;
		String Ans;
		while (Continue){
			++counter;
			accumulator += curr;
			if (counter > 0){
				System.out.print("Introduisez un note entre 0 et 6 (-1 pour terminer)!\n");
			}else{
				System.out.print("Introduisez la premier note entre 0 et 6!\n");
			}
			curr = IStream.nextInt();
			if (curr>6){
				System.out.print("La note n'est pas prise en compte car elle n'est pas \nvalide!\n");
				--counter;
				curr=0;
			}
			Continue = curr>=0;
		}
		IStream.close();
		System.out.print("Vous avez introduit " + counter + " Valeurs. \n");
		System.out.print("La moyenne des notes introduites est " + (counter>0?("\b:\n" + (double)accumulator/counter):"Indefinie") + ".\n");
		System.out.print("Merci et Au Revoir!\n");
	}

}
