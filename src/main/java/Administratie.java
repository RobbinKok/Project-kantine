public class Administratie {

    private final int days_in_week = 7;

    /**
     * Door de constructor private te maken kunnen andere klasses geen administratie aanmaken
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
        for (int i = 0; i < aantal.length; i++){
            total += aantal[i];
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
     * Dit komt omdat de methoden van administratie input van de andere klassen verwacht
     */

    /**
     * Week3 opgave 2D:
     * Het heeft nut om de methoden static te maken, aangezien je ze wilt aanroepen zonder dat er een object van Administratie bestaat
     */

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    static double berekenGemiddeldeOmzet(double[] omzet) {
        double total = 0;
        for (int i = 0; i < omzet.length; i++){
            total += omzet[i];
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
        double[] temp = new double[days_in_week];
        for(int i = 0; i < 7; i++) {
            int j = 0;
            while ( j < omzet.length ) {
                temp[i] += omzet[i + 7 * j];

                j++;

            }
        }
        return temp;
    }

    /**
     * Week 3 opgave 2G:
     * Door er een static variable van te maken heb je veel meer controle over het aantal dagen.
     */

    /**
     * Week 3 opgave 2H:
     * De compiler klaagt hierover, omdat je geen non static variablen kan aanroepen in een static funcite
     * Dit kan je oplossen door de variabele static te maken.
     */
}
