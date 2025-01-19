import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
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
                //String zakaznik = radek.split(oddelovac2);
                pridejZakaznikyDoSeznamu(parseZakaznik(radek, oddelovac));
            }
        } catch (FileNotFoundException e) {
            throw new EvidenceException("Soubor nebyl nalezen!");
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
}
