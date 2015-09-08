package cms_tp18;

import java.io.*;
import java.util.StringTokenizer;

public class CP_TP18Exo4 {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Bonjour!,");
		boolean CondCont = true;
		int nEtudiants = 1;
		double[] notes = new double[4];
		double mean = 0;
		// Throws IOException
		BufferedReader RecordsFile = new BufferedReader(new FileReader("notes.dat"));
		BufferedWriter Synthesis = new BufferedWriter(new FileWriter("Synthesis.dat"));
		String NomCurrEtudiant;
		StringTokenizer st;
		String SubString;
		do {
			try {
				// If EOF This will throw an exception
				NomCurrEtudiant = RecordsFile.readLine();
				for (int c = 0; c<4; ++c){
					st = new StringTokenizer(RecordsFile.readLine(), " ");
					// We know format, Idc About lenght
					notes[c] = Double.parseDouble(st.nextToken());
					mean += notes[c]/4;
				}
				System.out.println("Voici le nom du " + nEtudiants + (nEtudiants==1?"ére":"éme") + " étudiant. " );
				System.out.println(NomCurrEtudiant);
				System.out.println("Ce sont les notes du contrôles numero  1, 2, 3 et 4:" );
				for (int c = 0; c<4; ++c){
					System.out.print(notes[c] + "\t");
				}
				System.out.println();
				System.out.println("La moyenne de ces notes est: " + mean);
				Synthesis.write(NomCurrEtudiant + "\t" +  mean + "\n");
			} catch (EOFException obj){
				System.out.println();
				System.out.println("That's all folks!");
				CondCont=false;
			}
			RecordsFile.close();
			Synthesis.close();
			
		} while (CondCont);
		RecordsFile.close();
	}

}