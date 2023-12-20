package com.istef.truecitizenquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.istef.truecitizenquiz.R;
import com.istef.truecitizenquiz.model.Question;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTrue;
    private Button btnFalse;
    private ImageButton btnNext;
    private ImageButton btnPrev;
    private TextView txtQuestion;
    private int currentQuestionIndex;

    private Question[] questions = {
            new Question(R.string.qf_1, false),
            new Question(R.string.qf_2, false),
            new Question(R.string.qt_3, true),
            new Question(R.string.qt_4, true),
            new Question(R.string.qf_5, false),
            new Question(R.string.qf_6, false),
            new Question(R.string.qt_7, true),
            new Question(R.string.qf_8, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrue = findViewById(R.id.buttonTrue);
        btnFalse = findViewById(R.id.buttonFalse);
        btnNext = findViewById(R.id.buttonNext);
        btnPrev = findViewById(R.id.buttonPrev);
        txtQuestion = findViewById(R.id.questionTxt);
        txtQuestion.setText(questions[currentQuestionIndex].getTextId());

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTrue:
                checkAnswer(true);
                break;
            case R.id.buttonFalse:
                checkAnswer(false);
                break;
            case R.id.buttonNext:
                updateQuestion(true);
                break;
            case R.id.buttonPrev:
                updateQuestion(false);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void checkAnswer(boolean answer) {
        int messageId = questions[currentQuestionIndex].isCorrect() == answer
                ? R.string.correct_answer : R.string.incorrect_answer;
        Toast.makeText(getApplicationContext(), messageId, Toast.LENGTH_SHORT)
                .show();
    }
    private void updateQuestion(boolean forward) {
        int index = forward ? ++currentQuestionIndex : --currentQuestionIndex;
        if (index < 0 ) index += questions.length;
        txtQuestion.setText(questions[index % questions.length].getTextId());
    }
}