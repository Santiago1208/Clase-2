package com.appmoviles.clase1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static int SIGN_UP_CALLBACK = 11;

    // Components
    private EditText loginUsernameEt;

    private EditText loginPasswordEt;

    private Button loginLoginBtn;

    private Button loginSignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Component configuration
        loginUsernameEt = findViewById(R.id.login_username_et);
        loginPasswordEt = findViewById(R.id.login_password_et);
        loginLoginBtn = findViewById(R.id.login_login_btn);
        loginSignupBtn = findViewById(R.id.login_signup_btn);

        // Listener configuration
        loginLoginBtn.setOnClickListener(
                (View v) -> {
                    String username = loginUsernameEt.getText().toString();
                    String password = loginPasswordEt.getText().toString();
                    Toast.makeText(this, username + ", " + password, Toast.LENGTH_SHORT).show();
                }
        );

        loginSignupBtn.setOnClickListener(
                (View v) -> {
                    Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                    intent.putExtra("email", loginUsernameEt.getText().toString());
                    startActivityForResult(intent, SIGN_UP_CALLBACK);
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SIGN_UP_CALLBACK && resultCode == RESULT_OK) {
            String response = data.getExtras().getString("success");
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
        }
    }
}
