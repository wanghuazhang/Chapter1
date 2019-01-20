package chapter.android.aweme.ss.com.chapter1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import chapter.android.aweme.ss.com.chapter1.intent.IntentActivity;
import chapter.android.aweme.ss.com.chapter1.lifecycle.LifeCycleActivity;
import chapter.android.aweme.ss.com.chapter1.recycleview.RecycleViewActivity;
import chapter.android.aweme.ss.com.chapter1.view.CommonViewActivity;
import chapter.android.aweme.ss.com.chapter1.xmlparser.XmlActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final  String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_lifecycle).setOnClickListener(this);
        findViewById(R.id.btn_xml).setOnClickListener(this);
        findViewById(R.id.btn_intent).setOnClickListener(this);
        findViewById(R.id.btn_recycleview).setOnClickListener(this);
        findViewById(R.id.btn_commonview).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_xml:
                startActivity(new Intent(this, XmlActivity.class));
                Log.d(TAG, "onClick: xml");
                break;
            case R.id.btn_lifecycle:
                startActivity(new Intent(this, LifeCycleActivity.class));
                Log.d(TAG, "onClick: lifecycle");
                break;
            case R.id.btn_intent:
                startActivity(new Intent(this, IntentActivity.class));
                Log.d(TAG, "onClick: intent");
                break;
            case R.id.btn_recycleview:
                startActivity(new Intent(this, RecycleViewActivity.class));
                Log.d(TAG, "onClick: Recycleview");
                break;
            case R.id.btn_commonview:
                startActivity(new Intent(this, CommonViewActivity.class));
                Log.d(TAG, "onClick: Commonview");
                break;
        }
    }
}
