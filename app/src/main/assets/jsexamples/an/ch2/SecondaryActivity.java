import com.site.thisApplication;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondaryActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.Activity_secondary);
		Button activityButton = (Button) findViewById(R.id.button);
		Intent intent = getIntent();
		String message = intent.getStringExtra("com.site.MESSAGE");
		TextView messageTextView = (TextView) findViewById(R.id.message);
		messageTextView.setText(message);
	}
	// menu code excluded
}