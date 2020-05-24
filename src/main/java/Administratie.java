public class Administratie {

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public double berekenGemiddeldAantal(int[] aantal) {
        int total = 0;
        for (int i = 0; i < aantal.length; i++){
            total += aantal[i];
        }
        int gemiddeldAantal = total / aantal.length;

        return gemiddeldAantal;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public double berekenGemiddeldeOmzet(double[] omzet) {
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
