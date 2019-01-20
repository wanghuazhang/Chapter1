package chapter.android.aweme.ss.com.homework;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.PullParser;



/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */

public class Exercises3 extends AppCompatActivity implements MyAdapter.ListItemClickListener{

    private static final String TAG = "Exercises3";

    private MyAdapter myAdapter;
    private RecyclerView recyclerView;
    private Toast mToast;
    public List<chapter.android.aweme.ss.com.homework.model.Message> messages;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
//读取data，并用解析器读取数据
        try{
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
        }catch (Exception exception){
            exception.printStackTrace();
        }


        recyclerView=findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter=new MyAdapter(messages, this);
        recyclerView.setAdapter(myAdapter);

    }


    @Override
    public void onListItemClick(int clickedItemIndex){

        Log.d(TAG, "onListItemClick: 点击事件发生，第" + clickedItemIndex+"个\n");
//        测试：
//        if (mToast != null) {
//            mToast.cancel();
//        }
//        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
//        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
//
//        mToast.show();

        Intent intent = new Intent(this, Chatroom.class);
        intent.putExtra("message", messages.get(clickedItemIndex).getTitle());
        startActivity(intent);
//        startActivity(new Intent(this, Chatroom.class));
        
    }
}
