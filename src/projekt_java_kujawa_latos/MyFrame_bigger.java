
package projekt_java_kujawa_latos;

import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 * Klasa rozszerzająca klasę JFrame - okienko o wymiarach 800x800
 */
public class MyFrame_bigger extends JFrame {
    /**
     * Konstruktor klasy MyFrame_bigger
     */
    public MyFrame_bigger(){
        setSize(800, 800);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon_image.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
}
