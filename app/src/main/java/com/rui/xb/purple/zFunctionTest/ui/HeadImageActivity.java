package com.rui.xb.purple.zFunctionTest.ui;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rui.xb.purple.R;
import com.rui.xb.rui_core.ui.widget.view.DialogForChooseAvatar;
import com.rui.xb.rui_core.utils.PictureUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class HeadImageActivity extends AppCompatActivity {


    @BindView(R.id.iv_head)
    ImageView imgHead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_image);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_head_click)
    void click(){
        HeadImageActivityPermissionsDispatcher.startCameraWithPermissionCheck(this);

    }

    @NeedsPermission({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void startCamera(){
        DialogForChooseAvatar dialog = new DialogForChooseAvatar(this);
        dialog.show();
    }

    @OnPermissionDenied({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void denied() {
        Toast.makeText(this, "请提供操作权限", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void notAsk() {
        Toast.makeText(this, "请提供操作权限", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        HeadImageActivityPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureUtil.BY_CAMERA:
                if (resultCode == RESULT_OK){
                    PictureUtil.cropImage(this,PictureUtil.imageUriFromCamera);
                }
                break;
            case PictureUtil.BY_PHOTO:
                if (resultCode == RESULT_OK) {
                    PictureUtil.cropImage(this,data.getData());
                }
                break;
            case PictureUtil.CROP_IMAGE:
                if (resultCode == RESULT_OK) {
                    Glide.with(this)
                            .load(PictureUtil.cropImageUri)
                            .into(imgHead);
                }
        }
    }
}
