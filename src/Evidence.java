import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evidence {
    private List<Zakaznik> seznamZakazniku = new ArrayList<>();

    public void pridejZakaznikyDoSeznamu(Zakaznik zakaznik) {
        seznamZakazniku.add(zakaznik);
    }

    public List<Zakaznik> getSeznamZakazniku() {
        return seznamZakazniku;
    }

    public void nactiZakaznikyZeSouboru(String nazevSouboru, String oddelovac, String oddelovac2) throws EvidenceException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("resources/" + nazevSouboru)))) {
            while(scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                oddelRadek(radek, oddelovac, oddelovac2);
            }
        } catch (FileNotFoundException e) {
            throw new EvidenceException("Soubor nebyl nalezen!");
        }
    }

    private void oddelRadek(String radek, String oddelovac, String oddelovac2) throws EvidenceException {
        String [] polozky = radek.split(oddelovac2);
        for (int i = 0; i < polozky.length; i++) {
            String zakaznik = polozky[i];
            pridejZakaznikyDoSeznamu(parseZakaznik(zakaznik, oddelovac));
        }
    }


    private Zakaznik parseZakaznik(String radek, String oddelovac) throws EvidenceException {
        String [] polozky = radek.split(oddelovac);
        if (polozky.length != 3) {
            throw new EvidenceException("Chybný počet položek!");
        }
        int id = Integer.parseInt(polozky[0].trim());
        String jmeno = polozky[1].trim();
        String prijmeni = polozky[2].trim();
        return new Zakaznik(id, jmeno, prijmeni);
    }

    public List<Zakaznik> zakazniciPodLimitem() {
        List<Zakaznik> zakazniciPodminky = new ArrayList<>();
        for(Zakaznik zakaznik : getSeznamZakazniku()) {
            if(zakaznik.getId() < 50 && zakaznik.getJmeno().equals("Ivana")) {
                zakazniciPodminky.add(zakaznik);
            }
        }
        return zakazniciPodminky;
    }
}
