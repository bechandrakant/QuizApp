package ml.chandrakant.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String userAnswer1 = ""; // For storing user answer for question1.
    private String userAnswer2 = ""; // For storing user answer for question2.
    private String userAnswer3 = ""; // For storing user answer for question3.
    private String userAnswer4 = ""; // For storing user answer for question4.
    private int score; // Stores number of correct answer user got.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Takes User Input for Question 1 that have free text input, implemented using EditText.
     */
    public void userResponseQ1() {
        EditText answerText = findViewById(R.id.q1_answer);
        userAnswer1 = answerText.getText().toString().trim(); // trim() to remove spaces.
    }

    /**
     * Takes User Input for Question 2 that can have single correct answer, implemented using RadioButton.
     */
    public void userResponseQ2(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.q2_answer_1:
                if (checked) {
                    userAnswer2 = getString(R.string.q2_option1);
                }
                break;
            case R.id.q2_answer_2:
                if (checked) {
                    userAnswer2 = getString(R.string.q2_option2);
                }
                break;
            case R.id.q2_answer_3:
                if (checked) {
                    userAnswer2 = getString(R.string.q2_option3);
                }
                break;
            case R.id.q2_answer_4:
                if (checked) {
                    userAnswer2 = getString(R.string.q2_option4);
                }
                break;
        }
    }

    /**
     * Takes User Input for Question 3 that can have single correct answer, implemented using RadioButton.
     */
    public void userResponseQ3(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.q3_answer_1:
                if (checked) {
                    userAnswer3 = getString(R.string.q3_option1);
                }
                break;
            case R.id.q3_answer_2:
                if (checked) {
                    userAnswer3 = getString(R.string.q3_option2);
                }
                break;
            case R.id.q3_answer_3:
                if (checked) {
                    userAnswer3 = getString(R.string.q3_option3);
                }
                break;
            case R.id.q3_answer_4:
                if (checked) {
                    userAnswer3 = getString(R.string.q3_option4);
                }
                break;
        }
    }

    /**
     * Takes User Input for Question 4 that can have multiple correct answers, implemented using Checkboxes.
     */
    public void userResponseQ4() {
        userAnswer4 = "";
        CheckBox option1 = findViewById(R.id.q4_answer1);
        CheckBox option2 = findViewById(R.id.q4_answer2);
        CheckBox option3 = findViewById(R.id.q4_answer3);
        CheckBox option4 = findViewById(R.id.q4_answer4);
        CheckBox option5 = findViewById(R.id.q4_answer5);

        if (option1.isChecked()) {
            userAnswer4 += getString(R.string.q4_option1);
        }

        if (option2.isChecked()) {
            userAnswer4 += getString(R.string.q4_option2);
        }

        if (option3.isChecked()) {
            userAnswer4 += getString(R.string.q4_option3);
        }

        if (option4.isChecked()) {
            userAnswer4 += getString(R.string.q4_option4);
        }

        if (option5.isChecked()) {
            userAnswer4 += getString(R.string.q4_option5);
        }
    }

    /**
     * Triggered when submit button is clicked.
     */
    public void submit(View v) {
        score = 0;
        checkAnswers();

        String scoreReviewText;
        if (score == 4) {
            scoreReviewText = "Awesome! You are a true ninja!" + "\n" + "You have got " +  score + " questions right!";
        } else if (score == 3) {
            scoreReviewText = "Good Work!" + "\n" + "You have got " +  score + " questions right!";
        } else {
            scoreReviewText = "Please Take the Quiz Again!" + "\n" + "You have got " +  score + " questions right!";
        }

        // Display result via Toast.
        Toast.makeText(this, scoreReviewText, Toast.LENGTH_LONG).show();
    }

    /**
     * Checks User Answer to correct answers.
     */
    public void checkAnswers() {
        // Get Text Entry and Checkboxes as RadioButtons are automatically configured.
        userResponseQ1();
        userResponseQ4();

        // Check if user has got correct answers or not.
        if (userAnswer1.equalsIgnoreCase(getString(R.string.correctAnswer1))) {
            score++;
        }

        if (userAnswer2.equalsIgnoreCase(getString(R.string.correctAnswer2))) {
            score++;
        }

        if (userAnswer3.equalsIgnoreCase(getString(R.string.correctAnswer3))) {
            score++;
        }

        if (userAnswer4.equalsIgnoreCase(getString(R.string.correctAnswer4))) {
            score++;
        }
    }

    // Handle orientation changes
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Store RadioButton State.
        outState.putString("Answer2", userAnswer2);
        outState.putString("Answer3", userAnswer3);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Extract RadioButton State.
        userAnswer2 = savedInstanceState.getString("Answer2");
        userAnswer3 = savedInstanceState.getString("Answer3");
    }
}
