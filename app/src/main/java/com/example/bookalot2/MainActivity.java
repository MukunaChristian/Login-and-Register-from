package com.example.bookalot2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookalot2.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CheckBox showchech_btn;
    EditText password , email;
    private TextView register;
    Button btbnLogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        showchech_btn=findViewById(R.id.checkBox_btn);
        password=findViewById(R.id.password1);
        email = findViewById(R.id.email1);
        btbnLogin = findViewById(R.id.btnlogin);
        DB = new DBHelper(this);

        btbnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editemail = email.getText().toString();
                String editpassword = password.getText().toString();

                if(editemail.equals("") || editpassword.equals(""))
                    Toast.makeText(MainActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(editemail, editpassword);
                    if (checkuserpass == true){
                        Toast.makeText(MainActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), homeBuy.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        showchech_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    //for show password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //for hide password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        register = findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.Register:
                        startActivity(new Intent(MainActivity.this, Register.class));
                        break;
                }

            }
        });
    }


}