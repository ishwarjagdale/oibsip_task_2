import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

public class Game {

    JFrame frame;
    JTextField guessedNumber;
    JButton submitButton;
    JLabel status, attempts, rounds;
    int remaining_attempts = 5;
    int randomNumber = this.generateRandomNumber();
    int numberOfRounds = 1;
    boolean hasWon = false;
    int highScore = 0;

    public Game() {
        frame = new JFrame();

        JLabel title = new JLabel("Guess The Number");
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        JPanel jPanel = new JPanel();
        guessedNumber = new JTextField(" Enter your guess ");
        guessedNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                guessedNumber.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        submitButton = new JButton("Guess!");
        jPanel.add(guessedNumber);
        jPanel.add(submitButton);

        frame.add(jPanel);

        status = new JLabel("Status: ...");
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setVerticalAlignment(JLabel.TOP);
        frame.add(status);


        JPanel gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4, 1));
        attempts = new JLabel("Number of Attempts remaining: " + this.remaining_attempts);
        rounds = new JLabel("Round: " + this.numberOfRounds);
        attempts.setHorizontalAlignment(JLabel.CENTER);
        rounds.setHorizontalAlignment(JLabel.CENTER);
        gameInfo.add(attempts);
        gameInfo.add(rounds);
        frame.add(gameInfo);

        frame.setTitle("Guess The Number");
        frame.setResizable(true);
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(4, 1));
        frame.setVisible(false);
    }

    public int getGuessedNumber() {
        try {
            System.out.println(this.guessedNumber.getText());
            return Integer.parseInt(this.guessedNumber.getText().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int num = random.nextInt(1, 100);
        System.out.println("Number generated: " + num);
        return num;
    }

    public int calculateScore() {
        return this.remaining_attempts * 100 / 4;
    }

    public void newRound() {
        this.frame.setVisible(true);
        this.numberOfRounds++;
        this.randomNumber = generateRandomNumber();
        this.remaining_attempts = 5;
        this.hasWon = false;
        this.status.setText("Status: ...");
        this.rounds.setText("Round: " + this.numberOfRounds);
        this.attempts.setText("Number of Attempts remaining: " + this.remaining_attempts);
        this.guessedNumber.setText(" Enter your guess ");
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(1, 100));
    }
}
