package cms_tp6;

import java.util.Scanner;

public class CP_TP6Exo2 {

	public static void main(String[] args) {
		Scanner IStream = new Scanner(System.in);
		boolean Continue = true;
		int max=0;
		int min=0;
		int curr;
		int counter=0;
		String Ans;
		while (Continue){
			if (counter > 0){
				System.out.print("Introduisez le nombre entier Suivante!:\n");
			}else{
				System.out.print("Introduisez le premier nombre entier!:\n");
			}
			curr = IStream.nextInt();
			counter++;
			max = curr>max ? curr : max;
			min = curr<min ? curr : min;
			System.out.print("Voulez-vous continuer? (O/N)\n");
			Ans = IStream.next();
			Continue = (Ans.charAt(0)=='o'||Ans.charAt(0)=='O'||Ans.charAt(0)=='Y'||Ans.charAt(0)=='y');
		}
		IStream.close();
		System.out.print("Vous avez introduit " + counter + " Valeurs. \n");
		System.out.print("Le maximum introduit est: " + max + ".\n");
		System.out.print("Le minimum introduit est: " + min + ".\n");
		System.out.print("Merci et Au Revoir!\n");
	}

}
