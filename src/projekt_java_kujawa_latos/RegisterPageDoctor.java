package projekt_java_kujawa_latos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * Klasa reprezentująca okienko umożliwiające zarejestrowanie się lekarza
 */
public class RegisterPageDoctor implements ActionListener {

    MyFrameBigger frame = new MyFrameBigger();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel genderPanel = new JPanel();
    JPanel numberPanel = new JPanel();
    JPanel mailCodeFieldPanel = new JPanel();
    JLabel label = new JLabel("REJESTRACJA - JESTEM LEKARZEM");
    JLabel iconLabel = new JLabel();
    JLabel nameLabel = new JLabel("Imię: ");
    JTextField nameField = new JTextField();
    JLabel secondNameLabel = new JLabel("Drugie imię: ");
    JTextField secondNameField = new JTextField();
    JLabel lastNameLabel = new JLabel("Nazwisko: ");
    JTextField lastNameField = new JTextField();
    JLabel genderLabel = new JLabel("Płeć: ");
    JLabel peselLabel = new JLabel("PESEL: ");
    JTextField peselField = new JTextField();
    JLabel birthDateLabel = new JLabel("Data urodzenia: ");
    JLabel birthDateLabel2 = new JLabel("");
    JLabel phoneNumberLabel = new JLabel("Numer telefonu: ");
    JTextField phoneNumberField = new JTextField();
    JLabel emailLabel = new JLabel("E-mail: ");
    JTextField emailField = new JTextField();
    JLabel streetLabel = new JLabel("Ulica: ");
    JTextField streetField = new JTextField();
    JLabel numberLabel = new JLabel("Numer domu i numer mieszkania: ");
    JTextField numberField = new JTextField();
    JLabel number2Label = new JLabel("m.");
    JTextField number2Field = new JTextField();
    JLabel mailCodeLabel = new JLabel("Kod pocztowy i miasto: ");
    JTextField mailCodeField = new JTextField();
    JTextField mailCode2Field = new JTextField();
    JLabel countryLabel = new JLabel("Kraj: ");
    MyButton goNextButton = new MyButton("Dalej");
    MyCheckBox woman = new MyCheckBox("Kobieta");
    MyCheckBox man = new MyCheckBox("Mężczyzna");
    ButtonGroup gender = new ButtonGroup();
    Countries country = new Countries();

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    ImageIcon imageRegister = new ImageIcon("register.png");
    /**
     * zmienna przechowująca kolor przewodni GUI
     */
    Color c_back = new Color(221, 243, 249);
    Font font = new Font("Arial Nova Light", Font.BOLD, 20);

    /**
     * Konstruktor klasy RegisterPageDoctor
     */
    RegisterPageDoctor() {

        frame.setTitle("Rejestracja");
        mainPanel.setBackground(c_back);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        panel.setLayout(new GridLayout(12, 2, 10, 10));
        panel.setBackground(c_back);

        label.setIcon(imageRegister);
        label.setHorizontalTextPosition(SwingConstants.RIGHT);
        label.setVerticalTextPosition(SwingConstants.CENTER);
        label.setFont(new Font("Valken", Font.PLAIN, 30));
        label.setForeground(Color.BLACK);

        nameLabel.setFont(font);
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);

        nameField.setFont(font);

        secondNameLabel.setFont(font);
        secondNameLabel.setHorizontalAlignment(JLabel.RIGHT);

        secondNameField.setFont(font);

        lastNameLabel.setFont(font);
        lastNameLabel.setHorizontalAlignment(JLabel.RIGHT);

        lastNameField.setFont(font);

        genderLabel.setFont(font);
        genderLabel.setHorizontalAlignment(JLabel.RIGHT);

        woman.addActionListener(this);

        man.addActionListener(this);

        gender.add(woman);
        gender.add(man);

        peselLabel.setFont(font);
        peselLabel.setHorizontalAlignment(JLabel.RIGHT);

        peselField.setFont(font);
        peselField.addCaretListener(new CaretListener() {
            @Override
            /**
             * Metoda umożliwiająca pokazanie datu urodzenia po wpisaniu 11 cyfr
             * numeru pesel
             *
             * @param ce - obiekt klasy CaretEvent
             */
            public void caretUpdate(CaretEvent ce) {

                String peseltxt = peselField.getText();

                if (peseltxt.length() == 11) {
                    PeselToDate peselNumber = new PeselToDate();
                    peselNumber.PeselValidator(peseltxt);
                    peselNumber.PeselToTab(peseltxt);
                    birthDateLabel2.setText(peselNumber.getDay() + "." + peselNumber.getMonth() + "." + peselNumber.getYear());
                }
            }
        });

        birthDateLabel.setFont(font);
        birthDateLabel.setHorizontalAlignment(JLabel.RIGHT);

        birthDateLabel2.setFont(font);
        birthDateLabel2.setHorizontalAlignment(JLabel.CENTER);

        phoneNumberLabel.setFont(font);
        phoneNumberLabel.setHorizontalAlignment(JLabel.RIGHT);

        phoneNumberField.setFont(font);

        emailLabel.setFont(font);
        emailLabel.setHorizontalAlignment(JLabel.RIGHT);

        emailField.setFont(font);

        streetLabel.setFont(font);
        streetLabel.setHorizontalAlignment(JLabel.RIGHT);

        streetField.setFont(font);

        numberLabel.setFont(font);
        numberLabel.setHorizontalAlignment(JLabel.RIGHT);

        numberField.setFont(font);

        number2Label.setFont(font);
        number2Label.setHorizontalAlignment(JLabel.RIGHT);

        number2Field.setFont(font);

        mailCodeLabel.setFont(font);
        mailCodeLabel.setHorizontalAlignment(JLabel.RIGHT);

        mailCodeField.setFont(font);
        mailCodeField.setPreferredSize(new Dimension(50, 40));

        mailCode2Field.setFont(font);
        mailCode2Field.setPreferredSize(new Dimension(200, 40));

        countryLabel.setFont(font);
        countryLabel.setHorizontalAlignment(JLabel.RIGHT);

        country.setFont(font);
        country.setBackground(c_back);
        country.setFocusable(false);
        country.setCursor(cursor);

        goNextButton.setPreferredSize(new Dimension(200, 40));
        goNextButton.setRadius(40);
        goNextButton.setFont(font);
        goNextButton.setHorizontalAlignment(SwingConstants.CENTER);
        goNextButton.addActionListener(this);

        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        genderPanel.setBackground(c_back);
        genderPanel.add(Box.createRigidArea(new Dimension(40, 0)));
        genderPanel.add(woman);
        genderPanel.add(Box.createHorizontalGlue());
        genderPanel.add(man);
        genderPanel.add(Box.createRigidArea(new Dimension(40, 0)));

        numberPanel.setLayout(new GridLayout(1, 3, 20, 0));
        numberPanel.setBackground(c_back);
        numberPanel.add(numberField);
        numberPanel.add(number2Label);
        numberPanel.add(number2Field);

        mailCodeFieldPanel.setLayout(new BoxLayout(mailCodeFieldPanel, BoxLayout.X_AXIS));
        mailCodeFieldPanel.setBackground(c_back);
        mailCodeFieldPanel.add(mailCodeField);
        mailCodeFieldPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        mailCodeFieldPanel.add(mailCode2Field);

        labelPanel.add(label);
        labelPanel.setBackground(c_back);

        buttonPanel.add(goNextButton);
        buttonPanel.setBackground(c_back);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(secondNameLabel);
        panel.add(secondNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(genderLabel);
        panel.add(genderPanel);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(peselLabel);
        panel.add(peselField);
        panel.add(birthDateLabel);
        panel.add(birthDateLabel2);
        panel.add(streetLabel);
        panel.add(streetField);
        panel.add(numberLabel);
        panel.add(numberPanel);
        panel.add(mailCodeLabel);
        panel.add(mailCodeFieldPanel);
        panel.add(countryLabel);
        panel.add(country);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.setBackground(c_back);
        panel2.add(Box.createHorizontalGlue());
        panel2.add(panel);
        panel2.add(Box.createHorizontalGlue());

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(labelPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(panel2);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue());

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    /**
     * Metoda aktualizująca bazę danych danymi podanymi podczas rejestracji
     * przez lekarza
     *
     * @param doktor - obiekt klasy Doctor
     */
    public void insertDoctorData(Doctor doktor) {

        String sql = "INSERT INTO doctors_register_data (pesel, imie, \n"
                + "drugie_imie, nazwisko, plec, data_urodzenia, nr_telefonu, email, ulica, nr_domu, \n"
                + "nr_mieszkania, kod_pocztowy, miasto, kraj) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doktor.getPesel());
            pstmt.setString(2, doktor.getPierwszeImie());
            pstmt.setString(3, doktor.getDrugieImie());
            pstmt.setString(4, doktor.getNazwisko());
            pstmt.setString(5, doktor.getPlec());
            pstmt.setString(6, doktor.getDataUrodzenia());
            pstmt.setString(7, doktor.getNrTelefonu());
            pstmt.setString(8, doktor.getEmail());
            pstmt.setString(9, doktor.getUlica());
            pstmt.setInt(10, doktor.getNumerDomu());
            pstmt.setInt(11, doktor.getNumerMieszkania());
            pstmt.setString(12, doktor.getKodPocztowy());
            pstmt.setString(13, doktor.getMiasto());
            pstmt.setString(14, doktor.getKraj());
            pstmt.executeUpdate();

            System.out.println("Dodano lekarza! ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umożliwiająca wpisanie otrzymanych danych do tabeli logowania
     * lekarza
     *
     * @param doktor - obiekt klasy Doctor
     */
    public void insertDoctorPesel(Doctor doktor) {
        String sql = "INSERT INTO doctors_login_data (pesel,haslo) VALUES(?,?)";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doktor.getPesel());
            pstmt.setString(2, "brak");
            pstmt.executeUpdate();
            System.out.println("Dodano pesel do bazy lekarzy!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umożliwiająca wpisanie otrzymanych danych do tabeli szczegółowych
     * informacji o lekarzu
     *
     * @param doktor - obiekt klasy Doctor
     */
    public void insertDoctorInfoToSpec(Doctor doktor) {
        String sql = "INSERT INTO spec_and_place (pesel,imie, nazwisko, dzielnica, specjalnosc,legitymacja) VALUES(?,?,?,?,?,?)";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doktor.getPesel());
            pstmt.setString(2, doktor.getPierwszeImie());
            pstmt.setString(3, doktor.getNazwisko());
            pstmt.setString(4, "brak");
            pstmt.setString(5, "brakk");
            pstmt.setString(6, "brakkk");
            pstmt.executeUpdate();
            System.out.println("Dodano infromacje do bazy identyfikacji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == goNextButton) {

            String peseltxt = peselField.getText();
            String phonetxt = phoneNumberField.getText();
            if (nameLabel.getText().isEmpty() || lastNameLabel.getText().isEmpty()
                    || peselLabel.getText().isEmpty() || phoneNumberLabel.getText().isEmpty()
                    || emailLabel.getText().isEmpty() || streetLabel.getText().isEmpty() || numberLabel.getText().isEmpty()
                    || mailCodeLabel.getText().isEmpty()) {

                /**
                 * Wywołanie konstruktora ErrorEMPTYFrame
                 */
                ErrorEMPTYFrame eef = new ErrorEMPTYFrame();
            }
            if (woman.isSelected() == false && man.isSelected() == false) {
                /**
                 * Wywołanie konstruktora ErrorEMPTYFrame
                 */
                ErrorEMPTYFrame eef = new ErrorEMPTYFrame();
            }
            if (peseltxt.length() != 11) {
                /**
                 * Wywołanie konstruktora ErrorPESELFrame
                 */
                ErrorPESELFrame epf = new ErrorPESELFrame();
            }
            if (phonetxt.length() != 9) {
                /**
                 * Wywołanie konstruktora ErrorPHONEFrame
                 */
                ErrorPHONEFrame epf = new ErrorPHONEFrame();
            } else {

                try {
                    /**
                     * Wywołanie konstruktora Doctor
                     */
                    Doctor newDoctor = new Doctor();
                    newDoctor.setPierwszeImie(nameField.getText());
                    if (!"".equals(secondNameField.getText())) {
                        newDoctor.setDrugieImie(secondNameField.getText());
                    } else {
                        newDoctor.setDrugieImie("");
                    }

                    newDoctor.setNazwisko(lastNameField.getText());
                    if (woman.isSelected()) {
                        newDoctor.setPlec("kobieta");
                    }
                    if (man.isSelected()) {
                        newDoctor.setPlec("mezczyzna");
                    }
                    newDoctor.setNrTelefonu(phoneNumberField.getText());
                    newDoctor.setEmail(emailField.getText());
                    newDoctor.setPesel(peselField.getText());
                    newDoctor.setDataUrodzenia(birthDateLabel2.getText());
                    newDoctor.setUlica(streetField.getText());
                    newDoctor.setNumerDomu(Integer.parseInt(numberField.getText()));
                    if (!"".equals(number2Field.getText())) {
                        newDoctor.setNumerMieszkania(Integer.parseInt(number2Field.getText()));
                    } else {
                        newDoctor.setNumerMieszkania(0);
                    }
                    newDoctor.setKodPocztowy(mailCodeField.getText());
                    newDoctor.setMiasto(mailCode2Field.getText());
                    newDoctor.setKraj(country.getSelectedItem().toString());

                    insertDoctorData(newDoctor);
                    insertDoctorPesel(newDoctor);
                    insertDoctorInfoToSpec(newDoctor);
                    /**
                     * Wywołanie konstruktora SetPasswordDoctor
                     */
                    SetPasswordDoctor spd = new SetPasswordDoctor();
                    frame.dispose();
                } catch (Exception e) {
                    System.out.println("Problem adding a new user to database " + e.getMessage());
                }
            }
        }
    }
}
