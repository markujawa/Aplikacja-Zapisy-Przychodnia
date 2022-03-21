package projekt_java_kujawa_latos;

/**
 * Klasa reprezentująca wszystkie dane dotyczące pacjenta w aplikacji
 */
public class Patient {

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
     * Konstruktor domyślny klasy Patient
     */
    public Patient() {
    }

    /**
     * Konstruktor klasy Patient z parametrami
      *
     * @param pierwszeImie - pierwsze imie
     * @param drugieImie - drugie imie
     * @param nazwisko - nazwisko
     * @param plec - plec pacjenta
     * @param PESEL - nr pesel
     * @param data - data urodzenia
     * @param nrTelefonu - numer telefonu
     * @param email - email
     * @param ulica - ulica
     * @param numerDomu - numer domu
     * @param numerMieszkania - numer mieszkania
     * @param kodPocztowy - kod pocztowy
     * @param miasto - miasto zamieszkania
     * @param kraj - kraj pochodzenia
     */
     
    public Patient(String pierwszeImie, String drugieImie, String nazwisko, String plec, String PESEL, String data, String nrTelefonu, String email, String ulica, int numerDomu, int numerMieszkania, String kodPocztowy, String miasto, String kraj) {
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
     * Publiczna metoda zwracająca imię pacjenta
     *
     * @return pierwszeImie
     */
    public String getPierwszeImie() {
        return pierwszeImie;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie imienia pacjenta
     *
     * @param pierwszeImie - pierwsze imie pacjenta
     */
    public void setPierwszeImie(String pierwszeImie) {
        this.pierwszeImie = pierwszeImie;
    }

    /**
     * Publiczna metoda zwracająca drugie imię pacjenta
     *
     * @return drugieImie
     */
    public String getDrugieImie() {
        return drugieImie;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie drugiego imienia pacjenta
     *
     * @param drugieImie - drugie imie pacjenta
     */
    public void setDrugieImie(String drugieImie) {
        this.drugieImie = drugieImie;
    }

    /**
     * Publiczna metoda zwracająca nazwisko pacjenta
     *
     * @return nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie nazwiska pacjenta
     *
     * @param nazwisko - nazwisko pacjenta
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Publiczna metoda zwracająca płec pacjenta
     *
     * @return plec
     */
    public String getPlec() {
        return plec;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie płci pacjenta
     *
     * @param plec - płec pacjenta
     */
    public void setPlec(String plec) {
        this.plec = plec;
    }

    /**
     * Publiczna metoda zwracająca pesel pacjenta
     *
     * @return PESEL
     */
    public String getPesel() {
        return PESEL;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie PESELU pacjenta
     *
     * @param PESEL - PESEL pacjenta
     */
    public void setPesel(String PESEL) {
        this.PESEL = PESEL;
    }

    /**
     * Publiczna metoda zwracająca datę urodzenia pacjenta
     *
     * @return dataUrodzenia
     */
    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie daty urodzenia pacjenta
     *
     * @param data - data urodzenia pacjenta
     */
    public void setDataUrodzenia(String data) {
        this.dataUrodzenia = data;
    }

    /**
     * Publiczna metoda zwracająca numer telefonu pacjenta
     *
     * @return nrtelefonu
     */
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie numeru telefonu pacjenta
     *
     * @param nrTelefonu - numer telefonu pacjenta
     */
    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    /**
     * Publiczna metoda zwracająca email pacjenta
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie emaila pacjenta
     *
     * @param email - email pacjenta
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Publiczna metoda zwracająca ulicę pacjenta
     *
     * @return ulica
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie ulicy pacjenta
     *
     * @param ulica- miejsce zamieszkania pacjenta
     */
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    /**
     * Publiczna metoda zwracająca numer domu pacjenta
     *
     * @return numerDomu
     */
    public int getNumerDomu() {
        return numerDomu;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie numeru domu pacjenta
     *
     * @param numerDomu - numer domu pacjenta
     */
    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    /**
     * Publiczna metoda zwracająca numer mieszkania pacjenta
     *
     * @return numerMieszkania
     */
    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie numeru mieszkania pacjenta
     *
     * @param numerMieszkania - numer mieszkania pacjenta
     */
    public void setNumerMieszkania(int numerMieszkania) {
        this.numerMieszkania = numerMieszkania;
    }

    /**
     * Publiczna metoda zwracająca kod pocztowy pacjenta
     *
     * @return kodPocztowy
     */
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie kodu pocztowego pacjenta
     *
     * @param kodPocztowy - kod pocztowy
     */
    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    /**
     * Publiczna metoda zwracająca miasto pacjenta
     *
     * @return miasto
     */
    public String getMiasto() {
        return miasto;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie miasta zamieszkania pacjenta
     *
     * @param miasto - miasto zamieszkania pacjenta
     */
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    /**
     * Publiczna metoda zwracająca kraj pochodzenia
     *
     * @return kraj
     */
    public String getKraj() {
        return kraj;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie kraju pochodzenia pacjenta
     *
     * @param kraj - kraj pochodzenia pacjenta
     */
    public void setKraj(String kraj) {
        this.kraj = kraj;
    }
}
