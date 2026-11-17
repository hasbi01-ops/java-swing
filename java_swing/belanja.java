package java_swing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Program Daftar Belanja
public class belanja extends JFrame {

    public belanja() {
        super("Daftar Belanja");

        // Komponen input
        JTextField txtBarang = new JTextField(15);
        JButton btnTambah = new JButton("Tambah");
        JButton btnHapus = new JButton("Hapus Terpilih");

        // Model dan daftar belanja
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> daftar = new JList<>(model);

        // Mengatur tampilan daftar
        daftar.setFont(new Font("Arial", Font.PLAIN, 14));
        daftar.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scroll = new JScrollPane(daftar);
        scroll.setPreferredSize(new Dimension(300, 180));

        // Label judul
        JLabel judul = new JLabel(
            "DAFTAR BELANJA",
            SwingConstants.CENTER
        );
        judul.setFont(new Font("Arial", Font.BOLD, 20));

        // Tombol Tambah
        btnTambah.addActionListener(e -> {
            String barang = txtBarang.getText().trim();

            if (barang.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Nama barang wajib diisi.",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            model.addElement(barang);
            txtBarang.setText("");
            txtBarang.requestFocus();
        });

        // Tombol Hapus
        btnHapus.addActionListener(e -> {
            int index = daftar.getSelectedIndex();

            if (index == -1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Pilih barang yang ingin dihapus."
                );
                return;
            }

            model.remove(index);
        });

        // Panel input
        JPanel atas = new JPanel();
        atas.add(new JLabel("Nama Barang:"));
        atas.add(txtBarang);
        atas.add(btnTambah);

        // Panel tombol hapus
        JPanel bawah = new JPanel();
        bawah.add(btnHapus);

        // Panel utama
        JPanel utama = new JPanel(new BorderLayout(10, 10));
        utama.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        utama.add(judul, BorderLayout.NORTH);
        utama.add(atas, BorderLayout.CENTER);
        utama.add(scroll, BorderLayout.SOUTH);

        add(utama, BorderLayout.CENTER);
        add(bawah, BorderLayout.SOUTH);

        setSize(420, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new belanja().setVisible(true)
        );
    }
}
