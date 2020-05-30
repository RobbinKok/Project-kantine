public class KantineMedewerker extends Persoon{

    private int mederWerkersnummer = 0;
    private boolean magAchterKassaStaan;

    public KantineMedewerker() {}

    public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int mederWerkersnummer, boolean magAchterKassaStaan) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.mederWerkersnummer = mederWerkersnummer;
        this.magAchterKassaStaan = magAchterKassaStaan;
    }

    public int getMederWerkersnummer() {
        return mederWerkersnummer;
    }

    public void setMederWerkersnummer(int mederWerkersnummer) {
        this.mederWerkersnummer = mederWerkersnummer;
    }

    public boolean isMagAchterKassaStaan() {
        return magAchterKassaStaan;
    }

    public void setMagAchterKassaStaan(boolean magAchterKassaStaan) {
        this.magAchterKassaStaan = magAchterKassaStaan;
    }
}
