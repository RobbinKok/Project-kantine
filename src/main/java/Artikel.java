public class Artikel {

    private String naam;
    private float prijs;

    public Artikel(String naam, float prijs) {
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

    public float getPrijs() {
        return prijs;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

}
