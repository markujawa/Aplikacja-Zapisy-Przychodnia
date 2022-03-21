package projekt_java_kujawa_latos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko umożliwiające zalogowanie się pacjenta
 */
public class LoginPagePatient implements ActionListener {

    MyFrame frame = new MyFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("LOGOWANIE - JESTEM PACJENTEM");
    JLabel iconLabel = new JLabel();
    JLabel peselLabel = new JLabel("PESEL: ");
    static JLabel checkPasswordLabel = new JLabel(/*"Hasła nie są takie same!"*/);
    JTextField peselField = new JTextField();
    JLabel passwordLabel = new JLabel("HASŁO: ");
    JPasswordField passwordField = new JPasswordField();
    MyButton logInButton = new MyButton("Zaloguj się");
    JButton showButton = new JButton();
    MyButton registerButton = new MyButton("Zarejestruj się tutaj!");
    JLabel registrationLabel = new JLabel("Nie masz jeszcze konta?");
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    ImageIcon imageLock = new ImageIcon("lock.png");
    ImageIcon show = new ImageIcon("show.png");
    ImageIcon dontshow = new ImageIcon("dontshow.png");
    /**
     * zmienna przechowująca kolor przewodni GUI
     */
    Color c_back = new Color(221, 243, 249);

    /**
     * Konstruktor klasy LoginPagePatient
     */
    LoginPagePatient() {
        frame.setTitle("Logowanie");
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

        peselLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        peselLabel.setBounds(100, 250, 90, 40);

        peselField.setBounds(200, 250, 300, 40);
        peselField.setToolTipText("Wprowadź PESEL");
        peselField.setFont(new Font("Arial Nova Light", Font.BOLD, 20));

        passwordLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        passwordLabel.setBounds(100, 310, 90, 40);;

        passwordField.setBounds(200, 310, 300, 40);
        passwordField.setToolTipText("Wprowadź hasło");
        passwordField.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        passwordField.setEchoChar('*');

        checkPasswordLabel.setBounds(150, 170, 400, 80);
        checkPasswordLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        checkPasswordLabel.setForeground(Color.RED);

        showButton.setBounds(285, 355, 130, 25);
        showButton.setText("Pokaż hasło");
        showButton.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        showButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
        showButton.setFocusable(false);
        showButton.setIcon(show);
        showButton.setBackground(c_back);
        showButton.setCursor(cursor);
        showButton.addActionListener(this);

        logInButton.setBounds(200, 400, 200, 40);
        logInButton.setRadius(40);
        logInButton.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        logInButton.setBorder(BorderFactory.createEmptyBorder());
        logInButton.addActionListener(this);

        registrationLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        registrationLabel.setBounds(120, 500, 180, 40);

        registerButton.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        registerButton.setBounds(300, 505, 180, 30);
        registerButton.setRadius(30);
        registerButton.setBorder(BorderFactory.createEmptyBorder());
        registerButton.addActionListener(this);

        panel.add(label);
        panel.add(peselLabel);
        panel.add(passwordLabel);
        panel.add(registrationLabel);
        panel.add(logInButton);
        panel.add(peselField);
        panel.add(passwordField);
        panel.add(showButton);
        panel.add(registerButton);
        panel.add(checkPasswordLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Metoda pobierająca dane z bazy danych i sprawdzająca poprawność wpisanego
     * numeru pesel oraz hasła
     *
     * @param pesel - numer pesel pacjenta
     * @param password - hasło pacjenta
     * @return - zwraca wynik sprawdzania poprawności peselu i hasła
     */
    public static boolean CheckLogin(String pesel, String password) {

        try (Connection conn = ConnectionDB.connectDB();
                Statement stmt = (Statement) conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM patients_login_data WHERE pesel = \"" + pesel + "\" AND haslo = \"" + password + "\"");
            System.out.println("in check");
            if (resultSet.isBeforeFirst()) {
                System.out.println("result set is not empty");
                while (resultSet.next()) {
                    if (resultSet.getString("haslo").equals(password) && resultSet.getString("pesel").equals(pesel)) {
                        System.out.println("wszystko sie zgadza - możesz przejść dalej!");
                        return true;
                    }
                }
            } else {
                checkPasswordLabel.setText("Błędny PESEL lub hasło - wpisz ponownie");
            }

        } catch (Exception e) {
            System.out.println("Masz jakiś błąd!!!!!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == registerButton) {
            RegisterPagePatient regPage = new RegisterPagePatient();
            frame.dispose();
        }

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

        if (ae.getSource() == logInButton) {
            String pesel = peselField.getText();
            String password = passwordField.getText();
            if (CheckLogin(pesel, password) == true) {

                /**
                 * Wywołanie konstruktora klasy HomePagePatient
                 */
                HomePagePatient homePatient = new HomePagePatient(pesel);
                frame.dispose();
            }
        }
    }
}
