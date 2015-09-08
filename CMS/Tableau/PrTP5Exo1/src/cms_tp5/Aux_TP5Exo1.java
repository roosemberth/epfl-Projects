package cms_tp5;

import java.util.GregorianCalendar;

public class Aux_TP5Exo1 {
	public static int calculerAge(int anneNaissance){
		GregorianCalendar gc = new GregorianCalendar();
		int anneactual = gc.get(java.util.GregorianCalendar.YEAR);
		return (anneactual-anneNaissance);
	}
}
