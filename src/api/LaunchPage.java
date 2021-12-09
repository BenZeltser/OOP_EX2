package api;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();


    public static void main(String[] args) {
        new LaunchPage();
    }
    LaunchPage(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        System.out.println("TRUEEE");
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
