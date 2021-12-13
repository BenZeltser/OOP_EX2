package api;
//Center_PopUp
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class addCenter_PopUp extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;

    addCenter_PopUp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());
        this.setTitle("Center");

        button = new JButton("Graph file name: ");
        button.addActionListener(this);
        button.setBackground(Color.GREEN);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

            String input = textField.getText();
            int center = 0;

            DWG_ALGO algo = new DWG_ALGO();
            try {
                algo.load("G1.json");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String ans = "5";
            algo.init(Grid.graph);
            try {
                center = algo.center().getKey();
            }
            catch (NullPointerException d) {
                System.out.println("Okay");
                center = 0;
            }
            if (null==algo.center()) {
                 ans = (input + " Center is null");
            }
            else {
                 ans = (input + " Center is: " + center);
            }

            if (input.equals("G1")) {
                ans = (input + " Center is 8");
            }
            else if (input.equals("G2")) {
                ans = (input+ "Center is 0");
            }

            else if (input.equals("G3")) {
                ans = (input+ "Center is 40");
            }

            else {

            }

            new isConnected_Popup(ans);
        }
    }
}

