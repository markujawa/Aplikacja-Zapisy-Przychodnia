package projekt_java_kujawa_latos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko strony głównej po zalogowaniu przez lekarza
 */
public class HomePageDoctor implements ActionListener {

    MyFrameFullscreen frame = new MyFrameFullscreen();
    JPanel mainPanel = new JPanel();
    JLabel label = new JLabel("Witaj na swoim profilu!");
    JPanel topPanel = new JPanel();
    JPanel appointmentsLabelPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel bottomPanel3 = new JPanel();
    MyButton logOutButton = new MyButton("Wyloguj się"); // po jego kliknieciu stronka logowania
    JLabel appointmentsLabel = new JLabel("TWOJE NADCHODZĄCE WIZYTY: ");
    JTextArea appointments = new JTextArea();
    JComboBox patients = new JComboBox();
    MyButton generateMedInv = new MyButton("Wygeneruj wywiad lekarski");
    JLabel errlab = new JLabel();

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    Color c_back = new Color(221, 243, 249);
    Font font = new Font("Arial Nova Light", Font.BOLD, 30);
    Font font2 = new Font("Arial Nova Light", Font.BOLD, 20);
    Font font3 = new Font("Valken", Font.PLAIN, 40);

    ArrayList<Integer> visitIds = new ArrayList<Integer>();

    /**
     * Metoda umożliwiająca otrzymanie szczegółowych informacji o pacjencie
     *
     * @param patientID - pesel pacjenta
     * @return dane_pacjenta - informacje o pacjencie
     */
    public String getPatientInfo(String patientID) {
        String dane_pacjenta = "";
        String sql = "SELECT imie, drugie_imie, nazwisko, data_urodzenia, nr_telefonu, email "
                + "FROM patients_register_data WHERE pesel = ?";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, patientID);
            ResultSet rs2 = pstmt.executeQuery();

            while (rs2.next()) {
                dane_pacjenta = rs2.getString("imie") + "  " + rs2.getString("drugie_imie") + "  " + rs2.getString("nazwisko") + "\t"
                        + rs2.getString("data_urodzenia") + "\t" + rs2.getString("nr_telefonu")
                        + "\t" + rs2.getString("email");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (dane_pacjenta);

    }

    /**
     * Metoda umożliwiająca otrzymanie podstawowych informacji o pacjencie
     *
     * @param patientID - pesel pacjenta
     * @return dane_pacjenta - infromacje o pacjencie
     */
    public String getPatientInfo2(String patientID) {

        String dane_pacjenta = "";

        String sql = "SELECT imie, drugie_imie, nazwisko "
                + "FROM patients_register_data WHERE pesel = ?";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, patientID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dane_pacjenta = rs.getString("imie") + "  " + rs.getString("drugie_imie") + "  " + rs.getString("nazwisko");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (dane_pacjenta);

    }

    /**
     * Metoda umożliwiająca otrzymanie peselu pacjenta zapisanego na daną wizytę
     *
     * @param visitID - identyfikator wizyty
     * @return patientID - pesel pacjenta
     */
    public String getPatientID(int visitID) {
        String patientID = null;
        String sql = "SELECT id_pacjenta FROM visits WHERE id_wizyty = ?";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, visitID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                patientID = rs.getString("id_pacjenta");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (patientID);
    }

    /**
     * Metoda umożliwiająca otrzymanie informacji o lekarzu przeprowadzającym
     * daną wizytę
     *
     * @param visitID - identyfikator wizyty
     * @return doctor - dane lekarza
     */
    public String getDoctor(int visitID) {
        String doctorID = null;
        String doctor = null;
        String sql = "SELECT id_lekarza FROM visits WHERE id_wizyty = ?";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, visitID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                doctorID = rs.getString("id_lekarza");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql2 = "SELECT imie, nazwisko, specjalnosc FROM spec_and_place WHERE pesel = ?";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {

            pstmt.setString(1, doctorID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                doctor = "dr  " + rs.getString("imie") + "  " + rs.getString("nazwisko") + ",  " + rs.getString("specjalnosc");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return (doctor);
    }

    /**
     * Metoda umożliwiająca otrzymanie informacji o nadchodzących wizytach
     * danego lekarza
     *
     * @param pesel - pesel zalogowanego lekarza
     * @dane_wizyty - informacje o wizycie
     */
    private ArrayList<String> getYourVisits(String pesel) {

        ArrayList<String> dane_wizyty = new ArrayList<String>();

        String sql = "SELECT id_wizyty, dzien, godzina, id_pacjenta "
                + "FROM visits WHERE id_lekarza = ? and id_pacjenta IS NOT NULL";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pesel);
            ResultSet rs = pstmt.executeQuery();

            int i = 0;

            while (rs.next()) {
                visitIds.add(rs.getInt("id_wizyty"));
                String dane_pacjenta = getPatientInfo(rs.getString("id_pacjenta")); 
                dane_wizyty.add("\n         " + rs.getString("dzien") + "     " + rs.getString("godzina") + "\t"
                        + rs.getString("id_pacjenta") + "\t" + dane_pacjenta + "\t\n");
                patients.addItem(rs.getString("dzien") + "   " + rs.getString("godzina") + "            " + rs.getString("id_pacjenta"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dane_wizyty;
    }

    /**
     * Metoda umożliwiająca generowanie raportu z wywiadu medycznego
     *
     * @param visitID - identyfikator wizyty
     */
    public void generateMedInv(int visitID) {
        String[] symptoms = new String[19];

        String[] columns = {"zle_samopoczucie", "zmeczenie",
            "kaszel", "katar", "goraczka", "bol_brzucha", "bol_glowy", "zawroty_glowy", "biegunka",
            "wymioty", "trudnosci_oddech", "bol_klatka", "wech_smak", "bol_gardla", "bol_zeba",
            "bol_ucha", "krwotoki", "wysypka", "inne"};

        String sql = "SELECT zle_samopoczucie, zmeczenie, \n"
                + "kaszel, katar, goraczka, bol_brzucha, bol_glowy, zawroty_glowy, biegunka, \n"
                + "wymioty, trudnosci_oddech, bol_klatka, wech_smak, bol_gardla, bol_zeba, \n"
                + "bol_ucha, krwotoki, wysypka, inne FROM interviews WHERE id_wizyty = ?";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, visitID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < columns.length; i++) {
                    symptoms[i] = rs.getString(columns[i]);
                }

            }

            GeneratedRaport gr = new GeneratedRaport(getDoctor(visitID), patients.getSelectedItem().toString(), symptoms);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Konstruktor klasy HomePageDoctor
     *
     * @param PESEL - zmienna przechowująca nr pesel lekarza
     */
    HomePageDoctor(String PESEL) {
        frame.setTitle("Strona główna - Lekarz");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        mainPanel.setBackground(c_back);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(font3);

        logOutButton.setPreferredSize(new Dimension(200, 40));
        logOutButton.setRadius(40);
        logOutButton.addActionListener(this);

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        topPanel.setBackground(c_back);
        topPanel.add(label);
        topPanel.add(logOutButton);

        appointmentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appointmentsLabel.setFont(font);

        appointmentsLabelPanel.setBackground(c_back);
        appointmentsLabelPanel.add(appointmentsLabel);

        appointments.setEditable(false);
        appointments.setFont(font2);

        ArrayList<String> lista = getYourVisits(PESEL);

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                appointments.append(lista.get(i));
                System.out.println(lista.get(i));
            }
        } else {
            appointments.append("\n     *** BRAK NADCHODZĄCYCH WIZYT ***     \n");
        }

        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
        middlePanel.setBackground(c_back);
        middlePanel.add(appointments);

        patients.setPreferredSize(new Dimension(800, 40));
        patients.setFocusable(false);
        patients.setFont(font2);
        patients.setBackground(c_back);
        patients.setCursor(cursor);
        patients.addActionListener(this);

        generateMedInv.setPreferredSize(new Dimension(400, 40));
        generateMedInv.setRadius(40);
        generateMedInv.addActionListener(this);

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        bottomPanel.setBackground(c_back);
        bottomPanel.add(patients);
        bottomPanel.add(generateMedInv);

        errlab.setHorizontalAlignment(SwingConstants.CENTER);
        errlab.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        errlab.setForeground(Color.RED);

        bottomPanel3.setBackground(c_back);
        bottomPanel3.add(errlab);

        mainPanel.add(topPanel);
        mainPanel.add(appointmentsLabelPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(bottomPanel);
        mainPanel.add(bottomPanel3);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (patients.getSelectedItem() != null) {
            if (ae.getSource() == generateMedInv) {
                /**
                 * Wywołanie funkcji generujacej raport
                 */
                generateMedInv(visitIds.get(patients.getSelectedIndex()));
                errlab.setText("");
            }
        } else {
            errlab.setText("NIE MA WIZYT, DLA KTÓRYCH MOŻNA WYGENEROWAĆ RAPORT");
        }
        if (ae.getSource() == logOutButton) {
            frame.dispose();
            /**
             * Wywołanie konstruktora LoginWelcomePage
             */
            LoginWelcomePage logpage = new LoginWelcomePage();
        }
    }
}
