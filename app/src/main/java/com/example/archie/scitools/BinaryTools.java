package com.example.archie.scitools;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BinaryTools extends AppCompatActivity {
    TextView convertedNatural;
    EditText inputBinaryString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_tools);

        convertedNatural = findViewById(R.id.convertedDecimalNumber);
        inputBinaryString = findViewById(R.id.inputBinary);
    }

    public void computeTransformation(View view) {
        //Hide keyboard
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        //Finish hide keyboard

        String binaryInput = inputBinaryString.getText().toString();
        Integer decimalValue = Integer.parseInt(binaryInput, 2);

        convertedNatural.setVisibility(View.VISIBLE);
        convertedNatural.setText(String.valueOf(decimalValue));
    }
}
