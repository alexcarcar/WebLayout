package com.site.thisApplication;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.Activity_main);
		Button activityButton = (Button) findViewById(R.id.button);
		activityButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent startIntent = new Intent(getApplicationContext(), SecondaryActivity.class);
				startIntent.putExtra("com.site.MESSAGE", "Hello SecondaryActivity");
				startActivity(startIntent);
			}
		});
	}	
	// menu code excluded
}