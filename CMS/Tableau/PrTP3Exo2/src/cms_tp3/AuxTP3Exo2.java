package cms_tp3;

import java.util.GregorianCalendar;

public class AuxTP3Exo2 {
	public static int CalculerAge(int anZero){
		GregorianCalendar Calendar = new GregorianCalendar();
		int anCourant = Calendar.get(GregorianCalendar.YEAR);
		if (anZero >= 1900 && anZero <=anCourant){
			int age = anCourant - anZero;
			return age;
		} else {
			System.out.println("Année de naissance non valide!\nL'age aura la valeur -1!");
			return -1;
		}
	}
}
