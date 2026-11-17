package java_swing;

import javax.swing.*;
import java.awt.*;

public class regis extends JFrame {

    JTextField txtNama, txtEmail;
    JPasswordField txtSandi;
    JRadioButton rbLaki, rbPerempuan;
    JComboBox<String> cbProdi;
    JCheckBox cbCoding, cbGame, cbMusik;
    JButton btnDaftar;

    public regis() {

        setTitle("Form Registrasi Mahasiswa");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menggunakan GridBagLayout
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nama"), gbc);

        txtNama = new JTextField(20);
        gbc.gridx = 1;
        add(txtNama, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Email"), gbc);

        txtEmail = new JTextField(20);
        gbc.gridx = 1;
        add(txtEmail, gbc);

        // Sandi
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Sandi"), gbc);

        txtSandi = new JPasswordField(20);
        gbc.gridx = 1;
        add(txtSandi, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Gender"), gbc);

        JPanel panelGender = new JPanel();

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");

        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(rbLaki);
        groupGender.add(rbPerempuan);

        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);

        gbc.gridx = 1;
        add(panelGender, gbc);

        // Prodi
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Program Studi"), gbc);

        String[] prodi = {
            "Informatika",
            "Manajemen",
            "Akuntansi",
            "Desain Komunikasi Visual"
        };

        cbProdi = new JComboBox<>(prodi);

        gbc.gridx = 1;
        add(cbProdi, gbc);

        // Hobi
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Hobi"), gbc);

        JPanel panelHobi = new JPanel();

        cbCoding = new JCheckBox("Coding");
        cbGame = new JCheckBox("Game");
        cbMusik = new JCheckBox("Musik");

        panelHobi.add(cbCoding);
        panelHobi.add(cbGame);
        panelHobi.add(cbMusik);

        gbc.gridx = 1;
        add(panelHobi, gbc);

        // Tombol Daftar
        btnDaftar = new JButton("Daftar");

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(btnDaftar, gbc);

        // Aksi tombol daftar
        btnDaftar.addActionListener(e -> {

            String nama = txtNama.getText();
            String email = txtEmail.getText();
            String sandi = new String(txtSandi.getPassword());

            String gender = "";

            if (rbLaki.isSelected()) {
                gender = "Laki-laki";
            } else if (rbPerempuan.isSelected()) {
                gender = "Perempuan";
            }

            String program = cbProdi.getSelectedItem().toString();

            String hobi = "";

            if (cbCoding.isSelected()) hobi += "Coding ";
            if (cbGame.isSelected()) hobi += "Game ";
            if (cbMusik.isSelected()) hobi += "Musik ";

            String hasil =
                "Nama: " + nama +
                "\nEmail: " + email +
                "\nSandi: " + (sandi.isEmpty() ? "(kosong)" : "********") +
                "\nGender: " + gender +
                "\nProdi: " + program +
                "\nHobi: " + (hobi.isEmpty() ? "-" : hobi);

            JOptionPane.showMessageDialog(
                this,
                hasil,
                "Hasil Registrasi",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new regis());
    }
}

