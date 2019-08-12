package com.appmoviles.clase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    // Components

    private EditText signupEmailEt;

    private EditText signupPasswordEt;

    private EditText signupConfirmEt;

    private Button signupSignupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Receiving data from other activities
        String email = this.getIntent().getExtras().getString("email");

        // Configuring components
        signupEmailEt = findViewById(R.id.signup_email_et);
        signupPasswordEt = findViewById(R.id.signup_password_et);
        signupConfirmEt = findViewById(R.id.signup_confirm_et);
        signupSignupButton = findViewById(R.id.signup_signup_btn);

        // Listeners
        signupSignupButton.setOnClickListener(
                (View v) -> {
                    validatePasswords();
                }
        );

        signupEmailEt.setText(email);

    }

    private void validatePasswords() {
        String password = signupPasswordEt.getText().toString().trim();
        String confirmPassword = signupConfirmEt.getText().toString().trim();
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Some password field is empty", Toast.LENGTH_SHORT);
        }
        Intent intent = new Intent();
        intent.putExtra("success", "Sign up successful");
        setResult(RESULT_OK, intent);
        // setResult(RESULT_CANCELED);
        finish();
    }
}
