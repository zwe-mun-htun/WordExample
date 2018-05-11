package xyz.zwemunhtun.roomwordsexample.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.zwemunhtun.roomwordsexample.data.vo.WordVO;

@Dao
public interface WordDao {
    @Insert
    void insert(WordVO wordVO);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<WordVO>> getAllWords();

}
