package ahudon.cs395f22.com.ahudontemperatureconverter;
/*
 * Application Title:DSAss03A_Hudona
 * Author: Aaron Hudon
 * Keene State College Computer Science
 * Date: September 2022
 * Purpose: Prompts for user input of a temperature and to select a radio button option to convert temp
 *
 * 
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button rsltBtn,againBtn;
    TextView showResult;
    EditText getVal;
    RadioButton c2f,c2k,f2c,f2k,k2f,k2c;
    Double x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rsltBtn = findViewById(R.id.rsltBtn);
        showResult = findViewById(R.id.showResult);
        getVal = findViewById(R.id.getVal);
        c2f = findViewById(R.id.c2f);
        c2k = findViewById(R.id.c2k);

        f2c = findViewById(R.id.f2c);
        f2k = findViewById(R.id.f2k);

        k2c = findViewById(R.id.k2c);
        k2f = findViewById(R.id.k2f);

        againBtn = findViewById(R.id.againBtn);
// this allows user to enter a value and display results from onClick action of rsltBtn
        rsltBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(getVal.getText().toString().isEmpty()) {
                    showResult.setText("Please enter temperature");
                }
                else{
                    x = Double.parseDouble(String.valueOf(getVal.getText()));

                    if(c2f.isChecked()){
                        //equation to convert celsius to fahrenheit
                        x= (x*9/5)+32;
                        //sets the format for each displayed value
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        //displays a string with the results and explanation
                        showResult.setText(String.valueOf(x) + " Degrees F"+ "\n" +
                                "which is calculated by: (°C × 9/5) + 32 ");
                    } // end of nested if
                    else if (f2c.isChecked()){
                        //equation to convert fahrenheit to celsius
                        x = (x-32) * 5/9;
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        //displays a string with the results and explanation
                        showResult.setText(String.valueOf(x) + " Degrees C"+ "\n" +
                                "which is calculated by: (°F − 32) × 5/9");
                    } // end of else if
                    else if(f2k.isChecked()){
                        //equation to convert fahrenheit to kelvin
                        x = (x - 32) * 5/9 + 273.15;
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        //displays a string with the results and explanation
                        showResult.setText(String.valueOf(x) + " K"+ "\n" +
                                "which is calculated by:\n(°F − 32) × 5/9 + 273.15");

                    }// end of else if
                    else if(k2c.isChecked()){
                        //equation to convert fahrenheit to kelvin
                        x = (x - 273.15);
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        //displays a string with the results and explanation
                        showResult.setText(String.valueOf(x) + " Degrees C"+ "\n" +
                                "which is calculated by: (K − 273.15)");
                    }// end of else if
                    else if(c2k.isChecked()){
                        //equation to convert fahrenheit to kelvin
                        x = (x + 273.15) ;
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        //displays a string with the results and explanation
                        showResult.setText(String.valueOf(x) + " K"+ "\n" +
                                "which is calculated by: (°C + 273.15)");

                    }// end of else if

                    else if(k2f.isChecked()){
                        //equation to convert fahrenheit to kelvin
                        x = (x - 32) * 5/9 + 273.15;
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        //displays a string with the results and explanation
                        showResult.setText(String.valueOf(x) + " Degrees F"+ "\n" +
                                "which is calculated by: (K − 273.15) × 9/5 + 32");

                    }// end of else if
                    // if nothing is selected prompt user for option
                    else{
                        showResult.setText("PLease select an option");
                    } //end of final else
                } //end of outer else

            } // end of onClick(View v)
        }); // end of rsltBtn.setOnClickListener()

        // this allows user to click againBtn to reset and clear input and output
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult.setText("0.0");
                getVal.setText("");
                f2c.setChecked(true);
                c2f.setChecked(false);
                c2k.setChecked(false);
                f2k.setChecked(false);
                k2c.setChecked(false);
                k2f.setChecked(false);
            } // end of onClick(View v)
        }); // end of againBtn.setOnClickListener
    } // end of onCreate method
} // end of MainActivity class