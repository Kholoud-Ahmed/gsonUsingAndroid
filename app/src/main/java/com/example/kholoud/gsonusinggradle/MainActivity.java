package com.example.kholoud.gsonusinggradle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kholoud.pojo.Employee;

import controller.Controller;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText jsonEditText;
    Button handelGsonObjectBtn;
    TextView nameTextView;
    TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindComponents();

        assignListeners();
    }

    private void bindComponents() {

        jsonEditText = (EditText) findViewById(R.id.jsonEditText);
        handelGsonObjectBtn = (Button) findViewById(R.id.handelGsonBtn);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
    }

    private void assignListeners() {
        handelGsonObjectBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.handelGsonBtn){
            Employee employee= Controller.parseGsonObject(jsonEditText.getText().toString());

            if(employee != null) {
                Log.i("++++", "" + employee);
                nameTextView.setText("Name: " + employee.getName());
                ageTextView.setText("Age: " + employee.getAge());
            }

        }
    }
}
