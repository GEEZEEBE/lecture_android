package com.example.ohsanghun.awe_fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CodeFragmentMotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_fragment_mother);

//        getSupportFragmentManager().beginTransaction().add(R.id.codeFragmentLayout, new XmlFragmentChild()).commit();

//        XmlFragmentChild xmlFragmentChild = new XmlFragmentChild();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.codeFragmentLayout, new XmlFragmentChild());
        fragmentTransaction.commit();
    }
}
