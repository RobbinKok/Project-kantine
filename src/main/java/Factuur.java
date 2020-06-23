import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;

@Entity
@Table(name = "Factuur")
public class Factuur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Transaction_date", nullable = false)
    private LocalDate datum;

    @Column(name = "Korting", nullable = false)
    private double korting;

    @Column(name = "Totaalprijs", nullable = false)
    private double totaal;

    public Factuur() {
        totaal = 0;
        korting = 0;
    }

    public Factuur(Dienblad klant, LocalDate datum){
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    /**
     * Verwerk artikelen en pas kortingen toe.
     *
     * Zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen.
     *
     * @param klant
     */
    private void verwerkBestelling(Dienblad klant) {
        int aantalArtikelen = 0;

        Iterator<Artikel> it = klant.getArtikelen().iterator();
        while (it.hasNext()){
            Artikel a = it.next();
            aantalArtikelen++;

            if (a.getKorting()==0){
                totaal += a.getPrijs();
                if (klant instanceof KortingskaartHouder){
                    korting += a.getPrijs() * (((KortingskaartHouder)klant).geefKortingsPercentage()/100);
                }
            } else {
                totaal += a.getPrijs() - a.getKorting();
            }

            if (klant instanceof KortingskaartHouder){
                if (((KortingskaartHouder)klant).heeftMaximum()){
                    if (korting > ((KortingskaartHouder)klant).geefMaximum()){
                        korting = ((KortingskaartHouder)klant).geefMaximum();
                    }
                }
            }
            totaal = totaal - korting;
        }
    }


    public void setKorting(double korting) {
        this.korting = korting;
    }

    public void setTotaal(double totaal) {
        this.totaal = totaal;
    }

    /**
     * @return het totaalbedrag
     */
    public double getTotaal() {
        return totaal;
    }

    /**
     * @return de toegepaste korting
     */
    public double getKorting() {
        return korting;
    }

    /**
     * @return een printbaar bonnetje
     */
    public String toString() {
        return "Betalingsnummer: " + id +  "\nDatum: " + datum + "\nKorting: " + korting + "\nTotaalbedrag: " + totaal ;
    }
}
