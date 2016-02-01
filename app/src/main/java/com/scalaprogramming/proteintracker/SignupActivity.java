package com.scalaprogramming.proteintracker;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @Bind(R.id.TVEmailAddress)
    EditText tvEmailAddress;
    @Bind(R.id.ETEmailAddress)
    EditText etEmailAddress;
    @Bind(R.id.ETPassword)
    EditText etPassword;
    @Bind(R.id.BtnSignup)
    Button btnSignup;
    @Bind(R.id.TVLogin)
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });


        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        btnSignup.setEnabled(false);

        final ProgressDialog progressDialog =
                new ProgressDialog(SignupActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account");
        progressDialog.show();

        String name = tvEmailAddress.getText().toString();
        String email = etEmailAddress.getText().toString();
        String password = etPassword.getText().toString();

        // TODO: Implement your own signup logic here
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onSignupSuccess();
                progressDialog.dismiss();
            }
        }, 3000);
    }

    public void onSignupSuccess() {
        btnSignup.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        btnSignup.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = tvEmailAddress.getText().toString();
        String email = etEmailAddress.getText().toString();
        String password = etPassword.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            tvEmailAddress.setError("At least 3 characters");
            valid = false;
        } else {
            tvEmailAddress.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailAddress.setError("enter a valid email address");
            valid = false;
        } else {
            etEmailAddress.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            etPassword.setError("between 4 and 10 alphnumeric character");
            valid = false;
        } else {
            etPassword.setError(null);
        }

        return valid;
    }


}
