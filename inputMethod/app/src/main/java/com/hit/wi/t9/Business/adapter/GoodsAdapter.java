package com.hit.wi.t9.Business.adapter;



import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hit.wi.t9.Business.entity.Goods;
import com.hit.wi.t9.Business.util.ImageUtils;
import com.hit.wi.t9.R;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.List;

//一列商品的适配器类，作用是将一列商品加载进布局
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder>{
    private List<Goods> goodsList;        //一列商品
    Context context;

    //构造函数
    public GoodsAdapter(Context context, List<Goods> goodsList) {
        this.goodsList = goodsList;
        this.context=context;
    }

    //使用了ViewHolder就不用频繁的使用findViewById
    static class ViewHolder extends RecyclerView.ViewHolder {
        //一条图片的布局
        View imageView;
        ImageView image;
        TextView price;
        TextView name;
        TextView description;
       // LinearLayout goodsitem;

        public ViewHolder(View view) {
            super(view);
            // imageView = view;
            //  price=view
            image = (ImageView) view.findViewById(R.id.image);
            price=(TextView) view.findViewById(R.id.goodsprice);
            name=(TextView) view.findViewById(R.id.goodsname);
            description=(TextView) view.findViewById(R.id.goodsdescription);
           // goodsitem=(LinearLayout) view.findViewById(R.layout.goods_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将goods_item布局嵌入父布局，goods_item布局：一个商品的布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        /*图片的点击事件*/
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("保存图片").setMessage("确认保存")
                        .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int position = holder.getAdapterPosition();//获取当前item在列表中的位置
                                Goods image = goodsList.get(position);
                                //相关权限的申请 存储权限
                                try {
                                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                                            != PackageManager.PERMISSION_GRANTED
                                            || ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                            != PackageManager.PERMISSION_GRANTED) {

                                        // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
                                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                                    } else {
                                        ImageUtils.saveMyBitmap(context, ImageUtils.base64ToBitmap(image.getImage_base64()));
                                        //也可以用下面这段代码
//                                        ImageUtils.saveMyBitmap(context, ImageUtils.createViewBitmap(holder.image));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "取消保存", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });   //图片的点击事件
        return holder;
    }

    //将每个图片放入到view中，即将每个图片绑定在视图上
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Goods image = goodsList.get(position);

        holder.image.setImageBitmap(ImageUtils.base64ToBitmap(image.getImage_base64()));
        holder.name.setText(image.getName());
        holder.price.setText(image.getPrice());
        holder.description.setText(image.getDescription());
       // holder.goodsitem.setBackgroundColor(Color.parseColor("#F7F7F7"));
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }
}