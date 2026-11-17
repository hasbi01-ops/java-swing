
package java_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

// Login dengan Java Swing
public class login2 extends JFrame {

    // Komponen utama
    private JTextField user;
    private JPasswordField sandi;
    private JCheckBox showPass;
    private JPanel panel;

    private char echoChar;

    public login2() {

        super("Login Application");

        // Pengaturan JFrame
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Warna tema biru
        Color biru = new Color(35, 100, 190);
        Color background = new Color(225, 238, 252);

        // Panel utama
        panel = new JPanel(new BorderLayout());
        panel.setBackground(background);
        panel.setBorder(
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        // Panel form
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);

        form.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(
                new Color(190, 210, 235)
            ),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(9, 10, 9, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        JLabel judul = new JLabel("LOGIN USER");
        judul.setFont(new Font("Arial", Font.BOLD, 25));
        judul.setForeground(biru);
        judul.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        form.add(judul, gbc);

        // Subjudul
        JLabel subjudul = new JLabel(
            "Silakan masukkan akun Anda"
        );

        subjudul.setFont(new Font("Arial", Font.PLAIN, 12));
        subjudul.setForeground(Color.GRAY);
        subjudul.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridy = 1;
        form.add(subjudul, gbc);

        // Label Username
        gbc.gridwidth = 1;
        gbc.weightx = 0;

        JLabel lblUser = new JLabel("Username:");

        gbc.gridx = 0;
        gbc.gridy = 2;
        form.add(lblUser, gbc);

        // Input Username
        user = new JTextField(15);
        user.setFont(new Font("Arial", Font.PLAIN, 14));

        gbc.gridx = 1;
        gbc.weightx = 1;
        form.add(user, gbc);

        // Label Password
        JLabel lblPass = new JLabel("Password:");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        form.add(lblPass, gbc);

        // Input Password
        sandi = new JPasswordField(15);
        sandi.setFont(new Font("Arial", Font.PLAIN, 14));

        echoChar = sandi.getEchoChar();

        gbc.gridx = 1;
        gbc.weightx = 1;
        form.add(sandi, gbc);

        // Show / Hide Password
        showPass = new JCheckBox("Lihat Password");
        showPass.setBackground(Color.WHITE);

        gbc.gridx = 1;
        gbc.gridy = 4;
        form.add(showPass, gbc);

        showPass.addActionListener(e -> {

            if (showPass.isSelected()) {
                sandi.setEchoChar((char) 0);
            } else {
                sandi.setEchoChar(echoChar);
            }

        });

        // Tombol Login dan Reset
        JButton btn = new JButton("MASUK");
        JButton btnReset = new JButton("RESET");

        btn.setBackground(biru);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setToolTipText("Klik untuk login");
        btn.setMnemonic('M');

        btnReset.setFont(new Font("Arial", Font.BOLD, 13));
        btnReset.setFocusPainted(false);
        btnReset.setToolTipText("Kosongkan form");

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        form.add(btn, gbc);

        gbc.gridx = 1;
        form.add(btnReset, gbc);

        // Footer
        JLabel footer = new JLabel(
            "Java Swing Login Application"
        );

        footer.setForeground(Color.GRAY);
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 11));

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        form.add(footer, gbc);

        // Memasukkan form ke panel utama
        panel.add(form, BorderLayout.CENTER);
        add(panel);

        // Proses Login
        btn.addActionListener(e -> {

            String u = user.getText().trim();
            char[] s = sandi.getPassword();

            if (u.isEmpty() || s.length == 0) {

                JOptionPane.showMessageDialog(
                    this,
                    "Username dan password harus diisi!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
                );

            } else if (
                u.equals("admin") &&
                Arrays.equals(s, new char[]{'1','2','3','4'})
            ) {

                JOptionPane.showMessageDialog(
                    this,
                    "Login Berhasil! Selamat Datang.",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Username atau password salah!",
                    "Gagal",
                    JOptionPane.ERROR_MESSAGE
                );

            }

            Arrays.fill(s, '\0');

        });

        // Tombol Reset
        btnReset.addActionListener(e -> resetForm());

        // Membuat Menu
        buatMenu();

    }

    // Fungsi Reset Form
    private void resetForm() {

        user.setText("");
        sandi.setText("");

        showPass.setSelected(false);
        sandi.setEchoChar(echoChar);

        user.requestFocus();

    }

    // Fungsi Menu Bar
    private void buatMenu() {

        JMenuBar bar = new JMenuBar();

        // Menu File
        JMenu file = new JMenu("File");

        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem keluar = new JMenuItem("Keluar");

        reset.addActionListener(e -> resetForm());

        keluar.addActionListener(e -> {

            int pilihan = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin keluar?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
            );

            if (pilihan == JOptionPane.YES_OPTION) {
                dispose();
            }

        });

        file.add(reset);
        file.addSeparator();
        file.add(keluar);

        // Menu Bantuan
        JMenu bantuan = new JMenu("Bantuan");

        JMenuItem tentang = new JMenuItem("Tentang");

        tentang.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                this,
                "LOGIN APPLICATION\n" +
                "Dibuat menggunakan Java Swing\n" +
                "Pemrograman 1 - Week 6",
                "Tentang Aplikasi",
                JOptionPane.INFORMATION_MESSAGE
            );

        });

        bantuan.add(tentang);

        // Memasang Menu
        bar.add(file);
        bar.add(bantuan);

        setJMenuBar(bar);

    }

    // Main Program
    public static void main(String[] args) {

        // Menggunakan tema Nimbus
        try {

            for (UIManager.LookAndFeelInfo info :
                UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {

                    UIManager.setLookAndFeel(
                        info.getClassName()
                    );

                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Tema Nimbus tidak tersedia");
        }

        SwingUtilities.invokeLater(() -> {
            new login2().setVisible(true);
        });

    }

}
