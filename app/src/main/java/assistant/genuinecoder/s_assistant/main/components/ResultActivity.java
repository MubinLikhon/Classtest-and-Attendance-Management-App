package assistant.genuinecoder.s_assistant.main.components;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

import assistant.genuinecoder.s_assistant.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        EditText sgpa, percentage;
        sgpa = findViewById(R.id.sgpa);
        percentage = findViewById(R.id.percentage);
        TextView t = findViewById(R.id.t);
        TextView t1 = findViewById(R.id.t3);

        try {
            Bundle b = getIntent().getExtras();
            float final_sgpa = b.getFloat("final_sgpa");
            int flag = b.getInt("flag");

            // Retrieve the "final_perc" value as Object
            Object finalPercObject = b.get("final_perc");

            // Convert the "final_perc" value to float
            float final_perc = 0.0f;
            if (finalPercObject instanceof Float) {
                final_perc = (Float) finalPercObject;
            } else if (finalPercObject instanceof Integer) {
                final_perc = ((Integer) finalPercObject).floatValue();
            }

            if (flag == 0) {
                t.setText("Summation of top 3 CT marks is: ");
                percentage.setVisibility(View.INVISIBLE);
                t1.setVisibility(View.INVISIBLE);
            }

            BigDecimal bd = new BigDecimal(final_sgpa).setScale(2, RoundingMode.HALF_EVEN);
            final_sgpa = bd.floatValue();

            BigDecimal bd1 = new BigDecimal(final_perc).setScale(2, RoundingMode.HALF_EVEN);
            final_perc = bd1.floatValue();

            sgpa.setText(String.valueOf(final_sgpa));
            percentage.setText(String.valueOf(final_perc + "%"));
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Exception Occurred", Toast.LENGTH_LONG).show();
        }
    }
}
