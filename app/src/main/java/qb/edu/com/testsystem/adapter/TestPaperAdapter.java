package qb.edu.com.testsystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.entity.QusTestPaper;

/**
 * Created by admin on 2016/4/7.
 * 添加一个FootView
 */
public class TestPaperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<QusTestPaper> list;
    private Context context;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private View footView;
    public interface OnItemClickListener{  //设置点击事件回调接口
        void onItemClick(View view,int position);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }
    public TestPaperAdapter(Context cxt,List<QusTestPaper> list){
        this.context = cxt;
        this.list = list;
    }
    public void setFootView(View footView){
        this.footView = footView;
    }
    //用于返回view
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if(viewType == TYPE_FOOTER && footView!=null){
           return new FootViewHolder(footView);
       }
        View view = LayoutInflater.from(context).inflate(R.layout.test_paper_item,parent,false);
        return new ItemViewHolder(view);
    }
    //用于绑定事件和设置数据
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder){

            ((ItemViewHolder) holder).difficult_tv.setText("难易程度:"+list.get(position).getTestdifficult());
            ((ItemViewHolder) holder).test_paper_tv.setText(list.get(position).getTestname());
            ((ItemViewHolder) holder).textNumber_tv.setText("题量:"+list.get(position).getTestCount()+"道题 选择题/填空题");

            if(onItemClickListener != null && list != null){   //设置点击事件
                Log.i("点击事件...","出发");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition();
                        onItemClickListener.onItemClick(holder.itemView,position);
                    }
                });
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position+1 == getItemCount()){ //如果是最后一个item，那么设置类型是footerView
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return list.size()==0?0:list.size()+1;
    }
    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView test_paper_tv,difficult_tv,textNumber_tv;
        public ItemViewHolder(View itemView) {
            super(itemView);
            test_paper_tv = (TextView) itemView.findViewById(R.id.test_paper_tv);
            difficult_tv = (TextView) itemView.findViewById(R.id.difficult_tv);
            textNumber_tv = (TextView) itemView.findViewById(R.id.textNumber_tv);
        }
    }
    class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}
