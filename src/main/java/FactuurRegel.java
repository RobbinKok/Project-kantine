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
    }

}
