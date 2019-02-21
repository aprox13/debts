package com.ifkbhit.debts.recycler;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/*
 * https://gist.github.com/RanyAlbegWein/271258193d466e8cbabd
 * */
public class ClickListener extends RecyclerView.SimpleOnItemTouchListener {

    private OnItemClickListener mOnItemClickListener;
    private GestureDetector mGestureDetector;
    private View mChildView;
    private int mChildViewAdapterPosition;
    private Object clickedData = null;

    public ClickListener(OnItemClickListener listener, Context context) {
        mGestureDetector = new GestureDetector(context, new GestureDelegate());
        mOnItemClickListener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();

        mChildView = recyclerView.findChildViewUnder(x, y);

        if (mChildView != null) {
            mChildViewAdapterPosition = recyclerView.getChildAdapterPosition(mChildView);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if(adapter instanceof RecyclerViewAdapterBase){
                clickedData = ((RecyclerViewAdapterBase) adapter).getItemByPosition(mChildViewAdapterPosition);
            }
            mGestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }


    private class GestureDelegate extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (mOnItemClickListener != null) {
                if (mChildView != null) {
                    mOnItemClickListener.onItemDoubleClick(mChildViewAdapterPosition, clickedData);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (mOnItemClickListener != null) {
                if (mChildView != null) {
                    mOnItemClickListener.onItemClick(mChildViewAdapterPosition, clickedData);
                    return true;
                }
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            if (mOnItemClickListener != null) {
                if (mChildView != null) {
                    mOnItemClickListener.onItemLongClick(mChildViewAdapterPosition, clickedData);
                }
            }
        }
    }
}