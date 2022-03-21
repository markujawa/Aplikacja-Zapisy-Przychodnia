package projekt_java_kujawa_latos;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Klasa rozszerzająca klasę JFrame - okienko fullscreen
 */
public class MyFrameFullscreen extends JFrame {

    /**
     * Konstruktor klasy MyFrameFullscreen
     */
    public MyFrameFullscreen() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon_image.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
