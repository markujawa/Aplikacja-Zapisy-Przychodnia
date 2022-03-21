package projekt_java_kujawa_latos;

/**
 * Klasa reprezentująca wszystkie dane dotyczące lekarza w aplikacji
 */
public class Doctor {

    /**
     * prywatne zmienne lekarza przechowujące wszystie dane
     */
    private String pierwszeImie;
    private String drugieImie;
    private String nazwisko;
    private String plec;
    private String PESEL;
    private String dataUrodzenia;
    private String nrTelefonu;
    private String email;
    private String ulica;
    private int numerDomu;
    private int numerMieszkania;
    private String kodPocztowy;
    private String miasto;
    private String kraj;

    /**
     * Konstruktor domyślny klasy Doctor
     */
    public Doctor() {
    }

    /**
     * Konstruktor klasy Doctor z parametrami
     *
     * @param pierwszeImie - pierwsze imie
     * @param drugieImie - drugie imie
     * @param nazwisko - nazwisko
     * @param plec - plec lekarza
     * @param PESEL - nr pesel
     * @param data - data urodzenia
     * @param nrTelefonu - numer telefonu
     * @param email -email
     * @param ulica - ulica
     * @param numerDomu - numer domu
     * @param numerMieszkania - numer mieszkania
     * @param kodPocztowy - kod pocztowy
     * @param miasto - miasto zamieszkania
     * @param kraj - kraj pochodzenia
     */
    public Doctor(String pierwszeImie, String drugieImie, String nazwisko, String plec, String PESEL, String data, String nrTelefonu, String email, String ulica, int numerDomu, int numerMieszkania, String kodPocztowy, String miasto, String kraj) {
        this.pierwszeImie = pierwszeImie;
        this.drugieImie = drugieImie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.PESEL = PESEL;
        this.dataUrodzenia = data;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.kraj = kraj;
    }

    /**
     * Publiczna metoda zwracająca imię lekarza
     *
     * @return pierwszeImie
     */
    public String getPierwszeImie() {
        return pierwszeImie;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie imienia lekarza
     *
     * @param pierwszeImie - pierwsze imie lekarza
     */
    public void setPierwszeImie(String pierwszeImie) {
        this.pierwszeImie = pierwszeImie;
    }

    /**
     * Publiczna metoda zwracająca drugie imię lekarza
     *
     * @return drugieImie
     */
    public String getDrugieImie() {
        return drugieImie;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie drugiego imienia lekarza
     *
     * @param drugieImie - drugie imie lekarza
     */
    public void setDrugieImie(String drugieImie) {
        this.drugieImie = drugieImie;
    }

    /**
     * Publiczna metoda zwracająca nazwisko lekarza
     *
     * @return nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie nazwiska lekarza
     *
     * @param nazwisko - nazwisko lekarza
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Publiczna metoda zwracająca płec lekarza
     *
     * @return plec
     */
    public String getPlec() {
        return plec;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie płci lekarza
     *
     * @param plec - płec lekarza
     */
    public void setPlec(String plec) {
        this.plec = plec;
    }

    /**
     * Publiczna metoda zwracająca pesel lekarza
     *
     * @return PESEL
     */
    public String getPesel() {
        return PESEL;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie PESELU lekarza
     *
     * @param PESEL - PESEL lekarza
     */
    public void setPesel(String PESEL) {
        this.PESEL = PESEL;
    }

    /**
     * Publiczna metoda zwracająca datę urodzenia lekarza
     *
     * @return dataUrodzenia
     */
    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie daty urodzenia lekarza
     *
     * @param data - data urodzenia lekarza
     */
    public void setDataUrodzenia(String data) {
        this.dataUrodzenia = data;
    }

    /**
     * Publiczna metoda zwracająca numer telefonu lekarza
     *
     * @return nrtelefonu
     */
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie numeru telefonu lekarza
     *
     * @param nrTelefonu - numer telefonu lekarza
     */
    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    /**
     * Publiczna metoda zwracająca email lekarza
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie emaila lekarza
     *
     * @param email - email lekarza
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Publiczna metoda zwracająca ulicę lekarza
     *
     * @return ulica
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie ulicy lekarza
     *
     * @param ulica- miejsce zamieszkania lekarza
     */
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    /**
     * Publiczna metoda zwracająca numer domu lekarza
     *
     * @return numerDomu
     */
    public int getNumerDomu() {
        return numerDomu;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie numeru domu lekarza
     *
     * @param numerDomu - numer domu lekarza
     */
    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    /**
     * Publiczna metoda zwracająca numer mieszkania lekarza
     *
     * @return numerMieszkania
     */
    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie numeru mieszkania lekarza
     *
     * @param numerMieszkania - numer mieszkania lekarza
     */
    public void setNumerMieszkania(int numerMieszkania) {
        this.numerMieszkania = numerMieszkania;
    }

    /**
     * Publiczna metoda zwracająca kod pocztowy lekarza
     *
     * @return kodPocztowy
     */
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie kodu pocztowego lekarza
     *
     * @param kodPocztowy - kod pocztowy
     */
    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    /**
     * Publiczna metoda zwracająca miasto lekarza
     *
     * @return miasto
     */
    public String getMiasto() {
        return miasto;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie miasta zamieszkania lekarza
     *
     * @param miasto - miasto zamieszkania lekarza
     */
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    /**
     * Publiczna metodą zwracająca kraj pochodzenia
     *
     * @return kraj
     */
    public String getKraj() {
        return kraj;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie ktaju pochodzenia lekarza
     *
     * @param kraj - kraj pochodzenia lekarza
     */
    public void setKraj(String kraj) {
        this.kraj = kraj;
    }
}
