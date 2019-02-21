package com.ifkbhit.debts.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

public class DividerDecorator extends RecyclerView.ItemDecoration {



    static class StaticUtils {
        public static int convertDpToPixel(float dp, Context context) {
            Resources resources = context.getResources();
            DisplayMetrics metrics = resources.getDisplayMetrics();
            return (int) (dp * (metrics.densityDpi / 160f));
        }
    }

    private Rect offset;


    public DividerDecorator(int dpHeight, Context context) {
        this(new Rect(0, 0, 0, dpHeight), context);
    }

    public DividerDecorator(Rect dps, Context context){
        offset = new Rect(
                StaticUtils.convertDpToPixel(dps.left, context),
                StaticUtils.convertDpToPixel(dps.top, context),
                StaticUtils.convertDpToPixel(dps.right, context),
                StaticUtils.convertDpToPixel(dps.bottom, context)
        );
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        outRect.left = offset.left;
        outRect.right = offset.right;
        outRect.bottom = offset.bottom;
        outRect.top = offset.top;

    }
}
