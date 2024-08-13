package com.geeks.rvcustom;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.geeks.rvcustom.databinding.FragmentDetailBinding;

import java.util.ArrayList;

public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            ArrayList pizzaModels = (PizzaModel) getArguments().getSerializable("pizza");
           binding.tvPizza.setText(((PizzaModel) pizzaModels).name);
           binding.tvPizza.setText(((PizzaModel) pizzaModels).desc);
           binding.tvPrice.setText(((PizzaModel) pizzaModels).price + "$");
            Glide.with(binding.imgPizza).load(((PizzaModel) pizzaModels).image).into(binding.imgPizza);
        }
    }
}