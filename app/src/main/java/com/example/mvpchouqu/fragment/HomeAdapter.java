package com.example.mvpchouqu.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvpchouqu.R;
import com.example.mvpchouqu.bean.ListBean;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListBean.NewsBean> mList;

    public HomeAdapter(Context context, ArrayList<ListBean.NewsBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListBean.NewsBean newsBean = mList.get(position);
        holder.tvHomeName.setText(newsBean.getTile());
        Glide.with(context).load(newsBean.getImageUrl()).into(holder.ivHomeImg);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHomeImg;
        private TextView tvHomeName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeImg = (ImageView) itemView.findViewById(R.id.iv_home_img);
            tvHomeName = (TextView) itemView.findViewById(R.id.tv_home_name);
        }
    }
}
