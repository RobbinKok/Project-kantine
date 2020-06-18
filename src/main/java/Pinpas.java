public class Pinpas extends Betaalwijze {

    private double kredietlimiet = 1000;

    /**
     * Methode om kredietlimiet te zetten
     *
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) {
        if(kredietlimiet < tebetalen || saldo < tebetalen){
            throw new TeWeinigGeldException();
        }
    }
}
