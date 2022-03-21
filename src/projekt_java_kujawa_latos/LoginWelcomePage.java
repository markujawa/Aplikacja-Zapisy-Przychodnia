package projekt_java_kujawa_latos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko powitalne - umożliwia wybów pacjent/lekarz
 */
public class LoginWelcomePage implements ActionListener {

    MyFrame frame = new MyFrame();
    JPanel panel = new JPanel();
    JPanel grid = new JPanel();
    JLabel label = new JLabel("LOGOWANIE");
    JLabel iconLabel = new JLabel();
    MyButton button1 = new MyButton("Jestem Pacjentem");
    MyButton button2 = new MyButton("Jestem Lekarzem");
    JLabel patientLabel = new JLabel();
    JLabel doctorLabel = new JLabel();

    ImageIcon imageLock = new ImageIcon("lock.png");
    ImageIcon imagePatient = new ImageIcon("pacjent.png");
    ImageIcon imageDoctor = new ImageIcon("lekarz.png");

    Color c_back = new Color(221, 243, 249);

    /**
     * Konstruktor klasy LoginWelcomePage
     */
    LoginWelcomePage() {
        frame.setTitle("Logowanie");
        panel.setBackground(c_back);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        panel.setLayout(null);

        label.setIcon(imageLock);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setFont(new Font("Valken", Font.PLAIN, 50));
        label.setBounds(0, 40, 600, 130);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);

        button1.setIcon(imagePatient);
        button1.setIconTextGap(20);
        button1.setBounds(150, 300, 300, 40);
        button1.setRadius(40);
        button1.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        button1.addActionListener(this);

        button2.setIcon(imageDoctor);
        button2.setIconTextGap(25);
        button2.setBounds(150, 360, 300, 40);
        button2.setRadius(40);
        button2.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        button2.addActionListener(this);

        panel.add(label);
        panel.add(button1);
        panel.add(button2);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == button1) {

            /**
             * Wywołanie konstruktora klasy LoginPagePatient
             */
            LoginPagePatient loginPatient = new LoginPagePatient();
            frame.dispose();
        } else if (ae.getSource() == button2) {
            /**
             * Wywołanie konstruktora klasy LoginPagedoctor
             */

            LoginPageDoctor loginDoctor = new LoginPageDoctor();
            frame.dispose();
        }

    }

}
