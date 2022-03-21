package projekt_java_kujawa_latos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

/**
 * Klasa rozszerzająca klasę JCheckBox
 */
public class MyCheckBox extends JCheckBox {

    ImageIcon notSelectedBox = new ImageIcon("notselected.png");
    ImageIcon selectedBox = new ImageIcon("selected.png");
    /**
     * zmienna przechowująca kursor
     */
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    /**
     * zmienna przechowująca kolor przewodni GUI
     */
    Color c_back = new Color(221, 243, 249);
    /**
     * zmienna przechowująca czcionkę
     */
    Font font = new Font("Arial Nova Light", Font.BOLD, 20);

    /**
     * Konstruktor klasy MyCheckBox
     *
     * @param text - tekst obok checkbox'a
     */
    public MyCheckBox(String text) {
        setText(text);
        setFont(font);
        setBackground(c_back);
        setHorizontalTextPosition(JCheckBox.RIGHT);
        setIconTextGap(20);
        setIcon(notSelectedBox);
        setSelectedIcon(selectedBox);
        setFocusable(false);
        setCursor(cursor);
    }

}
