package com.eco4ndly.bekarapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.eco4ndly.bekarapp.databinding.ActivityMainBinding;

/**
 * A Sayan Porya code on 13/02/20
 */
public class BekarActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater()); // The magic happens here
        setContentView(mainBinding.getRoot());

        mainBinding.btnSubmit.setOnClickListener(view -> {
            String inputString = mainBinding.etName.getText().toString();
            if (TextUtils.isEmpty(inputString)) {
                Toast.makeText(this, "Emptiness Alert", Toast.LENGTH_SHORT).show();
            } else {
                openAnyFragment(inputString);
            }
        });
    }

    private void openAnyFragment(String message) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, TheFragment.newInstance(message), "TAG")
                .addToBackStack(null)
                .commit();
    }
}
