package de.androidnewcomer.mueckenfang;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

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

    private void bildschirmAktualisieren() {
        TextView tvPunkte = findViewById(R.id.points);
        tvPunkte.setText(Integer.toString(punkte));
        TextView tvround = findViewById(R.id.round);
        tvround.setText(Integer.toString(runde));

        TextView tvTreffer = findViewById(R.id.hits);
        tvTreffer.setText(Integer.toString(gefangeneMuecken));
        TextView tvZeit = findViewById(R.id.time);
        tvZeit.setText(Integer.toString(zeit));

        FrameLayout flTreffer = findViewById(R.id.bar_hits);
        FrameLayout flZeit = findViewById(R.id.bar_timer);
    }
}
