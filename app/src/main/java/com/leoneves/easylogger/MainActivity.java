package com.leoneves.easylogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.init("MY_TAG");
    }

    public void onVerbose(View view) {
        Logger.v("Verbose message");
    }

    public void onXml(View view) {
        String xml = "<note>\n" +
                "<to>Developer</to>\n" +
                "<from>Leo</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Thanks for download EasyLogger!</body>\n" +
                "</note>";
        Logger.xml(xml);
    }

    public void onInfo(View view) {
        Logger.i("The message may have %d elements of type %s", 10000, "string");
    }

    public void onDebug(View view) {
        class CustomClass{
            private String foo = "bar";

            @Override
            public String toString(){
                return "Custom object can be accepted";
            }
        }
        CustomClass anyObjectMayBePrinted = new CustomClass();
        Logger.d(anyObjectMayBePrinted);
    }

    public void onWarn(View view) {
        Logger.w("Warn message");
    }

    public void onError(View view) {
        Logger.e("Error accepts Throwables");
    }

    public void onJSON(View view) {
        try {
            JSONObject json = new JSONObject();
            json.put("foo", "bar");
            Logger.json(json);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void snackBar(String message){

    }
}
