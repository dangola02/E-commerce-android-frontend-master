package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView useName , password ;
    DataBase db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        useName = (TextView) findViewById(R.id.login_userName) ;
        password = (TextView) findViewById(R.id.login_password) ;
    }

    public void insetUser(View view) {
        if(this.useName.getText().toString().isEmpty() && this.password.getText().toString().isEmpty()){
            Toast.makeText(Login.this , "Please Inter something " , Toast.LENGTH_LONG).show();

        }
        else {
            long result = db.insertData(this.useName.getText().toString() , this.password.getText().toString()) ;
            if(result != -1){
                Toast.makeText(Login.this , "Add Successfully " , Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(Login.this , "Error Happened " , Toast.LENGTH_LONG).show();
            }
        }
    }

    public void skip(View view) {
        Intent intent = new Intent(Login.this , MainActivity.class);
        startActivity(intent);
    }
}