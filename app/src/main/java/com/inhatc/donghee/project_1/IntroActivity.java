package com.inhatc.donghee.project_1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {
    ImageView f_btn1, f_btn2, f_btn3, f_btn4, f_control;   // 프레임 메뉴 버튼 (아래)
    ImageView f_exit1, f_exit2, f_exit3, f_exit4, f_main_exit;  // 각 프레임 종료 버튼
    LinearLayout frame1, frame2, frame3, frame4, frame_control, frame_main;
    MediaPlayer mp, mp2, mp3;    // 배경음, 효과음
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;
    CheckBox ch1, ch2;

    boolean mp_effect= true;

    @Override
    public void onBackPressed() {       // 뒤로가기 두번 누르면 종료, 토스트로 종료하겠냐고 물어봄.
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if(0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime){
            super.onBackPressed();
        }else{
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(),"한번 더 누르면 앱을 종료합니다",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);  // 상태바 없애기
        setContentView(R.layout.activity_intro);

        ActionBar actionBar = getSupportActionBar();    // 타이틀바 없애기
        actionBar.hide();


        f_btn1 = (ImageView)findViewById(R.id.f_btn1);
        f_btn2 = (ImageView)findViewById(R.id.f_btn2);
        f_btn3 = (ImageView)findViewById(R.id.f_btn3);
        f_btn4 = (ImageView)findViewById(R.id.f_btn4);  // 프레임 이미지버튼 (내정보,스토리..)
        frame1 = (LinearLayout)findViewById(R.id.frame1);
        frame2 = (LinearLayout)findViewById(R.id.frame2);
        frame3 = (LinearLayout)findViewById(R.id.frame3);
        frame4 = (LinearLayout)findViewById(R.id.frame4);   // 프레임 레이아웃 1~ 4
        frame_control=(LinearLayout)findViewById(R.id.frame_control);
        frame_main = (LinearLayout) findViewById(R.id.frame_main);
        f_control = (ImageView)findViewById(R.id.f_control);

        f_exit1 = (ImageView)findViewById(R.id.img_exit1);
        f_exit2 = (ImageView)findViewById(R.id.img_exit2);
        f_exit3 = (ImageView)findViewById(R.id.img_exit3);
        f_exit4 = (ImageView)findViewById(R.id.img_exit4);  // 각 프레임 종료버튼
        f_main_exit =(ImageView)findViewById(R.id.f_main_exit);

        ch1 = (CheckBox)findViewById(R.id.ch_back);
        ch2=(CheckBox)findViewById(R.id.ch_effect);

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mp.start();
                }else{
                    mp.pause();
                }
            }
        });

        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mp_effect = true;
                }else{
                    mp_effect = false;
                }
            }
        });




        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.INVISIBLE);
        frame3.setVisibility(View.INVISIBLE);
        frame4.setVisibility(View.INVISIBLE);           // 메뉴 1~4 프레임
        frame_control.setVisibility(View.INVISIBLE);    // 설정 프레임

        f_exit1.setOnClickListener(new View.OnClickListener() {     // 종료버튼 클릭시, 효과음, 각프레임 안보이게함
            @Override
            public void onClick(View v) {       // 각 메뉴의 X버튼 (종료) 누를때
                if(mp_effect == true){
                    mp3.start();
                }
                frame1.setVisibility(View.INVISIBLE);
            }
        });
        f_exit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp3.start();
                }
                frame2.setVisibility(View.INVISIBLE);
            }
        });
        f_exit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp3.start();
                }
                frame3.setVisibility(View.INVISIBLE);
            }
        });
        f_exit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp3.start();
                }
                frame4.setVisibility(View.INVISIBLE);
            }
        });
        f_main_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp3.start();
                }
                frame_control.setVisibility(View.INVISIBLE);
            }
        });

        f_btn1.setOnClickListener(new View.OnClickListener() {  // '내정보'를 눌렀을 때
            @Override
            public void onClick(View v) {       // 아래 메뉴를 누를때
                if(mp_effect == true){
                    mp2.start();
                }
                frame1.setVisibility(View.VISIBLE);
                frame2.setVisibility(View.INVISIBLE);
                frame3.setVisibility(View.INVISIBLE);
                frame4.setVisibility(View.INVISIBLE);
            }
        });
        f_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp2.start();
                }
                frame1.setVisibility(View.INVISIBLE);
                frame2.setVisibility(View.VISIBLE);
                frame3.setVisibility(View.INVISIBLE);
                frame4.setVisibility(View.INVISIBLE);
            }
        });
        f_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp2.start();
                }
                frame1.setVisibility(View.INVISIBLE);
                frame2.setVisibility(View.INVISIBLE);
                frame3.setVisibility(View.VISIBLE);
                frame4.setVisibility(View.INVISIBLE);
            }
        });
        f_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp2.start();
                }
                frame1.setVisibility(View.INVISIBLE);
                frame2.setVisibility(View.INVISIBLE);
                frame3.setVisibility(View.INVISIBLE);
                frame4.setVisibility(View.VISIBLE);
        }
        });
        f_control.setOnClickListener(new View.OnClickListener() {   // 설정 프레임 열기 버튼
            @Override
            public void onClick(View v) {
                if(mp_effect == true){
                    mp2.start();
                }
                frame_control.setVisibility(View.VISIBLE);
            }
        });

        /*
        mp = MediaPlayer.create(this, R.raw.bit);       // 배경음
        mp.setLooping(true);
        mp.start();
        */

        mp = MediaPlayer.create(this,R.raw.mainthema2);
        mp.setLooping(false);
        mp.start();

        mp2 = MediaPlayer.create(this, R.raw.click2);   // 프레임메뉴버튼 효과음
        mp2.setLooping(false);

        mp3 = MediaPlayer.create(this, R.raw.click1);   // 종료버튼 효과음
        mp3.setLooping(false);



    }

}
