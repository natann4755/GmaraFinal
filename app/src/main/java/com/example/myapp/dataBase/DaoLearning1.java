package com.example.myapp.dataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.model.DafLearning1;

import java.util.Collection;
import java.util.List;

@Dao
public interface DaoLearning1 {
    @Query("SELECT * FROM DafLearning1")
    List<DafLearning1> getAllLearning();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllLearning(Collection<DafLearning1> AllLearning);

    @Query("UPDATE DafLearning1 SET isLearning = :isLearning WHERE masechet = :masechet and pageNumber = :page")
    void updateIsLearning(boolean isLearning , String masechet , int page);

    @Query("UPDATE DafLearning1 SET chazara = :chazara WHERE masechet = :masechet and pageNumber = :page")
    void updateNumOfChazara(int chazara , String masechet , int page);

    @Query("DELETE FROM DafLearning1")
    void deleteAll();
}
