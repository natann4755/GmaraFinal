package com.example.myapp.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.model.DafLearning1;

@Database(entities = {DafLearning1.class}, version = 3,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "DataBaseLearning";
    static AppDataBase INSTANCE;
    public abstract DaoLearning1 daoLearning1();
//    public abstract DaoLearning2 daoLearning2();
//    public abstract DaoLearning3 daoLearning3();
    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }





}

