package com.example.agecalculator;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AgeCalculatorDialog extends DialogFragment{
    String message;
    AgeCalculatorDialog(String message){
        super();
        this.message = message;
    }
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setMessage(R.string.dialog_message);
        builder.setMessage(message);

        return  builder.create();

    }
    public static String TAG="AgeCalculator";


}
