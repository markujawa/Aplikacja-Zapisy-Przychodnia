package projekt_java_kujawa_latos;

/**
 * Klasa główna zawierająca metodę main()
 */
public class PROJEKT_JAVA {

    /**
     * Metoda uruchamiająca aplikację
     * @param args argumenty aplikacji
     */
    public static void main(String[] args) {

        /**
         * Metody tworzące bazę danych i jej tabele
         */
        ConnectionDB.createNewPatientTable();
        ConnectionDB.createNewLoginPatientTable();

        ConnectionDB.createNewDoctorTable();
        ConnectionDB.createNewDoctorTable2();
        ConnectionDB.createNewLoginDoctorTable();

        ConnectionDB.createNewVisitsTable();
        ConnectionDB.createInterviewsTable();

        /**
         * Wywołanie konstruktora tworzącego pierwsze okienko - LoginWelcomePage
         */
        LoginWelcomePage loginWelcome = new LoginWelcomePage();

    }

}
