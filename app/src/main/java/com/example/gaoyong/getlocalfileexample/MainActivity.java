package com.example.gaoyong.getlocalfileexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class MainActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        // allows WebView to load content from a content provider installed in the system. The default is enabled.
        webView.getSettings().setAllowContentAccess(true);
        //File access is enabled by default. Note that this enables or disables file system access only. Assets and resources are still accessible using file:///android_asset and file:///android_res
        webView.getSettings().setAllowFileAccess(true);
        //webView.loadUrl("http://www.google.com");

        String customHtml =
                "<html>" +
                    "<body>" +
                        "<h3>img from android resouse </h3>" +
                        "<img src=\"file:///android_res/drawable/r_a.png\" width=\"60\" height=\"60\">"+
                        "<br /><i>will sucess display image in asset dir</i>"+
                        "<h3>img from android assets </h3>" +
                        "<img src=\"file:///android_asset/b.png\" width=\"60\" height=\"60\">"+
                        "<br /><i>will sucess display image in asset dir</i>"+
                        "<h3>img from http</h3>" +
                        "<img src=\"http://p4.music.126.net/MtPnFDiXLzU_UtrYQ01gFw==/5775734580934143.jpg?param=140y140\" width=\"60\" height=\"60\">"+
                        "<h3>img from sdcard</h3>" +
                        "<img src=\"content://com.example.gaoyong.getlocalfileexample.localfile/mnt/sdcard/qingguocrop_image.jpg\" width=\"60\" height=\"60\">"+
                        "<br /><i>make sure the image exists</i>"+
                    "</body>" +
                "</html>";
        //fail display android resouse & asset image
//        webView.loadData(customHtml, "text/html", "UTF-8");

        //sucess display android resouse & asset image
        webView.loadUrl("file:///android_asset/main.html");




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
