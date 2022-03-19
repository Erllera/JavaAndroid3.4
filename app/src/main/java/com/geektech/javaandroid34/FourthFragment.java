package com.geektech.javaandroid34;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FourthFragment extends Fragment {
    private TextView inputText;
    private Button button;
    public final static String KEY_BUNDLE="key4";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputText = view.findViewById(R.id.input_text);
        button = view.findViewById(R.id.btn_next);

        String value = getArguments().getString(ThirdFragment.KEY_BUNDLE);
        inputText.setText(value);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle textValue = new Bundle();
                textValue.putString(KEY_BUNDLE, inputText.getText().toString());
                FifthFragment fifthFragment = new FifthFragment();
                fifthFragment.setArguments(textValue);

                requireActivity().getSupportFragmentManager().
                        beginTransaction().replace(R.id.container, fifthFragment).commit();
            }
        });

    }
}