package course.edu.apps.bodymassindexapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private EditText result;
    private EditText classification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (EditText) findViewById(R.id.result);
        classification  = (EditText) findViewById(R.id.classification);
    }

    public void btn_Calculate(View view) {
        String height = this.height.getText().toString();
        String weight = this.weight.getText().toString();

        if (height != null && !"".equals(height)   && weight != null  &&  !"".equals(weight)) {
            float heightValue = Float.parseFloat(height) / 100;
            float weightValue = Float.parseFloat(weight);

            float BodyMass = weightValue / (heightValue * heightValue);
            BMIClassification(BodyMass);

            result.setText(String.valueOf(BodyMass));
            classification.setText(String.valueOf(BMIClassification(BodyMass)));
    }
}
    String underweight;
    String normal;
    String overweight;
    String obese;
    public String BMIClassification(Float bmi) {
        if (bmi < 18.5) {
            return underweight;
        } else if (bmi >= 18.5 && bmi < 25) {
            return normal;
        } else if (bmi >= 25 && bmi < 30){
            return overweight;
        } else {
            return obese;
        }
    }
}
