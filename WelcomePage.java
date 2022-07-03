import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage {

    JFrame frame;
    JButton playButton;

    public WelcomePage() {
        frame = new JFrame();

        JLabel title = new JLabel("Guess The Number");
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        JPanel jPanel = new JPanel();
        frame.add(jPanel);

        playButton = new JButton("Play");
        playButton.setHorizontalAlignment(JButton.CENTER);
        playButton.setSize(200, 150);
        jPanel.add(playButton);

        frame.setTitle("Guess The Number");
        frame.setResizable(false);
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
    }

}
