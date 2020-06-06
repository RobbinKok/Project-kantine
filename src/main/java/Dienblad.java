import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen = new Stack<>();
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        // method body omitted
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
        artikelen.add(artikel);
    }

    public Stack<Artikel> getArtikelen() {
        return artikelen;
    }

    public Persoon getKlant() {return klant;}

    public String getKlantNaam() { return klant.getVoornaam() + " " + klant.getAchternaam(); }

    public String getKlantGeslacht() { return klant.getGeslacht(); }

    public int getKlantBSN() { return klant.getBsn();}

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    public Betaalwijze getBetaalwijze() {
        return klant.getBetaalwijze();
    }
}

