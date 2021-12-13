package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class addLoad_PopUp extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;

    addLoad_PopUp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());
        this.setTitle("Load");

        button = new JButton("Insert File Name");
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

            String ans = textField.getText();
            ans = "data/"+ans;

            DWG_ALGO algo = new DWG_ALGO();
            boolean check = new File("data", "ans").exists();
            if (check)
                algo.load(ans);
                algo.init(Grid.graph);

            String input = textField.getText();

            button = new JButton("Graph file name: ");
            button.addActionListener(this);
            button.setBackground(Color.GREEN);

            textField = new JTextField();
            textField.setPreferredSize(new Dimension(250, 40));

            this.add(button);
            this.add(textField);
            this.pack();
            this.setVisible(true);

            new Load_PopUp();
        }
    }
}
