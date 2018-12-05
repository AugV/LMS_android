package com.vainius.augustinas.lms_android.courses;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.vainius.augustinas.lms_android.entities.Course;

public class CourseListAdapter extends ArrayAdapter<Course> {
    public CourseListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CourseThumbnailViewMVC courseThumbnailViewMVC;

        if (convertView == null) {
            courseThumbnailViewMVC = new CourseThumbnailViewMVCImpl(getContext(), parent);
            courseThumbnailViewMVC.getRootView().setTag(courseThumbnailViewMVC);
        } else {
            courseThumbnailViewMVC = ((CourseThumbnailViewMVC) convertView.getTag());
        }

        courseThumbnailViewMVC.bindCourse(getItem(position));
        return courseThumbnailViewMVC.getRootView();
    }

}
