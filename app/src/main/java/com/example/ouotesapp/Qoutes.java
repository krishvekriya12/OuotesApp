package com.example.ouotesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ouotesapp.categories.QoutesData;

import java.util.ArrayList;
import java.util.List;

public class Qoutes extends AppCompatActivity {

    private  TextView qoutestxt, writerName;

    private  final List<QoutesList>  QoutesList = new ArrayList<>();

    private int currentQoutePosition = 0;

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        return super.startActivityIfNeeded(intent, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qoutes);

        final TextView categoryName = findViewById(R.id.categoryName);
        qoutestxt = findViewById(R.id.qoutestxt);
        writerName = findViewById(R.id.writerName);

        final Button prevBtn =  findViewById(R.id.prevBtn);
        final  Button nextBtn = findViewById(R.id.nextBtn);
        final ImageView copyBtn = findViewById(R.id.copyBtn);
        final  String getName = getIntent().getStringExtra("name");
        categoryName.setText(getName);

        if (categoryName.equals("Love")){

            QoutesList.addAll(QoutesData.getLoveQoutes());

        }
        else if(getName.equals("Smiley")){
            QoutesList.addAll(QoutesData.getSmileyQoutes());
        }
        else if(getName.equals("Attitude")){
            QoutesList.addAll(QoutesData.getAttitudeQoutes());
        }
        else if(getName.equals("Motivatonal")){
            QoutesList.addAll(QoutesData.getMotivationalQoutes());
        }
        else if(getName.equals("Sad")){
            QoutesList.addAll(QoutesData.getSadQoutes());

        }

        setQoutesToTextView();
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQoutePosition--;
                if(currentQoutePosition < 0){
                    currentQoutePosition = QoutesList.size() -1;
                }
                setQoutesToTextView();
            }
        });

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("quote",QoutesList.get(currentQoutePosition).getQoute()+"\nby"+QoutesList.get(currentQoutePosition).getWriter());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(Qoutes.this,"Copied to ClipBoard",Toast.LENGTH_SHORT).show();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQoutePosition++;
                if (currentQoutePosition >= QoutesList.size()){
                    currentQoutePosition = 0;
                }
                setQoutesToTextView();
            }
        });
    }
    private void setQoutesToTextView(){
        qoutestxt.setText(QoutesList.get(currentQoutePosition).getQoute());
        writerName.setText(QoutesList.get(currentQoutePosition).getWriter());
    }
}