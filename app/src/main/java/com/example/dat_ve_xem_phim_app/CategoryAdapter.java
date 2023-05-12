package com.example.dat_ve_xem_phim_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    List<FilmModel> array;
    Context context;

    public CategoryAdapter(List<FilmModel> array, Context context) {
        this.array = array;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_phim,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView images;
        public TextView tenSp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            images=itemView.findViewById(R.id.imagePic);
            tenSp=itemView.findViewById(R.id.textName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context,"Bạn đã chọn category"+tenSp.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position){
        FilmModel category =array.get(position);
        holder.tenSp.setText(category.getTenPhim());
        Glide.with(context)
                .load(category.getHinhAnh())
                .into(holder.images);
        ImageView imgCategory=holder.itemView.findViewById(R.id.imagePic);
        imgCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,FilmDetailActivity.class);
                context.startActivity(intent);
            }
        });
// Tạo Intent để chuyển sang Activity hiển thị danh sách sản phẩm

    }
    @Override
    public int getItemCount(){return array==null?0:array.size();}
}
