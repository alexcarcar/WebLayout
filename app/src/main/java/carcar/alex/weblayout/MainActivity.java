package carcar.alex.weblayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView wv = (WebView) findViewById(R.id.webview);
        wv.setWebViewClient(new WebViewClient());
        String folderPath = "file:android_asset/";
        String fileName = "index.html";
        String file = folderPath + fileName;
        wv.loadUrl(file);
    }
}
