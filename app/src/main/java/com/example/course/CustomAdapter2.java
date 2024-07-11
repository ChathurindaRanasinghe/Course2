package com.example.course;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList courseID, courseName, courseFee, courseDuration, courseBranch, startDate, regDate, publishedDate;

    CustomAdapter2(Activity activity, Context context, ArrayList courseID, ArrayList courseName, ArrayList courseFee,
                   ArrayList courseDuration, ArrayList courseBranch, ArrayList startDate, ArrayList regDate, ArrayList publishedDate){
        this.activity = activity;
        this.context = context;
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.courseBranch = courseBranch;
        this.courseDuration = courseDuration;
        this.startDate = startDate;
        this.regDate = regDate;
        this.publishedDate = publishedDate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_raw2, parent, false);
        return new MyViewHolder(view);
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.courseIDText.setText(String.valueOf(courseID.get(position)));
        holder.courseNameText.setText(String.valueOf(courseName.get(position)));
        holder.courseFeeText.setText(String.valueOf(courseFee.get(position)));
        holder.courseBranchText.setText(String.valueOf(courseBranch.get(position)));
        holder.courseDurationText.setText(String.valueOf(courseDuration.get(position)));
        holder.startDateText.setText(String.valueOf(startDate.get(position)));
        holder.RegDueDateText.setText(String.valueOf(regDate.get(position)));
        holder.publishedDateText.setText(String.valueOf(publishedDate.get(position)));
        //Recyclerview onClickListener
        //holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //Intent intent = new Intent(context, UpdateActivity.class);
                //intent.putExtra("courseID", String.valueOf(courseID.get(position)));
                //intent.putExtra("courseName", String.valueOf(courseName.get(position)));
                //intent.putExtra("courseFee", String.valueOf(courseFee.get(position)));
                //intent.putExtra("courseFee", String.valueOf(courseFee.get(position)));
                //intent.putExtra("courseDuration", String.valueOf(courseDuration.get(position)));
                //intent.putExtra("startDate", String.valueOf(startDate.get(position)));
                //intent.putExtra("regDate", String.valueOf(regDate.get(position)));
                //intent.putExtra("publishedDate", String.valueOf(publishedDate.get(position)));
                //activity.startActivityForResult(intent, 1);
           // }
       // });


    }

    @Override
    public int getItemCount() {
        return courseID.size();
        //return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView courseIDText, courseNameText, courseFeeText, courseBranchText,courseDurationText,startDateText,RegDueDateText, publishedDateText;
        //LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            courseIDText = itemView.findViewById(R.id.courseIDText);
            courseNameText = itemView.findViewById(R.id.courseNameText);
            courseFeeText = itemView.findViewById(R.id.courseFeeText);
            courseBranchText = itemView.findViewById(R.id.courseBranchText);
            courseDurationText = itemView.findViewById(R.id.courseDurationText);
            startDateText = itemView.findViewById(R.id.startDateText);
            RegDueDateText = itemView.findViewById(R.id.RegDueDateText);
            publishedDateText = itemView.findViewById(R.id.publishedDateText);
            //mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            //Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            //mainLayout.setAnimation(translate_anim);
        }

    }

}