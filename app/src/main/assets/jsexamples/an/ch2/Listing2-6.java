import android.content.Intent;
import android.widget.Button;

Button mapButton = (Button) findViewById(R.id.button2);
mapButton.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {
		String geoURI = "geo:37.422,-122.084?z=23";
		Uri geo = Uri.parse(geoURI);
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, geo);
		if (mapIntent.resolveActivity(getPackageManager()) != null) {
			startActivity(mapIntent);
		}
	}
})