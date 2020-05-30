public class Student extends  Persoon {

    private int studentNummer = 0;
    private String studieRichting = "";

    public Student() {
    }

    public Student(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentNummer, String studieRichting) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

    public String getStudieRichting() {
        return studieRichting;
    }

    public void setStudieRichting(String studieRichting) {
        this.studieRichting = studieRichting;
    }

}
