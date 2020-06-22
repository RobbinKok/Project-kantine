import java.util.*;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class KantineSimulatie_2 {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    private static EntityManager manager;
    //private EntityManager manager;

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    public static final int DAGEN = 7;

    /**
     * Constructor
     * Maakt een Kantine aan met een aanbod van de artikelen met prijzen zoals bepaald in de statische constanten
     * van de klasse. Het aanbod van deze artikelen is, voor elk artikel, een willekeurige waarde tussen de
     * statische constanten MIN_ARTIKELEN_PER_SOORT en MAX_ARTIKELEN_PER_SOORT.
     */
    public KantineSimulatie_2() {
        kantine = new Kantine(manager);
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);

        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
/*        int index = random.nextInt(artikelnamen.length);
        Artikel artikelmetkorting = kantineaanbod.getArtikel(artikelnamen[index]);
        artikelmetkorting.setKorting(artikelmetkorting.getPrijs() * 0.2);*/

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     * Gebruikt de nextInt(int bound) methode in Java.util.Random. Deze methode geeft een willekeurige integer
     * tussen 0 (inclusive) en de bound (exclusive) terug. Dit betekent dat 0 wel gegeven kan worden, maar de bound
     * niet. Als nextInt 0 geeft, krijgen we 0 + min = min terug, wat de laagste waarde die we willen krijgen is.
     * Als nextInt de hoogst mogelijke waarde geeft, krijgen we ((max - min + 1) - 1) + min = max. De +1 in de bound
     * zorgt ervoor dat max inclusive is, terwijl bound van nextInt dat niet is.
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];
        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        //create an EntityManager
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();

        // for lus voor dagen
        int[] aantalGekochteArtikelen = new int[dagen];
        double[] omzet = new double[dagen];

        for(int i = 0; i < dagen; i++) {
            String artikelVanDeDag = artikelnamen[random.nextInt(artikelnamen.length)];
            kantineaanbod.setKorting(artikelVanDeDag, 0.2);
            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {
                // maak persoon en dienblad aan, koppel ze
                Dienblad klant = null;
                int n = random.nextInt(100);
                if(n<89) {
                    Pinpas pinpas = new Pinpas();
                    pinpas.setSaldo(500);
                    Persoon p = new Student(j, "John", "Doe",
                            new Datum(1, 1, 2000), 'M', j*33, "ICT");
                    p.setBetaalwijze(pinpas);
                    klant = new Dienblad(p);
                }else if(n<99){
                    Pinpas pinpas = new Pinpas();
                    pinpas.setSaldo(1000);
                    Persoon p = new Docent(j, "Jan", "Jansen",
                            new Datum(10, 10, 1970), 'M', "JAJA", "ICT");
                    p.setBetaalwijze(pinpas);
                    klant = new Dienblad(p);
                }else if(n==99){
                    Pinpas pinpas = new Pinpas();
                    pinpas.setSaldo(1000);
                    Persoon p = new KantineMedewerker(j, "Piet", "Hein",
                            new Datum(5, 5, 1980), 'M', j*33, true);
                    p.setBetaalwijze(pinpas);
                    klant = new Dienblad(p);
                }

                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(klant, artikelen);

                System.out.println(klant.getKlant());

            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af en hoeveel personen binnenzijn gekomen
            System.out.println("Er waren vandaag " + aantalpersonen + " klanten. \nIn totaal hebben ze " +
                    kantine.getKassa().aantalArtikelen() + " artikelen gekocht, voor een totaalbedrag van €" +
                    kantine.getKassa().hoeveelheidGeldInKassa() + ".\n");

            aantalGekochteArtikelen[i] = kantine.getKassa().aantalArtikelen();
            omzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();

            //Query van 3a:
            System.out.println("De query van 3a:");
            String queryV3aa = "SELECT Totaalprijs, Korting from Factuur";
            Query query3a = manager.createNativeQuery(queryV3aa);
            List<Object[]> result3a = query3a.getResultList();
            for (i = 0; i < result3a.size(); i++){
                System.out.println(Arrays.toString(result3a.get(i)));
            }


            //Query van 3b:
            System.out.println("");
            System.out.println("De query van 3b:");
            Query query3b = manager.createNativeQuery("SELECT avg(Totaalprijs), sum(Korting) from Factuur group by Totaalprijs");
            List<Object[]> result3b = query3b.getResultList();
            result3b.forEach(r -> System.out.println(Arrays.toString(r)));


            //Query van 3C:
            System.out.println("");
            System.out.println("De query van 3c:");
            Query query3c = manager.createNativeQuery("SELECT  Totaalprijs, Korting from Factuur order by totaalprijs DESC limit 3");
            List<Object[]> result3c = query3c.getResultList();
            for (int j = 0; j < result3c.size(); j++){
                System.out.println(Arrays.toString(result3c.get(j)));
            }
            System.out.println();


            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();

        }

        System.out.println("Het gemiddeld aantal gekochte artikelen is " +
                Administratie.berekenGemiddeldAantal(aantalGekochteArtikelen));
        System.out.println("De gemiddelde omzet is €" + Administratie.berekenGemiddeldeOmzet(omzet));
        double[] dagomzet = Administratie.berekenDagOmzet(omzet);
        System.out.println("De omzet op maandagen was €" + dagomzet[0] + ". \nDe omzet op dinsdagen was € " + dagomzet[1] +
                ". \nDe omzet op woensdagen was €" + dagomzet[2] + ". \nDe omzet op donderdagen was € " + dagomzet[3] +
                ". \nDe omzet op vrijdagen was € " + dagomzet[4] + ". \nDe omzet op zaterdagen was € " + dagomzet[5] +
                ". \nDe omzet op zondagen was € " + dagomzet[6] + ".");

        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_2 simulatie = new KantineSimulatie_2();
        simulatie.simuleer(dagen);
        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }

}
