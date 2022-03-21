package projekt_java_kujawa_latos;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Klasa rozszerzająca klasę JFrame - okienko o wymiarach 900x900
 */
public class MyFrameBigger extends JFrame {

    /**
     * Konstruktor klasyMyFrameBigger
     */
    public MyFrameBigger() {
        setSize(900, 900);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon_image.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
