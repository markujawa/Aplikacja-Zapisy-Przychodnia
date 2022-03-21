package projekt_java_kujawa_latos;

/**
 * Klasa pozwalające na przechowywanie danych logowania
 */
public class Password {

    /**
     * prywatna zmienna PESEL
     */
    private String PESEL;
    /**
     * prywatna zmienna Password
     */
    private String Password;

    /**
     * Konstruktor domyślny klasy Password
     */
    public Password() {
    }

    ;
    /**
 * Konstruktor klasy Password
 * @param PESEL - pesel
 * @param Password - haslo
 */
    public Password(String PESEL, String Password) {
        this.PESEL = PESEL;
        this.Password = Password;
    }

    /**
     * Publiczna metoda zwracająca PESEL
     *
     * @return PESEL
     */
    public String getPesel() {
        return PESEL;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie peselu
     *
     * @param PESEL - pesel
     */
    public void setPesel(String PESEL) {
        this.PESEL = PESEL;
    }

    /**
     * Publiczna metoda zwracająca hasło
     *
     * @return Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Publiczna metoda umożliwiająca ustawienie hasła
     *
     * @param Password - hasło
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
