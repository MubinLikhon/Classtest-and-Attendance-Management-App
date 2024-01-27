package assistant.genuinecoder.s_assistant.main.components;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

import assistant.genuinecoder.s_assistant.R;

public class CtActivity extends AppCompatActivity {

    EditText c1, c2, c3, c4, c5;
    Button b3;
    float sg1, sg2, sg3, sg4, sg5, cg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        b3 = findViewById(R.id.b3);

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sg1 = read(c1);
                sg2 = read(c2);
                sg3 = read(c3);
                sg4 = read(c4);
                sg5 = read(c5);
                float[] marks = {sg1, sg2, sg3, sg4, sg5};
                Arrays.sort(marks);
                cg = (marks[2] + marks[3] + marks[4]);

                if ((sg1 > 20.0) || sg2 > 20.0 || sg3 > 20.0 || sg4 > 20.0 || sg5 > 20.0) {
                    Toast.makeText(getApplicationContext(), " Invalid CT Marks", Toast.LENGTH_SHORT).show();
                } else {

                    Intent i3 = new Intent(getApplicationContext(), ResultActivity.class);
                    i3.putExtra("final_sgpa", cg);
                    i3.putExtra("flag", 0);
                    i3.putExtra("final_perc", 0);
                    startActivity(i3);

                }

            }


        });

    }


    private float read(EditText c) {
        if (c.getText().toString().matches("")) {
            return 0;

        } else {
            return (Float.valueOf(c.getText().toString()).floatValue());
        }
    }

}




















