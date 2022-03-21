package projekt_java_kujawa_latos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko z wygenerowanym raportem z przeprowadzonego
 * przed wizytą wywiadu medycznego
 */
public class GeneratedRaport implements ActionListener {

    MyFrameBigger frame = new MyFrameBigger();
    JLabel head1 = new JLabel();
    JLabel head2 = new JLabel("LEKARZ: ");
    JLabel doctorData = new JLabel();
    JLabel patientData2 = new JLabel();
    JPanel mainPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel labelPanel2 = new JPanel();
    JPanel panel = new JPanel();
    JPanel closePanel = new JPanel();
    JLabel[] lab = new JLabel[19];
    JLabel[] ans = new JLabel[18];
    JTextArea other = new JTextArea();
    MyButton close = new MyButton("Zamknij");

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    ImageIcon imageRegister = new ImageIcon("register.png");

    Color c_back = new Color(221, 243, 249);
    Font font = new Font("Arial Nova Light", Font.BOLD, 20);

    /**
     * Konstruktor klasy GeneratedRaport
     *
     * @param doctor - zmienna zawierająca dane o lekarzu, u którego ma się
     * odbyć wizyta
     * @param visit_data - zmienna zawierająca dane o wizycie i nr pesel
     * pacjenta
     * @param symptoms - tablica zawierająca informacje o odpowiedziach
     * udzielonych w wywiadzie medycznym
     */
    GeneratedRaport(String doctor, String visit_data, String[] symptoms) {

        frame.setTitle("Raport z wywiadu medycznego");

        mainPanel.setBackground(c_back);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        head1.setText(" DANE WIZYTY I PESEL PACJENTA: ");
        head1.setFont(font);
        head1.setHorizontalAlignment(JLabel.RIGHT);

        patientData2.setText(visit_data);
        patientData2.setFont(font);
        patientData2.setHorizontalAlignment(JLabel.LEFT);

        head2.setText(" LEKARZ: ");
        head2.setFont(font);
        head2.setHorizontalAlignment(JLabel.RIGHT);

        doctorData.setText(doctor);
        doctorData.setFont(font);
        doctorData.setHorizontalAlignment(JLabel.LEFT);

        labelPanel.setLayout(new GridLayout(2, 2, 40, 10));
        labelPanel.setBackground(c_back);
        labelPanel.add(head1);
        labelPanel.add(patientData2);
        labelPanel.add(head2);
        labelPanel.add(doctorData);

        String[] symptoms_list = {"ZŁE SAMOPOCZUCIE: ", "ZMĘCZENIE: ", "KASZEL: ", "KATAR: ",
            "GORĄCZKA: ", "BÓL BRZUCHA: ", "BÓL GŁOWY: ", "ZAWROTY GŁOWY: ", "BIEGUNKA: ",
            "WYMIOTY: ", "TRUDNOSCI W ODDYCHANIU / DUSZNOŚCI: ", "BÓL W KLATCE PIERSIOWEJ: ",
            "BRAK WĘCHU I / LUB SMAKU: ", "BÓL GARDŁA: ", "BÓL ZĘBA: ", "BÓL UCHA: ",
            "KRWOTOKI Z NOSA: ", "WYSYPKA: ", "INNE: "};

        panel.setBackground(c_back);
        panel.setLayout(new GridLayout(19, 2, 40, 5));

        for (int i = 0; i < symptoms_list.length - 1; i++) {
            lab[i] = new JLabel();
            ans[i] = new JLabel();
            if (symptoms[i].equals("TAK")) {
                lab[i].setForeground(Color.RED);
                ans[i].setForeground(Color.RED);
            }
            lab[i].setText(symptoms_list[i]);
            lab[i].setFont(new Font("Arial Nova Light", Font.BOLD, 15));
            lab[i].setHorizontalAlignment(JLabel.RIGHT);
            ans[i].setText(symptoms[i]);
            ans[i].setFont(new Font("Arial Nova Light", Font.BOLD, 15));
            panel.add(lab[i]);
            panel.add(ans[i]);
        }
        lab[18] = new JLabel();
        lab[18].setText(symptoms_list[18]);
        lab[18].setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        lab[18].setHorizontalAlignment(JLabel.RIGHT);
        if (!"Brak innych objawów".equals(symptoms[18])) {
            lab[18].setForeground(Color.RED);
            other.setForeground(Color.RED);
        }
        other.setText(symptoms[18]);
        other.setFont(new Font("Arial Nova Light", Font.BOLD, 15));
        other.setLineWrap(true);
        other.setEditable(false);
        other.setWrapStyleWord(true);
        other.setBackground(c_back);
        panel.add(lab[18]);
        panel.add(other);

        close.setPreferredSize(new Dimension(200, 40));
        close.setRadius(40);
        close.setFont(font);
        close.setHorizontalAlignment(SwingConstants.CENTER);
        close.addActionListener(this);

        closePanel.setBackground(c_back);
        closePanel.add(close);

        mainPanel.add(labelPanel);
        mainPanel.add(panel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(closePanel);
        frame.add(mainPanel);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == close) {
            frame.dispose();
        }
    }
}
