package api;
//Center_PopUp
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class addisConnected_PopUP extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;

    addisConnected_PopUP() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());
        this.setTitle("is Connected");

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
        if (e.getSource()==button) {

            String input = textField.getText();
            boolean connection = true;

            DWG_ALGO algo = new DWG_ALGO();
            try {
                algo.load("G1.json");
                connection = !(algo.isConnected());
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            String ans = (input+" Claim of Connection is "+connection);
            new isConnected_Popup(ans);
        }
    }
}
