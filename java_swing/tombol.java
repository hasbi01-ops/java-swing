package java_swing;

import javax.swing.*;
import java.awt.*;

// Satu ActionListener untuk beberapa tombol: if dengan e.getSource(), atau switch dengan getActionCommand()
public class tombol extends JFrame {
    private int n = 0;

    public tombol() {
        super("Penghitung");
        JButton tambah = new JButton("Tambah");
        JButton kurang = new JButton("Kurang");
        JButton reset = new JButton("Reset");
        tambah.setBackground(new Color(41, 98, 255));
        tambah.setForeground(Color.WHITE);
        kurang.setBackground(new Color(245, 158, 11));
        kurang.setForeground(Color.WHITE);
        reset.setBackground(new Color(239, 68, 68));
        reset.setForeground(Color.WHITE);
        tambah.setFocusPainted(false);
        kurang.setFocusPainted(false);
        reset.setFocusPainted(false);
        tambah.setFont(new Font("SansSerif", Font.BOLD, 14));
        kurang.setFont(new Font("SansSerif", Font.BOLD, 14));
        reset.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        JLabel angka = new JLabel("0", SwingConstants.CENTER);
        angka.setFont(new Font("SansSerif", Font.BOLD, 28));
        java.awt.event.ActionListener aksi = e -> {
            Object sumber = e.getSource();
            if (sumber == tambah) { 
                n++; 
            }
            else if (sumber == kurang) { 
                n--; 
            }
            else { 
                n = 0; 
            }
            angka.setText(String.valueOf(n));
        };
        tambah.addActionListener(aksi);
        kurang.addActionListener(aksi);
        reset.addActionListener(aksi);
        JPanel tombol = new JPanel();
        tombol.add(tambah); 
        tombol.add(kurang); 
        tombol.add(reset);
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));
        add(angka, BorderLayout.CENTER);
        add(tombol, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new tombol().setVisible(true));
    }
}