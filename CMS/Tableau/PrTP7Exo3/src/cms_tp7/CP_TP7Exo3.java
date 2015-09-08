package cms_tp7;

//la classe "principale" contenant la m�thode main
public class CP_TP7Exo3
{
	public static void main(String args[])
	{
		//Cr�ation d'un nouvel objet de type "PMD_Public"
		//dont la r�f�rence est stock�e dans la variable objet
		//(ou la variable de type classe) "premierPoint" cr��e � cet effet
		PMD_Public premierPoint = new PMD_Public();
		
		//Appel de la m�thode afficher() pour l'objet
		//r�f�renc� par la variable objet "premierPoint"
		//Les champs ont �t� initialis�s par d�fault
		System.out.println();
		System.out.println("L'objet premierPoint initial se pr�sente : ");
		premierPoint.afficher();
		
		//Modification de la valeur du champ public "nomPoint" de l'objet 
		//r�f�renc� par la variable objet "premierPoint" 
		premierPoint.nomPoint = 'A';
		
		//Modification de la valeur du champ public "posX" de l'objet 
		//r�f�renc� par la variable objet "premierPoint"
		premierPoint.posX = 15.3;
		
		//Lecture de la valeur du champ public "nomPoint" de l'objet
		//r�f�renc� par la variable objet "premierPoint"
		System.out.println();
		System.out.println("Le nom du premierPoint est devenu : " + premierPoint.nomPoint + "."); 
		
		//Lecture de la valeur du champ public "posX" de l'objet
		//r�f�renc� par la variable objet "premierPoint"
		System.out.println();
		System.out.println("La position du premierPoint est devenue : " + premierPoint.posX + ".");		
		
		//Appel de la m�thode afficher() pour l'objet r�f�renc� par la variable objet "premierPoint"
		System.out.println();
		System.out.println("L'objet premierPoint modifi� se pr�sente : ");
		premierPoint.afficher();
		
		//Cr�ation d'un nouvel objet de type "PMD_Private"
		//dont la r�f�rence est stock�e dans la variable objet
		//(ou la variable classe) "deuxiemePoint" cr��e � cet effet
		PMD_Private deuxiemePoint = new PMD_Private();
		
		//Appel de la m�thode afficher() pour l'objet r�f�renc� par la variable objet "deuxiemePoint"
		//Les champs ont �t� initialis�s avec des valeurs pr�cis�es dans la classe
		System.out.println();
		System.out.println("L'objet deuxiemePoint initial se pr�sente : ");		
		deuxiemePoint.afficher();
		
		//Modification de la valeur du champ priv� "nomPoint" de l'objet
		//r�f�renc� par la variable objet "deuxiemePoint" 
		//deuxiemePoint.nomPoint = 'B';   faux
		deuxiemePoint.setNomPoint('B');
		
		//Modification de la valeur du champ priv� "posX" de l'objet
		//r�f�renc� par la variable objet "deuxiemePoint"
		//deuxiemePoint.posX = 30.6;   faux
		deuxiemePoint.setPosX(30.6);
						
		//Lecture de la valeur du champ priv� "nomPoint" de l'objet
		//r�f�renc� par la variable objet "deuxiemePoint"
		//System.out.println("Le nom du deuxiemePoint est : " + deuxiemePoint.nomPoint + ".");  faux
		System.out.println("\nLe nom du deuxiemePoint est devenu : " + deuxiemePoint.getNomPoint() + "."); 
		
		//Lecture de la valeur du champ priv� "posX" de l'objet
		//r�f�renc� par la variable objet "deuxiemePoint"
		//System.out.println("La position du deuxiemePoint est : " + deuxiemePoint.posX + ".");  faux
		System.out.println("\nLa position du deuxiemePoint est devenue : " + deuxiemePoint.getPosX() + ".");		
		   	
		//Appel de la m�thode afficher() pour l'objet
		//r�f�renc� par la variable objet "deuxiemePoint"
		System.out.println("\nL'objet deuxiemePoint modifi� se pr�sente : ");
		deuxiemePoint.afficher();
		
		System.out.print("On verifie maintenant la méthode translate(dobule) de la classe PMD_Private\n");
		deuxiemePoint.translate(5.0);
		System.out.print("On bouge le point 5 unités. Le deuxiemePoint se Presente!\n");
		deuxiemePoint.afficher();
		
	}	//fin de la m�thode main
}		//fin de la classe CP_TP7Exo3