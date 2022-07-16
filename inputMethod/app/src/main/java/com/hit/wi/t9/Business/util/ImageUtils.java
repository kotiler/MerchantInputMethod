package com.hit.wi.t9.Business.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.hit.wi.t9.Business.entity.Goods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageUtils {
    public static Boolean isFinishedGetGoods = false;
    //public static String u_email = "123456789@qq.com";
    public static List<Goods> goods =new ArrayList<>();
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
    
    /*
     * 将图片 bitmap保存到图库
     */
    public static void saveMyBitmap(Context activity, Bitmap bitmap) {
        //设置图片名称，要保存png，后缀就是png，要保存jpg，后缀就用jpg
        String imageName = System.currentTimeMillis() + "code.png";

        File f = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(f.getPath() + "/"+imageName);//创建文件
        try {
            //文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            //压缩图片，如果要保存png，就用Bitmap.CompressFormat.PNG，要保存jpg就用Bitmap.CompressFormat.JPEG,质量是100%，表示不压缩
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            //写入，这里会卡顿，因为图片较大
            fileOutputStream.flush();
            //记得要关闭写入流
            fileOutputStream.close();
            //成功的提示，写入成功后，请在对应目录中找保存的图片
            Log.e("写入成功！位置目录", f.getPath() + "/"+imageName);
            Toast.makeText(activity, "保存成功，请您到 相册/图库 中查看", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(activity, "保存失败", Toast.LENGTH_SHORT).show();
            Log.d("状态","失败");//失败的提示
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(activity, "保存失败", Toast.LENGTH_SHORT).show();
            Log.d("状态","失败");//失败的提示
        }

        // 下面的步骤必须有，不然在相册里找不到图片，若不需要让用户知道你保存了图片，可以不写下面的代码。
        // 把文件插入到系统图库
        /*try {
            MediaStore.Images.Media.insertImage(activity.getContentResolver(),
                    file.getAbsolutePath(), imageName, null);
            Toast.makeText(activity, "保存成功，请您到 相册/图库 中查看", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(activity, "保存失败", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }*/
        // 最后通知图库更新
        activity.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.fromFile(new File(file.getPath()))));
    }

    public static Bitmap createViewBitmap(View v) {
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);
        return bitmap;
    }
}
