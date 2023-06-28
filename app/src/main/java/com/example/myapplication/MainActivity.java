package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner stateSpinner;
    EditText nameEt, emailEt, phoneEt, addressEt, zipCodeEt, categoryEt, religionEt, bloodGrpEt, maritalStatusEt;
    EditText msq1, msq2, msq3, fsq1, fsq2, fsq3;
    String name, email, phoneNo, address, state, zipCode, category, religion, bloodGrp, maritalStatus;
    String msa1, msa2, msa3, fsa1, fsa2, fsa3;

    RadioGroup genderRadio;
    Button btnSubmit, btnReset;
    ScrollView formScrollView;
    TextView enteredText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        stateSpinner = findViewById(R.id.spinnerStates);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        stateSpinner.setAdapter(adapter);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetButtonClicked();

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonClicked();
            }
        });

    }


    public void initialize() {

        nameEt = findViewById(R.id.nameEt);
        emailEt = findViewById(R.id.emailEt);
        phoneEt = findViewById(R.id.phoneNoEt);
        addressEt = findViewById(R.id.addressEt);
        zipCodeEt = findViewById(R.id.zipCodeEt);
        categoryEt = findViewById(R.id.categoryEt);
        religionEt = findViewById(R.id.religionEt);
        bloodGrpEt = findViewById(R.id.bloodGroupEt);
        maritalStatusEt = findViewById(R.id.maritalStatusEt);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        formScrollView = findViewById(R.id.fromScrollView);

        enteredText = findViewById(R.id.enteredData);
        msq1 = findViewById(R.id.msq1);
        msq2 = findViewById(R.id.msq2);
        msq3 = findViewById(R.id.msq3);

        fsq1 = findViewById(R.id.fsq1);
        fsq2 = findViewById(R.id.fsq2);
        fsq3 = findViewById(R.id.fsq3);


    }

    public void getText() {

        name = nameEt.getText().toString().trim();
        email = emailEt.getText().toString().trim();
        phoneNo = phoneEt.getText().toString();
        address = addressEt.getText().toString();
        state = ((Spinner) findViewById(R.id.spinnerStates)).getSelectedItem().toString();
        zipCode = zipCodeEt.getText().toString();
        category = categoryEt.getText().toString();
        religion = religionEt.getText().toString();
        bloodGrp = bloodGrpEt.getText().toString();
        maritalStatus = maritalStatusEt.getText().toString();

        msa1 = msq1.getText().toString();
        msa2 = msq2.getText().toString();
        msa3 = msq3.getText().toString();

        fsa1 = fsq1.getText().toString();
        fsa2 = fsq2.getText().toString();
        fsa3 = fsq3.getText().toString();


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioMale:
                if (checked)
                    maleSectionVisible();
//                    Toast.makeText(this, "Male Chocked : ", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioFemale:
                if (checked)
                    femaleSectionVisible();
//                    Toast.makeText(this, "female clicked : ", Toast.LENGTH_SHORT).show();
                    break;
        }
    }

    public void submitButtonClicked(){
        btnReset.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.INVISIBLE);
        enteredText.setVisibility(View.VISIBLE);
        getText();

        if (msa1.length()!=0){
            enteredText.setText("\n Name : " + name +
                    "\n Email : "+ email+
                    "\n Phone No: " + phoneNo+
                    "\n Address : " + address +" "+ state + " " + zipCode +
                    "\n Category: " + category +
                    "\n Religion : "+ religion +
                    "\n Blood Grp: "+ bloodGrp +
                    "\n Marital Status : "+ maritalStatus+
                    "\n Your likes are : " + msa1 + " , " + msa2 + " , " + msa3);
        }else {
            enteredText.setText("\n Name : " + name +
                    "\n Email : "+ email+
                    "\n Phone No: " + phoneNo+
                    "\n Address : " + address +" "+ state + " " + zipCode +
                    "\n Category: " + category +
                    "\n Religion : "+ religion +
                    "\n Blood Grp: "+ bloodGrp +
                    "\n Marital Status : "+ maritalStatus+
                    "\n Your likes are : " + msa1 + " , " + msa2 + " , " + msa3);
        }

        formScrollView.setVisibility(View.GONE);

    }

    public void onResetButtonClicked(){
        nameEt.setText("");
        emailEt.setText("");
        phoneEt.setText("");
        addressEt.setText("");
        zipCodeEt.setText("");
        religionEt.setText("");
        bloodGrpEt.setText("");
        categoryEt.setText("");
        maritalStatusEt.setText("");
        msq1.setText("");
        msq2.setText("");
        msq3.setText("");
        fsq1.setText("");
        fsq2.setText("");
        fsq3.setText("");
    }

    public void maleSectionVisible(){
        LinearLayout maleSection = findViewById(R.id.maleSection);
        LinearLayout femaleSection = findViewById(R.id.femaleSection);
        maleSection.setVisibility(View.VISIBLE);
        femaleSection.setVisibility(View.GONE);

    }

    public void femaleSectionVisible(){
        LinearLayout maleSection = findViewById(R.id.maleSection);
        LinearLayout femaleSection = findViewById(R.id.femaleSection);
        maleSection.setVisibility(View.GONE);
        femaleSection.setVisibility(View.VISIBLE);

    }

}