import android.content.Intent;
import android.view.View;
import android.widget.Button;

Button activityButton = (Button) findViewById(R.id.button);
activityButton.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {
		Intent startIntent = new Intent(getApplicationContext(), SecondaryActivity.class);
		startActivity(startIntent);
	}
});