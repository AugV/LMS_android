package com.vainius.augustinas.lms_android.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.entities.Task;

import java.util.List;

public class TaskPageViewMVCImpl implements TaskPageViewMVC {

    View mRootView;
    ListView mListView;
    TaskPageViewMVCListener mListener;
    TaskListAdapter mAdapter;

    public TaskPageViewMVCImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.mvc_view_task_page, container, false);
        mListView = (ListView) mRootView.findViewById(R.id.list_tasks);
        mAdapter = new TaskListAdapter(inflater.getContext(), 0);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mListener != null) {
                    mListener.onTaskClicked(mAdapter.getItem(position).getId());
                }
            }
        });

    }

    @Override
    public void bindTasks(List<Task> tasks) {
        mAdapter.clear();
        mAdapter.addAll(tasks);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setListener(TaskPageViewMVCListener listener) {
        mListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
