package projekt_java_kujawa_latos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko błędu - błędne wpisanie numeru PESEL wyskakujące
 * w przypadku wykrycia nieprawidłowości
 */
public class ErrorPESELFrame implements ActionListener {

    MyFrameSmall frame = new MyFrameSmall();
    JPanel panel = new JPanel();
    JLabel error = new JLabel("ERROR!");
    JLabel info = new JLabel("Zła długość numeru PESEL");
    JLabel info2 = new JLabel("Sprawdź czy numer ma 11 cyfr!");
    MyButton okButton = new MyButton("OK!");
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    /**
     * Zmienna przechowująca kolor przewodni GUI
     */
    Color c_back = new Color(221, 243, 249);

    /**
     * Konstruktor klasy ErrorPESELFrame
    */
    public ErrorPESELFrame() {

        frame.setTitle("PESEL ERROR!");
        panel.setBackground(c_back);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        panel.setLayout(null);

        error.setHorizontalTextPosition(SwingConstants.CENTER);
        error.setFont(new Font("Valken", Font.PLAIN, 30));
        error.setBounds(70, 20, 200, 60);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(Color.BLACK);

        info.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        info.setBounds(70, 70, 300, 40);
        info2.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        info2.setBounds(55, 90, 300, 40);

        okButton.setBounds(70, 140, 200, 40);
        okButton.setRadius(40);
        okButton.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        okButton.setBorder(BorderFactory.createEmptyBorder());
        okButton.addActionListener(this);

        panel.add(error);
        panel.add(info);
        panel.add(info2);
        panel.add(okButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == okButton) {
            frame.dispose();
        }

    }

}
