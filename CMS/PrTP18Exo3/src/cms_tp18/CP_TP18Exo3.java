package cms_tp18;

import java.io.*;
import java.util.*;

public class CP_TP18Exo3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Bonjour!,");
		boolean CondCont = false;
		int nEtudiants = 1;
		// Throws IOException
		PrintWriter RecordsFile = new PrintWriter("notes.dat");
		do {
			System.out.println("Introduisez le nom du " + nEtudiants + (nEtudiants==1?"ére":"éme") + " étudiant. " );
			RecordsFile.println(scan.nextLine());
			for (int c=0; c<4; ++c){
				System.out.println("Introduisez les notes du contrôle numero  "+ (c+1) );
				RecordsFile.print(scan.nextDouble());
			}
			System.out.println("Vous aimerais Continuer ? O/N");
			switch (scan.next().charAt(0)){
				case 'O':
					CondCont = true;
					nEtudiants++;
					break;
				case 'N':
				default:
					CondCont = false;
					break;
			}
		} while (CondCont);
		RecordsFile.close();
		scan.close();
	}
}
