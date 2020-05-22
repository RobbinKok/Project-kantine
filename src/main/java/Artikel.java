public class Artikel {

    private String naam;
    private double prijs;

    public Artikel(String naam, double prijs) {
        setNaam(naam);
        setPrijs(prijs);
    }

    public Artikel() {
        setNaam(null);
        setPrijs(0);
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return naam + ": €" + prijs;
    }
}
