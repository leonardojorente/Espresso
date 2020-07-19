package com.leonardojorente.espressotests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tEmail = (TextView) findViewById(R.id.inputEmail);
                TextView tPassword = (TextView) findViewById(R.id.inputPassword);
                String email = tEmail.getText().toString();
                String password = tPassword.getText().toString();
                if(email.equals("")||password.equals("")){
                    alertEmptyFieldsMessage("Fill email and password to continue");
                    openDialogEmptyFieldsWarning();
                }
                else{
                    openSelectTestActivity();
                }
            }
        });
    }

    public void alertEmptyFieldsMessage (String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    public void openDialogEmptyFieldsWarning (){
    DialogEmptyFieldsWarning dialogEmptyFieldswarning = new DialogEmptyFieldsWarning();
        dialogEmptyFieldswarning.show(getSupportFragmentManager(), "Empty fields");
    }

    public void openSelectTestActivity (){
        Intent intent = new Intent(this,SelectTestActivity.class);

        startActivity(intent);
    }

}
