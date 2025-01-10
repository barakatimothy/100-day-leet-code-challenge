import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AwesomeGame{
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
        frame.setSize(400, 300);

        // Create a panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Header Label
        JLabel header = new JLabel("Guess the 12 Apostles", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(header, BorderLayout.NORTH);

        // Text field for input
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(inputField, BorderLayout.CENTER);

        // Button to submit
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(submitButton, BorderLayout.EAST);

        // Text area for feedback
        JTextArea feedbackArea = new JTextArea();
        feedbackArea.setEditable(false);
        feedbackArea.setFont(new Font("Arial", Font.PLAIN, 14));
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        panel.add(scrollPane, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        // ActionListener for the submit button
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
                        feedbackArea.append("You already guessed '" + input + "'. Try another.\n");
                    } else {
                        guessedCorrectly.add(input);
                        score++;
                        feedbackArea.append("Correct! '" + input + "' is an apostle.\n");
                    }
                } else {
                    feedbackArea.append("Incorrect! '" + input + "' is not an apostle.\n");
                }

                inputField.setText("");

                // Check if the user has guessed all apostles
                if (score == apostles.size()) {
                    feedbackArea.append("Congratulations! You've guessed all apostles!\n");
                    submitButton.setEnabled(false);
                    inputField.setEditable(false);
                }
            }
        });
    }
}
