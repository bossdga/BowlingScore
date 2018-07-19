package com.paradoxcat.bowlingscore.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.paradoxcat.bowlingscore.model.Frame;
import com.paradoxcat.bowlingscore.persistence.BowlingRepository;

import java.util.List;

import io.reactivex.Flowable;

/**
 * ViewModel to interact between the view and the model
 */
public class BowlingViewModel extends AndroidViewModel {

   private BowlingRepository mRepository;

   public BowlingViewModel (Application application) {
       super(application);
       mRepository = new BowlingRepository(application);
   }

   public Flowable<List<Frame>> getAllFrames() {
       return mRepository.getAllFrames();
   }

   public void insert(Frame frame) {
       mRepository.insert(frame);
   }

   public void delete(Frame frame) {
        mRepository.delete(frame);
   }

   public Flowable<Frame> findById(int id) {
        return mRepository.findById(id);
   }

}