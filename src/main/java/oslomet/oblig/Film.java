package oslomet.oblig;
//POJO
public class Film {
    private int antall;
    private String film;
    private String fornavn;
    private String etternavn;
    private String nummer;
    private String epost;

    public Film(int antall, String film, String fornavn, String etternavn, String nummer, String epost){
        this.antall=antall;
        this.film=film;
        this.fornavn=fornavn;
        this.etternavn=etternavn;
        this.nummer=nummer;
        this.epost=epost;
    }
    public Film(){

    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer=nummer;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}
