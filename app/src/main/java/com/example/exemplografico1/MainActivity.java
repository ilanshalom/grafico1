package com.example.exemplografico1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MinhaView mv = new MinhaView(this); //classe derivada de View
        setContentView(mv);

        mv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()
                        ,"\nLegal! Evento click normal atendido...\n",
                        Toast.LENGTH_LONG).show();
                mv.setTipoPaint(1);
            }
        });
    }
}
