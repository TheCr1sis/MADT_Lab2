package com.example.madt_2_lab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edUserInput;
    private TextView tvResult;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResult = findViewById(R.id.tvResult);

        this.spinner = (Spinner) findViewById(R.id.spinCountOption);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.choose_option,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);
    }


    public void btnCountClick(View view)
    {
        String spinner_character_select = getResources().getString(R.string.spinner_character_select);
        String userInput = this.edUserInput.getText().toString().trim();

        if (userInput.isEmpty()) {
            Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show();
            return;
        }

        if (this.spinner.getSelectedItem().toString().equalsIgnoreCase(spinner_character_select))
        {

            int count = WordCounter.countCharacters(userInput);

            this.tvResult.setText(String.valueOf(count));
        }
        else
        {

            int count = WordCounter.countWords(userInput);

            this.tvResult.setText(String.valueOf(count));
        }
    }
}