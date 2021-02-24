package com.joe.taipeijourney.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joe.taipeijourney.R;
import com.joe.taipeijourney.databinding.JourneyItemViewBinding;
import com.joe.taipeijourney.model.JourneyResultsBean;

import java.util.ArrayList;

/**
 * author: Joe Cheng
 */
public class JourneyInfoListAdapter extends RecyclerView.Adapter<JourneyInfoListAdapter.JourneyViewHolder>{
    Context context;
    ArrayList<JourneyResultsBean> alJourneyBean;
    JourneyItemViewBinding journeyItemViewBinding;

    public JourneyInfoListAdapter(Context context, ArrayList<JourneyResultsBean> alJourneyBean) {
        this.context = context;
        this.alJourneyBean = alJourneyBean;
    }

    @NonNull
    @Override
    public JourneyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        journeyItemViewBinding = JourneyItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new JourneyViewHolder(journeyItemViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull JourneyViewHolder holder, int position) {
        holder.jbinding.tvName.setText(alJourneyBean.get(position).getStitle());
        holder.jbinding.tvAddress.setText(alJourneyBean.get(position).getInfo());
        holder.jbinding.tvTag.setText(alJourneyBean.get(position).getXbody());
    }

    @Override
    public int getItemCount() {
        return alJourneyBean.size();
    }

    class JourneyViewHolder extends RecyclerView.ViewHolder
    {
        JourneyItemViewBinding jbinding;
        public JourneyViewHolder(@NonNull JourneyItemViewBinding itemView) {
            super(itemView.getRoot());
            jbinding = itemView;
        }
    }

}
