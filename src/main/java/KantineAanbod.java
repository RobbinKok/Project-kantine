import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> startVoorraad;
    private HashMap<String, Double> prijzen;
    private String artikelKorting;

    /**
     * 2.5b:
     * Een HashMap heeft keys waarmee naar bepaalde elementen verwezen kan worden. Een HashSet heeft geen keys,
     * en garandeert zelfs niet dat elementen in dezelfde volgorde blijven staan. Een HashSet kan dus beter gebruikt
     * worden als je van plan bent te itereren over alle elementen, terwijl een HashMap gebruikt kan worden om
     * specifieke elementen op te vragen aan de hand van een key van een type dat je zelf kan bepalen.
     */

    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen, het tweede argument is
     * een lijst met prijzen en het derde argument is een lijst met hoeveelheden. Let op: de
     * dimensies van de drie arrays moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) {
        aanbod = new HashMap<>();
        startVoorraad = new HashMap<>();
        prijzen = new HashMap<>();
        for (int i = 0; i < artikelnaam.length; i++) {
            ArrayList<Artikel> artikelen = new ArrayList<>();
            for (int j = 0; j < hoeveelheid[i]; j++) {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            startVoorraad.put(artikelnaam[i], hoeveelheid[i]);
            prijzen.put(artikelnaam[i], prijs[i]);
            aanbod.put(artikelnaam[i], artikelen);
        }
    }

    public void setKorting(String naam, double korting){
        ArrayList<Artikel> artikelen = aanbod.get(naam);

        for (int i = 0; i < artikelen.size(); i++){
            artikelen.get(i).setKorting(artikelen.get(i).getPrijs() * korting);
        }

        this.artikelKorting = naam;

    }


    private void vulVoorraadAan(String productnaam) {
        ArrayList<Artikel> huidigeVoorraad = aanbod.get(productnaam);
        int startHoeveelheid = startVoorraad.get(productnaam);
        int huidigeHoeveelheid = huidigeVoorraad.size();
        double prijs = prijzen.get(productnaam);
        for (int j = huidigeHoeveelheid; j < startHoeveelheid; j++) {
            if (productnaam.equals(artikelKorting)){
                huidigeVoorraad.add(new Artikel(productnaam, prijs, prijs * 0.2));
            } else {
                huidigeVoorraad.add(new Artikel(productnaam,prijs));
            }
        }
        aanbod.put(productnaam, huidigeVoorraad);
    }

    /**
     * Private methode om de lijst van artikelen te krijgen op basis van de naam van het artikel.
     * Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
        return aanbod.get(productnaam);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. Retourneert null als de
     * stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel == null) {
            return null;
        }
        if (stapel.size() == 0) {
            return null;
        } else {
            Artikel a = stapel.get(0);
            stapel.remove(0);
            if (stapel.size() <= 10)
                vulVoorraadAan(a.getNaam());
            return a;
        }
    }

    /**
     * 2.5a:
     * De twee bovenstaande private methodes zijn niet nuttig om van buiten deze klasse aan te roepen. Ze bestaan
     * immers alleen om de werking van de onderstaande methode mogelijk te maken. Er wordt gezorgd dat door middel
     * van enkel de productnaam een artikel met die naam wordt doorgegeven, en ook verwijderd uit het aanbod.
     */

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken. Retourneert null als artikel
     * niet bestaat of niet op voorraad is.
     *
     * @param productnaam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String productnaam) {
        return getArtikel(getArrayList(productnaam));
    }
}
