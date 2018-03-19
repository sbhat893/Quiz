package com.examples.android.quiz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {

    int i=0,countBc, countSc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


       /* String qNN[] = getResources().getStringArray(R.array.qno);
        String qn[] = getResources().getStringArray(R.array.qn);
        String ans[] = getResources().getStringArray(R.array.ans);
        String r0[] = getResources().getStringArray(R.array.r0);
        String r1[] = getResources().getStringArray(R.array.r1);
        String r2[] = getResources().getStringArray(R.array.r2);
        String r3[] = getResources().getStringArray(R.array.r3);
        */



       /* RadioGroup mGroup = (RadioGroup) findViewById(R.id.c);
        int count = mGroup.getChildCount();
        for(int i = 0;i<count;i++){
            if(mGroup.getChildAt(i) instanceof RadioButton)
                ((RadioButton) mGroup.getChildAt(i)).setText("Radio Button "+i);
                */

        changeR0();
        changeR1();
        changeR2();
        changeR3();
        changeqNN();
        changeQn();
        changeImage();

       /* RadioButton radioButton0=findViewById(R.id.ca);
        radioButton0.setText(r0[i]);
        RadioButton radioButton1=findViewById(R.id.cb);
        radioButton1.setText(r1[i]);
        RadioButton radioButton2=findViewById(R.id.cc);
        radioButton2.setText(r2[i]);
        RadioButton radioButton3=findViewById(R.id.cd);
        radioButton3.setText(r3[i]);
        TextView textView=findViewById(R.id.a);
        textView.setText(qNN[i]);
        TextView textView1=findViewById(R.id.b);
        textView1.setText(qn[i]);
        */

    }



     public void changeR0(){
        String r0[] = getResources().getStringArray(R.array.r0);
        RadioButton radioButton=findViewById(R.id.ca);
        radioButton.setText(r0[i]);

    }

    public void changeR1(){
        String r1[] = getResources().getStringArray(R.array.r1);
        RadioButton radioButton=findViewById(R.id.cb);
        radioButton.setText(r1[i]);
    }

    public void changeR2(){
        String r2[] = getResources().getStringArray(R.array.r2);
        RadioButton radioButton=findViewById(R.id.cc);
        radioButton.setText(r2[i]);
    }

    public void changeR3(){
        String r3[] = getResources().getStringArray(R.array.r3);
        RadioButton radioButton=findViewById(R.id.cd);
        radioButton.setText(r3[i]);
    }

    public void changeqNN(){
        String qNN[] = getResources().getStringArray(R.array.qno);
        TextView textView=findViewById(R.id.a);
        textView.setText(qNN[i]);
    }

    public void changeQn(){
        String qn[] = getResources().getStringArray(R.array.qn);
        TextView textView=findViewById(R.id.b);
        textView.setText(qn[i]);
    }

    public void changeImage(){

        int[] imgList = new int[]{R.drawable.img1_result,R.drawable.img2_result,R.drawable.img3_result,R.drawable.img4_result,R.drawable.img5_result};
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.l);
        linearLayout.setBackgroundResource(imgList[i]);
    }

    public void onClick(View view) {
        Button button = findViewById(R.id.d);
        RadioGroup radioGroup=findViewById(R.id.c);
        String[] ans = getResources().getStringArray(R.array.ans);
        int selectedId=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        int[] ansarray={R.id.cb,R.id.cc,R.id.ca,R.id.cc,R.id.cd};
        countBc++;

        if (countBc >= 5){

            if(selectedId==ansarray[i])
            {
                Log.v("quizini","sc="+i);
                ++countSc;
                Log.v("quizinsc","sc="+countSc);
            }
            radioGroup.clearCheck();
            button.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Score is="+countSc,Toast.LENGTH_LONG).show();
        }else {

            if (selectedId==0){

            }

            Log.v("quizoutsc","sc="+countSc);
            Log.v("quizouti","sc="+i);
            if(selectedId==ansarray[i])
            {
                Log.v("quizini","sc="+i);
                ++countSc;
                Log.v("quizinsc","sc="+countSc);
            }
            radioGroup.clearCheck();
            i++;
            changeR0();
            changeR1();
            changeR2();
            changeR3();
            changeqNN();
            changeQn();
            changeImage();
        }

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("clicks", countBc);
        editor.apply();
    }

}





