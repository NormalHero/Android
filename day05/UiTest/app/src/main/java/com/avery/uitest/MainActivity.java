package com.avery.uitest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnInput, btnPrint, btnLog, btnToast, btnAlert;
    TextView tvInput, tvChange, tvResult;
    ToggleButton tbChange;
    Switch swChange;
    CheckBox cbChange;

    //Activity가 만들어 질 때 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 해당 Activity의 Layout을 매칭해주는 메소드

        etInput = findViewById(R.id.etInput); // layout에 있는 컴포넌트를 Activity에서 사용할 수 있게 연결해주는 메소드
        btnInput = findViewById(R.id.btnInput);
        tvInput = findViewById(R.id.tvInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = etInput.getText().toString();
                tvInput.setText(input);
            }
        });                                         // 좌상단 Layout

        tvChange = findViewById(R.id.tvChange);
        tbChange = findViewById(R.id.tbChange);

        tbChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tvChange.setText("On by TB");
                    tvChange.setBackgroundColor(Color.GREEN);
                }else{
                    tvChange.setText("Off by TB");
                    tvChange.setBackgroundColor(Color.RED);
                }
            }
        });

        swChange = findViewById(R.id.swChange);
        swChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tvChange.setText("On by SW");
                    tvChange.setBackgroundColor(Color.GREEN);
                }else{
                    tvChange.setText("Off by SW");
                    tvChange.setBackgroundColor(Color.RED);
                }

            }
        });

        cbChange = findViewById(R.id.cbChange);
        cbChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    tvChange.setText("On by CB");
                    tvChange.setBackgroundColor(Color.GREEN);
                }else{
                    tvChange.setText("Off by CB");
                    tvChange.setBackgroundColor(Color.RED);
                }

            }
        });


        //Print 를 눌럿을 때 tvResult에 , etInput, tbChange, swChange, cbChange 결과 값들을 다 출력
        // EditText : abcd
        // ToggleButton : true
        // Switch : false
        // CheckBox : true


        tvResult = findViewById(R.id.tvResult);
        btnPrint = findViewById(R.id.btnPrint);
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = etInput.getText().toString();
                boolean isTbChecked = tbChange.isChecked();
                boolean isSwChecked = swChange.isChecked();
                boolean isCbChecked = cbChange.isChecked();

                String result = "EditText : " + input +"\n"+
                        "ToggleButton : " + isTbChecked + "\n"+
                        "Switch : " + isSwChecked + "\n" +
                        "CheckBox : " + isCbChecked;

                tvResult.setText(result);
            }
        });


        btnLog = findViewById(R.id.btnLog);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("### UI TEST MainActivity ###", "Log.d 로그 테스트");
                Log.e("### UI TEST MainActivity ###", "Log.e 로그 테스트");
                Log.w("### UI TEST MainActivity ###", "Log.w 로그 테스트");
                Log.i("### UI TEST MainActivity ###", "Log.i 로그 테스트");
                Log.v("### UI TEST MainActivity ###", "Log.v 로그 테스트");
            }
        });

        btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"안녕하세요 박민수입니다.",Toast.LENGTH_SHORT).show();
            }
        });

        btnAlert = findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("타이틀");
                builder.setMessage("얼러트 테스트");

                builder.setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "긍정 긍정",Toast.LENGTH_SHORT).show();
                    }
                });
                // 부정 중립 버튼

                builder.setNegativeButton("부정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"부정 부정",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("중립", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"중립",Toast.LENGTH_SHORT).show();
                    }
                });


                builder.setCancelable(false); // 창 밖 터치시 종료옵션
                builder.show();
            }
        });

        ImageView imgDIa = findViewById(R.id.imgDIa);
        imgDIa.setBackground(new ShapeDrawable(new OvalShape()));
        imgDIa.setClipToOutline(true);

    }

}