package cms_tp17;

@SuppressWarnings("serial")
class NameException extends java.lang.Exception {}

@SuppressWarnings("serial")
class AgeException extends java.lang.RuntimeException{}

public class CMSStudent
{
	private String name = new String("DefaultName");
	private int age = 18;

	CMSStudent() {}

	CMSStudent(String name, int age) throws NameException
	{
		try {
			setName(name);
			setAge(age);
		} catch(AgeException ExcRef) {

		}
	}

	public void setName(String name) throws NameException
	{
		char I = name.charAt(0);
		if ((I<'A')||(I>'z')) throw new NameException();
		if (I>'a') I -= 32;
		this.name = new String(I + name.substring(1));		
	}

	public String getName()
	{
		return name;
	}

	public void setAge(int age) throws AgeException
	{
		this.age = (age<16)?16:(age>23)?23:age;
		if (this.age!=age) throw new AgeException();
	}

	public int getAge()
	{
		return age;
	}	

	public void afficher()
	{
		System.out.println("Je suis un etudiant du CMS.");
		System.out.println("Mon nom est "+name+" et mon age est "+age+".");
	}
}