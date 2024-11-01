package new_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	private static ArrayList<LinieMetrou> citireDate() {
		ArrayList<LinieMetrou> liniiMetrou = new ArrayList<>();
		try {
			String cale = "src/new_package/retea.in";
			File fisier = new File(cale);
			Scanner scanner = new Scanner(fisier);
			int dimensiune = scanner.nextInt();
			scanner.nextLine();
			for(int i=0;i<dimensiune;i++) {
				String linie = scanner.nextLine();
				String[] campuri = linie.split("[*]");
				int id = Integer.valueOf(campuri[0]);
				ArrayList<Statie> statii = new ArrayList<>();
				int nrStatii = Integer.valueOf(campuri[1]);
				for(int j=0;j<nrStatii;j++) {
					String denumire = campuri[2];
					int numarStatii = Integer.valueOf(campuri[3]);
					statii.add(new Statie(denumire, numarStatii));
				}
				liniiMetrou.add(new LinieMetrou(id, statii));
			}
			scanner.close();
		}
		catch(FileNotFoundException exceptie){
			System.out.println("Nu exista fisierul");
			exceptie.printStackTrace();
		}
		return liniiMetrou;
	}
	
	private static void sortareDUpaNrCalatorii(ArrayList<LinieMetrou> liniiMetrou) {
		ArrayList<Statie> calatorii = new ArrayList<>();
		for(LinieMetrou linie : liniiMetrou) {
			for(Statie lin:linie.getStatii()) {
				if(lin instanceof Statie)
					calatorii.add((Statie)lin);
			}
			
		Collections.sort(calatorii ,new Comparator<Statie>() {
			@Override
			public int compare(Statie c1, Statie c2) {
				if (c1.getNumarCalatorii()>c2.getNumarCalatorii()) 
					return -1;
				return 1;
				
			}
		});

		}
	}
	
	public static void afisareInFisier(ArrayList<LinieMetrou> liniiMetrou) {
		try {
			String cale = "src/new_package/statii.out";
			FileWriter fisier = new FileWriter(cale);
			for(var linie:liniiMetrou) {
				fisier.write(linie.toString() + "\n");
			}
			fisier.close();
			
		} 
		catch(IOException exceptie)
		{
			System.out.println("Eroare la scriere in fisier");
			exceptie.printStackTrace();
		}
		
	}
	
	public static void mapaStatii(ArrayList<LinieMetrou> liniiMetrou) {
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		for(LinieMetrou linie:liniiMetrou) {
			for(Statie statie: linie.getStatii()) {
				if(!mapa.containsKey(statie.getDenumire())) {
					mapa.put(statie.getDenumire(), 1);
				} else {
					mapa.put(statie.getDenumire(), mapa.get(statie.getDenumire())+1);
				}
			}
		}
		System.out.println(mapa);
		int maxim = Collections.max(mapa.values());
		System.out.println("Valoare maxima: "+maxim);
		for(var element:mapa.entrySet()) {
			if(element.getValue() == maxim) {
				System.out.println("Cheia: "+element.getKey()+" Valoare: "+element.getValue());
				break;
			}
		}
	}

	public static void statiiValide(ArrayList<LinieMetrou> liniiMetrou) {
		String regex = "[^aeiouAEIOU].*";
		Pattern pattern = Pattern.compile(regex);
		for(LinieMetrou linie : liniiMetrou) {   
			for(var lin:linie.getStatii()) {
			String Denumire = lin.getDenumire();
			if(pattern.matcher(Denumire).matches() && lin.getNumarCalatorii()>9) {
				System.out.println(Denumire);
			}
		}}
	}
	
	public static void main(String[] args) {
		ArrayList<LinieMetrou> liniiMetrou = citireDate();
		System.out.println(liniiMetrou);
		sortareDUpaNrCalatorii(liniiMetrou);
		afisareInFisier(liniiMetrou);	
		mapaStatii(liniiMetrou);
		statiiValide(liniiMetrou);
	}
}
