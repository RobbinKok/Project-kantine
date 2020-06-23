import javax.persistence.Embeddable;

@Embeddable
public class Artikel {

    private String naam;
    private double prijs;
    private double korting;

    public Artikel(String naam, double prijs, double korting){
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }

    public Artikel(String naam, double prijs) {
        this(naam, prijs, 0);
    }

    public Artikel() {
        setNaam(null);
        prijs = 0;
        korting = 0;
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

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }

    @Override
    public String toString() {
        return naam + ": €" + prijs;
    }
}
