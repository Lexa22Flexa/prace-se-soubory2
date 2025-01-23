public class Main {
    public static void main(String[] args) {
        Evidence evidence = new Evidence();
        try {
            evidence.nactiZakaznikyZeSouboru("zakaznici.txt", " ", ";");
            for(Zakaznik zakaznik : evidence.zakazniciPodLimitem()) {
                System.out.println(zakaznik.getId());
            }
        } catch (EvidenceException e) {
            System.err.println(e);
        }


    }
}