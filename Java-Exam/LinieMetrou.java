package new_package;

import java.util.ArrayList;

public class LinieMetrou {
	private int id;
	private ArrayList<Statie> statii;
	
	public LinieMetrou(int id, ArrayList<Statie> statii) {
		super();
		this.id = id;
		this.statii = statii;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Statie> getStatii() {
		return statii;
	}

	public void setStatii(ArrayList<Statie> statii) {
		this.statii = statii;
	}

	@Override
	public String toString() {
		return "LinieMetrou [id=" + id + ", statii=" + statii + "]";
	}
	
	
}
