package chapter.android.aweme.ss.com.homework;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chatroom extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        TextView name = findViewById(R.id.tv_with_name);
        Bundle temp = this.getIntent().getExtras();
        name.setText(temp.getString("message"));
        editText=findViewById(R.id.ed_say);
        editText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(editText.getText()!=null){
            TextView tv_content_info = findViewById(R.id.tv_content_info);
            tv_content_info.append("我正在"+editText.getText()+"\n");
            editText.setText("");
        }
    }
}
