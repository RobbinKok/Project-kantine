public class Administratie {

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
     * Week3 opgave 2b:
     * De uitkomst van de 2 methoden klopt inderdaad met de gegeven input
     * Bij berekenGemiddeldeOmzet is de uitkomst: 508.2833333333333
     * Bij berekenGemiddeldAantal is de uitkomst: 40.833333333333336
     */

    /**
     * Week3 opgave 2c:
     * Dit komt omdat de methoden van administratie input van de andere klassen verwacht
     */

    /**
     * Week3 opgave 2d:
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
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++) {

            int j = 0;
            while ( ... ) {
                temp[i] += omzet[i + 7 * j];

                // omitted

            }
        }
        return temp;
    }
}
