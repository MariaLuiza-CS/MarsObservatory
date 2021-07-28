package com.example.myapplication.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myapplication.R;
import com.example.myapplication.data.model.User;
import com.example.myapplication.data.source.local.UserDao;
import com.example.myapplication.data.source.local.UserDatabase;
import com.example.myapplication.ui.login.LoginActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    Button btnRegister, btnToLogin;
    TextInputLayout tilRegisterEmail, tilRegisterPassword, tilRegisterPasswordConfirmation;
    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnRegister = findViewById(R.id.btn_register);
        btnToLogin = findViewById(R.id.btn_go_activity_login);

        tilRegisterEmail = findViewById(R.id.til_email_sign_up);
        tilRegisterPassword = findViewById(R.id.til_password_sign_up);
        tilRegisterPasswordConfirmation = findViewById(R.id.til_password_confirmation);

        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        mUserDao = Room.databaseBuilder(this, UserDatabase.class, "user_database")
                .allowMainThreadQueries()
                .build()
                .mUserDao();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tilRegisterEmail.getEditText().getText().toString().trim();
                String password = tilRegisterPassword.getEditText().getText().toString().trim();
                String confirmationPassword = tilRegisterPasswordConfirmation.getEditText().getText().toString().trim();

                if (validationInputs(email, password, confirmationPassword)){
                    if (confirmValidationPasswords(password, confirmationPassword)){
                        User user = new User(email, password);
                        mUserDao.insert(user);
                        Intent moveToLogin = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(moveToLogin);
                        finish();
                    }
                }
            }

            public boolean validationInputs(String email, String password, String confirmationPassword) {
                return !(!validationEmail(email) |
                        !validationPassword(password) |
                        !validationPasswordConfirmation(confirmationPassword));
            }

            public boolean confirmValidationPasswords(String password, String confirmationPassword) {
                return validationPasswords(password, confirmationPassword);
            }

            private boolean validationEmail(String email) {

                email = tilRegisterEmail.getEditText().getText().toString().trim();

                if (email.isEmpty()) {
                    tilRegisterEmail.setError(getString(R.string.til_error_email_empty));
                    return false;
                } else {
                    tilRegisterEmail.setError(null);
                    return true;
                }

            }

            private boolean validationPassword(String password) {
                password = tilRegisterPassword.getEditText().getText().toString().trim();

                if (password.isEmpty()) {
                    tilRegisterPassword.setError(getString(R.string.til_error_email_empty));
                    return false;
                } else {
                    tilRegisterPassword.setError(null);
                    return true;
                }
            }

            private boolean validationPasswordConfirmation(String passwordConfirmation) {
                passwordConfirmation = tilRegisterPasswordConfirmation.getEditText().getText().toString().trim();

                if (passwordConfirmation.isEmpty()) {
                    tilRegisterPasswordConfirmation.setError(getString(R.string.til_error_email_empty));
                    return false;
                } else {
                    tilRegisterPasswordConfirmation.setError(null);
                    return true;
                }

            }

            private boolean validationPasswords(String password, String passwordConfirmation) {
                password = tilRegisterPassword.getEditText().getText().toString().trim();
                passwordConfirmation = tilRegisterPasswordConfirmation.getEditText().getText().toString().trim();

                if (!validationFormationPassword(password)) {
                    tilRegisterPassword.setError(getString(R.string.til_error_password_inform));
                    return false;
                }else if (!passwordConfirmation.equals(password)) {
                    tilRegisterPasswordConfirmation.setError(getString(R.string.til_error_password_diferent));
                    return false;
                } else {
                    tilRegisterPasswordConfirmation.setError(null);
                    tilRegisterPassword.setError(null);
                    return true;
                }

            }

            private boolean validationFormationPassword(String password) {
                String Formationpattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
                final Pattern textPattern = Pattern.compile(Formationpattern);
                final Matcher textMatch = textPattern.matcher(password);
                return textMatch.matches();
            }

        });


    }
}




