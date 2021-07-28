package com.example.myapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.model.User;
import com.example.myapplication.data.source.local.UserDao;
import com.example.myapplication.data.source.local.UserDatabase;
import com.example.myapplication.ui.home.HomeActivity;
import com.example.myapplication.ui.signup.SignUpActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnToSignUp, btnLogin;
    TextInputLayout tilLoginEmail, tilLoginPassword;
    CheckBox checkBoxKeepLogin;
    UserDao mUserDao;
    boolean keepLogin = false;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEEP_LOGIN = "keepLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserDao = Room.databaseBuilder(this, UserDatabase.class, "user_database")
                .allowMainThreadQueries()
                .build()
                .mUserDao();

        checkBoxKeepLogin = findViewById(R.id.checkbox_keep_login);


        btnToSignUp = findViewById(R.id.btn_go_activity_sign_up);
        btnLogin = findViewById(R.id.btn_login);
        tilLoginEmail = findViewById(R.id.til_email_login);
        tilLoginPassword = findViewById(R.id.til_password_login);
        btnToSignUp.setOnClickListener(this);


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        keepLogin = sharedPreferences.getBoolean(KEEP_LOGIN, false);

        if (keepLogin) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = tilLoginEmail.getEditText().getText().toString().trim();
                String password = tilLoginPassword.getEditText().getText().toString().trim();

                User user = mUserDao.getUser(email, password);


                if (validationInputs()) {

                    if (user != null) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        boolean keepLogin = checkBoxKeepLogin.isChecked();
                        editor.putString(KEY_EMAIL, email);
                        editor.putString(KEY_PASSWORD, password);
                        editor.putBoolean(KEEP_LOGIN, keepLogin);
                        editor.apply();
                        String emailPref = sharedPreferences.getString(KEY_EMAIL, null);

                        if (emailPref != null) {
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            i.putExtra("User", user);
                            startActivity(i);
                            finish();
                        }
                    } else {
                        tilLoginPassword.setError("Digite um email válido");
                        Toast.makeText(LoginActivity.this, "Digite um email válido", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            public boolean validationInputs() {
                return !(!validationEmail() | !validationPassword());
            }

            private boolean validationEmail() {
                String email = tilLoginEmail.getEditText().getText().toString().trim();

                if (email.isEmpty()) {
                    tilLoginEmail.setError("Campo não pode ficar vazio");
                    return false;
                } else {
                    tilLoginEmail.setError(null);
                    return true;
                }

            }

            private boolean validationPassword() {
                String password = tilLoginPassword.getEditText().getText().toString().trim();

                final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");

                if (password.isEmpty()) {
                    tilLoginPassword.setError("Campo não pode ficar vazio");
                    return false;
                } else if (password.length() > 16) {
                    tilLoginPassword.setError("Muito longa");
                    return false;
                } else if (password.length() < 8) {
                    tilLoginPassword.setError("Muito curta");
                    return false;
                } else if (!textPattern.matcher(password).matches()) {
                    tilLoginPassword.setError("A senha precisa conter uma letra maiuscula,\numa letra minuscula e um numero");
                    return false;
                } else {
                    tilLoginPassword.setError(null);
                    return true;
                }

            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_go_activity_sign_up) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }

}