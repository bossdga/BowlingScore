package com.paradoxcat.bowlingscore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.paradoxcat.bowlingscore.R;
import com.paradoxcat.bowlingscore.model.Frame;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide views to RecyclerView with data from frames.
 */
public class FrameAdapter extends RecyclerView.Adapter<FrameAdapter.ViewHolder> {

    private List<Frame> frameList = new ArrayList<>();

    /**
     * Provide a reference to the type of views used (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView firstValue;
        private final TextView secondValue;
        private final TextView totalValue;

        public ViewHolder(View v, final List<Frame> frameList) {
            super(v);

            firstValue = v.findViewById(R.id.FirstValue);
            secondValue = v.findViewById(R.id.SecondValue);
            totalValue = v.findViewById(R.id.TotalValue);
        }

        TextView getFirstValue() {
            return firstValue;
        }

        TextView getSecondValue() {
            return secondValue;
        }

        TextView getTotalValue() {
            return totalValue;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param frameList List<Frame> containing the data to populate views to be used by RecyclerView.
     */
    public FrameAdapter(List<Frame> frameList, Context context) {
        this.frameList = frameList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_frame, viewGroup, false);

        return new ViewHolder(v, frameList);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final Frame frame = frameList.get(position);

        viewHolder.getFirstValue().setText(frame.getId());
        viewHolder.getSecondValue().setText(frame.getId());
        viewHolder.getTotalValue().setText(frame.getId());
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return frameList.size();
    }

}