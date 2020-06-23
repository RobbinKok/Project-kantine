import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FactuurRegel")
public class FactuurRegel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(targetEntity = Factuur.class)
    private Factuur factuur;

    @Column(name = "Artikel", nullable = false)
    private Artikel artikel;

    /**
     * Vraag 6.4e:
     * Door een aparte klasse te hebben voor factuurregels kan je makkelijker een aparte tabel voor factuurregels maken,
     * wat goed is om te voorkomen dat je een tabel in een tabel krijgt.
     */

    public FactuurRegel(){

    }

    public FactuurRegel(Factuur factuur, Artikel artikel){
        this.factuur = factuur;
        this.artikel = artikel;
    }

    /**
     * @return een printbare factuurregel
     */
    public String toString(){
        // method body omitted
        return artikel.toString();
    }

}
