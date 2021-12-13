package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Center_PopUp extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel center = new JLabel();

    Center_PopUp(String input) {
        String ans = (input);
        center.setBackground(Color.green);
        center.setVisible(true);
        center.setEnabled(true);
        center.setSize(900,70);
        center.setText(ans);
        center.setVerticalTextPosition(JLabel.TOP);
        center.setHorizontalAlignment(JLabel.LEFT);
        center.setForeground(Color.green);
        center.setFont((new Font("Arial", Font.PLAIN, 20)));

        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,70);
        frame.setTitle("Center");
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(center);
        frame.revalidate();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

