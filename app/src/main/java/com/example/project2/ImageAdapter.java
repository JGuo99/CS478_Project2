package com.example.project2;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
//    These are in nodpi drawable folder!
    private Context context;          // To pass to the ImageView
    private List<Integer> mThumbIds;   // Store AdapterView's items
    private List<String> mCarNames;
    private LayoutInflater layoutInflater;

    // Save the list of image IDs and the context
    public ImageAdapter(Context c, List<Integer> ids, List<String> names) {
        context = c;
        this.mThumbIds = ids;
        this.mCarNames = names;
    }

    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    // Will get called to provide the ID that
    // is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    public static class ContainerView {
        public ImageView imageView;
        public TextView subHeading;
    }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContainerView view;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = new ContainerView();
            convertView = layoutInflater.inflate(R.layout.image_container, null);

            view.subHeading = (TextView) convertView.findViewById(R.id.subHeading);
            view.imageView = (ImageView) convertView.findViewById(R.id.imageContainer);

            convertView.setTag(view);

            view.subHeading.setText(mCarNames.get(position));
            view.imageView.setImageResource(mThumbIds.get(position));
        }
        return convertView;
    }


}
