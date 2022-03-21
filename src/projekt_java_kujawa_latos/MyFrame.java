package projekt_java_kujawa_latos;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Klasa rozszerzająca klasę JFrame - okienko o wymiarach 600x600
 */
public class MyFrame extends JFrame {

    /**
     * Konstruktor klasyMyFrame
     */
    public MyFrame() {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon_image.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
