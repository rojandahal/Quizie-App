package com.rojanprod.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonTrue;
    private Button buttonFalse;
    private TextView questionView;
    private ImageButton nextButton;
    private int currentState=0;
    private TextView answerInfo;

    private Questions[] questions = new Questions[]{
            new Questions(R.string.question_name,true),
            new Questions(R.string.question_born,false),
            new Questions(R.string.question_live,true),
            new Questions(R.string.question_study,false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTrue = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        answerInfo = findViewById(R.id.answer);
        buttonFalse = findViewById(R.id.false_button);
        questionView = findViewById(R.id.questionText);

        //The code below will register the two buttons to onClick listener by implementing the onClickListener to the MainActivity
        //This can also be done to setOnClickListener to multiple buttons without writing different methods for different buttons
       buttonTrue.setOnClickListener(this);
       buttonFalse.setOnClickListener(this);
       nextButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){         //This will get the ID as the value for switch

            case R.id.true_button:
                //True text toast shows up when the true button is pressed
                Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
                checkAnswer(true);
                break;

            case R.id.false_button:
                //False text toast shows up when the false button is pressed
                Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_SHORT).show();
                checkAnswer(false);
                break;

            case R.id.next_button:
                //This case gets the next button operation to choose next question either by answering or just skipping
                nextButton();
        }
    }

    private void nextButton(){  //This function will set the text view to next question Id represented by the current state integer

        answerInfo.setText("");
        currentState = (currentState+1)%questions.length;
        Log.d("Next","Current State Question: " + currentState);
        questionView.setText(questions[currentState].getQuestionId());
    }

    /*  This function checks whether the answer provided by the user matches the answerId of the question or not
        if yes then the text field is set to a string as correct if no then another string as Wrong answer\

        Example: Is your name Rojan Dahal? --> this question has a answer set to "true" : so if the user press "true" then userAnswer==true
        It's correct answer --> this is displayed in the text view and : if the user press "false" then
        Sorry It's wrong answer --> this is displayed in the text view

     */
    private void checkAnswer(boolean userAnswer){

        if(questions[currentState].getAnswerID()==userAnswer)
        {
            answerInfo.setText(R.string.correct_answer);
        }else
            answerInfo.setText(R.string.wrong_answer);
    }
}
