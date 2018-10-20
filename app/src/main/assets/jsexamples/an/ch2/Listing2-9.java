import android.content.Intent;
import android.os.Bundle;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.Activity_secondary);
	String message = "no data from Intent";
	Intent intent = getIntent();
	if (intent != null) {
		if (intent.hasExtra("com.site.MESSAGE")) {
			message = intent.getStringExtra("com.site.MESSAGE");
		} else if (intent.hasExtra(intent.EXTRA_TEXT)) {
			message = intent.getStringExtra(intent.EXTRA_TEXT);
		}
	}
	TextView messageTextView = (TextView) findViewById(R.id.message);
	messageTextView.setText(message);
}