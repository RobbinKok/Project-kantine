public class Docent extends Persoon{
    private String afkorting;
    private String afdeling;

    public Docent() {}

    /**
     * Week3 vraag 3B:
     * De super-aanroep wordt alleen uitgevoerd als het het eerste is wat de constructor doet.
     */

    public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht,
                  String afkorting, String afdeling) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);

        if (afkorting.length() == 4) {
            this.afkorting = afkorting;
        } else {
            System.out.println("Afkorting moet 4 letters bevatten");
        }
        this.afdeling = afdeling;
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        if (afkorting.length() == 4) {
            this.afkorting = afkorting;
        } else {
            System.out.println("Afkorting moet 4 letters bevatten");
        }
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}