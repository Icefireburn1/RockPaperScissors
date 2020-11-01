package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_scissors, b_paper;
    TextView tv_score;
    ImageView iv_computerChoice, iv_humanChoice;

    int HumanScore, ComputerScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_paper = findViewById(R.id.btn_paper);
        b_scissors = findViewById(R.id.btn_scissors);
        b_rock = findViewById(R.id.btn_rock);

        iv_computerChoice = findViewById(R.id.iv_computerChoice);
        iv_humanChoice = findViewById(R.id.iv_humanChoice);

        tv_score = findViewById(R.id.tv_score);

        b_paper.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });
    }

    private String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();

        // choose 1 2 or 3
        int computer_choice_number = r.nextInt(3) + 1;

        if (computer_choice_number == 1) {
            computer_choice = "rock";
        }
        else if (computer_choice_number == 2) {
            computer_choice = "scissors";
        }
        else {
            computer_choice = "paper";
        }

        // Set picture
        if (computer_choice == "rock") {
            iv_computerChoice.setImageResource(R.drawable.rock);
        }
        else if (computer_choice == "paper") {
            iv_computerChoice.setImageResource(R.drawable.paper);
        }
        else {
            iv_computerChoice.setImageResource(R.drawable.scissors);
        }

        // set winner
        if (computer_choice == player_choice) {
            return "Draw. Nobody won.";
        }
        else if (player_choice == "rock" && computer_choice == "scissors") {
            HumanScore++;
            return "Rock crushes scissors. You win!";
        }
        else if (player_choice == "rock" && computer_choice == "paper") {
            ComputerScore++;
            return "Paper covers rock. Computer wins!";
        }
        else if (player_choice == "scissors" && computer_choice == "rock") {
            ComputerScore++;
            return "Rock crushes scissors. Computer wins!";
        }
        else if (player_choice == "scissors" && computer_choice == "paper") {
            HumanScore++;
            return "Scissors cuts paper. You win!";
        }
        else if (player_choice == "paper" && computer_choice == "rock") {
            HumanScore++;
            return "Paper covers rock. You win!";
        }
        else if (player_choice == "paper" && computer_choice == "scissors") {
            ComputerScore++;
            return "Scissors cuts paper. Computer wins!";
        }
        else return "Not sure";
    }
}