package java_swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class edit extends JFrame {

    JTextArea areaTeks;
    JFileChooser fileChooser;

    public edit() {

        setTitle("Editor Teks");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat area teks
        areaTeks = new JTextArea();
        areaTeks.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(areaTeks);
        add(scrollPane, BorderLayout.CENTER);

        // Membuat File Chooser
        fileChooser = new JFileChooser();

        // Membuat Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // Menu File
        JMenu menuFile = new JMenu("File");

        JMenuItem itemBaru = new JMenuItem("Baru");
        JMenuItem itemBuka = new JMenuItem("Buka");
        JMenuItem itemSimpan = new JMenuItem("Simpan");
        JMenuItem itemKeluar = new JMenuItem("Keluar");

        menuFile.add(itemBaru);
        menuFile.add(itemBuka);
        menuFile.add(itemSimpan);
        menuFile.addSeparator();
        menuFile.add(itemKeluar);

        // Menu Edit
        JMenu menuEdit = new JMenu("Edit");

        JMenuItem itemPotong = new JMenuItem("Potong");
        JMenuItem itemSalin = new JMenuItem("Salin");
        JMenuItem itemTempel = new JMenuItem("Tempel");

        menuEdit.add(itemPotong);
        menuEdit.add(itemSalin);
        menuEdit.add(itemTempel);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        // Membuat Toolbar
        JToolBar toolbar = new JToolBar();

        JButton btnBaru = new JButton("Baru");
        JButton btnBuka = new JButton("Buka");
        JButton btnSimpan = new JButton("Simpan");
        JButton btnPotong = new JButton("Potong");
        JButton btnSalin = new JButton("Salin");
        JButton btnTempel = new JButton("Tempel");

        toolbar.add(btnBaru);
        toolbar.add(btnBuka);
        toolbar.add(btnSimpan);
        toolbar.addSeparator();
        toolbar.add(btnPotong);
        toolbar.add(btnSalin);
        toolbar.add(btnTempel);

        add(toolbar, BorderLayout.NORTH);

        // Aksi menu Baru
        itemBaru.addActionListener(e -> areaTeks.setText(""));

        // Aksi menu Buka
        itemBuka.addActionListener(e -> bukaFile());

        // Aksi menu Simpan
        itemSimpan.addActionListener(e -> simpanFile());

        // Aksi menu Keluar
        itemKeluar.addActionListener(e -> dispose());

        // Aksi menu Edit
        itemPotong.addActionListener(e -> areaTeks.cut());
        itemSalin.addActionListener(e -> areaTeks.copy());
        itemTempel.addActionListener(e -> areaTeks.paste());

        // Aksi Toolbar
        btnBaru.addActionListener(e -> itemBaru.doClick());
        btnBuka.addActionListener(e -> itemBuka.doClick());
        btnSimpan.addActionListener(e -> itemSimpan.doClick());
        btnPotong.addActionListener(e -> itemPotong.doClick());
        btnSalin.addActionListener(e -> itemSalin.doClick());
        btnTempel.addActionListener(e -> itemTempel.doClick());

        setVisible(true);
    }

    // Method membuka file
    private void bukaFile() {

        int pilihan = fileChooser.showOpenDialog(this);

        if (pilihan == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try (BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {

                areaTeks.read(reader, null);

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Gagal membuka file: " + ex.getMessage()
                );
            }
        }
    }

    // Method menyimpan file
    private void simpanFile() {

        int pilihan = fileChooser.showSaveDialog(this);

        if (pilihan == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer =
                    new BufferedWriter(new FileWriter(file))) {

                areaTeks.write(writer);

                JOptionPane.showMessageDialog(
                    this,
                    "File berhasil disimpan!"
                );

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Gagal menyimpan file: " + ex.getMessage()
                );
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new edit());
    }
}
