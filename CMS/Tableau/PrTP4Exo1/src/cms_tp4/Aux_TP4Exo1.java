package cms_tp4;

public class Aux_TP4Exo1 
{
//************************************************************************************************************************	
//	D�finir une m�thode statique appel�e "verifierBaseNombre" qui a deux arguments :
//	    - le premier argument "base" repr�sentant une base comprise entre 2 et 9 ;
//	    - le deuxi�me argument "nombre" repr�sentant un nombre entier positif exprim� dans la base mentionn�e ;
//	 et qui retourne une valeur bool�enne :
//	    - FAUX si le premier argument est trop petit ou trop grand ou
//	           si un chiffre qui appara�t dans le deuxi�me argument est sup�rieur ou �gal � la base ;
//	    - VRAI dans les autres cas.	
	    
	//Pr�ciser l'en-t�te de la m�thode
	
	static boolean verifierBaseNombre(int base, int nombre){
	    //Si la base n'est pas comprise entre 2 et 9
		if (base < 2 || base > 9){
			//Afficher une message d'erreur
			System.out.print("Base invalide! \n");
			//Retourner la valeur bool�enne FAUX (et quitter la fonction)
			return false;
		}
		
	    //La partie qui suit s'ex�cute seulement si la base est bien comprise entre 2 et 9
		
		//Cr�er la variable "strNombre" de type String qui correspond au deuxi�me argument transform� en cha�ne de caract�res
		String strNombre = Integer.toString(nombre);
		//Cr�er la variable "lon" de type int qui stocke la longueur de la cha�ne de caract�res "strNombre"
		int lonStrNombre = strNombre.length();
		//Cr�er un compteur entier "i" initialis� � z�ro et qui sera utilis� dans la boucle do ci-dessous
		char k=0;
		//Dans une boucle do, comparer chaque chiffre du deuxi�me argument ("le nombre") avec le premier argument ("la base")
		do
		{
			//Si le chiffre courant est plus grand ou �gal � la base
			if(strNombre.charAt(k)-48 >= base){
				//Afficher un message d'erreur
				System.out.print("Nombre Incompatible avec la base!\n");
				//Retourner la valeur bool�enne FAUX (et quitter le m�thode)
				return false;
			}
			//Incr�menter le compteur
			++k;
		//Continuer la boucle tant qu'il y a encore des chiffres � tester
		}while(k<lonStrNombre);
		//Retourner la valeur bool�enne VRAI 
		//(car le programme arrive � ce point seulement si le couple "base et nombre" est valide)
		return true;
	}	//fin de la m�thode verifierBaseNombre

//	************************************************************************************************************************	
	/*Définir une méthode statique appelée "calculerSomme" qui a trois arguments :
    	- le premier argument "b" représentant une base comprise entre 2 et 9 ;
    	- les deux arguments suivants ("nb1" et "nb2") représentant deux nombres entiers positifs exprimés dans la base mentionnée ;
 	et qui :
    	- si au moins un des trois arguments n'est pas valide, arrête l'exécution du programme ;
    	- dans les autres cas, retourne la somme des deux derniers arguments.*/
	
	//Préciser l'en-tête de la méthode
	static int calculerSomme(int b, int nb1, int nb2)
	{
	    /*Utiliser la méthode ad-hoc verifierBaseNombre définie ci-dessus afin de vérifier 
	      si le couple b et nb1 (i.e. la base et le premier terme de la somme à calculer) n'est pas valide*/
		if(verifierBaseNombre(b, nb1) == false)
		{
			//Afficher un message d'erreur 
			System.out.println("Erreur fatale !");
			//Quitter prématurément le programme
			System.exit(-1); 
		}
	    /*Utiliseer la méthode ad-hoc verifierBaseNombre définie ci-dessus afin de vérifier
		  si le couple b et nb2 (i.e. la base et le deuxième terme de la somme à calculer) n'est pas valide*/
		if(verifierBaseNombre(b, nb2) == false)
		{
			//Afficher un message d'erreur
			System.out.println("Erreur fatale !");
			//Quitter prématurément le programme
			System.exit(-1); 
		}
		
	    //La partie qui suit s'exécute seulement si la base et les deux nombres à additionner sont valides
		
		//Créer la variable "strNb1" de type String qui correspond au deuxième argument transformé en chaîne de caractères
		String strNb1 = Integer.toString(nb1);
		//Créer la variable "lon1" de type int qui stocke la longueur de la chaîne de caractères "strNb1"
		int lon1 = strNb1.length();
		//Créer la variable "strNb2" de type String qui correspond au troisième argument transformé en chaîne de caractères
		String strNb2 = Integer.toString(nb2);
		//Créer la variable "lon2" de type int qui stocke la longueur de la chaîne de caractères "strNb2"
		int lon2 = strNb2.length();
		//Créer deux variables "chiffre1" et "chiffre2" de type int
		int chiffre1, chiffre2;
		//Créer la variable "ret" (pour la retenue) de type int et l'initialiser avec la valeur zéro
		int ret = 0;
		//Créer un compteur entier "i" de type int et initialisé à 1
		int i = 1;
		//Créer une variable "strSomme" (pour la somme calculée) de type String et l'initiliser avec la chaîne vide
		String strSomme = "";
	    /*Parcourir les deux nombres de la droite vers la gauche et additionner, pour chaque position,
	    les chiffres correspondants et la retenue*/
		do
		{
			//Préciser le chiffre courant du premier terme de la somme
			if(i <= lon1)
			{
				chiffre1 = strNb1.charAt(lon1-i)-48;
			}else
			{
				chiffre1 = 0;
			}
			//Préciser le chiffre courant du deuxième terme de la somme
			if(i <= lon2)
			{
				chiffre2 = strNb2.charAt(lon2-i)-48;
			}else
			{
				chiffre2 = 0;
			}
			//Calculer le chiffre courant de la somme et le concatener à gauche de la chaîne "strSomme"
			strSomme = ((chiffre1 + chiffre2 + ret) % b) + strSomme;
			//Calculer la nouvelle retenue
			ret = (chiffre1 + chiffre2 + ret) / b;
			//incrémenter le compteur d'une unité
			i = i+1;
		//Continuer la boucle tant qu'il y a encore des chiffres à additionner
		}while(i <= lon1 || i <= lon2);
		//Si la dernière retenue n'est pas nulle, concaténer sa valeur à gauche de la chaîne "strSomme"
		if(ret != 0)
		{
			strSomme = ret + strSomme;
		}
		//Crééer la variable "somme" de type int qui correspond à la chaîne "strSomme" transformée en valeur entière
		int somme = Integer.parseInt(strSomme);
		//Retourner la valeur entière de la somme calculée
		return somme;	
	}
//************************************************************************************************************************	
//	D�finir une m�thode statique appel�e "decToBase" qui a deux arguments :
//	    - le premier argument "nb" repr�sentant un nombre entier positif exprim� en base 10 ;
//	    - le deuxi�me argument "base" repr�sentant une base comprise entre 2 et 9 ;
//	 et qui :
//	    - si la base n'est pas valide, arr�te l'ex�cution du programme ;
//   	- dans les autres cas, retourne la valeur du deuxi�me argument exprim�e dans la base mentionn�e.

	static int decToBase(int nb, int base){
		if (base<2 || base >9){
			System.out.println("Erreur Base Incompatible");
			System.exit(-1);
		}
		int quotient = nb;
		String strRes = "";
		int chiffreRes = 0;
		while(quotient >= base){
			chiffreRes = quotient%base;
			quotient /= base;
			strRes = chiffreRes + strRes;
		}
		strRes = chiffreRes+ strRes;
		int res = Integer.parseInt(strRes);
		return res;
	}

//************************************************************************************************************************	
//	D�finir une m�thode statique appel�e "baseToDec" qui a deux arguments :
//	    - le premier argument "base" repr�sentant une base comprise entre 2 et 9 ;
//	    - le deuxi�me argument "nb" repr�sentant un nombre entier positif exprim� dans la base mentionn�e ;
//	 et qui :
//	    - si au moins un des deux arguments n'est pas valide, arr�te l'ex�cution du programme ;
//	    - dans les autres cas, retourne la valeur du deuxi�me argument en base 10.	
	static int baseToDec(int nb, int base){
		if (base<2 || base >9){
			System.out.println("Erreur Base Incompatible");
			System.exit(-1);
		}
		String strNb = Integer.toString(nb);
		int lon = strNb.length();
		int i = 1;
		int res = 0;
		
		while(i <= lon){
			res = res + Integer.parseInt(strNb.substring(i-1, i))*(int)Math.pow(base,  lon-i);
			++i;
		}
		return res;
	}

	
//************************************************************************************************************************	
//	D�finir une m�thode statique appel�e "base1ToBase2" qui a trois arguments :
//	    - le premier argument "base1" repr�sentant une "ancienne" base comprise entre 2 et 9 ;
//	    - le deuxi�me argument "nb" repr�sentant un nombre entier positif exprim� dans l'"ancienne" base ; 
//	    - le troisi�me argument "base2" repr�sentant une "nouvelle" base comprise entre 2 et 9 ;
//	 et qui :
//	    - si au moins un des trois arguments n'est pas valide, arr�te l'ex�cution du programme ;
//	    - dans les autres cas, retourne la valeur du deuxi�me argument exprim�e dans la "nouvelle" base.

	
//************************************************************************************************************************
	static int base1ToBase2(int base1, int nb, int base2){
		if (verifierBaseNombre(base1, nb) == false || verifierBaseNombre(base2, nb)){
			System.out.println("Erreur Base Incompatible");
			System.exit(-1);
		}
		int resInterm = baseToDec(base1, nb);
		int resFinal = decToBase(resInterm, base2);
		return resFinal;
	}
	
}
















