package com.android.automotivesample;

import androidx.appcompat.app.AppCompatActivity;
import android.car.Car;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{

    int button_id;
    EditText temp;
    int current_temp;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickTempCtrl(View view){
        try{
            button_id = view.getId();
            temp = findViewById(R.id.temp);
            current_temp = Integer.parseInt(temp.getText().toString());
            if (R.id.up_temp_button == button_id ){
                increace_temp();
            }
            else if (R.id.down_temp_button == button_id) {
                decreace_temp();
            }
            else{
                throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        } catch (IllegalStateException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void increace_temp(){
        current_temp++;
        temp.setEnabled(true);
        temp.setText(Integer.toString(current_temp));
        temp.setEnabled(false);
    }
    private void decreace_temp(){
        current_temp--;
        temp.setEnabled(true);
        temp.setText(Integer.toString(current_temp));
        temp.setEnabled(false);
    }
}

