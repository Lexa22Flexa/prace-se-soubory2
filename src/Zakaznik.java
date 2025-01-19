public class Zakaznik {
    private int id;
    private String jmeno;
    private String prijmeni;

    public Zakaznik(int id, String jmeno, String prijmeni) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }
}
