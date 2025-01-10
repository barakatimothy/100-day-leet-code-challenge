import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AwesomeGame {

    // List of apostles' names
    private static final ArrayList<String> apostles = new ArrayList<>(Arrays.asList(
        "Peter", "Andrew", "James", "John", "Philip",
        "Bartholomew", "Thomas", "Matthew",
        "James (son of Alphaeus)", "Thaddaeus",
        "Simon (the Zealot)", "Judas Iscariot"
    ));
    private static final ArrayList<String> guessedCorrectly = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Apostles Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(135, 206, 250));
        JLabel header = new JLabel("Guess the 12 Apostles!");
        header.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        headerPanel.add(header);

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);

        // Feedback Panel
        JPanel feedbackPanel = new JPanel(new BorderLayout(10, 10));
        JTextArea feedbackArea = new JTextArea(5, 30);
        feedbackArea.setEditable(false);
        feedbackArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        feedbackPanel.add(scrollPane, BorderLayout.CENTER);

        // Hint and Reset Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton hintButton = new JButton("Show Hint");
        JButton resetButton = new JButton("Reset Game");
        buttonPanel.add(hintButton);
        buttonPanel.add(resetButton);

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(feedbackPanel, BorderLayout.SOUTH);
        frame.add(buttonPanel, BorderLayout.EAST);

        frame.setVisible(true);

        // ActionListener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();

                if (input.isEmpty()) {
                    feedbackArea.append("Please enter a name.\n");
                    return;
                }

                if (apostles.contains(input)) {
                    if (guessedCorrectly.contains(input)) {
                        feedbackArea.append("😊 You already guessed '" + input + "'. Try another!\n");
                    } else {
                        guessedCorrectly.add(input);
                        score++;
                        feedbackArea.append("🎉 Correct! '" + input + "' is an apostle.\n");
                    }
                } else {
                    feedbackArea.append("😢 Incorrect! '" + input + "' is not an apostle. Try again!\n");
                }

                inputField.setText("");

                // Check if the user has guessed all apostles
                if (score == apostles.size()) {
                    feedbackArea.append("🏆 Congratulations! You guessed all apostles!\n");
                    submitButton.setEnabled(false);
                    inputField.setEditable(false);
                }
            }
        });

        // ActionListener for Hint Button
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                String hint;
                do {
                    hint = apostles.get(random.nextInt(apostles.size()));
                } while (guessedCorrectly.contains(hint));

                feedbackArea.append("🔍 Hint: Try '" + hint + "'!\n");
            }
        });

        // ActionListener for Reset Button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessedCorrectly.clear();
                score = 0;
                feedbackArea.setText("");
                inputField.setEditable(true);
                submitButton.setEnabled(true);
                feedbackArea.append("Game reset! Start guessing again.\n");
            }
        });
    }
}
