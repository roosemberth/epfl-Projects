package cms_tp14;

import cms_tp14.PBD;
import cms_tp14.PTD;
import cms_tp14.VTD;

import java.util.Scanner;

public class CP_TP14Exo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Bonjour! Je suis une application autonome Java interactive qui calcule ");
		System.out.println("les distances entre les points introduits, et le point de reference");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.println("Combien de points (dans l'espace ou dans le plan) seront introduits?");
		int nbPoints = scan.nextInt();
		PBD[] PtArray = new PBD[nbPoints];
		PBD MaxPt = new PBD();
		PBD MinPt = new PBD();
		PTD Orig3D = new PTD();
		PBD Orig2D = new PBD();
		System.out.print("Par la suite precisez le type de point que vous souhaiterais introduire ");
		System.out.println("Precisez 'B' pour un point dans le plan ou 'T' pour un point dans l'espace");
		char typePt;
		for (int currPt=0; currPt<nbPoints; ++currPt){
			System.out.print("Precisez le type de point pour le " + (currPt+1) + (currPt==0?"ère":"ème"));
			System.out.println(" point");
			typePt = scan.next().charAt(0);
			if (typePt=='b'||typePt=='B'){
				System.out.println("Introduisez les coordonées pour ce point");
				PtArray[currPt] = new PBD();
				((PBD)PtArray[currPt]).setX(scan.nextDouble());
				((PBD)PtArray[currPt]).setY(scan.nextDouble());
			} else if (typePt=='t'||typePt=='T'){
				System.out.println("Introduisez les coordonées pour ce point");
				PtArray[currPt] = new PTD();
				((PTD)PtArray[currPt]).setX(scan.nextDouble());
				((PTD)PtArray[currPt]).setY(scan.nextDouble());
				((PTD)PtArray[currPt]).setZ(scan.nextDouble());
			} else {
				System.out.println("Je n'ai pas compris le type de point que vous souhaitez");
				--currPt;
				continue;
			}
		}
		
		System.out.println("Veuillez introduire les 3 coordonnées cartésiennes du point d'origine");
		Orig3D.setX(scan.nextDouble());
		Orig3D.setY(scan.nextDouble());
		Orig3D.setZ(scan.nextDouble());
		
		// Créer la projection de l'origine sur le plan xOy
		VTD OrigVec3D = new VTD(Orig3D.getX(), Orig3D.getY(), Orig3D.getZ());
		double ProjNorm = VTD.calculerProduitScalaire(OrigVec3D, new VTD(0,0,1));
		VTD nProjNorm3D = new VTD(0,0,-ProjNorm);
		VTD OrigVec2D = VTD.calculerSomme(OrigVec3D, nProjNorm3D);
		Orig2D.setX(OrigVec2D.getComposante1());
		Orig2D.setY(OrigVec2D.getComposante2());
		
		double Distance =0;
		double MaxDist = 0;
		double MinDist = 0;
		
		for (int currPt=0; currPt<nbPoints; ++currPt){
			if (PtArray[currPt] instanceof PTD){
				((PTD)PtArray[currPt]).afficher();
				Distance = PTD.calculerDistance(PtArray[currPt], Orig3D);
				System.out.println(" et distance à l'origine de " + Distance);
				if (currPt==0){
					MaxDist=MinDist=Distance;
					MaxPt=MinPt=PtArray[currPt];
				}
				if (Distance>MaxDist){
					MaxDist=Distance;
					MaxPt=PtArray[currPt];
				}
				if (Distance<MinDist){
					MinDist=Distance;
					MinPt=PtArray[currPt];
				}
			} else {
				PtArray[currPt].afficher();
				Distance = PBD.calculerDistance((PBD)PtArray[currPt], Orig2D);
				System.out.println(" et distance à l'origine de " + Distance);
				if (currPt==0){
					MaxDist=MinDist=Distance;
					MaxPt=MinPt=PtArray[currPt];
				}
				if (Distance>MaxDist){
					MaxDist=Distance;
					MaxPt=PtArray[currPt];
				}
				if (Distance<MinDist){
					MinDist=Distance;
					MinPt=PtArray[currPt];
				}
			}
		}
		
		scan.close();
		
		System.out.print("Le point avec la plus grand distance: " + MaxDist + ", ");
		MaxPt.afficher();
		System.out.println();

		System.out.print("Le point avec la plus petite distance: " + MinDist + ", ");
		MinPt.afficher();
		System.out.println();
	}
}
