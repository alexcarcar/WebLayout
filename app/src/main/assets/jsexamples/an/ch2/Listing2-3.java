import android.content.Intent;
import android.view.View;
import android.view.TextView;
import android.widget.Button;

Intent intent = getIntent();
String message = intent.getStringExtra("com.site.MESSAGE");
TextView messageTextView = (TextView) findViewById(R.id.message);
messageTextView.setText(message);
