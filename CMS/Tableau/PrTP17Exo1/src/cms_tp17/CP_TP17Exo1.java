package cms_tp17;

public class CP_TP17Exo1 
{
	public static void main(String args[])
	{
		String [] tabNoms = {"Dupont", "blanc", "_martin"};
		int [] tabAges = {15,19,28};
		CMSStudent [] tabEtudiants = new CMSStudent[3];
		
		for(int i=0;i<3;i++)
		{
			try {
				tabEtudiants[i] = new CMSStudent(tabNoms[i],tabAges[i]);
			} catch (NameException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Nom Non Valide!");
				System.exit(1);
			}
			tabEtudiants[i].afficher();
		}		
	}
}