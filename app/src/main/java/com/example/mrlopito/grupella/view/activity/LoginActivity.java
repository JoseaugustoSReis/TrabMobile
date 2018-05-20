package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmailUser;
    private EditText edtPassUser;
    private Button btnPassUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmailUser = findViewById(R.id.edtEmail);
        edtPassUser = findViewById(R.id.edtSenha);
        btnPassUser = findViewById(R.id.btnLogin);
    }

    /*A login provosory method*/
    public void loginProvisorio(View v){
        if(edtEmailUser.getText().equals("dev@dev.com") && edtPassUser.getText().equals("admin"))
            startActivity(new Intent(this, MainActivity.class));
        else
            toastAlert("Usuário não autorizado!");
    }
    public void toastAlert(String textToAlert){
        if(textToAlert!=null || textToAlert.equals(""))
            Toast.makeText(LoginActivity.this, textToAlert, Toast.LENGTH_SHORT);
    }
}
