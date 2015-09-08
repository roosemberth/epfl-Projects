package cms_tp11;
import java.util.Scanner;
import cms_tp11.VTD;

public class CP_TP11Exo1 {

	public static void main(String[] args) {
		char GPB;
		VTD tabForces[][];
		VTD tabResultants[];
		Scanner scan = new Scanner(System.in);
		System.out.print("Bonjour!\n\nCombien des test vous avez prevu pour cette experience?: ");
		int tests = scan.nextInt();
		int forces;
		System.out.print("\nD'accord! On commence!\n");
		tabForces = new VTD[tests][];
		tabResultants = new VTD[tests];
		
		for (int i=0; i<tests; ++i){
			System.out.print("Avez-vous effectué le " + (i+1) + (i<1?"ère":"ème") + " Test? O/N: ");
			GPB = scan.next().charAt(0);
			if (GPB == 'N' || GPB == 'n') continue;
			System.out.print("\nIntroduissez les donnés pour la " + (i+1) + (i<1?"ère":"ème") + " Experience. ");
			System.out.print("Combien des forces ont été apliquées au solide testé?: ");
			forces = scan.nextInt();
			tabForces[i] = new VTD[forces];
			tabResultants[i] = new VTD();
			for (int j=0; j<forces; ++j){
				tabForces[i][j] = new VTD();
				System.out.print("\tIntroduissez les donnés pour la " + (j+1) + (j<1?"ère":"ème") + " Force:\n");

				System.out.print("\t\tPremière Composante: ");
				tabForces[i][j].setComposante1(scan.nextDouble());
				
				System.out.print("\t\tDeuxième Composante: ");
				tabForces[i][j].setComposante2(scan.nextDouble());
				
				System.out.print("\t\tTroisième Composante: ");
				tabForces[i][j].setComposante3(scan.nextDouble());
				tabResultants[i].calculerPlusEgal(tabForces[i][j]);
			}
			
		}
		
		if (tests>0){
			System.out.print("\nTous les experiences ont fini. Voici les resultantes des forces pour chaque experience:");
			for (int i=0; i<tests; ++i){
				if (tabResultants[i]==null) continue;
				System.out.print("\n\t" + (i+1) + (i<1?"ère":"ème") + " Experience:\t"); tabResultants[i].afficher();
			}
		} else {
			System.out.print("Vous n'avez pas effectué aucun test.");
		}
		System.out.print("\n\n Merci et Au Revoir!");
		scan.close();
	}

}
