package xyz.zwemunhtun.roomwordsexample.data.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import xyz.zwemunhtun.roomwordsexample.data.vo.WordVO;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<WordVO>> mAllWords;

    public WordRepository(Application application){
        WordDatabase db = WordDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<WordVO>> getAllWords() {
        return mAllWords;
    }

    public void insert(WordVO mWordVO){
        new insertAsyncTask(mWordDao).execute(mWordVO);
    }

    private static class insertAsyncTask extends AsyncTask<WordVO, Void, Void>{

        private WordDao mAsyncTaskDao;

        public insertAsyncTask(WordDao mAsyncTaskDao) {
            this.mAsyncTaskDao = mAsyncTaskDao;
        }

        @Override
        protected Void doInBackground(WordVO... wordVOS) {
            mAsyncTaskDao.insert(wordVOS[0]);
            return null;
        }
    }
}


