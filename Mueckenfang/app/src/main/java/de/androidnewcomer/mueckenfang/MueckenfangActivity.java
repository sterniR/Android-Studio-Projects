package de.androidnewcomer.mueckenfang;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MueckenfangActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        spielStarten();
    }

    @Override
    public void onClick(View v) { // View.OnClickListener
        startActivity(new Intent(this, GameActivity.class));
    }
    private void spielStarten() {
        spielLaeuft = true;
        runde = 0;
        punkte = 0;
        starteRunde();
    }

    private void starteRunde() {
        runde = runde + 1;
        muecken = muecken * 10;
        gefangeneMuecken = 0;
        zeit = 60;
        bildschirmAktualisieren();
    }
}
