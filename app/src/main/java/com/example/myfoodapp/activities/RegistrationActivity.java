package com.example.myfoodapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfoodapp.MainActivity;
import com.example.myfoodapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    private EditText fullNameEditText, emailEditText, passwordEditText;
    private Button registerButton;
    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fullNameEditText = findViewById(R.id.fullNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firebase database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");

        // Set click listener for register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String fullName = fullNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(email)
                        || TextUtils.isEmpty(password)) {

                    Toast.makeText(RegistrationActivity.this, "Please enter valid information", Toast.LENGTH_SHORT).show();
                } else if (!email.matches(emailpattern)) {
//
                    emailEditText.setError("Type valid email here");
                } else if (password.length() < 6) {

                    passwordEditText.setError("password must be 6 character");
                } else {
                    // Create a new User object
                    User user = new User(fullName, email, password);

                    // Push the user data to Firebase database
                    usersRef.push().setValue(user);
                    usersRef.push().setValue(user, new DatabaseReference.CompletionListener() {

                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                            if (error != null) {
                                Toast.makeText(RegistrationActivity.this, "Data could not be saved. " + error.getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                mAuth.createUserWithEmailAndPassword(email, password)
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    // Sign in success, update UI with the signed-in user's information
                                                    Toast.makeText(RegistrationActivity.this, "Authentication Passed.",
                                                            Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                                                    startActivity(intent);

                                                } else {
                                                    // If sign in fails, display a message to the user.
                                                    Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                                            Toast.LENGTH_SHORT).show();

                                                }
                                            }
                                        });

                Toast.makeText(RegistrationActivity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            }
        });

    }



    public void login(View view) {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}