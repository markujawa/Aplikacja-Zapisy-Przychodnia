package projekt_java_kujawa_latos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko umożliwiające ustawienie hasla przez pacjenta
 */
public class SetPasswordPatient implements ActionListener {

    MyFrame frame = new MyFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("USTAW HASŁO");
    JLabel checkPasswordLabel = new JLabel(/*"Hasła nie są takie same!"*/);
    JLabel iconLabel = new JLabel();
    JLabel passwordLabel = new JLabel("HASŁO: ");
    JPasswordField passwordField = new JPasswordField();
    JLabel passwordLabel2 = new JLabel("POWTÓRZ HASŁO: ");
    JPasswordField passwordField2 = new JPasswordField();
    MyButton setButton = new MyButton("Ustaw hasło");
    JButton showButton = new JButton("Pokaż hasło");
    JButton showButton2 = new JButton("Pokaż hasło");
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    ImageIcon imageLock = new ImageIcon("lock.png");
    ImageIcon show = new ImageIcon("show.png");
    ImageIcon dontshow = new ImageIcon("dontshow.png");
    /**
     * zmienna przechowująca kolor przewodni GUI
     */
    Color c_back = new Color(221, 243, 249);

    /**
     * Konstruktor klasy SetPasswordPatient
     */
    public SetPasswordPatient() {

        frame.setTitle("Ustaw hasło");
        panel.setBackground(c_back);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        panel.setLayout(null);

        label.setIcon(imageLock);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setFont(new Font("Valken", Font.PLAIN, 30));
        label.setBounds(0, 40, 600, 110);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);

        passwordLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        passwordLabel.setBounds(155, 250, 85, 40);

        passwordField.setBounds(250, 250, 300, 40);
        passwordField.setToolTipText("Wprowadź hasło");
        passwordField.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        passwordField.setEchoChar('*');

        checkPasswordLabel.setBounds(230, 170, 200, 80);
        checkPasswordLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        checkPasswordLabel.setForeground(Color.RED);

        showButton.setBounds(335, 295, 130, 25);
        showButton.setText("Pokaż hasło");
        showButton.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        showButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
        showButton.setFocusable(false);
        showButton.setIcon(show);
        showButton.setBackground(c_back);
        showButton.setCursor(cursor);
        showButton.addActionListener(this);

        passwordLabel2.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        passwordLabel2.setBounds(50, 330, 190, 40);

        passwordField2.setBounds(250, 330, 300, 40);
        passwordField2.setToolTipText("Wprowadź hasło");
        passwordField2.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        passwordField2.setEchoChar('*');

        showButton2.setBounds(335, 375, 130, 25);
        showButton2.setText("Pokaż hasło");
        showButton2.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        showButton2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
        showButton2.setFocusable(false);
        showButton2.setIcon(show);
        showButton2.setBackground(c_back);
        showButton2.setCursor(cursor);
        showButton2.addActionListener(this);

        setButton.setBounds(200, 420, 200, 40);
        setButton.setRadius(40);
        setButton.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        setButton.setBorder(BorderFactory.createEmptyBorder());
        setButton.addActionListener(this);

        panel.add(label);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(showButton);
        panel.add(passwordLabel2);
        panel.add(passwordField2);
        panel.add(showButton2);
        panel.add(setButton);
        panel.add(checkPasswordLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Metoda aktualizująca bazę danych wybranym przez lekarza hasłem
     *
     * @param pass - obiekt klasy Password
     */
    public void insertPatientPassword(Password pass) {
        String sql = "UPDATE patients_login_data SET haslo = ? WHERE (haslo= 'brak')";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pass.getPassword());
            //pstmt.setString(1, pacjent.getPesel());
            pstmt.executeUpdate();
            System.out.println("Dodano hasło do bazy pacjentów!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == showButton) {
            if (passwordField.echoCharIsSet() == false) {
                showButton.setIcon(show);
                showButton.setText("Pokaż hasło");
                passwordField.setEchoChar('*');
            } else if (passwordField.echoCharIsSet() == true) {
                showButton.setIcon(dontshow);
                showButton.setText("Ukryj hasło");
                passwordField.setEchoChar((char) 0);
            }
        }

        if (ae.getSource() == showButton2) {
            if (passwordField2.echoCharIsSet() == false) {
                showButton2.setIcon(show);
                showButton2.setText("Pokaż hasło");
                passwordField2.setEchoChar('*');
            } else if (passwordField2.echoCharIsSet() == true) {
                showButton2.setIcon(dontshow);
                showButton2.setText("Ukryj hasło");
                passwordField2.setEchoChar((char) 0);
            }
        }

        if (ae.getSource() == setButton) {

            try {
                Password pass = new Password();
                pass.setPassword(passwordField.getText());
                /**
                 * Wywołanie konstruktora Patient
                 */
                Patient pacjent = new Patient();
                pacjent.getPesel();
                if (passwordField.getText().equals(passwordField2.getText())) {
                    insertPatientPassword(pass);

                    /**
                     * Wywołanie konstruktora LoginPagePatient
                     */
                    LoginPagePatient loginPatient = new LoginPagePatient();
                    frame.dispose();
                } else {
                    checkPasswordLabel.setText("Hasła nie są takie same");
                }
            } catch (Exception e) {
                System.out.println("Problem adding a new user to database " + e.getMessage());
            }
        }
    }
}
