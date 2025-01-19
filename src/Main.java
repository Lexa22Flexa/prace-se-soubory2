public class Main {
    public static void main(String[] args) {
        Evidence evidence = new Evidence();
        try {
            evidence.nactiZakaznikyZeSouboru("zakaznici.txt", " ", ";");
        } catch (EvidenceException e) {
            System.err.println(e);
        }

        System.out.println(evidence.getSeznamZakazniku().size());
    }
}