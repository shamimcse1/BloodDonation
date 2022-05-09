package com.codercamp.blooddonation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.codercamp.blooddonation.R;
import com.codercamp.blooddonation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    public String[] bloodGroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    public ArrayAdapter<String> adapter;
    public String mBlood = "";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setupBloodGroup();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setupBloodGroup() {
        adapter = new ArrayAdapter<String>(getContext(), R.layout.list_item, bloodGroup);
        binding.bloodGroup.setAdapter(adapter);
        binding.bloodGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mBlood = adapterView.getItemAtPosition(i).toString();
            }
        });
    }
}