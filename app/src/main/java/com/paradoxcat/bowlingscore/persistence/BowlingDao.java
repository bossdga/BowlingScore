package com.paradoxcat.bowlingscore.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.paradoxcat.bowlingscore.model.Frame;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Dao to interact with the database
 */
@Dao
public interface BowlingDao {

    @Query("SELECT * FROM frame")
    Flowable<List<Frame>> getAll();

    @Query("SELECT * FROM frame WHERE id = :id")
    Flowable<Frame> findById(int id);

    @Insert
    void insertAll(Frame... frameList);

    @Insert
    void insert(Frame frame);

    @Delete
    void delete(Frame frame);

}