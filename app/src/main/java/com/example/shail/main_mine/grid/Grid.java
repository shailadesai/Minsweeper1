package com.example.shail.main_mine.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.shail.main_mine.C_flow;


public class Grid extends GridView {

    public Grid(Context context , AttributeSet attrs)
    {
        super(context,attrs);

      C_flow.getInstance().LaunchGrid(context);

        setNumColumns(C_flow.w);
        setAdapter(new GridAdapter());
    }


    /*@Override
    /*protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }\\*/

    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount()
        // here we get the current instance of the position based on the count in create grid class.
        {
            return C_flow.getInstance().w * C_flow.getInstance().h;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            return C_flow.getInstance().cellposition(position);
        }
    }
}
/**
 * Originally created by Marcell and then based on the code modified by shail 2017. 10. 19..
 * Comments were given by shail for better explanation of code
 *
 */



