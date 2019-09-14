package com.bu.architecturecomp.Room;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.bu.architecturecomp.DebugX.Loggers;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private final static String TAG = "NoteDatabase Class";

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context,
                    NoteDatabase.class,"note_database.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        Loggers.show(TAG,"C","got Instance");

        return instance;

    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Loggers.show(TAG, "Callback","Oncreate");

            new PoplulateDBAsyncTask(instance).execute();
        }
    };


    private static class PoplulateDBAsyncTask extends AsyncTask<Void, Void, Void>{

        private NoteDao noteDao;

        private PoplulateDBAsyncTask(NoteDatabase noteDatabase){
            noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Loggers.show(TAG,"PopulateDBTask","background process");
            noteDao.insert(new Note("Title1","Description 1", 1));
            noteDao.insert(new Note("Title2","Description 2", 2));
            noteDao.insert(new Note("Title3","Description 3", 3));
            return null;
        }
    }
}
