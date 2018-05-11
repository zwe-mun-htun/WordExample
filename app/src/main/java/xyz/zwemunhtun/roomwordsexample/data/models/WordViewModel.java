package xyz.zwemunhtun.roomwordsexample.data.models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import xyz.zwemunhtun.roomwordsexample.data.db.WordRepository;
import xyz.zwemunhtun.roomwordsexample.data.vo.WordVO;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<WordVO>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<WordVO>> getAllWords() {
        return mAllWords;
    }

    public void insert(WordVO mWordVO){ mRepository.insert(mWordVO);}
}
