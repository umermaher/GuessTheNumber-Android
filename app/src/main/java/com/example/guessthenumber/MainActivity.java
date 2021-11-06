package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements InfoDialog.InfoDialogListener {
    Button start;
    InfoDialog info=new InfoDialog();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
    public void openDialog(){
        info=new InfoDialog();
        info.show(getSupportFragmentManager(),"Information");
    }

    @Override
    public void onOkClick() {
        Intent i=new Intent(MainActivity.this,Game.class);
        startActivity(i);
    }
}