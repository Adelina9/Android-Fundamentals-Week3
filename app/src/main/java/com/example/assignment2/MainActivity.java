package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailAddressEditText;
    private EditText phoneEditText;
    private CheckBox termsCheckBox;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        emailAddressEditText = findViewById(R.id.emailAddressEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        termsCheckBox = findViewById(R.id.termsCheckBox);
        resultTextView = findViewById(R.id.emailAndPhoneTextView);
    }

    public void loginOnClick(View view) {
        String email = emailAddressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailAddressEditText.setError(getString(R.string.empty_email_address_message));
        }
        if (phone.isEmpty()) {
            phoneEditText.setError(getString(R.string.empty_phone_number_message));
        }
        if (!termsCheckBox.isChecked()) {
            Toast.makeText(this, R.string.accept_terms_and_conds_message, Toast.LENGTH_LONG).show();
        }
        if (!email.isEmpty() && !phone.isEmpty()) {
            String resultString =
                            getString(R.string.email) + " " + email + "\n" +
                            getString(R.string.phone) + " " + phone + "\n" +
                            getString(R.string.accepted_terms_and_conds) + " " + termsCheckBox.isChecked();
            resultTextView.setText(resultString);
        }
    }
}
