package com.paradoxcat.bowlingscore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paradoxcat.bowlingscore.R;
import com.paradoxcat.bowlingscore.adapter.FrameAdapter;
import com.paradoxcat.bowlingscore.model.BallThrow;
import com.paradoxcat.bowlingscore.model.BowlingGame;
import com.paradoxcat.bowlingscore.model.Frame;

import java.util.List;
import java.util.Random;

/**
 * Fragment that will show a list of blacklisted apps, add new apps to the black list and start/stop
 * a background service to check which app is on the foreground
 */
public class MainFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FrameAdapter adapter;

    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        setHasOptionsMenu(true);

        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        startBowlingGame();

        return rootView;
    }

    public void startBowlingGame() {
        BowlingGame bowlingGame = new BowlingGame();
        for (int i = 0; i < 10; i++) {
            BallThrow firstBallThrow = new BallThrow(getThrowNumber());
            BallThrow secondBallThrow = new BallThrow(getThrowNumber());

            if(i < 9) {
                if (firstBallThrow.getValue() == 10) {
                    //It is a strike frame
                    bowlingGame.strikeFrame();
                } else if (firstBallThrow.getValue() + secondBallThrow.getValue() == 10) {
                    //It is a spare frame
                    bowlingGame.spareFrame(firstBallThrow, secondBallThrow);
                } else {
                    // It is an open frame
                    bowlingGame.openFrame(firstBallThrow, secondBallThrow);
                }
            } else {
                //It is the last frame, we need to check if it is a strike, spare or open
                if (firstBallThrow.getValue() == 10) {
                    //It is a strike frame
                    bowlingGame.strikeFrame();
                    bowlingGame.extraThrow(firstBallThrow.getValue());
                    bowlingGame.extraThrow(secondBallThrow.getValue());
                } else if (firstBallThrow.getValue() + secondBallThrow.getValue() == 10) {
                    //It is a spare frame
                    bowlingGame.spareFrame(firstBallThrow, secondBallThrow);
                    bowlingGame.extraThrow(firstBallThrow.getValue());
                } else {
                    // It is an open frame
                    bowlingGame.openFrame(firstBallThrow, secondBallThrow);
                }
            }
        }

        adapter = new FrameAdapter(bowlingGame.getFrames(), MainFragment.this.getActivity());
        mRecyclerView.setAdapter(adapter);

        System.out.println("::: " + bowlingGame.getScore());
    }

    private int getThrowNumber() {
        Random random = new Random();

        return random.nextInt(11);
    }

}