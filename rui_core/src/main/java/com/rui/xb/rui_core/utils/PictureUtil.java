package com.rui.xb.rui_core.utils;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.rui.xb.rui_core.app.Rui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Rui on 2018/5/15.
 */

public class PictureUtil {

    public static final int BY_CAMERA = 200;
    public static final int BY_PHOTO = 201;
    public static final int CROP_IMAGE = 202;
    public static Uri imageUriFromCamera;
    public static Uri cropImageUri;


    public static void openCameraImage(Activity activity) {
        imageUriFromCamera = createImagePathUri(activity);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // MediaStore.EXTRA_OUTPUT参数不设置时,系统会自动生成一个uri,但是只会返回一个缩略图
        // 返回图片在onActivityResult中通过以下代码获取
        // Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriFromCamera);
        activity.startActivityForResult(intent, BY_CAMERA);
    }

    public static void openLocalImage(final Activity activity) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, BY_PHOTO);
    }


    public static void cropImage(Activity activity,Uri uri) {
        cropImageUri = createImagePathUri(activity);

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);// aspectX aspectY 是裁剪框宽高的比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 700);       // outputX outputY 是裁剪后生成图片的宽高
        intent.putExtra("outputY", 700);
        intent.putExtra("return-data", false);// return-data为true时,会直接返回bitmap数据,但是大图裁剪时会出现问题,推荐下面为false时的方式
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropImageUri); // return-data为false时,不会返回bitmap,但需要指定一个MediaStore.EXTRA_OUTPUT保存图片uri
        activity.startActivityForResult(intent, CROP_IMAGE);

    }
        ////////////////////////////////////////////////////////////////
        // 1.宽高和比例都不设置时,裁剪框可以自行调整(比例和大小都可以随意调整)
        ////////////////////////////////////////////////////////////////
        // 2.只设置裁剪框宽高比(aspect)后,裁剪框比例固定不可调整,只能调整大小
        ////////////////////////////////////////////////////////////////
        // 3.裁剪后生成图片宽高(output)的设置和裁剪框无关,只决定最终生成图片大小
        ////////////////////////////////////////////////////////////////
        // 4.裁剪框宽高比例(aspect)可以和裁剪后生成图片比例(output)不同,此时,
        //	会以裁剪框的宽为准,按照裁剪宽高比例生成一个图片,该图和框选部分可能不同,
        //  不同的情况可能是截取框选的一部分,也可能超出框选部分,向下延伸补足
        ////////////////////////////////////////////////////////////////



    /**
     * 创建一条图片地址uri,用于保存拍照后的照片
     *
     * @param context
     * @return 图片的uri
     */
    public static Uri createImagePathUri(final Context context) {
        final Uri[] imageFilePath = {null};

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            imageFilePath[0] = Uri.parse("");
            Toast.makeText(Rui.getApplicationContext(),"请先获取写入SDCard权限",Toast.LENGTH_SHORT).show();
        } else {
            String status = Environment.getExternalStorageState();
            SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
            long time = System.currentTimeMillis();
            String imageName = timeFormatter.format(new Date(time));
            // ContentValues是我们希望这条记录被创建时包含的数据信息
            ContentValues values = new ContentValues(3);
            values.put(MediaStore.Images.Media.DISPLAY_NAME, imageName);
            values.put(MediaStore.Images.Media.DATE_TAKEN, time);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");

            if (status.equals(Environment.MEDIA_MOUNTED)) {// 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
                imageFilePath[0] = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                imageFilePath[0] = context.getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, values);
            }
        }

        Log.i("", "生成的照片输出路径：" + imageFilePath[0].toString());
        return imageFilePath[0];
    }

}
