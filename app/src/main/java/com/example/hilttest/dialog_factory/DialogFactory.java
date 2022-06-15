package com.example.hilttest.dialog_factory;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.hilttest.R;

import javax.inject.Inject;


public class DialogFactory {

//    private Context context;

    public interface DialogFactoryInteraction {

        void onAcceptButtonClicked(String... strings);

        void onDeniedButtonClicked(boolean cancel_dialog);
    }

//    public DialogFactory(Context ctx) {
//
//        this.context = ctx;
//    }





    // sample dialog
    public void createTestDialog(DialogFactoryInteraction listener, RelativeLayout root , Context context) {

        View customLayout = LayoutInflater.from(context).inflate(R.layout.dialog, (ViewGroup) root, false);
        Button btn = customLayout.findViewById(R.id.btn);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(customLayout);

        //create dialog and set background transparent
        AlertDialog dialog = builder.create();
        if (dialog.getWindow() != null) {

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        btn.setOnClickListener(view -> dialog.dismiss());
//        btn.setOnClickListener(view -> listener.onAcceptButtonClicked(""));
//        btn.setOnClickListener(view -> listener.onDeniedButtonClicked(false));




        dialog.show();
    }











}
