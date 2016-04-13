package qb.edu.com.testsystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.entity.Qusbank;
import qb.edu.com.testsystem.util.QusListUtil;

/**
 * Created by admin on 2016/4/9.
 */
public class WrongQusAdapter extends RecyclerView.Adapter {
    private List<Qusbank> qusList;
    private Context context;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private TestPaperAdapter.OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(TestPaperAdapter.OnItemClickListener listener){
        this.onItemClickListener = listener;
    }
    public WrongQusAdapter(RecyclerView view,List<Qusbank> list){
        this.context = view.getContext();
        this.qusList = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wrongqus_item,parent,false);
        return new WrongQusHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof WrongQusHolder){
            ((WrongQusHolder) holder).qusissue_tv.setText("问题:"+ QusListUtil.distinguishQus(
                    qusList.get(position).getQusissue()));
            ((WrongQusHolder) holder).qusAnswer_tv.setText("答案:"+qusList.get(position).getQusanswer());
            ((WrongQusHolder) holder).qusType_tv.setText("题型:"+qusList.get(position).getQustype());
        }
        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return qusList.size();
    }
    class WrongQusHolder extends RecyclerView.ViewHolder {
        TextView qusissue_tv,qusAnswer_tv,qusType_tv;
        public WrongQusHolder(View itemView) {
            super(itemView);
            qusissue_tv = (TextView) itemView.findViewById(R.id.qusissue_tv);
            qusAnswer_tv = (TextView) itemView.findViewById(R.id.qusAnswer_tv);
            qusType_tv = (TextView) itemView.findViewById(R.id.qusType_tv);
        }
    }
}
