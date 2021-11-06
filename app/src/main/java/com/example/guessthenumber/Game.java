package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity implements ResultDialog.ResultDialogListener{
    EditText numberText;
    Button checkBtn;
    Random random;
    ResultDialog result;
    public int computerInput,userInput;
    public static int attempt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        numberText=findViewById(R.id.number);
        checkBtn=findViewById(R.id.checkNumber);
        random=new Random();
        computerInput=random.nextInt(100);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(numberText.getText().toString().isEmpty())) {
                    attempt++;
                    try {
                        userInput = Integer.parseInt(numberText.getText().toString());
                        if(userInput>100){
                            Toast.makeText(Game.this, "Enter a number between 1 and 100", Toast.LENGTH_SHORT).show();
                        }
                        else if (userInput == computerInput) {
                            Toast.makeText(Game.this, numberText.getText().toString(), Toast.LENGTH_SHORT).show();
                            openResultDialog();
                        }
                        else if (userInput > computerInput)
                            Toast.makeText(Game.this, "Number is greater", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Game.this, "Number is less than the computer one", Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        Toast.makeText(Game.this, "Enter a number between 1 and 100", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(Game.this, "Enter a number", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openResultDialog(){
        result=new ResultDialog();
        result.show(getSupportFragmentManager(),"Finished");
    }

    public void onOkClick() {
        Game.attempt=0;
        Intent i=new Intent(Game.this,MainActivity.class);
        startActivity(i);
    }
}