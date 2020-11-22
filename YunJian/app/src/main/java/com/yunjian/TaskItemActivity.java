package com.yunjian;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.yunjian.entity.TaskItemEntity;

/**
 * @author 何楚玥
 * @package com.yunjian
 * @date on 2020/9/26
 * @describe 任务页面 --列表展示
 */
public class TaskItemActivity extends BaseActivity {
    /**
     * The Taskitem name.
     */
    TextView taskitem_name, /**
     * The Taskitem method.
     */
    taskitem_method, /**
     * The Taskitem standard.
     */
    taskitem_standard, /**
     * The Taskitem project.
     */
    taskitem_project,

    taskitem_day;
    /**
     * The Intent.
     */
    Intent intent;
    private TaskItemEntity taskItemEntity;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_item);
        init();
        intent = getIntent();
        taskItemEntity = (TaskItemEntity) getIntent().getSerializableExtra("listentity");
        position = intent.getIntExtra("position",0);
        changetext();
    }

    /**
     * 初始化
     */
    private void init(){
        taskitem_name=findViewById(R.id.txt_taskitem_name);
        taskitem_method=findViewById(R.id.txt_taskitem_method);
        taskitem_standard=findViewById(R.id.txt_taskitem_standard);
        taskitem_project=findViewById(R.id.txt_taskitem_project);
        taskitem_day=findViewById(R.id.day_time);
    }

    /**
     * 列表信息更改
     */
    private void changetext(){
        taskitem_name.setText(taskItemEntity.getTaskName());
        taskitem_method.setText(taskItemEntity.getTaskPlanDate());
        taskitem_standard.setText(taskItemEntity.getTaskTypeName());
        taskitem_project.setText(taskItemEntity.getTaskTypeName());
        taskitem_day.setText(taskItemEntity.getTaskPlanDate());
    }
}
