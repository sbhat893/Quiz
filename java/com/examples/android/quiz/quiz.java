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

    //intialize i,Button click count,score count
    int i=0,countBc, countSc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        
        //The initial state of quiz activity
        changeR0();
        changeR1();
        changeR2();
        changeR3();
        changeqNN();
        changeQn();
        changeImage();



    }


    //Function to change the 1st radio button
     public void changeR0(){
        String r0[] = getResources().getStringArray(R.array.r0);
        RadioButton radioButton=findViewById(R.id.ca);
        radioButton.setText(r0[i]);

    }
    
    //Function to change the 2nd radio button

    public void changeR1(){
        String r1[] = getResources().getStringArray(R.array.r1);
        RadioButton radioButton=findViewById(R.id.cb);
        radioButton.setText(r1[i]);
    }
    
    //Function to change the 3d radio button

    public void changeR2(){
        String r2[] = getResources().getStringArray(R.array.r2);
        RadioButton radioButton=findViewById(R.id.cc);
        radioButton.setText(r2[i]);
    }

    //Function to change the 4th radio button
    public void changeR3(){
        String r3[] = getResources().getStringArray(R.array.r3);
        RadioButton radioButton=findViewById(R.id.cd);
        radioButton.setText(r3[i]);
    }
    
    ////Function to change the question number

    public void changeqNN(){
        String qNN[] = getResources().getStringArray(R.array.qno);
        TextView textView=findViewById(R.id.a);
        textView.setText(qNN[i]);
    }
    
    //Function to change the Question

    public void changeQn(){
        String qn[] = getResources().getStringArray(R.array.qn);
        TextView textView=findViewById(R.id.b);
        textView.setText(qn[i]);
    }
    
    //Function to change the Background image each time

    public void changeImage(){

        int[] imgList = new int[]{R.drawable.img1_result,R.drawable.img2_result,R.drawable.img3_result,R.drawable.img4_result,R.drawable.img5_result};
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.l);
        linearLayout.setBackgroundResource(imgList[i]);
    }
    
    //When the user clicks on the button

    public void onClick(View view) {
        Button button = findViewById(R.id.d);
        RadioGroup radioGroup=findViewById(R.id.c);
        //Get the radio button which is clicked
        int selectedId=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        //Store the ids of the answer radio buttons
        int[] ansarray={R.id.cb,R.id.cc,R.id.ca,R.id.cc,R.id.cd};
        
        countBc++;

        //Make the button to be clicked only 5 times
        if (countBc >= 5){

            //Check whether the checked radio buttton is the answer for that qustion
            if(selectedId==ansarray[i])
            {
                //If Yes then increment the Score count
                ++countSc;
            }
            //After each time user clicks Next button clear the checked radio button
            radioGroup.clearCheck();
            button.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Score is="+countSc,Toast.LENGTH_LONG).show();
        }else {

            //If user didn't select any button then do nothing
            if (selectedId==0){

            }

        //Check whether the checked radio buttton is the answer for that qustion
            if(selectedId==ansarray[i])
            {
                 //If Yes then increment the Score count
                ++countSc;
            }
             //After each time user clicks Next button clear the checked radio button
            radioGroup.clearCheck();
            i++;
            //Change all required fields
            changeR0();
            changeR1();
            changeR2();
            changeR3();
            changeqNN();
            changeQn();
            changeImage();
        }

        //This set of code is to remember how many times the button is clicked
        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("clicks", countBc);
        editor.apply();
    }

}





