package cms_tableau;

public class Auxiliaire {
	public static double calculerMoyenne(double table[]){
		double moyenne = 0;
		for (int i=0;i<table.length; ++i){
			moyenne += table[i];
		}
		moyenne /= table.length;
		return moyenne;
	}
	
	public static int[] testerQualite(double tableau[]){
		int tabQualite[] = new int[3];
		double moyenne = calculerMoyenne(tableau);
		for (int i=0; i<tableau.length; ++i){
			if (tableau[i]< moyenne){
				tabQualite[0]++;
			} else if (tableau[i]==moyenne){
				tabQualite[1]++;
			} else if (tableau[i]> moyenne){
				tabQualite[2]++;
			}
		}
		return tabQualite;
	}
}
