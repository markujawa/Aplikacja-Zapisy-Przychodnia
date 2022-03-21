package projekt_java_kujawa_latos;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Klasa rozszerzająca klasę JFrame - okienko o wymiarach 350x250
 */
public class MyFrameSmall extends JFrame {

    /**
     * Konstruktor klasy MyFrameSmall
     */
    public MyFrameSmall() {
        setSize(350, 250);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon_image.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
