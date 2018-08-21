package com.example.rd_softwaredeveloper.sharedpreferencedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private SharedPreferences settings;
    private static final String data = "DATA";
    private static final String nameField = "NAME";
    private static final String phoneField = "PHONE";
    private static final String sexField = "SEX";
    private EditText name , phone , sex;
    private Button save , read , clear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        setEventListener();
    }

    public void initComponent()
    {
        name = (EditText)findViewById(R.id.nameField);
        phone = (EditText)findViewById(R.id.phoneField);
        sex = (EditText)findViewById(R.id.sexField);
        save = (Button)findViewById(R.id.saveButton);
        read = (Button)findViewById(R.id.readButton);
        clear = (Button)findViewById(R.id.clearButton);
    }
    public void readData()
    {
        settings = getSharedPreferences(data,0);
        name.setText(settings.getString(nameField, ""));
        phone.setText(settings.getString(phoneField, ""));
        sex.setText(settings.getString(sexField, ""));
    }

    public void saveData()
    {
        settings = getSharedPreferences(data,0);
        settings.edit()
                .putString(nameField, name.getText().toString())
                .putString(phoneField, phone.getText().toString())
                .putString(sexField, sex.getText().toString())
                .commit();
    }

    public void setEventListener()
    {
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                saveData();
                Toast.makeText(MainActivity.this, R.string.save_success, Toast.LENGTH_SHORT).show();
            }
        });

        read.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                readData();
                Toast.makeText(MainActivity.this, R.string.read_success, Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                name.setText("");
                phone.setText("");
                sex.setText("");
            }
        });
    }
}
