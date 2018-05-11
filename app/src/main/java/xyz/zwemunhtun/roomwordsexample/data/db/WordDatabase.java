package xyz.zwemunhtun.roomwordsexample.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import xyz.zwemunhtun.roomwordsexample.data.vo.WordVO;

@Database(entities = {WordVO.class}, version = 1)
public abstract class WordDatabase  extends RoomDatabase{

    public abstract WordDao wordDao();

    private static WordDatabase INSTANCE;

    static WordDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        PopulateDbAsync(WordDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll();

            WordVO word = new WordVO("Hello");
            mDao.insert(word);
            word = new WordVO("World");
            mDao.insert(word);
            return null;
        }
    }
}
