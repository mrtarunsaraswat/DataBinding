package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers clickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setStudent(getCurrentStudent());

        clickHandlers = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(clickHandlers);
    }

    private Student getCurrentStudent(){

        Student student = new Student();
        student.setStudentName("Tarun");
        student.setStudentEmail("mrtarunsaraswat@gmail.com");
        return student;

    }

    public class MainActivityClickHandlers{

        Context context;

        public MainActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onEnrollButtonClicked(View view) {
            Toast.makeText(context,"Enroll Button Clicked",Toast.LENGTH_SHORT).show();
        }

        public void onCancelButtonClicked(View view) {
            Toast.makeText(context,"Cancel Button Clicked",Toast.LENGTH_SHORT).show();
        }
    }
}
