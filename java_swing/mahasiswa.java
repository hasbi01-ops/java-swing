package java_swing;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class mahasiswa extends JFrame {

    JTable tabel;
    DefaultTableModel model;

    JTextField txtNim, txtNama, txtProdi, txtIpk;

    JButton btnTambah, btnUbah, btnHapus;

    public mahasiswa() {

        setTitle("Data Mahasiswa");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // Judul
        JLabel judul = new JLabel(
            "DATA MAHASISWA",
            JLabel.CENTER
        );

        judul.setFont(new Font("Arial", Font.BOLD, 22));

        add(judul, BorderLayout.NORTH);

        // Membuat tabel
        String[] kolom = {
            "NIM", "Nama", "Prodi", "IPK"
        };

        model = new DefaultTableModel(kolom, 0);

        tabel = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tabel);

        add(scrollPane, BorderLayout.CENTER);

        // Panel Form
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));

        txtNim = new JTextField();
        txtNama = new JTextField();
        txtProdi = new JTextField();
        txtIpk = new JTextField();

        panelForm.add(new JLabel("NIM"));
        panelForm.add(txtNim);

        panelForm.add(new JLabel("Nama"));
        panelForm.add(txtNama);

        panelForm.add(new JLabel("Prodi"));
        panelForm.add(txtProdi);

        panelForm.add(new JLabel("IPK"));
        panelForm.add(txtIpk);

        // Panel Tombol
        JPanel panelTombol = new JPanel();

        btnTambah = new JButton("Tambah");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");

        panelTombol.add(btnTambah);
        panelTombol.add(btnUbah);
        panelTombol.add(btnHapus);

        // Panel bawah
        JPanel panelBawah = new JPanel(new BorderLayout());

        panelBawah.add(panelForm, BorderLayout.CENTER);
        panelBawah.add(panelTombol, BorderLayout.SOUTH);

        add(panelBawah, BorderLayout.SOUTH);

        // Data awal
        model.addRow(new Object[]{
            "2026001", "Andi", "Informatika", "3.75"
        });

        model.addRow(new Object[]{
            "2026002", "Budi", "Manajemen", "3.50"
        });

        model.addRow(new Object[]{
            "2026003", "Citra", "Akuntansi", "3.85"
        });

        // Tombol Tambah
        btnTambah.addActionListener(e -> {

            if (txtNim.getText().isEmpty()
                || txtNama.getText().isEmpty()
                || txtProdi.getText().isEmpty()
                || txtIpk.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Semua data harus diisi!"
                );

                return;
            }

            try {
                double ipk = Double.parseDouble(txtIpk.getText());

                if (ipk < 0 || ipk > 4) {
                    JOptionPane.showMessageDialog(
                        this,
                        "IPK harus antara 0 sampai 4!"
                    );
                    return;
                }

                model.addRow(new Object[]{
                    txtNim.getText(),
                    txtNama.getText(),
                    txtProdi.getText(),
                    ipk
                });

                kosongkanForm();

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "IPK harus berupa angka!"
                );
            }
        });

        // Memilih data tabel
        tabel.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                int baris = tabel.getSelectedRow();

                if (baris != -1) {

                    txtNim.setText(model.getValueAt(baris, 0).toString());
                    txtNama.setText(model.getValueAt(baris, 1).toString());
                    txtProdi.setText(model.getValueAt(baris, 2).toString());
                    txtIpk.setText(model.getValueAt(baris, 3).toString());
                }
            }
        });

        // Tombol Ubah
        btnUbah.addActionListener(e -> {

            int baris = tabel.getSelectedRow();

            if (baris == -1) {

                JOptionPane.showMessageDialog(
                    this,
                    "Pilih data yang ingin diubah!"
                );

                return;
            }

            try {
                double ipk = Double.parseDouble(txtIpk.getText());

                if (ipk < 0 || ipk > 4) {
                    JOptionPane.showMessageDialog(
                        this,
                        "IPK harus antara 0 sampai 4!"
                    );
                    return;
                }

                model.setValueAt(txtNim.getText(), baris, 0);
                model.setValueAt(txtNama.getText(), baris, 1);
                model.setValueAt(txtProdi.getText(), baris, 2);
                model.setValueAt(ipk, baris, 3);

                JOptionPane.showMessageDialog(
                    this,
                    "Data berhasil diubah!"
                );

                kosongkanForm();

                tabel.clearSelection();

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "IPK harus berupa angka!"
                );
            }
        });

        // Tombol Hapus
        btnHapus.addActionListener(e -> {

            int baris = tabel.getSelectedRow();

            if (baris != -1) {

                model.removeRow(baris);
                kosongkanForm();

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Pilih data yang ingin dihapus!"
                );
            }
        });

        setVisible(true);
    }

    // Method mengosongkan form
    private void kosongkanForm() {

        txtNim.setText("");
        txtNama.setText("");
        txtProdi.setText("");
        txtIpk.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new mahasiswa());
    }
}
