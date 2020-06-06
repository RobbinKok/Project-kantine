import java.util.Iterator;

public class Kassa {

    private KassaRij kassaRij;
    private int aantalVerkochteItems = 0;
    private double totaalPrijs = 0;


    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij) {
        this.kassaRij = kassaRij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant, Betaalwijze betaalwijze) {
        klant.getKlant().setBetaalwijze(betaalwijze);
        int aantalArtikelen = 0;
        double totalePrijs = 0;
        Iterator<Artikel> it = klant.getArtikelen().iterator();
        while(it.hasNext()){
            Artikel a = it.next();
            aantalArtikelen++;
            totalePrijs += a.getPrijs();
        }

        if (klant.getBetaalwijze().betaal(totalePrijs)) {// geeft nullpointer

            System.out.println("Betaling gelukt");
            if (klant instanceof KortingskaartHouder){
                if (((KortingskaartHouder) klant).geefKortingsPercentage() == 35){
                    totalePrijs = totaalPrijs * 0.65;
                }
                if (((KortingskaartHouder) klant).geefKortingsPercentage() == 25){
                    if (totalePrijs <= 1.0){
                        totalePrijs = totaalPrijs * 0.75;
                    } else {
                        totalePrijs = totaalPrijs * 1;
                    }
                }
            }
            aantalVerkochteItems += aantalArtikelen;
            totaalPrijs += totalePrijs;
        } else {
            System.out.println("Onvoldoende slado");
        }
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalVerkochteItems;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return totaalPrijs;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        aantalVerkochteItems = 0;
        totaalPrijs = 0;
    }
}
