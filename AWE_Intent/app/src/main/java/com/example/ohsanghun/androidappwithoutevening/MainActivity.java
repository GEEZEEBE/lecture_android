package com.example.ohsanghun.androidappwithoutevening;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickExplicitIntent(View view) {
        int id = view.getId();
        Intent intent = null;
        String text = ((Button) view).getText().toString();
        Bundle bundle = new Bundle();
        Class<?> cls = null;
        switch (id) {
            case R.id.explicitIntentSimple:
                cls = ExplicitIntentSimpleActivity.class;
                break;
            case R.id.explicitIntentRequest:
                bundle.putString("singleName", text);
                bundle.putLong("bundleName", id);
                cls = ExplicitIntentRequestActivity.class;
                break;
            case R.id.explicitIntentResponse:
                bundle.putString("singleName", text);
                bundle.putLong("bundleName", id);
                cls = ExplicitIntentResponseActivity.class;
                break;
            case R.id.explicitIntentListView:
                cls = ListViewActivity.class;
                break;
        }
        intent = new Intent(this, cls);

        if (id == R.id.explicitIntentSimple || id == R.id.explicitIntentListView) {
            intent.putExtra("subActivity", "Send Value Directly!");
            startActivity(intent);
        } else if (id == R.id.explicitIntentRequest) {
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            // Result from sub Activity
            intent.putExtras(bundle);
            startActivityForResult(intent, Activity.RESULT_FIRST_USER);
        }
    }

    public void onClickImplicitIntent(View view) {
        int id = view.getId();
        Intent intent = null;
        String text = ((Button) view).getText().toString();
        text = "51";
        Bundle bundle = new Bundle();
        Class<?> cls = null;
        Uri uri = null;
        switch (id) {
            case R.id.implicitIntentWeb:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                break;
            case R.id.implicitIntentGeo:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194"));
//                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.implicitIntentWebSearch:
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, text);
                break;
            case R.id.implicitIntentContactsContract:
                intent = new Intent(Intent.ACTION_PICK);
                intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                break;
            case R.id.implicitIntentCPSearch:
                // text : ontactsContract.CommonDataKinds.Photo.CONTACT_ID
                text = "51";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
//                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/" + text));
                break;
            case R.id.implicitIntentTelDial:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + text));
                break;
            case R.id.implicitIntentTelCall:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + text));
                break;
            case R.id.implicitIntentSendEmail:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:otter35@naver.com"));
                break;
//            case R.id.implicitIntentSendEmail:
//                intent = new Intent(Intent.ACTION_SEND);
//                String[] tos = {"otter35@naver.com"};
////                String[] ccs = {"you@abc.com"};
//                intent.putExtra(Intent.EXTRA_EMAIL, tos);
////                intent.putExtra(Intent.EXTRA_CC, ccs);
//                intent.putExtra(Intent.EXTRA_TEXT, "The email body text");
//                intent.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
//                intent.setType("message/rfc822");
//                break;
            case R.id.implicitIntentSendSMS:
                uri = Uri.parse("smsto:0800000123");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "The SMS text");
                break;
            case R.id.implicitIntentSendMSM:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("address", "01024058735");
                intent.putExtra("sms_body", "This is a test message");
                intent.setType("vnd.android-dir/mms-sms");
                break;

        }
        if (id == R.id.implicitIntentContactsContract) {
            startActivityForResult(intent, 10);  // requestCode >= 0
//        } else if(id == R.id.implicitIntentSendEmail){
//            startActivity(Intent.createChooser(intent, "Choose Email Client"));
        } else {
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            String[] contacts =
                    new String[]{ContactsContract.Contacts._ID,
                            ContactsContract.Contacts.DISPLAY_NAME,
                            ContactsContract.Contacts.PHOTO_ID,
                            ContactsContract.CommonDataKinds.Email.DATA,
                            ContactsContract.CommonDataKinds.Photo.CONTACT_ID};
            Cursor cursor = getContentResolver().query(data.getData(),contacts, null, null, null);
            cursor.moveToFirst();
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String number = cursor.getString(3);
            String contact = cursor.getString(4);
            cursor.close();
        } else if (resultCode == RESULT_OK || requestCode == RESULT_FIRST_USER) {
            if (data.hasExtra("resultValue")) {
                Toast.makeText(getApplicationContext(),
                        data.getStringExtra("resultValue"), Toast.LENGTH_LONG).show();
            }
        }
    }

}
