package com.shubham.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button save,fetch,update,delete;
EditText e1,e2;
SharedPreferences pref;
String prefName="Shubham";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.save_id);
        fetch=findViewById(R.id.fetch_id);
        update=findViewById(R.id.update_id);
        delete=findViewById(R.id.delete_id);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putInt("ID",Integer.parseInt(e1.getText().toString()));
                editor.putString("Name",e2.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"saved",Toast.LENGTH_SHORT).show();
            }
        });
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                String s1=String.valueOf((pref.getInt("ID",100)));
                String s2=pref.getString("Name","ABC");
                e1.setText(s1);
                e2.setText(s2);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putInt("ID",Integer.parseInt(e1.getText().toString()));
                editor.putString("Name",e2.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"updated",Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
