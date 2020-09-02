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

    @Query("SELECT * FROM DafLearning1 WHERE indexTypeOfStudy = :typeOfStudy")
    List<DafLearning1> getAllLearning(int typeOfStudy);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllLearning(Collection<DafLearning1> AllLearning);

    @Query("UPDATE DafLearning1 SET isLearning = :isLearning WHERE masechet = :masechet and pageNumber = :page")
    void updateIsLearning(boolean isLearning , String masechet , int page);

    @Query("UPDATE DafLearning1 SET chazara = :chazara WHERE masechet = :masechet and pageNumber = :page")
    void updateNumOfChazara(int chazara , String masechet , int page);

    @Query("DELETE FROM DafLearning1")
    void deleteAll();

    @Query("SELECT DISTINCT indexTypeOfStudy FROM DafLearning1")
    List<Integer> getAllIndexTypeOfLeaning();

    @Query("DELETE FROM DafLearning1 WHERE indexTypeOfStudy = :typeOfLeaning and isLearning = 0")
    void deleteTypeOfLeaning(int typeOfLeaning);

    @Query("UPDATE DafLearning1 SET indexTypeOfStudy = 0 WHERE indexTypeOfStudy = :typeOfLeaning and isLearning = 1")
    void updateDeletedLeaning(int typeOfLeaning);

    @Query("UPDATE DafLearning1 SET indexTypeOfStudy = :typeOfLeaning-1 WHERE indexTypeOfStudy = :typeOfLeaning")
    void updateIndexTypeOfStudy(int typeOfLeaning);
}
