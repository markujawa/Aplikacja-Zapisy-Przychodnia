package projekt_java_kujawa_latos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko uzyskiwania dodatkowych informacji o lekarzu
 */
public class LegitDoctor implements ActionListener {

    MyFrame frame = new MyFrame();
    JPanel panel = new JPanel();
    JPanel mainpanel = new JPanel();

    JLabel label = new JLabel("DODATKOWE DANE:");
    JLabel idLabel = new JLabel("Numer prawa wykonywania zawodu PWZ: ");
    JTextField idField = new JTextField();
    JLabel checkID = new JLabel(/*"Błędny numer PWZ!"*/);
    JLabel dzielnicaLabel = new JLabel("Dzielnica: ");
    JLabel specjalizacjaLabel = new JLabel("Specjalizacja: ");
    MyButton goNextButton = new MyButton("Dalej");

    String[] dzielnice = {"Mokotów", "Wola", "Śródmieście", "Ochota", "Włochy"};
    JComboBox listaDzielnic = new JComboBox(dzielnice);

    String[] specjalizacje = {"Dermatolog", "Ginekolog", "Internista", "Ortopeda", "Pediatra", "Stomatolog"};
    JComboBox listaSpecjalizacji = new JComboBox(specjalizacje);

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    Color c_back = new Color(221, 243, 249);
    Font font = new Font("Arial Nova Light", Font.BOLD, 20);

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Konstruktor klasy LegitDoctor
     */
    LegitDoctor() {

        frame.setTitle("DODATKOWE DANE!");
        panel.setBackground(c_back);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        panel.setLayout(null);

        listaDzielnic.setSelectedIndex(4);

        listaDzielnic.addActionListener(this);

        listaDzielnic.setMaximumRowCount(5);

        listaSpecjalizacji.setSelectedIndex(5);
        listaSpecjalizacji.addActionListener(this);
        listaSpecjalizacji.setMaximumRowCount(4);

        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setFont(new Font("Valken", Font.PLAIN, 30));
        label.setBounds(100, 40, 400, 60);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);

        idLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        idLabel.setBounds(40, 150, 500, 40);

        dzielnicaLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        dzielnicaLabel.setBounds(40, 250, 500, 40);

        specjalizacjaLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        specjalizacjaLabel.setBounds(40, 320, 500, 40);

        listaDzielnic.setBounds(150, 250, 392, 40);
        listaDzielnic.setFont(new Font("Arial Nova Light", Font.BOLD, 20));

        listaSpecjalizacji.setBounds(190, 320, 355, 40);
        listaSpecjalizacji.setFont(new Font("Arial Nova Light", Font.BOLD, 20));

        idField.setBounds(40, 200, 500, 40);
        idField.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        idField.setBorder(BorderFactory.createEmptyBorder());

        checkID.setBounds(200, 360, 400, 80);
        checkID.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        checkID.setForeground(Color.RED);

        goNextButton.setBounds(200, 450, 200, 50);
        goNextButton.setRadius(30);
        goNextButton.setFont(new Font("Arial Nova Light", Font.BOLD, 20));
        goNextButton.setBorder(BorderFactory.createEmptyBorder());
        goNextButton.addActionListener(this);

        mainpanel.add(Box.createVerticalGlue());
        mainpanel.add(panel);

        panel.add(idField);
        panel.add(listaSpecjalizacji);
        panel.add(label);
        panel.add(idLabel);
        panel.add(specjalizacjaLabel);
        panel.add(dzielnicaLabel);
        panel.add(listaDzielnic);
        panel.add(goNextButton);
        panel.add(checkID);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    /**
     * Metoda umożliwiająca wpisanie szczegółowych danych do tablicy
     *
     * @param dzielnica - dzielnica, w której przyjmuje lekarz
     * @param specjalnosc - spacjalność lekarza
     * @param id - numer PWZ lekarza
     */
    public void inserttDoctorData(String dzielnica, String specjalnosc, String id) {

        String sql = "INSERT INTO spec_and_place (dzielnica, specjalnosc, legitymacja) VALUES (?,?,?)";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dzielnica);
            pstmt.setString(2, specjalnosc);
            pstmt.setString(3, id);
            pstmt.executeUpdate();
            System.out.println("Dodano dane do bazy specjalności!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umożliwiająca zaktualizowanie danych o dzielnicy w tabeli
     *
     * @param dzielnica - dzielnica, w której będzie przyjmował lekarz
     */
    public void insertDzielnicaData(String dzielnica) {
        String sql = "UPDATE spec_and_place SET dzielnica = ? WHERE (dzielnica= 'brak')";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dzielnica);
            pstmt.executeUpdate();
            System.out.println("Dodano dzielnice do bazy informacji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umozliwiająca zaaktualizowanie danych o specjalizacja
     *
     * @param spec - specjalizacja lekarza
     */

    public void insertSpecjalizacjaData(String spec) {
        String sql = "UPDATE spec_and_place SET specjalnosc = ? WHERE (specjalnosc= 'brakk')";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, spec);
            pstmt.executeUpdate();
            System.out.println("Dodano specjalizacje do bazy informacji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda umozliwiająca zaaktualizowanie danych o numerze legitymacji
     *
     * @param id - numer prawa wykonywania zawodu
     */
    public void insertIdData(String id) {
        String sql = "UPDATE spec_and_place SET legitymacja = ? WHERE (legitymacja= 'brakkk')";

        try (Connection conn = ConnectionDB.connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            System.out.println("Dodano legitymacje do bazy informacji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == listaDzielnic) {

            //l1.setText(listaDzielnic.getSelectedItem() + " selected");
        }

        if (ae.getSource() == goNextButton) {
            try {
                /**
                 * zmienna pobierająca dane o numerze PWZ z pola tekstowego
                 */
                String id = idField.getText();
                /**
                 * zmienne pobierające dane z list rozwijanych
                 */
                String dziel = listaDzielnic.getSelectedItem().toString();
                String spec = listaSpecjalizacji.getSelectedItem().toString();

                if (idField.getText().length() != 7) {
                    checkID.setText("\"Błędny numer PWZ!\"");
                } else {

                    insertDzielnicaData(dziel);
                    insertSpecjalizacjaData(spec);
                    insertIdData(id);

                    LoginPageDoctor loginDoctor = new LoginPageDoctor();
                    frame.dispose();
                }

            } catch (Exception e) {

                System.out.println("Problem adding a new SPECKA to database " + e.getMessage());
            }

        }
    }
}
