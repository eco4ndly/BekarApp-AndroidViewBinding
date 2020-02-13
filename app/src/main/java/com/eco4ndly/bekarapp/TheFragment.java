package com.eco4ndly.bekarapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eco4ndly.bekarapp.databinding.FragmentBekarBinding;

/**
 * A Sayan Porya code on 13/02/20
 */
public class TheFragment extends Fragment {
    public static final String ANY_ARG = "anyArg";

    private String theIncomingString = "";
    private FragmentBekarBinding binding;

    public static TheFragment newInstance(String anyString) {
        Bundle arg = new Bundle();
        arg.putString(ANY_ARG, anyString);
        TheFragment tf = new TheFragment();
        tf.setArguments(arg);
        return tf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theIncomingString = getArguments().getString(ANY_ARG);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBekarBinding.inflate(inflater, container, false); //The magic happens here
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.tvAnything.setText(theIncomingString);
    }
}
