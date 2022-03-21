package projekt_java_kujawa_latos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko dotyczące wstępnego wywiadu medycznego
 */
public class MedicalInterview implements ActionListener {

    MyFrameFullscreen frame = new MyFrameFullscreen();
    JPanel mainPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel quePanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel confirmPanel = new JPanel();
    JLabel label = new JLabel("Wywiad lekarski");
    MyButton confirm = new MyButton("Zatwierdź");
    JTextArea introduction = new JTextArea("*** Poniższy wywiad ma na celu przyspieszenie i ułatwienie przebiegu wizyty lekarskiej. Uprzejmie prosimy o jego dokładne wypełnienie. ***");

    JLabel question = new JLabel("  Proszę o zaznaczenie wszystkich objawów, które obecnie u Pani/Pana występują:");

    MyCheckBox samopoczucie = new MyCheckBox("Złe samopoczucie");
    MyCheckBox katar = new MyCheckBox("Katar");
    MyCheckBox kaszel = new MyCheckBox("Kaszel");
    MyCheckBox krwotok = new MyCheckBox("Krwotoki z nosa");
    MyCheckBox bolUcha = new MyCheckBox("Ból ucha");
    MyCheckBox bolGardla = new MyCheckBox("Ból gardła");
    MyCheckBox wechSmak = new MyCheckBox("Brak węchu i/lub smaku");
    MyCheckBox goraczka = new MyCheckBox("Gorączka");
    MyCheckBox bolBrzucha = new MyCheckBox("Ból brzucha");
    MyCheckBox bolGlowy = new MyCheckBox("Ból głowy");
    MyCheckBox zawrotyGlowy = new MyCheckBox("Zawroty głowy");
    MyCheckBox bolZeba = new MyCheckBox("Ból zęba");
    MyCheckBox biegunka = new MyCheckBox("Biegunka");
    MyCheckBox wymioty = new MyCheckBox("Wymioty");
    MyCheckBox bolKlatka = new MyCheckBox("Ból w klatce piersiowej");
    MyCheckBox wysypka = new MyCheckBox("Wysypka");
    MyCheckBox dusznosci = new MyCheckBox("Trudności w oddychaniu / duszności");
    MyCheckBox zmeczenie = new MyCheckBox("Zmęczenie");
    MyCheckBox other = new MyCheckBox("Inne, proszę wpisać jakie: ");
    JTextField otherWhat = new JTextField();

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    Color c_back = new Color(221, 243, 249);
    Font font1 = new Font("Arial Nova Light", Font.BOLD, 20);
    Font font2 = new Font("Valken", Font.PLAIN, 50);

    /**
     * prywatna zmienna przechowująca dane o wizycie
     */
    private String wizyta;
    /**
     * prywatna zmienna przechowująca pesel
     */
    private String pesel;

    /**
     * Konstruktor klasy MedicalInterview
     *
     * @param visitID - identyfikator wizyty
     * @param PESEL - pesel zalogowanego pacjenta
     */
    public MedicalInterview(String visitID, String PESEL) {

        frame.setTitle("Wywiad lekarski");

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(font2);

        introduction.setFont(new Font("Arial Nova Light", Font.ITALIC, 30));
        introduction.setLineWrap(true);
        introduction.setEditable(false);
        introduction.setWrapStyleWord(true);

        question.setHorizontalAlignment(SwingConstants.LEFT);
        question.setFont(font1);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        mainPanel.setBackground(c_back);

        quePanel.setLayout(new GridLayout(10, 2, 10, 10));
        quePanel.setBackground(c_back);

        labelPanel.setLayout(new GridLayout(3, 1));
        labelPanel.setBackground(c_back);

        samopoczucie.addActionListener(this);
        katar.addActionListener(this);
        kaszel.addActionListener(this);
        krwotok.addActionListener(this);
        bolUcha.addActionListener(this);
        bolGardla.addActionListener(this);
        wechSmak.addActionListener(this);
        goraczka.addActionListener(this);
        bolBrzucha.addActionListener(this);
        bolGlowy.addActionListener(this);
        zawrotyGlowy.addActionListener(this);
        bolZeba.addActionListener(this);
        biegunka.addActionListener(this);
        wymioty.addActionListener(this);
        bolKlatka.addActionListener(this);
        wysypka.addActionListener(this);
        zmeczenie.addActionListener(this);
        dusznosci.addActionListener(this);
        other.addActionListener(this);
        otherWhat.setFont(font1);
        otherWhat.setToolTipText("Tutaj wpisz inne objawy");
        otherWhat.setMaximumSize(new Dimension(300, 40));
        otherWhat.setEnabled(false);

        quePanel.add(samopoczucie);
        quePanel.add(dusznosci);
        quePanel.add(zmeczenie);
        quePanel.add(bolKlatka);
        quePanel.add(kaszel);
        quePanel.add(wechSmak);
        quePanel.add(katar);
        quePanel.add(bolGardla);
        quePanel.add(goraczka);
        quePanel.add(bolZeba);
        quePanel.add(bolBrzucha);
        quePanel.add(bolUcha);
        quePanel.add(bolGlowy);
        quePanel.add(krwotok);
        quePanel.add(zawrotyGlowy);
        quePanel.add(wysypka);
        quePanel.add(biegunka);
        quePanel.add(other);
        quePanel.add(wymioty);
        quePanel.add(otherWhat);

        confirm.setPreferredSize(new Dimension(250, 40));
        confirm.setRadius(40);
        confirm.addActionListener(this);

        labelPanel.add(label);
        labelPanel.add(introduction);
        labelPanel.add(question);

        confirmPanel.setBackground(c_back);
        confirmPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        confirmPanel.add(confirm);

        mainPanel.add(labelPanel);
        mainPanel.add(quePanel);
        mainPanel.add(confirmPanel);

        frame.add(mainPanel);
        frame.setVisible(true);

        wizyta = visitID;
        pesel = PESEL;
    }

    /**
     * Metoda aktualizująca bazę danych o odpowiedziach pacjenta na pytania w
     * wywiadzie medycznym
     *
     * @param wizyta - identyfikator wizyty
     * @param symptoms - przechowuje odpowiedzi na pytania (TAK/NIE)
     * @param others - przechowuje odpowiedź na pytanie rozbudowane
     */
    public void setSymptoms(String wizyta, String[] symptoms, String others) {
        String sql = "INSERT INTO interviews (id_wizyty, zle_samopoczucie, zmeczenie, \n"
                + "kaszel, katar, goraczka, bol_brzucha, bol_glowy, zawroty_glowy, biegunka, \n"
                + "wymioty, trudnosci_oddech, bol_klatka, wech_smak, bol_gardla, bol_zeba, \n"
                + "bol_ucha, krwotoki, wysypka, inne) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, wizyta);
            for (int i = 0; i < symptoms.length; i++) {
                pstmt.setString(i + 2, symptoms[i]);
            }
            pstmt.setString(20, others);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String[] objawy = new String[18];
        String others;
        MyCheckBox[] check = {samopoczucie, zmeczenie, kaszel, katar, goraczka, bolBrzucha,
            bolGlowy, zawrotyGlowy, biegunka, wymioty, dusznosci, bolKlatka, wechSmak,
            bolGardla, bolZeba, bolUcha, krwotok, wysypka};

        if (other.isSelected()) {
            otherWhat.setEnabled(true);
            objawy[17] = "TAK";
        } else {
            otherWhat.setEnabled(false);
            objawy[17] = "NIE";
        }

        if (ae.getSource() == confirm) {

            for (int i = 0; i < check.length; i++) {
                if (check[i].isSelected()) {
                    objawy[i] = "TAK";
                } else {
                    objawy[i] = "NIE";
                }
            }
            if (other.isSelected()) {
                others = otherWhat.getText();
            } else {
                others = "Brak innych objawów";
            }
            /**
             * wywołanie funkcji aktualizującej bazę danych
             */
            setSymptoms(wizyta, objawy, others);
            frame.dispose();

            /**
             * Wywołanie konstruktora klasy HomePagePatient
             */
            HomePagePatient hompag = new HomePagePatient(pesel);
        }
    }
}
