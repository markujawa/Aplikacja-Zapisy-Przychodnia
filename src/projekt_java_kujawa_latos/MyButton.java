package projekt_java_kujawa_latos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Klasa rozszerzająca klasę JButton
 */
public class MyButton extends JButton {

    /**
     * Metoda ustawiająca kolor przycisku
     *
     * @param color - kolor przycisku
     */
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    /**
     * Metoda ustawiająca promień zaokrąglenia przycisku
     *
     * @param radius - promień
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Konstruktor klasy MyButton
     *
     * @param text - tekst na przycisku
     */
    public MyButton(String text) {
        Color c_butt = new Color(168, 224, 238);
        Color c_click = new Color(158, 182, 192);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        Font font = new Font("Arial Nova Light", Font.BOLD, 20);

        setText(text);
        setColor(c_butt);
        setContentAreaFilled(false);
        setRadius(40);
        setCursor(cursor);
        setBorder(BorderFactory.createEmptyBorder());
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(font);
        setFocusable(false);

        addMouseListener(new MouseAdapter() {

            @Override
            /**
             * Metoda ustawiająca reakcję na przyciśnięcie przycisku myszy w
             * obszarze przycisku
             *
             * @param me - obiekt klasy MouseEvent
             */
            public void mousePressed(MouseEvent me) {
                setBackground(c_click);
            }

            @Override
            /**
             * Metoda ustawiająca reakcję na zwolnienie przycisku myszy w
             * obszarze przycisku
             *
             * @param me - obiekt klasy MouseEvent
             */
            public void mouseReleased(MouseEvent me) {
                setBackground(c_butt);
            }

            @Override
            /**
             * Metoda ustawiająca reakcję na najechanie kursorem myszy na obszar
             * przycisku
             *
             * @param me - obiekt klasy MouseEvent
             */

            public void mouseEntered(MouseEvent me) {
                setBackground(c_butt);
                setSize(getWidth() * 21 / 20, getHeight() * 21 / 20);
            }

            @Override
            /**
             * Metoda ustawiająca reakcję na wyjechanie kursorem myszy poza
             * obszar przycisku
             *
             * @param me - obiekt klasy MouseEvent
             */
            public void mouseExited(MouseEvent me) {
                setBackground(c_butt);
                setSize(getWidth() * 20 / 21, getHeight() * 20 / 21);
                setHorizontalAlignment(SwingConstants.CENTER);
            }
        });

    }
    /**
     * zmianna klasy Color
     */
    private Color color;
    /**
     * zmienna przechowująca wartość promienia
     */
    private int radius = 0;

    @Override
    /**
     * Metoda pozwalająca na "pokolorowanie" obszaru przycisku o nieregularnym
     * kształcie
     *
     * @param graphics - obiekt klasy Graphics
     */
    protected void paintComponent(Graphics graphics) {
        Graphics2D button = (Graphics2D) graphics;
        button.setColor(getBackground());
        button.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(graphics);
    }

}
