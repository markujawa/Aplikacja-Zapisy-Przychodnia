package projekt_java_kujawa_latos;

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
import javax.swing.SwingConstants;

/**
 * Klasa reprezentująca okienko umożliwiające umówienie się na wizytę
 */
public class MakeAppointment implements ActionListener {

    MyFrameFullscreen frame = new MyFrameFullscreen();
    JPanel mainPanel = new JPanel();
    JLabel districtLabel = new JLabel("Oto dzielnice, w których przyjmują nasi lekarze. \nProszę wybrać dzielnicę, w której ma się odbyć wizyta: ");
    JLabel districtLabel2 = new JLabel("(po najechaniu na przycisk pokazuje się pełny adres placówki)");
    JPanel chosenPanel = new JPanel();
    JLabel chosenDistrict = new JLabel("Wybrana dzielnica:      ...");
    JPanel districtPanel = new JPanel();
    JLabel doctorLabel = new JLabel("Proszę wybrać lekarza:");
    JPanel doctorLabelPanel = new JPanel();
    JLabel doctor2Label = new JLabel("SPECJALIZACJA:");
    JLabel doctor3Label = new JLabel("LEKARZ:");
    JPanel doctorPanel = new JPanel();
    JPanel districtLabelPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JLabel appointmentLabel = new JLabel("Proszę wybrać dzień i godzinę wizyty:");
    JPanel appointmentLabelPanel = new JPanel();
    JPanel appointmentDayPanel = new JPanel();
    JPanel appointmentHourPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    MyButton district1 = new MyButton("Wola");
    MyButton district2 = new MyButton("Ochota");
    MyButton district3 = new MyButton("Włochy");
    MyButton district4 = new MyButton("Śródmieście");
    MyButton district5 = new MyButton("Mokotów");
    MyButton goBack = new MyButton("Wróć");
    MyButton goNext = new MyButton("Zatwierdź wizytę");

    JComboBox doctors = new JComboBox();
    JComboBox doctorsBySpeciality = new JComboBox();
    JLabel dayLabel = new JLabel("DZIEŃ:    ");
    JComboBox day = new JComboBox();
    JLabel hourLabel = new JLabel("GODZINA:    ");
    JComboBox hour = new JComboBox();

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    Color c_back = new Color(221, 243, 249);
    Font font1 = new Font("Arial Nova Light", Font.BOLD, 20);
    Font font2 = new Font("Valken", Font.PLAIN, 50);

    private String Pesel;
    private String visidID;
    private String dist = null;
    private String pickedDay = null;
    ArrayList<String> docIds = new ArrayList<String>();

    /**
     * Konstruktor klasy MakeAppointment
     *
     * @param PESEL - pesel zalogowanego pacjenta
     */
    public MakeAppointment(String PESEL) {
        frame.setTitle("Rejestracja na wizytę");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        mainPanel.setBackground(c_back);

        districtLabel.setHorizontalAlignment(SwingConstants.CENTER);
        districtLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 30));

        districtLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        districtLabel2.setFont(font1);

        districtLabelPanel.setBackground(c_back);
        districtPanel.setBackground(c_back);
        districtPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        chosenDistrict.setHorizontalAlignment(SwingConstants.CENTER);
        chosenDistrict.setFont(new Font("Arial Nova Light", Font.BOLD, 30));
        chosenPanel.setBackground(c_back);
        chosenPanel.add(chosenDistrict);

        doctorLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 30));
        doctorLabelPanel.setBackground(c_back);

        doctor2Label.setFont(new Font("Arial Nova Light", Font.BOLD, 30));
        doctor3Label.setFont(new Font("Arial Nova Light", Font.BOLD, 30));

        doctorPanel.setBackground(c_back);
        doctorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        appointmentLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 30));

        appointmentLabelPanel.setBackground(c_back);

        appointmentDayPanel.setBackground(c_back);
        appointmentHourPanel.setBackground(c_back);

        district1.setPreferredSize(new Dimension(200, 40));
        district1.setRadius(40);
        district1.addActionListener(this);
        district1.setToolTipText("ul. Dzielna 33, Warszawa Wola");

        district2.setPreferredSize(new Dimension(200, 40));
        district2.setRadius(40);
        district2.addActionListener(this);
        district2.setToolTipText("ul. Archiwalna 15, Warszawa Ochota");

        district3.setPreferredSize(new Dimension(200, 40));
        district3.setRadius(40);
        district3.addActionListener(this);
        district3.setToolTipText("ul. 1 Sierpnia 34, Warszawa Włochy");

        district4.setPreferredSize(new Dimension(200, 40));
        district4.setRadius(40);
        district4.addActionListener(this);
        district4.setToolTipText("ul. Brzozowa 3, Warszawa Śródmieście");

        district5.setPreferredSize(new Dimension(200, 40));
        district5.setRadius(40);
        district5.addActionListener(this);
        district5.setToolTipText("ul. Spacerowa 21, Warszawa Mokotów");

        districtPanel.add(district1);
        districtPanel.add(district2);
        districtPanel.add(district3);
        districtPanel.add(district4);
        districtPanel.add(district5);

        districtLabelPanel.add(districtLabel);
        districtLabelPanel.add(districtLabel2);

        doctors.setPreferredSize(new Dimension(400, 40));
        doctors.setFocusable(false);
        doctors.setFont(font1);
        doctors.setBackground(c_back);
        doctors.setCursor(cursor);
        doctors.setEnabled(false);
        doctors.addItem("");
        doctors.addActionListener(this);

        doctorsBySpeciality.setPreferredSize(new Dimension(400, 40));
        doctorsBySpeciality.setFocusable(false);
        doctorsBySpeciality.setFont(font1);
        doctorsBySpeciality.setBackground(c_back);
        doctorsBySpeciality.setCursor(cursor);
        doctorsBySpeciality.setEnabled(false);
        doctorsBySpeciality.addItem("");
        doctorsBySpeciality.addActionListener(this);

        doctorLabelPanel.add(doctorLabel);

        doctorPanel.add(doctor2Label);
        doctorPanel.add(doctorsBySpeciality);

        doctorPanel.add(doctor3Label);
        doctorPanel.add(doctors);

        appointmentLabelPanel.add(appointmentLabel);

        dayLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 30));
        day.setPreferredSize(new Dimension(400, 40));
        day.setFocusable(false);
        day.setFont(font1);
        day.setBackground(c_back);
        day.setCursor(cursor);
        day.setEnabled(false);
        day.addItem("");
        day.addActionListener(this);

        hourLabel.setFont(new Font("Arial Nova Light", Font.BOLD, 30));
        hour.setPreferredSize(new Dimension(400, 40));
        hour.setFocusable(false);
        hour.setFont(font1);
        hour.setBackground(c_back);
        hour.setCursor(cursor);
        hour.setEnabled(false);
        hour.addItem("");
        hour.addActionListener(this);

        appointmentDayPanel.add(dayLabel);
        appointmentDayPanel.add(day);
        appointmentDayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        appointmentHourPanel.add(hourLabel);
        appointmentHourPanel.add(hour);
        appointmentHourPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        goBack.setPreferredSize(new Dimension(250, 40));
        goBack.setRadius(40);
        goBack.addActionListener(this);

        goNext.setPreferredSize(new Dimension(250, 40));
        goNext.setRadius(40);
        goNext.addActionListener(this);

        buttonPanel.setBackground(c_back);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        buttonPanel.add(goBack);
        buttonPanel.add(goNext);

        mainPanel.add(districtLabelPanel);
        mainPanel.add(districtPanel);
        mainPanel.add(chosenPanel);
        mainPanel.add(doctorLabelPanel);
        mainPanel.add(doctorPanel);
        mainPanel.add(appointmentLabelPanel);
        mainPanel.add(appointmentDayPanel);
        mainPanel.add(appointmentHourPanel);
        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
        frame.setVisible(true);
        Pesel = PESEL;
    }

    /**
     * Metoda szukająca lekarzy o wybranej specjalności w wybranej dzielnicy
     * (dodanie do JComboBox)
     *
     * @param district - dzielnica
     */
    public void getDoctorInDistrict(String district) {
        String sql = "SELECT specjalnosc "
                + "FROM spec_and_place WHERE dzielnica = ?";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, district);
            ResultSet rs = pstmt.executeQuery();

            while (doctorsBySpeciality.getItemCount() != 1) {
                doctorsBySpeciality.removeItemAt(doctorsBySpeciality.getItemCount() - 1);
            }

            while (rs.next()) {
                boolean exists = false;
                for (int index = 0; index < doctorsBySpeciality.getItemCount() && !exists; index++) {
                    if (rs.getString("specjalnosc").equals(doctorsBySpeciality.getItemAt(index))) {
                        exists = true;
                    }
                }
                if (!exists) {
                    doctorsBySpeciality.addItem(rs.getString("specjalnosc"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Metoda szukająca lekarzy wybranej specjalności w danej dzielnicy (dodanie
     * do JComboBox)
     *
     * @param district - wybrana dzielnica
     * @param speciality - specjalizacja lekarza
     */
    public void getDoctorSpeciality(String district, String speciality) {
        String sql = "SELECT imie, nazwisko, pesel "
                + "FROM spec_and_place WHERE dzielnica = ? and specjalnosc = ?";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, district);
            pstmt.setString(2, speciality);
            ResultSet rs = pstmt.executeQuery();

            while (doctors.getItemCount() != 1) {
                doctors.removeItemAt(doctors.getItemCount() - 1);
            }
            if (!docIds.isEmpty()) {
                docIds.clear();
            }
            while (rs.next()) {
                doctors.addItem("dr " + rs.getString("imie") + " " + rs.getString("nazwisko"));
                docIds.add(rs.getString("pesel"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prywatna metoda umozliwiająca otrzymanie nr pesel lekarza
     *
     * @param index - indeks obiektu (w JComboBox) odnoszący się do wybranego
     * lekarza
     * @return docID
     */
    private String getDocID(int index) {
        String docID = docIds.get(index - 1);
        return docID;
    }

    /**
     * Metoda umożliwiająca pozyskanie konkretnych dni wizyty u wybranego
     * lekarza (dodanie do JComboBox)
     *
     * @param docID - pesel lekarza
     */
    public void getVisitDay(String docID) {
        String sql = "SELECT dzien "
                + "FROM visits WHERE id_lekarza = ? and id_pacjenta IS NULL";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, docID);
            ResultSet rs = pstmt.executeQuery();

            while (day.getItemCount() != 1) {
                day.removeItemAt(day.getItemCount() - 1);
            }

            while (rs.next()) {
                boolean exists = false;
                for (int index = 0; index < day.getItemCount() && !exists; index++) {
                    if (rs.getString("dzien").equals(day.getItemAt(index))) {
                        exists = true;
                    }
                }
                if (!exists) {
                    day.addItem(rs.getString("dzien"));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Metoda umożliwiająca pozyskanie godzin wizyt w wybranym dniu (dodanie do
     * JComboBox)
     *
     * @param docID - pesel lekarza
     */
    public void getVisitHour(String docID) {
        String sql = "SELECT godzina "
                + "FROM visits WHERE id_lekarza = ? and dzien = ? and id_pacjenta IS NULL ";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, docID);
            pstmt.setString(2, pickedDay);
            ResultSet rs = pstmt.executeQuery();

            while (hour.getItemCount() != 1) {
                hour.removeItemAt(hour.getItemCount() - 1);
            }

            while (rs.next()) {
                hour.addItem(rs.getString("godzina"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Metoda umożliwiająca pozyskanie identyfikatora wizyty
     *
     * @param docID - pesel lekarza
     * @param hour - godzina wizyty
     * @return visitID
     */
    public String getVisitID(String docID, String hour) {
        String sql = "SELECT id_wizyty "
                + "FROM visits WHERE id_lekarza = ? and dzien = ? and godzina = ? and id_pacjenta = ?";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, docID);
            pstmt.setString(2, pickedDay);
            pstmt.setString(3, hour);
            pstmt.setString(4, Pesel);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                visidID = rs.getString("id_wizyty");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return visidID;
    }

    /**
     * Metoda umożliwiająca zapis na wizytę o wybranych parametrach
     *
     * @param pacient - pesel pacjenta
     * @param doctor - pesel lekarza
     * @param day - dzien wizyty
     * @param hour - godzina wizyty
     */
    public void makeNewAppointment(String pacient, String doctor, String day, String hour) {
        String sql = "UPDATE visits SET id_pacjenta = ? "
                + "WHERE id_lekarza = ? and dzien = ? and godzina = ?";

        try (Connection conn = ConnectionDB.connectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pacient);
            pstmt.setString(2, doctor);
            pstmt.setString(3, day);
            pstmt.setString(4, hour);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == district1) {
            getDoctorInDistrict("Wola");
            doctorsBySpeciality.setEnabled(true);
            dist = "Wola";
            chosenDistrict.setText("Wybrana dzielnica:      " + dist);
            doctors.setSelectedItem("");
            day.setSelectedItem("");
            hour.setSelectedItem("");
            doctors.setEnabled(false);
            day.setEnabled(false);
            hour.setEnabled(false);
        }
        if (ae.getSource() == district2) {
            getDoctorInDistrict("Ochota");
            doctorsBySpeciality.setEnabled(true);
            dist = "Ochota";
            chosenDistrict.setText("Wybrana dzielnica:      " + dist);
            doctors.setSelectedItem("");
            day.setSelectedItem("");
            hour.setSelectedItem("");
            doctors.setEnabled(false);
            day.setEnabled(false);
            hour.setEnabled(false);
        }
        if (ae.getSource() == district3) {
            doctorsBySpeciality.setEnabled(true);
            getDoctorInDistrict("Włochy");
            dist = "Włochy";
            chosenDistrict.setText("Wybrana dzielnica:      " + dist);;
            doctors.setSelectedItem("");
            day.setSelectedItem("");
            hour.setSelectedItem("");
            doctors.setEnabled(false);
            day.setEnabled(false);
            hour.setEnabled(false);
        }
        if (ae.getSource() == district4) {
            doctorsBySpeciality.setEnabled(true);
            getDoctorInDistrict("Śródmieście");
            dist = "Śródmieście";
            chosenDistrict.setText("Wybrana dzielnica:      " + dist);;
            doctors.setSelectedItem("");
            day.setSelectedItem("");
            hour.setSelectedItem("");
            doctors.setEnabled(false);
            day.setEnabled(false);
            hour.setEnabled(false);
        }
        if (ae.getSource() == district5) {
            doctorsBySpeciality.setEnabled(true);
            getDoctorInDistrict("Mokotów");
            dist = "Mokotów";
            chosenDistrict.setText("Wybrana dzielnica:      " + dist);;
            doctors.setSelectedItem("");
            day.setSelectedItem("");
            hour.setSelectedItem("");
            doctors.setEnabled(false);
            day.setEnabled(false);
            hour.setEnabled(false);
        }

        if (ae.getSource() == doctorsBySpeciality) {
            doctors.setEnabled(false);
            day.setEnabled(false);
            hour.setEnabled(false);
            if (!"".equals(doctorsBySpeciality.getSelectedItem().toString()) && doctorsBySpeciality.getItemCount() > 1) {
                if (doctors.isEnabled() == false) {
                    getDoctorSpeciality(dist, doctorsBySpeciality.getSelectedItem().toString());
                    doctors.setEnabled(true);
                }
            }
        }

        if (ae.getSource() == doctors) {
            day.setSelectedItem("");
            day.setEnabled(false);
            if (!"".equals(doctors.getSelectedItem().toString()) && doctors.getItemCount() > 1) {
                getVisitDay(getDocID(doctors.getSelectedIndex()));
                day.setEnabled(true);
            }
        }

        if (ae.getSource() == day) {
            hour.setSelectedItem("");
            hour.setEnabled(false);
            if (!"".equals(day.getSelectedItem().toString()) && day.getItemCount() > 1) {
                pickedDay = day.getSelectedItem().toString();
                getVisitHour(getDocID(doctors.getSelectedIndex()));
                hour.setEnabled(true);
            }
        }

        if (ae.getSource() == goNext) {
            makeNewAppointment(Pesel, getDocID(doctors.getSelectedIndex()), day.getSelectedItem().toString(), hour.getSelectedItem().toString());
            frame.dispose();
            /**
             * Wywołanie konstruktora klasy MedicalInterview
             */
            MedicalInterview medinv = new MedicalInterview(getVisitID(getDocID(doctors.getSelectedIndex()), hour.getSelectedItem().toString()), Pesel);
        }

        if (ae.getSource() == goBack) {
            /**
             * Wywołanie konstruktora klasy HomePagePatient
             */
            HomePagePatient hompag = new HomePagePatient(Pesel);
        }

    }

}
