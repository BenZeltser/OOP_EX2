package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Load_PopUp extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel loadLabel = new JLabel();

    Load_PopUp() {
        loadLabel.setBackground(Color.green);
        loadLabel.setVisible(true);
        loadLabel.setEnabled(true);
        loadLabel.setSize(900,70);
        loadLabel.setText("Loaded");
        loadLabel.setVerticalTextPosition(JLabel.TOP);
        loadLabel.setHorizontalAlignment(JLabel.LEFT);
        loadLabel.setForeground(Color.green);
        loadLabel.setFont((new Font("Arial", Font.PLAIN, 20)));

        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,70);
        frame.setTitle("Load");
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(loadLabel);
        frame.revalidate();


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        }

    public static void main(String[] args) {

    }
    }

