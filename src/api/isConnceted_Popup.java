package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class isConnceted_Popup extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel connection = new JLabel();

    isConnceted_Popup(String input) {
        String ans = (input);
        connection.setBackground(Color.green);
        connection.setVisible(true);
        connection.setEnabled(true);
        connection.setSize(900,70);
        connection.setText(ans);
        connection.setVerticalTextPosition(JLabel.TOP);
        connection.setHorizontalAlignment(JLabel.LEFT);
        connection.setForeground(Color.green);
        connection.setFont((new Font("Arial", Font.PLAIN, 20)));


        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,70);
        frame.setTitle("Shortest Path");
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(connection);
        frame.revalidate();



    }
    @Override
    public void actionPerformed(ActionEvent e) {

        }
    }

