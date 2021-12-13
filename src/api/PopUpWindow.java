package api;

import javax.swing.*;
import java.awt.*;

public class PopUpWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    public static void main(String[] args) {}

    PopUpWindow(String ans){

        frame.setBackground(Color.BLACK);
        label.setText(ans);
        label.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,110);
        frame.setLayout(null);
        frame.setVisible(true);
        label.setVisible(true);
        label.setLocation(0,0);
        label.setSize(new Dimension(300,110));
        label.setFont(new Font("MV Boli", Font.BOLD,20));
        label.setForeground(Color.GREEN);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        label.setOpaque(true);
        frame.add(label);
    }
}


