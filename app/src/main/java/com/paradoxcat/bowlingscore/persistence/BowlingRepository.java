package com.paradoxcat.bowlingscore.persistence;

import android.app.Application;
import android.os.AsyncTask;

import com.paradoxcat.bowlingscore.model.Frame;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Repository to execute database operations
 */
public class BowlingRepository {

    private BowlingDao bowlingDao;
    private Flowable<List<Frame>> appDataList;
    private Flowable<Frame> appData;

    public BowlingRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        bowlingDao = db.bowlingDao();
    }

    public Flowable<List<Frame>> getAllFrames() {
        return this.bowlingDao.getAll();
    }

    public void insert (Frame frame) {
        new InsertFrameTask(bowlingDao).execute(frame);
    }

    public void delete (Frame frame) {
        new DeleteFrameTask(bowlingDao).execute(frame);
    }

    public Flowable<Frame> findById (int id) {
        return this.bowlingDao.findById(id);
    }

    /**
     * AsyncTask that will insert one row to the database
     */
    private class InsertFrameTask extends AsyncTask<Frame, Void, Void> {

        private BowlingDao dao;

        InsertFrameTask(BowlingDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(final Frame... params) {
            this.dao.insert(params[0]);
            return null;
        }

    }

    /**
     * AsyncTask that will delete a row from the database
     */
    private class DeleteFrameTask extends AsyncTask<Frame, Void, Void> {

        private BowlingDao dao;

        DeleteFrameTask(BowlingDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(final Frame... params) {
            this.dao.delete(params[0]);
            return null;
        }

    }

}