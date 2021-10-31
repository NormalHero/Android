package com.avery.thirdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    ListView lvContact;


    ArrayAdapter adapter;

    public class PhneBook {
        String id;
        String name;
        String tel;

        @Override
        public String toString() {
            return "PhneBook{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
        }
    }

    ArrayList<PhneBook> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ContentResolver resolver = getContentResolver();
        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        String[] projection = { ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};

        Cursor cursor = resolver.query(phoneUri, projection, null, null, null);

        lvContact = findViewById(R.id.lvContact);




        if(cursor != null) { // 널 체크
             while(cursor.moveToNext()){

                 int idIndex = cursor.getColumnIndex(projection[0]);
                 int nameIndex = cursor.getColumnIndex(projection[1]);
                 int numberIndex = cursor.getColumnIndex(projection[2]);

                 String id = cursor.getString(idIndex);
                 String name = cursor.getString(nameIndex);
                 String number = cursor.getString(numberIndex);

                 PhneBook phneBook = new PhneBook();
                 phneBook.id = id;
                 phneBook.name = name;
                 phneBook.tel = number;

                 list.add(phneBook);




             }


        }

        cursor.close();

        for (int i = 0; i < list.size() ; i++){
            Log.d("### Phone Book List ###",list.get(i).toString());



        };
        adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, list);
        lvContact.setAdapter(adapter);

    }
}