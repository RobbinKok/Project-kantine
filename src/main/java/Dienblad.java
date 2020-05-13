import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    Persoon klant;
    /**
     * Constructor
     */
    public Dienblad() {
        // method body omitted
        artikelen = new ArrayList<>();
        klant = new Persoon();
    }

    /**
     * De constructor die een nieuwe dienbald aanmaakt met klant als parameter
     * @param klant
     */
    public Dienblad(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        // method body omitted
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        // method body omitted

        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        // method body omitted

        float prijs = 0;
        for (Artikel a: artikelen) {
            a.getPrijs();
            prijs = prijs + a.getPrijs();

        }
        return prijs;
    }

    public Persoon getKlant() {return klant;}


    public String getKlantNaam() { return klant.getVoornaam() + " " + klant.getAchternaam(); }

    public String getKlantGeslacht() { return klant.getGeslacht(); }

    public int getKlantBSN() { return klant.getBsn();}
}

