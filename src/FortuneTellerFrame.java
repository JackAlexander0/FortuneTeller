import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JLabel titleLbl;
    JTextArea fortuneTA;
    JScrollPane scroller;
    ImageIcon fortuneIcon;

    JButton fortuneBtn;
    JButton quitBtn;

    ArrayList<String> fortuneArray = new ArrayList<String>();

    Random rnd = new Random();

    int x;
    int y;

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayArea();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));

        fortuneBtn = new JButton("Read My Fortune!");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneArray.add("");
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            x = -1;

            while (x == y) {
                y = rnd.nextInt(11);
            }

            fortuneTA.append(fortuneArray.get(y));
            x = y;

        });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            System.exit(0);
        });

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);
    }

    private void createDisplayArea() {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(12,25);
        fortuneTA.setEditable(false);
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
    }

    private void createIconPanel() {
        iconPnl = new JPanel();
        fortuneIcon = new ImageIcon("\\FortuneTeller\\src\\Ball.jpg");
        titleLbl = new JLabel("Fortune Teller", fortuneIcon, JLabel.CENTER);
        titleLbl.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }
}
