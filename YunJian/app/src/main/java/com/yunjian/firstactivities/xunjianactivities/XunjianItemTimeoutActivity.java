package com.yunjian.firstactivities.xunjianactivities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xuexiang.xui.widget.popupwindow.popup.XUISimplePopup;
import com.xuexiang.xutil.display.DensityUtils;
import com.yunjian.BaseActivity;
import com.yunjian.R;
import com.yunjian.entity.XunjianItemEntity;

import java.io.File;

import data.DataProvider;
import pub.devrel.easypermissions.EasyPermissions;
import utils.XToastUtils;
import utils.GetPhotoFromPhotoAlbumUtils;

/**
 * @author 吴立柳
 * @package com.yunjian
 * @date on 2020/9/6
 * @describe 巡检页面 --列表展示
 */
public class XunjianItemTimeoutActivity extends BaseActivity implements View.OnClickListener {
    /**
     * The Xunjianitem name.
     */
    TextView xunjianitem_name, /**
     * The Xunjianitem method.
     */
    xunjianitem_method, /**
     * The Xunjianitem standard.
     */
    xunjianitem_standard, /**
     * The Xunjianitem xiang.
     */
    xunjianitem_xiang;
    /**
     * The Intent.
     */
    Intent intent,intent1;

    RadioGroup radioGroup;
    ImageView xunjian_imageView;
    /**
     * 简单弹出窗
     */
    private XUISimplePopup mListPopup;

    File cameraSavePath;//拍照照片路径
    private Uri uri;
    private String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private XunjianItemEntity xunjianItemEntity;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xunjian_item_finish);
        init();
        intent = getIntent();
        xunjianItemEntity = (XunjianItemEntity) getIntent().getSerializableExtra("listentity");
        //position似乎也不需要
        position = intent.getIntExtra("position", 0);
        changetext();
        //照片存储路径
        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");
    }

    /**
     * 初始化
     */
    private void init(){
        xunjianitem_name = findViewById(R.id.txt_xunjianitem_name);
        xunjianitem_method = findViewById(R.id.txt_xunjianitem_fangfa);
        xunjianitem_standard = findViewById(R.id.txt_xunjianitem_standard);
        xunjianitem_xiang = findViewById(R.id.txt_xunjianitem_xiang);
        findViewById(R.id.xunjian_item_submit).setOnClickListener(this);
        findViewById(R.id.xunjian_item_save).setOnClickListener(this);
        findViewById(R.id.xunjian_item_return).setOnClickListener(this);
        findViewById(R.id.xunjian_camera).setOnClickListener(this);
        radioGroup = findViewById(R.id.xunjian_radioGroup);
        xunjian_imageView = findViewById(R.id.xunjian_imageView);
        mListPopup = new XUISimplePopup(XunjianItemTimeoutActivity.this, DataProvider.dpiItems)
                .create(DensityUtils.dip2px(XunjianItemTimeoutActivity.this, 170), (adapter, item, position) -> {
                    switch (item.getTitle().toString()){
                        case "系统相册":{
                            //调用系统相册
                            getPermission();
                            goPhotoAlbum();
                            break;
                        }
                        //调用相机
                        case "相机":{
                            getPermission();
                            goCamera();
                            break;
                        }
                    }
                })
        .setHasDivider(true);
    }

    /**
     * 列表信息更改
     */
    private void changetext(){
            xunjianitem_name.setText(xunjianItemEntity.getName());
            xunjianitem_method.setText(xunjianItemEntity.getMethod());
            xunjianitem_standard.setText(xunjianItemEntity.getStandard());
            xunjianitem_xiang.setText(xunjianItemEntity.getItems());
    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        int btnID = view.getId();
        //根据ID判断点击按钮
        switch (btnID){
            //提交
            case R.id.xunjian_item_submit:{
                AlertDialog.Builder builder = new AlertDialog.Builder(XunjianItemTimeoutActivity.this);
                builder.setTitle("提交");
                builder.setMessage("您确定提交内容吗?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //判断合格选项框
                        //没有选合格或者不合格
                        if(isNull()){
                            XToastUtils.toast("请选择任务合格或者不合格");
                        }
                        else{
                            XToastUtils.toast("此处进行数据提交");
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                break;
            }
            case R.id.xunjian_item_save:{
                XToastUtils.toast("此处进行数据保存");
                break;
            }
            case R.id.xunjian_item_return:{
                finish();
                break;
            }
            //图片点击,系统图片
            case R.id.xunjian_camera:{
                //实现弹窗选项
                mListPopup.showDown(view);
                break;
            }
        }
    }




    /**
     * 判断是否有选中合格或者不合格
     * @return
     */
    private boolean isNull(){
        for(int i=0;i<radioGroup.getChildCount();i++){
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            if(radioButton.isChecked()){
                return false;
            }
        }
        return true;
    }

    /**
     * 激活相册
     */
    private void goPhotoAlbum() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    /**
     * 激活相机
     */
    private void goCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(XunjianItemTimeoutActivity.this, "com.yunjian.fileprovider", cameraSavePath);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(cameraSavePath);
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        XunjianItemTimeoutActivity.this.startActivityForResult(intent, 1);
    }
    /**
     * 获取权限
     */
    private void getPermission() {
        if (EasyPermissions.hasPermissions(this, permissions)) {

        } else {
            //没有打开相关权限、申请权限
            EasyPermissions.requestPermissions(this, "需要获取您的相册、照相使用权限", 1, permissions);
        }

    }

    /**
     * 重写框架方法
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //框架要求必须这么写
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 系统图片调用返回
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String photoPath;
        if (requestCode == 1 && resultCode == RESULT_OK) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                photoPath = String.valueOf(cameraSavePath);
            } else {
                photoPath = uri.getEncodedPath();
            }
            Log.d("拍照返回图片路径:", photoPath);
            //后面再改一下用GridView显示多张图片
            Glide.with(XunjianItemTimeoutActivity.this).load(photoPath).into(xunjian_imageView);
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            photoPath = GetPhotoFromPhotoAlbumUtils.getRealPathFromUri(this, data.getData());
            Glide.with(XunjianItemTimeoutActivity.this).load(photoPath).into(xunjian_imageView);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}