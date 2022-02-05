package com.example.agecalculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class FirstFragment extends Fragment {
    View view;
    EditText years, months, days;
    Button calculate, context;
    TextView result;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_first,container,false);
        context=view.findViewById(R.id.context);
        registerForContextMenu(context);
        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        years=view.findViewById(R.id.yeartxt);
        months=view.findViewById(R.id.monthtxt);
        days=view.findViewById(R.id.daytxt);
        result=view.findViewById(R.id.resulttxt);
        calculate=view.findViewById(R.id.calculate);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year=Integer.parseInt((years.getText().toString()));
                int month=Integer.parseInt((months.getText().toString()));
                int day=Integer.parseInt((days.getText().toString()));


                Calendar date=Calendar.getInstance();
                int currentYear=date.get(Calendar.YEAR);
                int currentMonth=date.get(Calendar.MONTH);
                int currentDay=date.get(Calendar.DAY_OF_MONTH);

                int finalYear = currentYear-year;

                int finalMonth = currentMonth-month;
                if(finalMonth < 0){
                    finalYear--;
                    finalMonth= currentMonth+12 - month;
                }


                int finalDay= currentDay - day;
                if(finalDay < 0){
                    finalMonth--;
                    finalDay= currentDay+30 - day;
                }

               String result = String.valueOf(finalYear) + " year " + String.valueOf(finalMonth) + " month " + String.valueOf(finalDay) +" day";
                new AgeCalculatorDialog(result).show(getActivity().getSupportFragmentManager(), AgeCalculatorDialog.TAG);

            }
        });


    }
}