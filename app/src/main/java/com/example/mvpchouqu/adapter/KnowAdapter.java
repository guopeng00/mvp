package com.example.mvpchouqu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpchouqu.R;
import com.example.mvpchouqu.bean.StudentBean;

import java.util.ArrayList;

public class KnowAdapter extends RecyclerView.Adapter<KnowAdapter.ViewHolder> {
    private Context context;
    private ArrayList<StudentBean.StudenlistBean> mStu;


    public KnowAdapter(Context context, ArrayList<StudentBean.StudenlistBean> mStu) {
        this.context = context;
        this.mStu = mStu;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_know, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentBean.StudenlistBean studenlistBean = mStu.get(position);
        holder.tvKnowName.setText(studenlistBean.getName());
        holder.tvKnowPwd.setText(studenlistBean.getSkill());
    }

    @Override
    public int getItemCount() {
        return mStu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvKnowName;
        private TextView tvKnowPwd;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKnowName = (TextView) itemView.findViewById(R.id.tv_know_name);
            tvKnowPwd = (TextView) itemView.findViewById(R.id.tv_know_pwd);
        }
    }
}
