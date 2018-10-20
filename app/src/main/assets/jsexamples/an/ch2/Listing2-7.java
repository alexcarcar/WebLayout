import android.content.Intent;

String webURI = "http://www.google.com";
Uri web = Uri.parse(webURI);
Intent webIntent = new Intent(Intent.ACTION_VIEW, web);
if (webIntent.resolveActivity(getPackageManager()) != null) {
	startActivity(webIntent);
}
