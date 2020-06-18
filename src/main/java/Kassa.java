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
    public void rekenAf(Dienblad klant) {
        //klant.getKlant().setBetaalwijze(betaalwijze);
        int aantalArtikelen = 0;
        double totalePrijs = 0;
        double korting = 0;

        Iterator<Artikel> it = klant.getArtikelen().iterator();
        while(it.hasNext()){
            Artikel a = it.next();
            aantalArtikelen++;

            if(a.getKorting()==0){
                totalePrijs += a.getPrijs();
                if(klant instanceof KortingskaartHouder){
                    korting += a.getPrijs() * (((KortingskaartHouder)klant).geefKortingsPercentage()/100);
                }
            }else{
                totalePrijs += a.getPrijs() - a.getKorting();
            }
        }

        if (klant instanceof KortingskaartHouder){
            if(((KortingskaartHouder)klant).heeftMaximum()){
                if(korting > ((KortingskaartHouder)klant).geefMaximum()){
                    korting = ((KortingskaartHouder)klant).geefMaximum();
                }
            }
        }

        totalePrijs = totalePrijs - korting;
        try{
            klant.getBetaalwijze().betaal(totalePrijs);
            aantalVerkochteItems += aantalArtikelen;
            totaalPrijs += totalePrijs;
        } catch(TeWeinigGeldException e) {
            System.out.println(klant.getKlantNaam() + " heeft onvoldoende saldo voor deze transactie.");
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
