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
import qb.edu.com.testsystem.entity.Grade;

/**
 * Created by admin on 2016/4/9.
 */
public class LookGradeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Grade> list;
    private Context context;
    public LookGradeAdapter(RecyclerView view, List<Grade> grades){
        this.context = view.getContext();
        this.list = grades;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grade_list_item,parent,false);
        return new GradeHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.i("get","hplder==="+holder);
        if(holder instanceof GradeHolder){
            Log.i("get",list.get(position).toString());
            ((GradeHolder) holder).testName.setText("试卷名:"+list.get(position).getTestName());
            ((GradeHolder) holder).testUser.setText("考试人:"+list.get(position).getUsername());
            ((GradeHolder) holder).testGrade.setText("成绩:"+list.get(position).getGradeScore());
            ((GradeHolder) holder).testTime.setText("考试时间:"+list.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GradeHolder extends RecyclerView.ViewHolder {
    TextView testName,testUser,testTime,testGrade;

        public GradeHolder(View itemView) {
            super(itemView);
            testName = (TextView) itemView.findViewById(R.id.testName_tv);
            testUser = (TextView) itemView.findViewById(R.id.testUser_tv);
            testTime = (TextView) itemView.findViewById(R.id.testTime_tv);
            testGrade = (TextView) itemView.findViewById(R.id.testGrade_tv);
        }

    }
}
