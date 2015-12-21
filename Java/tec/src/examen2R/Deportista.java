package examen2R;

public abstract class Deportista {
	private String nom;
	private String dom;
	private String suelMens;
	
	public Deportista()
	{	
	}
	
	public Deportista(String nom, String dom, double suelMens)
	{
		setNom(nom);
		setDom(dom);
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getSuelMens() {
		return suelMens;
	}

	
	

	public abstract double bono();
	public abstract String desplegar();
}
