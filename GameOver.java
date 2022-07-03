import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver {
    JFrame frame;

    public GameOver(Game game) {
        frame = new JFrame();

        JLabel gameStatus = new JLabel(game.hasWon ? "YOU WON!" : "GAME OVER!");
        gameStatus.setHorizontalAlignment(JLabel.CENTER);
        frame.add(gameStatus);

        JLabel numberLabel = new JLabel("Guessed Number is " + game.randomNumber);
        numberLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(numberLabel);

        JLabel score = new JLabel("Your Score: " + game.calculateScore());
        score.setHorizontalAlignment(JLabel.CENTER);
        frame.add(score);

        if(game.highScore < game.calculateScore()) {
            game.highScore = game.calculateScore();
        }

        JLabel highScore = new JLabel("HIGH SCORE: " + game.highScore);
        highScore.setHorizontalAlignment(JLabel.CENTER);
        frame.add(highScore);

        JPanel jPanel = new JPanel();
        JButton playAgain = new JButton("Play again");
        jPanel.add(playAgain);
        frame.add(jPanel);

        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                game.newRound();
            }
        });


        frame.setTitle("Game Over");
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(6, 1));
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        Game sample_game = new Game();
        sample_game.hasWon = true;
        GameOver gameOver = new GameOver(sample_game);
        gameOver.frame.setVisible(true);
    }
}
