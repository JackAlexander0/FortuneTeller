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

    int x = -1;
    int y;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;

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
        setSize(screenWidth/2,screenHeight/2);
        setLocation(screenWidth/4 , screenHeight/4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));

        fortuneBtn = new JButton("Read My Fortune!");
        fortuneArray.add("Error 404: Fortune Not Found\n");
        fortuneArray.add("Don't Play Leap Frog With A Unicorn\n");
        fortuneArray.add("7 Days...\n");
        fortuneArray.add("It's Taco Tuesday, But On A Wednesday\n");
        fortuneArray.add("Why Do They Call It Oven When You Of In The Cold Food Out Hot Eat The Food\n");
        fortuneArray.add("Think For Yourself\n");
        fortuneArray.add("Wake Up\n");
        fortuneArray.add("Your Fortune Is In Another Castle\n");
        fortuneArray.add("It's Dangerous To Go Alone\n");
        fortuneArray.add("You Are Not Illiterate\n");
        fortuneArray.add("Don't Look Behind You\n");
        fortuneArray.add("If You Are Reading This You Are Too Close\n");
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {

            do  {
                y = rnd.nextInt(11);
            } while (x == y);

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
        fortuneTA.setFont(new Font("Impact", Font.PLAIN, 18));
    }

    private void createIconPanel() {
        iconPnl = new JPanel();
        fortuneIcon = new ImageIcon("src\\Ball.jpg");
        titleLbl = new JLabel("Fortune Teller", fortuneIcon, JLabel.CENTER);
        titleLbl.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }
}
