package com.reload.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class SettingActivity extends AppCompatActivity {
CheckBox music;
SeekBar position;
boolean b_music;
int b_position;

SharedPreferences setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        music=findViewById(R.id.music);
        position=findViewById(R.id.position);

        setting=getSharedPreferences("setting",Context.MODE_PRIVATE);
        b_music=setting.getBoolean("MUSIC",true);
        b_position=setting.getInt("POSITION",0);
        if(b_music){
            music.setChecked(true);

        }
        position.setProgress(b_position);
        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){

                    b_music=true;
                    saveSettingBoolean("MUSIC",b_music);

                }
                else {
                    b_music=false;
                    saveSettingBoolean("MUSIC",b_music);
                }
            }
        });

        position.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                saveSettingInt("POSITION",i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void saveSettingBoolean(String s,boolean b){
        SharedPreferences.Editor editor=setting.edit();
        editor.putBoolean(s,b);
        editor.apply();

    }
    public void saveSettingInt(String s,int i){
        SharedPreferences.Editor editor=setting.edit();
        editor.putInt(s,i);
        editor.apply();

    }

}
