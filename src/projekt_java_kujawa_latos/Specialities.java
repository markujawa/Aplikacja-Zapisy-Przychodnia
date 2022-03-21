package projekt_java_kujawa_latos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 * Klasa rozszerzająca klasę JComboBox umieszczająca listę specjalizacji z pliku
 * do JComboBox
 */
public class Specialities extends JComboBox {

    /**
     * Konstruktor klasy Specialities
     */
    public Specialities() {

        ArrayList<String> specialities = new ArrayList<String>();

        /**
         * Stworzenie obiektu typu File
         */
        File file = new File("specialities.txt");

        /**
         * Stworzenie obiektu typu Scanner
         */
        Scanner scanner;
        try {
            scanner = new Scanner(file);

            for (int i = 0; i < 7; i++) {
                /**
                 * Zmienna przechowująca linijkę tekstu odczytaną z pliku
                 */
                String zdanie = scanner.nextLine();
                specialities.add(zdanie);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegisterPageDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < 7; i++) {
            addItem(specialities.get(i));
        }
    }
}
