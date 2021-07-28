package com.example.myapplication.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ui.home.adapter.ListMoviesAdapter;
import com.example.myapplication.ui.home.presenter.ListMarsContract;
import com.example.myapplication.ui.home.presenter.ListMarsPresenter;
import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.R;
import com.example.myapplication.data.model.MarsData;
import com.example.myapplication.data.model.User;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements ListMarsContract.ListMarsView {

    private ListMoviesAdapter mListMoviesAdapter;
    TextView tvEmailFinal;
    Button btnDisconnect;
    private ListMarsContract.ListMarsPresenter presenter;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvEmailFinal = findViewById(R.id.tv_home_email);
        btnDisconnect = findViewById(R.id.btn_disconnect);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        setAdapter();
        presenter = new ListMarsPresenter(this);
        presenter.getMarsInformation();

        String emailUser = sharedPreferences.getString(KEY_EMAIL,null);

        if (emailUser != null) {
            tvEmailFinal.setText("Olá,  " + emailUser);
        }


        btnDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setAdapter() {
        RecyclerView rvListMovie = findViewById(R.id.rv_list_movie);

        mListMoviesAdapter = new ListMoviesAdapter();
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        rvListMovie.setLayoutManager(gridLayoutManager);
        rvListMovie.setAdapter(mListMoviesAdapter);
    }

    @Override
    public void showMarsInformation(List<MarsData> marsData) {
        mListMoviesAdapter.setMarsItem(marsData);
    }

    @Override
    public void showApiError() {
        Toast.makeText(this, "Erro ao obter informações da sonda", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }
}