package java_swing;


import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class jam extends JFrame {

    public jam() {
        super("Jam Digital");

        // Membuat label judul
        JLabel judul = new JLabel(
            "JAM DIGITAL",
            SwingConstants.CENTER
        );

        judul.setFont(new Font("Arial", Font.BOLD, 22));

        // Membuat label waktu
        JLabel waktu = new JLabel(
            "",
            SwingConstants.CENTER
        );

        waktu.setFont(new Font("Arial", Font.BOLD, 50));
        waktu.setForeground(new Color(41, 98, 255));

        // Format jam
        DateTimeFormatter format =
            DateTimeFormatter.ofPattern("HH:mm:ss");

        // Membuat Timer
        Timer timer = new Timer(1000, e -> {
            LocalTime sekarang = LocalTime.now();

            waktu.setText(sekarang.format(format));
        });

        // Menjalankan timer
        timer.start();

        // Panel utama
        JPanel utama = new JPanel(new GridLayout(2, 1, 5, 5));

        utama.setBackground(new Color(239, 246, 255));
        utama.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        utama.add(judul);
        utama.add(waktu);

        add(utama);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new jam());
    }
}
