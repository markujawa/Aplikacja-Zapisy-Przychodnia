package projekt_java_kujawa_latos;

/**
 * Klasa zawierająca metody umożliwiające stworzenie obiektu daty urodzenia
 * otrzymanej z nr pesel
 */
public class PeselToDate {

    /**
     * prywatne zmienne przechowujące rok, miesiąc i dzień
     */
    private int year, month, day;
    /**
     * prywatna zmienna tablice PESEL
     */
    private byte PESEL[] = new byte[11];
    /**
     * prywatna zmienna przechowująca informacje o poprawności nr pesel
     */
    private boolean valid = false;

    /**
     * Metoda sprawdzająca poprawność peselu
     *
     * @param peselNumber - numer pesel
     * @return - zwraca informację o poprawności peselu
     */
    public boolean PeselValidator(String peselNumber) {

        if (peselNumber.length() != 11) {
            return false;
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int j = 0, sum = 0, control = 0;
        int csum = Integer.valueOf(peselNumber.substring(peselNumber.length() - 1));
        for (int i = 0; i < peselNumber.length() - 1; i++) {
            char c = peselNumber.charAt(i);
            j = Integer.valueOf(String.valueOf(c));
            sum += j * weights[i];
        }
        control = 10 - (sum % 10);
        if (control == 10) {
            control = 0;
        }
        return (control == csum);

    }

    /**
     * Metoda umożliwiająca konwersję wpisanego numeru pesel na bajty i wpisanie
     * do tablicy
     *
     * @param peselNumber - pesel
     */
    public void PeselToTab(String peselNumber) {

        for (int i = 0; i < 11; i++) {
            PESEL[i] = Byte.parseByte(peselNumber.substring(i, i + 1));
        }
    }

    /**
     * Metoda obliczająca rok urodzenia
     *
     * @return year - rok
     */
    public int getYear() {

        year = 10 * PESEL[0] + PESEL[1];
        month = 10 * PESEL[2] + PESEL[3];
        if (month > 80 && month < 93) {
            year += 1800;
        } else if (month > 0 && month < 13) {
            year += 1900;
        } else if (month > 20 && month < 33) {
            year += 2000;
        } else if (month > 40 && month < 53) {
            year += 2100;
        } else if (month > 60 && month < 73) {
            year += 2200;
        }
        return year;

    }

    /**
     * Metoda obliczająca miesiąc urodzenia
     *
     * @return m - miesiąc
     */
    public String getMonth() {

        month = 10 * PESEL[2] + PESEL[3];
        if (month > 80 && month < 93) {
            month -= 80;
        } else if (month > 20 && month < 33) {
            month -= 20;
        } else if (month > 40 && month < 53) {
            month -= 40;
        } else if (month > 60 && month < 73) {
            month -= 60;
        }

        String m;
        if (month < 10) {
            m = "0" + month;
        } else {
            m = Integer.toString(month);
        }

        return m;
    }

    /**
     * Metoda obliczająca dzień urodzenia
     *
     * @return d - dzień
     */
    public String getDay() {

        day = 10 * PESEL[4] + PESEL[5];
        String d;
        if (day < 10) {
            d = "0" + day;
        } else {
            d = Integer.toString(day);
        }

        return d;
    }

}
