package com.example.myapplication.ui.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.R;
import com.example.myapplication.data.model.User;
import com.example.myapplication.data.source.local.UserDao;
import com.example.myapplication.data.source.local.UserDatabase;
import com.google.android.material.textfield.TextInputLayout;

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

                if (validationInputs()) {
                    User user = new User(email, password);
                    mUserDao.insert(user);
                    Intent moveToLogin = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Senhas diferentes", Toast.LENGTH_SHORT).show();
                }
            }

            public boolean validationInputs() {
                return !(!validationEmail() | !validationPassword());
            }

            private boolean validationEmail() {
                String email = tilRegisterEmail.getEditText().getText().toString().trim();

                if (email.isEmpty()) {
                    tilRegisterEmail.setError("Campo não pode ficar vazio");
                    return false;
                } else {
                    tilRegisterEmail.setError(null);
                    return true;
                }

            }

            private boolean validationPassword() {
                String password = tilRegisterPassword.getEditText().getText().toString().trim();
                String confirmationPassword = tilRegisterPasswordConfirmation.getEditText().getText().toString().trim();

                final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");

                if (password.isEmpty()) {
                    tilRegisterPassword.setError("Campo não pode ficar vazio");
                    return false;
                } else if (confirmationPassword.isEmpty()) {
                    tilRegisterPasswordConfirmation.setError("Campo não pode ficar vazio");
                    return false;
                } else if (password.length() > 16) {
                    tilRegisterPassword.setError("Muito longa");
                    return false;
                } else if (password.length() < 8) {
                    tilRegisterPassword.setError("Muito curta");
                    return false;
                } else if (confirmationPassword.length() < 8) {
                    tilRegisterPasswordConfirmation.setError("Muito curta");
                    return false;
                } else if (confirmationPassword.length() > 16) {
                    tilRegisterPasswordConfirmation.setError("Muito longa");
                    return false;
                } else if (!confirmationPassword.equals(password)) {
                    tilRegisterPasswordConfirmation.setError("senhas incompatíveis");
                    return false;
                } else if (!textPattern.matcher(password).matches()) {
                    tilRegisterPassword.setError("A senha precisa conter uma letra maiúscula, uma letra minúscula e um número");
                    tilRegisterPassword.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);
                    return false;
                } else {
                    tilRegisterPasswordConfirmation.setError(null);
                    tilRegisterPassword.setError(null);
                    return true;
                }
            }
        });
    }

}


