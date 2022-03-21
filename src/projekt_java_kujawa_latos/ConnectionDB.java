package projekt_java_kujawa_latos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Klasa zawierająca metody, umożliwiająca połączenie z bazą danych i stworzenie
 * tabeli w bazie danych
 */
public class ConnectionDB {

    /**
     * Metoda ustawiająca połączenie z bazą danych
     *
     * @return conn obiekt reprezentujący połączenie (w przypadku, gdy
     * połączenie się nie powiedzie = null)
     */
    public static Connection connectDB() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:RegisterDB.db");
            System.out.println("Connection Succeded");
        } catch (SQLException e) {
            System.out.println("Connection failed" + e);
        }
        return conn;
    }

    /**
     * Metoda umożliwiająca stworzenie nowej tabeli (w przypadku jej braku) -
     * pacjent
     */
    public static void createNewPatientTable() {
        String url = "jdbc:sqlite:RegisterDB.db";

        String table = "CREATE TABLE IF NOT EXISTS patients_register_data (\n"
                + "	pesel text PRIMARY KEY NOT NULL,\n"
                + "	imie text NOT NULL,\n"
                + "	drugie_imie text DEFAULT 0,\n"
                + "	nazwisko text NOT NULL,\n"
                + "	plec text NOT NULL,\n"
                + "	data_urodzenia text NOT NULL,\n"
                + "	nr_telefonu text NOT NULL UNIQUE,\n"
                + "	email text NOT NULL UNIQUE,\n"
                + "	ulica text NOT NULL,\n"
                + "	nr_domu integer NOT NULL,\n"
                + "	nr_mieszkania integer DEFAULT NULL,\n"
                + "	kod_pocztowy text NOT NULL,\n"
                + "	miasto text NOT NULL,\n"
                + "	kraj text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(table);
            System.out.println("[BAZA DANYCH] Pomyślnie utworzono tabelę pacjentów w bazie danych!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda tworząca tabelę (w przypadku jej braku) danych logowania pacjentów
     */
    public static void createNewLoginPatientTable() {
        String url = "jdbc:sqlite:RegisterDB.db";

        String table = "CREATE TABLE IF NOT EXISTS patients_login_data (\n"
                + "	pesel text PRIMARY KEY,\n"
                + "	haslo text NOT NULL,\n"
                + "     FOREIGN KEY (pesel) REFERENCES patients_register_data (pesel)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(table);
            System.out.println("[BAZA DANYCH] Pomyślnie utworzono tabelę danych logowania pacjentów w bazie danych!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda tworząca tabelę (w przypadku jej braku) zawierającą informacje
     * dodatkowe o lekarzach
     */
    public static void createNewDoctorTable() {
        String url = "jdbc:sqlite:RegisterDB.db";

        String table = "CREATE TABLE IF NOT EXISTS spec_and_place (\n"
                + "	pesel text PRIMARY KEY,\n"
                + "     imie text NOT NULL,\n"
                + "     nazwisko text NOT NULL, \n"
                + "	dzielnica text NOT NULL,\n"
                + "	specjalnosc text NOT NULL, \n"
                + "     legitymacja text NOT NULL, \n"
                + "     FOREIGN KEY (pesel) REFERENCES doctors_register_data (pesel)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(table);
            System.out.println("[BAZA DANYCH] Pomyślnie utworzono tabelę lekarzy (2) w bazie danych!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umożliwiająca stworzenie nowej tabeli (w przypadku jej braku)
     * wizyt u lekarza
     */
    public static void createNewVisitsTable() {
        String url = "jdbc:sqlite:RegisterDB.db";

        String table = "CREATE TABLE IF NOT EXISTS visits (\n"
                + "	id_wizyty integer PRIMARY KEY AUTOINCREMENT,\n"
                + "     dzien text NOT NULL,\n"
                + "     godzina text NOT NULL, \n"
                + "	id_lekarza text NOT NULL,\n"
                + "	id_pacjenta text DEFAULT NULL,\n"
                + "     FOREIGN KEY (id_pacjenta) REFERENCES patients_register_data (pesel), \n"
                + "     FOREIGN KEY (id_lekarza) REFERENCES spec_and_place (pesel)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(table);
            System.out.println("[BAZA DANYCH] Pomyślnie utworzono tabelę wizyt w bazie danych!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umożliwiająca stworzenie tabeli (w przypadku jej braku)
     * zawierającej informacje o odpowiedziach udzielonych przez pacjentów w
     * wywiadzie medycznym
     */
    public static void createInterviewsTable() {
        String url = "jdbc:sqlite:RegisterDB.db";

        String table = "CREATE TABLE IF NOT EXISTS interviews (\n"
                + "	id_wizyty text PRIMARY KEY,\n"
                + "	zle_samopoczucie text, \n"
                + "	zmeczenie text, \n"
                + "	kaszel text, \n"
                + "	katar text, \n"
                + "	goraczka text, \n"
                + "	bol_brzucha text, \n"
                + "	bol_glowy text, \n"
                + "	zawroty_glowy text, \n"
                + "	biegunka text, \n"
                + "	wymioty text, \n"
                + "	trudnosci_oddech text, \n"
                + "	bol_klatka text, \n"
                + "	wech_smak text, \n"
                + "	bol_gardla text, \n"
                + "	bol_zeba text, \n"
                + "	bol_ucha text, \n"
                + "	krwotoki text, \n"
                + "	wysypka text, \n"
                + "	inne text, \n"
                + "     FOREIGN KEY (id_wizyty) REFERENCES visits (id_wizyty) \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(table);
            System.out.println("[BAZA DANYCH] Pomyślnie utworzono tabelę wywiadów w bazie danych!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Metoda umożliwiająca stworzenie nowej tabeli (w przypadku jej braku)
     * lekrzy
     */
    public static void createNewDoctorTable2() {
        String url = "jdbc:sqlite:RegisterDB.db";

        String table = "CREATE TABLE IF NOT EXISTS doctors_register_data (\n"
                + "	pesel text PRIMARY KEY NOT NULL,\n"
                + "	imie text NOT NULL,\n"
                + "	drugie_imie text DEFAULT 0,\n"
                + "	nazwisko text NOT NULL,\n"
                + "	plec text NOT NULL,\n"
                + "	data_urodzenia text NOT NULL,\n"
                + "	nr_telefonu text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	ulica text NOT NULL,\n"
                + "	nr_domu integer NOT NULL,\n"
                + "	nr_mieszkania integer DEFAULT NULL,\n"
                + "	kod_pocztowy text NOT NULL,\n"
                + "	miasto text NOT NULL,\n"
                + "	kraj text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(table);
            System.out.println("[BAZA DANYCH] Pomyślnie utworzono tabelę lekarzy w bazie danych!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umożliwiająca stworzenie tabeli (w przypadku jej braku)
     * zawierającej dane logowania lekarzy
     */
    public static void createNewLoginDoctorTable() {
        String url = "jdbc:sqlite:RegisterDB.db";

        String table = "CREATE TABLE IF NOT EXISTS doctors_login_data (\n"
                + "	pesel text PRIMARY KEY,\n"
                + "	haslo text NOT NULL,\n"
                + "     FOREIGN KEY (pesel) REFERENCES doctors_register_data (pesel)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(table);
            System.out.println("[BAZA DANYCH] Pomyślnie utworzono tabelę danych logowania lekarzy w bazie danych!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
