package edu.takming.myapplication_sharedprefdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends Activity {
	
	private TextView tv;
	Boolean isTrue;
	String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main2);
		
		tv = (TextView)findViewById(R.id.textView2);

		loadPreference();

		if (isTrue) {
			CharSequence cs = new String("Your name is " + name);
			tv.setText(cs);
		}		
	}
	
	
	public void loadPreference() {
		int mode = Activity.MODE_PRIVATE;
		
		SharedPreferences mySharedPreference = getSharedPreferences(
				MainActivity.MYPREFS, mode);
		
		isTrue = mySharedPreference.getBoolean("isTrue", false);
		name = mySharedPreference.getString("name", "?");
	}
	

}
