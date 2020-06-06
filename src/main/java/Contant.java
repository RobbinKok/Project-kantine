public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) {
        if(saldo < tebetalen){
            throw new TeWeinigGeldException();
        }
    }
}
