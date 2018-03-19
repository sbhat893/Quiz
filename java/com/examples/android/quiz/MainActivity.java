package com.examples.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText password;
    private Button LOGIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.editText0);
        password = (EditText)findViewById(R.id.editText1);
        LOGIN = (Button) findViewById(R.id.button);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), password.getText().toString());

            }
        });
    }

    private void validate(String userName,String userPassword){
        if((userName.equals("sbhat893@gmail.com"))&&(userPassword.equals("0000")))
        {
            Intent intent=new Intent(this,quiz.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Wrong credentials",Toast.LENGTH_SHORT).show();
        }

    }
}