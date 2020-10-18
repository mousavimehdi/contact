package contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPractice extends JApplet implements ActionListener {

    JButton button, button1, button2, button3;
    JTextField name, phonenumber, rmvname, oldname, oldnumber, newname, newnumber;
    JLabel label, label1, jLabel, currentname, currentnumber, newname0, newnumber0;
    JPanel addpanel, remove,editpanel , panel,manegar;
    GridBagLayout gridbag;
    GridBagConstraints gb;
    CardLayout cardLayout;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    makeGui();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGui() {

        gridbag = new GridBagLayout();
        gb = new GridBagConstraints();
        cardLayout=new CardLayout();

        panel = new JPanel();
        panel.setLayout(gridbag);

        button = new JButton("ADD");
        button1 = new JButton("REMOVE");
        button2 = new JButton("SEARCH");
        button3 = new JButton("EDIT");

        gb.gridx = 0;
        gb.gridy = 0;
        panel.add(button, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        panel.add(button1, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        panel.add(button2, gb);

        gb.gridx = 0;
        gb.gridy = 3;
        panel.add(button3, gb);

        add(panel);

        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        addpanel = new JPanel();
        addpanel.setLayout(gridbag);

        name = new JTextField(15);
        phonenumber = new JTextField(15);

        gb.gridx = 1;
        gb.gridy = 0;
        addpanel.add(name, gb);

        gb.gridx = 1;
        gb.gridy = 1;
        addpanel.add(phonenumber, gb);

        label = new JLabel("Name:");
        label1 = new JLabel("Number:");

        gb.gridx = 0;
        gb.gridy = 0;
        addpanel.add(label, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        addpanel.add(label1, gb);

        name.addActionListener(this);
        phonenumber.addActionListener(this);

        remove = new JPanel();
        remove.setLayout(gridbag);

        jLabel = new JLabel("name:");
        gb.gridx = 0;
        gb.gridy = 0;
        remove.add(jLabel, gb);

        rmvname = new JTextField(15);
        gb.gridx = 1;
        gb.gridy = 0;
        remove.add(rmvname, gb);

        rmvname.addActionListener(this);

        editpanel = new JPanel();
        editpanel.setLayout(gridbag);

        oldname = new JTextField();
        oldnumber = new JTextField();
        newname = new JTextField();
        newnumber = new JTextField();

        currentname = new JLabel("current name:");
        currentnumber = new JLabel("current number:");
        newname0 = new JLabel("new name:");
        newnumber0 = new JLabel("new number:");

        gb.gridx = 0;
        gb.gridy = 0;
        editpanel.add(currentname, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        editpanel.add(currentnumber, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        editpanel.add(newname0, gb);

        gb.gridx = 0;
        gb.gridy = 3;
        editpanel.add(newnumber0, gb);

        gb.gridx = 1;
        gb.gridy = 0;
        editpanel.add(oldname, gb);

        gb.gridx = 1;
        gb.gridy = 1;
        editpanel.add(oldnumber, gb);

        gb.gridx = 1;
        gb.gridy = 3;
        editpanel.add(newname, gb);

        gb.gridx = 1;
        gb.gridy = 4;
        editpanel.add(newnumber, gb);

        manegar=new JPanel();
        manegar.setLayout(cardLayout);

        manegar.add(addpanel,cardLayout);
        manegar.add(editpanel,cardLayout);
        manegar.add(remove,cardLayout);

        panel.add(manegar);

        oldname.addActionListener(this);
        oldnumber.addActionListener(this);
        newname.addActionListener(this);
        newnumber.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();


        if (action.equals("ADD")) {

            cardLayout.show(manegar,"addpanel");
        }
    }
}
