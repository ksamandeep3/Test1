package com.example.test141219;

import androidx.appcompat.app.AppCompatActivity;

import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    RadioGroup Rdgroup;
    RadioButton rdgraduate,rdungraduate;
    Spinner sp1;
    EditText etfees,ethours,ettotalfee,ettotalhours;
    CheckBox chaccomo,chmedical;
    Button addbtn;
    TextView textv1;
    int [] fees = {200,100,1000,2000,700};
    int [] hours ={6,5,5,7,4};
    double fe;
    Double hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //String  name =  getIntent().getStringExtra("name");
        //textv1.setText(String.valueOf(name));
        String  name =  getIntent().getStringExtra("studentName");
        textv1=findViewById(R.id.tv1);
        textv1.setText("Welcome "+name);


        Rdgroup = findViewById(R.id.rg1);
        rdgraduate = findViewById(R.id.rbtn1);
        rdungraduate = findViewById(R.id.rbtn2);
        sp1 = findViewById(R.id.spin);
        etfees = findViewById(R.id.et1);
        ethours = findViewById(R.id.et2);
        ettotalfee = findViewById(R.id.et3);
        ettotalhours = findViewById(R.id.et4);
        chaccomo = findViewById(R.id.ch1);
        chmedical = findViewById(R.id.ch2);
        addbtn = findViewById(R.id.btn1);
        textv1 = findViewById(R.id.tv1);



        List<String> programs = new ArrayList<>();
        programs.add("Java");
        programs.add("Swift");
        programs.add("Ios");
        programs.add("Android");
        programs.add("Database");

        ArrayAdapter<String> proAdapter= new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,programs);
        proAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp1.setAdapter(proAdapter);
        sp1.setOnItemSelectedListener(this);
        addbtn.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        fe = new Double(fees[i]);
        etfees.setText(String.valueOf(fe));
        hour = new Double(hours[i]);
        ethours.setText(String.valueOf(hour));



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onClick(View view)
    {
        if(!etfees.getText().equals(""))
        {

            Double  fee  = Double.parseDouble(etfees.getText().toString());
            ettotalfee.setText(String.valueOf(fee));


            Double  hour  = Double.parseDouble(ethours.getText().toString());
            ettotalhours.setText(String.valueOf(hour));

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
