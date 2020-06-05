public class KantineMedewerker extends Persoon implements KortingskaartHouder{

    private int medewerkersnummer;
    private boolean magAchterKassaStaan;

    public KantineMedewerker() {}

    public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht,
                             int medewerkersnummer, boolean magAchterKassaStaan) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.magAchterKassaStaan = magAchterKassaStaan;
    }

    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isMagAchterKassaStaan() {
        return magAchterKassaStaan;
    }

    public void setMagAchterKassaStaan(boolean magAchterKassaStaan) {
        this.magAchterKassaStaan = magAchterKassaStaan;
    }

    @Override
    public double geefKortingsPercentage() {
        return 35.0;
    }

    @Override
    public boolean heeftMaximum() {
        return false;
    }

    @Override
    public double geefMaximum() {
        return 0;
    }
}