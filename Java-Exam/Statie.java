package new_package;

public class Statie {
	private String denumire;
	private int numarCalatorii;
	
	public Statie(String denumire, int numarCalatorii) {
		super();
		this.denumire = denumire;
		this.numarCalatorii = numarCalatorii;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getNumarCalatorii() {
		return numarCalatorii;
	}

	public void setNumarCalatorii(int numarCalatorii) {
		this.numarCalatorii = numarCalatorii;
	}

	@Override
	public String toString() {
		return "Statie [denumire=" + denumire + ", numarCalatorii=" + numarCalatorii + "]";
	}
	
	
}
