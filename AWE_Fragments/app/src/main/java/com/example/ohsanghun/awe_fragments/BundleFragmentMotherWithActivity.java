package com.example.ohsanghun.awe_fragments;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BundleFragmentMotherWithActivity extends AppCompatActivity
        implements BundleSimpleFragment.OnFragmentInteractionListener {

    EditText interactionValue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_fragment_mother_with);

        interactionValue = (EditText) findViewById(R.id.interactionValue);

//        getSupportFragmentManager().beginTransaction().add(R.id.bundle_fragment, new BundleSimpleFragment()).commit();

    }

    public void onClick(View view){
        BundleSimpleFragment bundleSimpleFragment = (BundleSimpleFragment) getSupportFragmentManager().findFragmentById(R.id.bundle_fragment);
//        BundleSimpleFragment bundleSimpleFragment = null;

        if(bundleSimpleFragment != null){
            bundleSimpleFragment.updateArticleView(interactionValue.getText().toString());
        } else {
            bundleSimpleFragment = new BundleSimpleFragment();
            Bundle bundle = new Bundle();
            bundle.putString("interactionValue", interactionValue.getText().toString());
            bundleSimpleFragment.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.bundle_fragment, bundleSimpleFragment);
//            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
/*
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
*/

    @Override
    public void onButtonClick(int position, String text) {
        interactionValue.setText(position + ", " + text);
    }
}
