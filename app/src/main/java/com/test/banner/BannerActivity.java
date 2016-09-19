package com.test.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

public class BannerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        getSupportActionBar().setTitle(getIntent().getStringExtra("des"));
        //本地资源图片
        Integer[] image={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f};
        //网络图片
        String[] images= getResources().getStringArray(R.array.url2);
        //图片对应title
        String[] titles= getResources().getStringArray(R.array.title);

        int position=getIntent().getIntExtra("position",0);
        Banner banner = (Banner) findViewById(R.id.banner1);
        switch (position){
            case 0:
                //设置样式 默认样式
                banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
                break;
            case 1:
                //显示圆形指示器
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                break;
            case 2:
                //显示数字指示器
                banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
                break;
            case 3:
                //显示数字指示器和标题
                banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
                //记得设置标题列表哦
                banner.setBannerTitle(titles);
                break;
            case 4:
                //显示圆形指示器和标题
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                //记得设置标题列表哦
                banner.setBannerTitle(titles);
                break;
            case 5:
                //显示标题内圆形指示器和标题
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                //记得设置标题列表哦
                banner.setBannerTitle(titles);
                break;
            case 6:
                //设置指示器居中（CIRCLE_INDICATOR或者CIRCLE_INDICATOR_TITLE模式下）
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                banner.setIndicatorGravity(BannerConfig.RIGHT);
                break;
        }
        banner.setImages(images);//设置图片网址
//        banner.setImages(image);//设置资源文件
        banner.setOnBannerClickListener(new OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getApplicationContext(),"你点击了："+position,Toast.LENGTH_LONG).show();
            }
        });
    }

}
