package com.example.bookalot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookalot2.Database.DBHelper;

public class Register extends AppCompatActivity {
    CheckBox showchech_btn2;
    EditText password1;
    EditText Confirm_password, firstName, lastName,email;
    Button register;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        showchech_btn2=findViewById(R.id.checkBox_btn2);
        password1= (EditText) findViewById(R.id.editpassword1);
        firstName = (EditText) findViewById(R.id.editfirstName);
        lastName = (EditText) findViewById(R.id.editlastName);
        email =(EditText) findViewById(R.id.editemail);
        Confirm_password = (EditText) findViewById(R.id.Confirm_password);
        register = (Button)findViewById(R.id.btnregister2);
        DB = new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = firstName.getText().toString();
                String  lastname = lastName.getText().toString();
                String editemail = email.getText().toString();
                String password = password1.getText().toString();
                String confi = Confirm_password.getText().toString();

                if(firstname.equals("")||lastname.equals("")||editemail.equals("")||password.equals("")||confi.equals(""))
                    Toast.makeText(Register.this, "Please enter all the fields ", Toast.LENGTH_SHORT).show();

                else{
                    if(password.equals(confi)){
                        Boolean checkuser = DB.checkusername(editemail);
                        if(checkuser == false){
                            boolean insert  = DB.insertData(firstname, lastname, editemail, password);
                            if(insert == true){
                                Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register.this, "Registered failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Register.this, "user already exits ! please sgin in", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
//                if(!password.equals(confi)){
//                    Toast.makeText(Register.this,"Password does not match",Toast.LENGTH_SHORT).show();
//                }


            }
        });

        showchech_btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked2) {
                if(isChecked2){
                    //for show password
                    password1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    Confirm_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //for hide password
                    password1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    Confirm_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

    }
}