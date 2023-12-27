package edu.takming.myapplication_sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MYPREFS = "mySharedPreference";

    TextView tv;
    EditText et;
    Button btn;
    Button clearBtn;

    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int mode = Activity.MODE_PRIVATE;

        tv = (TextView)findViewById(R.id.textView2);
        SharedPreferences mySharedPreference = getSharedPreferences(MainActivity.MYPREFS, mode);
        String name = mySharedPreference.getString("name", "?");
        CharSequence cs = new String("Your name is " + name);
        tv.setText(cs);


        et = (EditText)findViewById(R.id.editText1);
        btn = (Button)findViewById(R.id.button1);
        clearBtn = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(MainActivity.this, Activity2.class);

                savePreference();

                startActivity(intent);

            }

        });

        clearBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                int mode = Activity.MODE_PRIVATE;
                SharedPreferences mySharedPreference = getSharedPreferences(MYPREFS, mode);

                SharedPreferences.Editor editor = mySharedPreference.edit();
                editor.clear();
                editor.commit();

            }

        });
    }
    protected void savePreference() {

        int mode = Activity.MODE_PRIVATE;
        SharedPreferences mySharedPreference = getSharedPreferences(MYPREFS, mode);

        SharedPreferences.Editor editor = mySharedPreference.edit();

        editor.putBoolean("isTrue", true);
        s = et.getText().toString();
        editor.putString("name", s);

        editor.commit();
    }
}