package com.yunjian;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.xuexiang.xui.widget.popupwindow.popup.XUISimplePopup;
import com.xuexiang.xutil.display.DensityUtils;
import com.yunjian.adapters.currentxunjianadapters.CurrentXunjianXiangAdapter;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.currentxunjian.CurrentXunjianDetailResponse;
import com.yunjian.entity.currentxunjian.CurrentXunjianResponse;

import java.io.File;
import java.util.HashMap;

import data.DataProvider;
import pub.devrel.easypermissions.EasyPermissions;
import utils.GetPhotoFromPhotoAlbumUtils;
import utils.XToastUtils;

/**
 * @author 吴立柳
 * @package com.yunjian
 * @date on 2020/9/6
 * @describe 巡检页面 --列表展示
 */
public class XunjianItemCurrentActivity extends BaseActivity implements View.OnClickListener {
    /**
     * The Xunjianitem name.
     */
    TextView xunjianitem_name;

    Intent intent;

//    第一层recycleview----检验项
    private RecyclerView recyclerView_Jianyanxiang;


//    File cameraSavePath;//拍照照片路径
//    private Uri uri;
//    private String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xunjian_item_current);
        init();
        intent = getIntent();
        id = getIntent().getIntExtra("id",0);

        //数据请求
        getCunrrentXunjianDetail(id);

        //照片存储路径
//        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");
    }

    /**
     * 初始化
     */
    private void init(){
        xunjianitem_name = findViewById(R.id.xunjian_current_detail_name);
//        初始化recycleview
        recyclerView_Jianyanxiang = findViewById(R.id.xunjian_current_jianyanxiang_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_Jianyanxiang.setLayoutManager(linearLayoutManager);
//        配置适配器

//        findViewById(R.id.xunjian_camera).setOnClickListener(this);
//        radioGroup = findViewById(R.id.xunjian_radioGroup);
//        xunjian_imageView = findViewById(R.id.xunjian_imageView);
//        mListPopup = new XUISimplePopup(XunjianItemCurrentActivity.this, DataProvider.dpiItems)
//                .create(DensityUtils.dip2px(XunjianItemCurrentActivity.this, 170), (adapter, item, position) -> {
//                    switch (item.getTitle().toString()){
//                        case "系统相册":{
//                            //调用系统相册
//                            getPermission();
//                            goPhotoAlbum();
//                            break;
//                        }
//                        //调用相机
//                        case "相机":{
//                            getPermission();
//                            goCamera();
//                            break;
//                        }
//                    }
//                })
//        .setHasDivider(true);
    }

    /**
     * 列表信息更改
     */
    private void changeUI(String res){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    转为实体类
                    CurrentXunjianDetailResponse response = new Gson().fromJson(res, CurrentXunjianDetailResponse.class);
                    if(response!= null && response.getCode() == 0){
                        xunjianitem_name.setText(response.getData().getTaskName());
                        CurrentXunjianXiangAdapter adapter = new CurrentXunjianXiangAdapter(XunjianItemCurrentActivity.this,response.getData().getCurrentDailyTaskDetailsItemVos());
                        recyclerView_Jianyanxiang.setAdapter(adapter);
                    }
                }
            });
    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        int btnID = view.getId();
        //根据ID判断点击按钮
    }




    /**
     * 判断是否有选中合格或者不合格
     * @return
     */
//    private boolean isNull(){
//        for(int i=0;i<radioGroup.getChildCount();i++){
//            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
//            if(radioButton.isChecked()){
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * 激活相册
     */
//    private void goPhotoAlbum() {
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent, 2);
//    }

    /**
     * 激活相机
     */
//    private void goCamera() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            uri = FileProvider.getUriForFile(XunjianItemCurrentActivity.this, "com.yunjian.fileprovider", cameraSavePath);
//            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        } else {
//            uri = Uri.fromFile(cameraSavePath);
//        }
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//        XunjianItemCurrentActivity.this.startActivityForResult(intent, 1);
//    }
    /**
     * 获取权限
     */
//    private void getPermission() {
//        if (EasyPermissions.hasPermissions(this, permissions)) {
//
//        } else {
//            //没有打开相关权限、申请权限
//            EasyPermissions.requestPermissions(this, "需要获取您的相册、照相使用权限", 1, permissions);
//        }
//
//    }

    /**
     * 重写框架方法
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        //框架要求必须这么写
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
//    }

    /**
     * 系统图片调用返回
     * @param requestCode
     * @param resultCode
     * @param data
     */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        String photoPath;
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                photoPath = String.valueOf(cameraSavePath);
//            } else {
//                photoPath = uri.getEncodedPath();
//            }
//            Log.d("拍照返回图片路径:", photoPath);
//            //后面再改一下用GridView显示多张图片
//            Glide.with(XunjianItemCurrentActivity.this).load(photoPath).into(xunjian_imageView);
//        } else if (requestCode == 2 && resultCode == RESULT_OK) {
//            photoPath = GetPhotoFromPhotoAlbumUtils.getRealPathFromUri(this, data.getData());
//            Glide.with(XunjianItemCurrentActivity.this).load(photoPath).into(xunjian_imageView);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    /**
     *
     * @param id
     * 根据ID获取数据
     */
    private void getCunrrentXunjianDetail(int id){
        HashMap<String,Object> params = new HashMap<>();
        params.put("taskId",id);
        Api.config(ApiConfig.XUNJIAN_CURRENT_DETAIL,params).getRequest(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                Log.i("detail",res);
                changeUI(res);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

}