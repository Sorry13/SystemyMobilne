package com.example.zad_uno_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(true);
            }

        });

    falseButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
        checkAnswerCorrectness(false);
    }
    });

    nextButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            currentIndex = (currentIndex + 1)%questions.length;
            setNextQuestion();
        }
    });
    setNextQuestion();
}


    private void setNextQuestion() {
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }

    private Question[] questions = new Question[] {
            new Question(R.string.koty, true),
            new Question(R.string.kosmos, true),
            new Question(R.string.mnożenie, false),
            new Question(R.string.zebra, true),
            new Question(R.string.myszki, false)
    };

    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        String resultMessageId;
        if(userAnswer == correctAnswer) {
            resultMessageId = "Poprawna odpowiedź!";
        } else {
            resultMessageId = "Niepoprawna odpowiedź!";
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_LONG).show();
    }
}