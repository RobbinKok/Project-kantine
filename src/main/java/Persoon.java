public class Persoon {

    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;

    public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        setGeslacht(geslacht);
    }

    public Persoon() {
        this.bsn = 0;
        this.voornaam = "";
        this.achternaam = "";
        this.geboortedatum = new Datum(0,0,0);
        setGeslacht('X');
    }

    public void setBsn(int bsn) {
        this.bsn = bsn;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht(char geslacht) {
        if(geslacht == 'M' || geslacht == 'V'){
            this.geslacht = geslacht;
            return;
        }
        System.out.println("De waarde van geslacht moet 'M' of 'V' zijn. De gegeven waarde was " + geslacht);
    }

    public int getBsn() {
        return bsn;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum.getDatumAsString();
    }

    public String getGeslacht() {
        switch (geslacht){
            case 'M':
                return "Man";
            case 'V':
                return "Vrouw";
        }
        return "Onbekend";
    }

    @Override
    public String toString() {
        return bsn + " " + voornaam + " " + achternaam + " " + getGeboortedatum() + " " + getGeslacht();
    }

}
