package com.example.myapplication.data.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.myapplication.data.model.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao mUserDao();
}
