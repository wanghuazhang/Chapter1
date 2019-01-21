package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;


//适配器

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private static final String TAG = "MyAdapter";
//    初始化
    private final ListItemClickListener mOnClickListener;

    public List<Message> mdata;

    public MyAdapter(List<Message> data, ListItemClickListener listener) {
        this.mdata = data;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        myViewHolder.tv_title.setText(mdata.get(position).getTitle());
        myViewHolder.tv_description.setText(mdata.get(position).getDescription());
        myViewHolder.tv_time.setText(mdata.get(position).getTime());
        //判断是否是官方的
        myViewHolder.isofficial.setImageResource(R.drawable.im_icon_notice_official);
        if(mdata.get(position).isOfficial()){
            myViewHolder.isofficial.setVisibility(View.VISIBLE);
        }
        else{
            myViewHolder.isofficial.setVisibility(View.INVISIBLE);
        }
        if(mdata.get(position).getIcon().equals("TYPE_ROBOT")){
            myViewHolder.iv_avatar.setImageResource(R.drawable.session_robot);
        }else if (mdata.get(position).getIcon().equals("TYPE_SYSTEM")){
            myViewHolder.iv_avatar.setImageResource(R.drawable.session_system_notice);
        }else if (mdata.get(position).getIcon().equals("TYPE_GAME")){
            myViewHolder.iv_avatar.setImageResource(R.drawable.icon_micro_game_comment);
        }else if (mdata.get(position).getIcon().equals("TYPE_STRANGER")){
            myViewHolder.iv_avatar.setImageResource(R.drawable.session_stranger);
        }else if (mdata.get(position).getIcon().equals("TYPE_USER")){
            myViewHolder.iv_avatar.setImageResource(R.drawable.icon_girl);
        }


     //   myViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


//    //第一步：自定义一个回调接口来实现Click和LongClick事件
//    public interface OnItemClickListener {
//        void onItemClick(View v, int position);
//
//        void onItemLongClick(View v);
//    }
//    //第二步：声明自定义的接口
//    public OnItemClickListener mOnItemClickListener;
//
//    //第三步：定义方法并暴露给外面的调用者
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.mOnItemClickListener = listener;
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv_title;
        private TextView tv_description;
        private TextView tv_time;
        private CircleImageView iv_avatar;
        private ImageView isofficial;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_description = (TextView) itemView.findViewById(R.id.tv_description);
            this.tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            this.iv_avatar = (CircleImageView) itemView.findViewById(R.id.iv_avatar);
            this.isofficial = (ImageView) itemView.findViewById(R.id.robot_notice);
//            注意要把itemView.setOnClickListener(this)加进来，实现点击
            itemView.setOnClickListener(this);
        }

//相当于给内容赋值

//        public void bind(int position){
//            tv_title.setText(mdata.get(position).getTitle());
//            tv_description.setText(mdata.get(position).getDescription());
//            tv_time.setText(mdata.get(position).getTime());
//            iv_avatar.setText(mdata.get(position).getIcon());
//            if(iv_avatar.equals("TYPE_ROBOT")){
//                pic_avatar.setImageResource(R.drawable.session_robot);
//            }else if (iv_avatar.equals("TYPE_SYSTEM")){
//                pic_avatar.setImageResource(R.drawable.session_system_notice);
//            }else if (iv_avatar.equals("TYPE_GAME")){
//                pic_avatar.setImageResource(R.drawable.icon_micro_game_comment);
//            }else if (iv_avatar.equals("TYPE_STRANGER")){
//                pic_avatar.setImageResource(R.drawable.session_stranger);
//            }else if (iv_avatar.equals("TYPE_USER")){
//                pic_avatar.setImageResource(R.drawable.icon_girl);
//            }
//
//        }
        @Override
        public void onClick(View v){
            int clickedPosition = getAdapterPosition();
            if(mOnClickListener != null){
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }

    }
    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }
}