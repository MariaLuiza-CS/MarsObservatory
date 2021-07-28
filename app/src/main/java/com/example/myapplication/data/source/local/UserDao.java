package com.example.myapplication.data.source.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.data.model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_table WHERE userEmail=:email and userPassword=:password")
    User getUser(String email, String password);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

}
