
package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShortestPath_PopUp implements ActionListener {
    JFrame frame = new JFrame();
    JLabel distance = new JLabel();
    public ShortestPath_PopUp(double input, String path) {

        String ans = ("Shortest Path Distance is "+input + " || "+"Shortest Path is: "+path);
        distance.setBackground(Color.green);
        distance.setVisible(true);
        distance.setEnabled(true);
        distance.setSize(900,70);
        distance.setText(ans);
        distance.setVerticalTextPosition(JLabel.TOP);
        distance.setHorizontalAlignment(JLabel.LEFT);
        distance.setForeground(Color.green);
        distance.setFont((new Font("Arial", Font.PLAIN, 20)));


        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,70);
        frame.setTitle("Shortest Path");
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(distance);
        frame.revalidate();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
//        ShortestPath_PopUp pop = new ShortestPath_PopUp();
    }
}