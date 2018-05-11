package xyz.zwemunhtun.roomwordsexample.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class WordVO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public WordVO(@NonNull String word) {
        this.mWord = word;}

    public String getWord(){return this.mWord;}
}
