public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    public Kassa getKassa() {
        return kassa;
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan() {
        Persoon persoon1 = new Persoon(123456789, "Bob", "Ross", new Datum(4,7,1995), 'M');
        Dienblad dienbladPersoon1 = new Dienblad(persoon1);
        Artikel artikel1 = new Artikel("vis", 12);
        Artikel artikel2 = new Artikel("pizza", 15);
        dienbladPersoon1.voegToe(artikel1);
        dienbladPersoon1.voegToe(artikel2);
        kassarij.sluitAchteraan(dienbladPersoon1);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

}
