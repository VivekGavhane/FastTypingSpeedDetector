package com.gavhane.b.vivek.fasttypinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_text, tv_result;
    EditText et_text;
    Button b_new;

    String fullstory;
    long startTime, endTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_result = (TextView) findViewById(R.id.tv_result);
        et_text = (EditText) findViewById(R.id.et_text);
        b_new = (Button) findViewById(R.id.b_new);

        fullstory = tv_text.getText().toString();

        et_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String currentStory = et_text.getText().toString();

                //start typing
                if (currentStory.length() ==1 ){
                    startTime = System.currentTimeMillis();
                    tv_result.setText("Started");
                }

                //finished typing
                if (currentStory.equals(fullstory)){
                    endTime = System.currentTimeMillis();

                    //calculate the time
                    long currentTime = ((endTime - startTime)/1000);
                    tv_result.setText("Finished in " + currentTime + "seconds!");

                    et_text.setEnabled(false);
                    et_text.clearFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_text.setEnabled(true);
                et_text.setText("");
                tv_result.setText("");
            }
        });

    }
}
