public class Administratie {

    private final static int DAYS_IN_WEEK = 7;

    /**
     * Week3 opgave 3E:
     * Door de constructor private te maken kunnen andere klassen geen administratie aanmaken
     */
    private Administratie() {}

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    static double berekenGemiddeldAantal(int[] aantal) {
        int total = 0;
        for (int value : aantal) {
            total += value;
        }
        return (double)total / (double)aantal.length;
    }

    /**
     * Week3 opgave 2B:
     * De uitkomst van de 2 methoden klopt inderdaad met de gegeven input
     * Bij berekenGemiddeldeOmzet is de uitkomst: 508.2833333333333
     * Bij berekenGemiddeldAantal is de uitkomst: 40.833333333333336
     */

    /**
     * Week3 opgave 2C:
     * Als er geen constructor is maakt Java automatisch een constructor zonder argumenten aan.
     */

    /**
     * Week3 opgave 2D:
     * De methodes kunnen static zijn omdat ze werken zonder variabelen van een object van Administratie
     */

    /**
     * Week 3 opgave 2G:
     * Het keyword "final" zorgt ervoor dat een variabele maar één keer een waarde toegekend kan krijgen.
     */

    /**
     * Week 3 opgave 2H:
     * De compiler klaagt hierover, omdat je geen non static variabelen kan aanroepen in een static methode
     * Dit kan je oplossen door de variabele static te maken.
     */

    /**
     * Week 3 opgave 2I:
     * Het probleem dat nu weer word geïntroduceerd is dat DAYS_IN_WEEK veranderd zou kunnen worden.
     */

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    static double berekenGemiddeldeOmzet(double[] omzet) {
        double total = 0;
        for (double value : omzet) {
            total += value;
        }

        return total / omzet.length;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {
            int j = 0;
            while ( i + DAYS_IN_WEEK * j < omzet.length ) {
                int index = i + DAYS_IN_WEEK * j;
                if (index <= omzet.length) {
                    temp[i] += omzet[index];
                }
                j++;
            }
        }
        return temp;
    }
}
