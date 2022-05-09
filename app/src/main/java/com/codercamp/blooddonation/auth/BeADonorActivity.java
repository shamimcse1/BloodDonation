package com.codercamp.blooddonation.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.codercamp.blooddonation.MainActivity;
import com.codercamp.blooddonation.R;
import com.codercamp.blooddonation.databinding.ActivityBeDonorBinding;
import com.google.android.material.button.MaterialButton;

public class BeADonorActivity extends AppCompatActivity {
    public String[] gender = {"Male", "Female","Other's"};
    public String[] bloodGroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    public ArrayAdapter<String> adapter;
    public String mGender = "";
    public String mBlood = "";
    public String fullName = "";
    public String email = "";
    public String number = "";
    public String address = "";
    public String dateOfBirth = "";
    ActivityBeDonorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_be_donor);
        setupGender();
        setupBloodGroup();

        binding.btnSubmit.setOnClickListener(v -> {
            fullName = binding.fullNameTextField.getText().toString().trim();
            email = binding.emailTextField.getText().toString().trim();
            number = binding.numberTextField.getText().toString().trim();
            address = binding.addressTextField.getText().toString().trim();
            dateOfBirth = binding.dateOfBirthTextField.getText().toString().trim();
            if (!isValidFullName() || !isValidEmailTex() || !isValidEmail() || !isValidNumber() || !isValidAddress() || !isValidDOB() || !isValidGender() || !isValidBlood()) {
                return;
            } else {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setupGender() {

        // autoCompleteTextView = findViewById(R.id.gender);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, gender);
        binding.gender.setAdapter(adapter);

        binding.gender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mGender = adapterView.getItemAtPosition(i).toString();
            }

        });
    }

    private void setupBloodGroup() {

        // autoCompleteTextView = findViewById(R.id.bloodGroup);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, bloodGroup);
        binding.bloodGroup.setAdapter(adapter);

        binding.bloodGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mBlood = adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    private boolean isValidFullName() {

        if (fullName.length() == 0) {
            binding.fullNameTextField.setError("Full Name is required");
            binding.fullNameTextField.requestFocus();
            return false;
        } else {
            binding.fullNameTextField.setError(null);
            // binding.fullNameTextField.setEnabled(false);
            return true;
        }

    }

    private boolean isValidEmailTex() {
        if (email.length() == 0) {
            binding.emailTextField.setError("Email is required");
            binding.emailTextField.requestFocus();
            return false;
        } else {
            binding.emailTextField.setError(null);
            //binding.emailTextField.setEnabled(false);
            return true;
        }

    }

    private boolean isValidEmail() {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailTextField.setError("Email must be Valid");
            binding.emailTextField.requestFocus();
            return false;
        } else {
            binding.emailTextField.setError(null);
            //  binding.emailTextField.setEnabled(false);
            return true;
        }

    }

    private boolean isValidNumber() {
        if (number.length() == 0) {
            binding.numberTextField.setError("Number is required");
            binding.numberTextField.requestFocus();
            return false;
        } else {
            binding.numberTextField.setError(null);
            //binding.numberTextField.setEnabled(false);
            return true;
        }

    }

    private boolean isValidDOB() {
        if (dateOfBirth.length() == 0) {
            binding.dateOfBirthTextField.setError("Date OF Birth is required");
            binding.dateOfBirthTextField.requestFocus();
            return false;
        } else {
            binding.dateOfBirthTextField.setError(null);
            // binding.dateOfBirthTextField.setEnabled(false);
            return true;
        }

    }

    private boolean isValidAddress() {
        if (address.length() == 0) {
            binding.addressTextField.setError("Address is required");
            binding.addressTextField.requestFocus();
            return false;
        } else {
            binding.addressTextField.setError(null);
            // binding.addressTextField.setEnabled(false);
            return true;
        }

    }

    private boolean isValidGender() {
        if (mGender.length() == 0) {
            binding.gender.setError("Gender is required");
            binding.gender.requestFocus();
            return false;
        } else {
            binding.gender.setError(null);
            // binding.fullNameTextField.setEnabled(false);
            return true;
        }
    }

    private boolean isValidBlood() {
        if (mBlood.length() == 0) {
            binding.bloodGroup.setError("Blood Group is required");
            binding.bloodGroup.requestFocus();
            return false;
        } else {
            binding.bloodGroup.setError(null);
            // binding.fullNameTextField.setEnabled(false);
            return true;
        }
    }
}