package com.reload.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText editText1,editText2;
    TextView textView1,textView2,music,position;
    Button btn_save,btn_load,btn_setting;

    boolean b_music;
    int b_position;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // text view settings

        music=findViewById(R.id.music);
        position=findViewById(R.id.position);



        // ======================================to write data
        editText1=findViewById(R.id.edt1);
        editText2=findViewById(R.id.edt2);

        //======================================= to show data
        textView1=findViewById(R.id.tv1);
        textView2=findViewById(R.id.tv2);

        //======================================== when click on button
        btn_save=findViewById(R.id.btn_save);
        btn_load=findViewById(R.id.btn_load);
        btn_setting=findViewById(R.id.setting);

        //======================================== initialize  shared preference

        sharedPreferences=getSharedPreferences("MyShared", Context.MODE_PRIVATE);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //write data

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",editText1.getText().toString());
                editor.putString("id",editText2.getText().toString());
                editor.commit();
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // read data

                textView1.setText(sharedPreferences.getString("name","empty"));
                textView2.setText(sharedPreferences.getString("id","empty"));
            }
        });

        //=================================================
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });

SharedPreferences settings=getSharedPreferences("setting",MODE_PRIVATE);
b_music=settings.getBoolean("MUSIC",true);
b_position=settings.getInt("POSITION",0);
if (b_music){
    music.setText("Music ON");

}else {

    music.setText("Music OFF");
}
position.setText("Position: "+b_position);
    }
}