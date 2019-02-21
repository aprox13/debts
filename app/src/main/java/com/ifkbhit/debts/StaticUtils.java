package com.ifkbhit.debts;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class StaticUtils {

    private static final char SEPARATOR = ' ';

    private static final char CURRENCY = '€';

    private static String priceWithDecimal(Double price) {
        DecimalFormatSymbols separator = new DecimalFormatSymbols();
        separator.setGroupingSeparator(SEPARATOR);
        separator.setDecimalSeparator('.');
        DecimalFormat formatter = new DecimalFormat("###,###,###.00", separator);
        return formatter.format(price);
    }

    private static String priceWithoutDecimal(Double price) {
        DecimalFormatSymbols separator = new DecimalFormatSymbols();
        separator.setGroupingSeparator(SEPARATOR);
        separator.setDecimalSeparator('.');
        DecimalFormat formatter = new DecimalFormat("###,###,###.##", separator);
        return formatter.format(price);
    }

    public static String toCurrencyString(Double price) {
        price = Math.abs(price);
        String toShow = priceWithoutDecimal(price);
        if (toShow.indexOf(".") > 0) {
            return priceWithDecimal(price) + CURRENCY;
        }
        return priceWithoutDecimal(price) + CURRENCY;

    }


    public static int convertDpToPixel(float dp, Context context) {
        return (int) (dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }


    public static void picassoSetRoundedIcon(int id, ImageView icon) {
        Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(50)
                .oval(false)
                .build();
        Picasso.get().load(id).fit().centerCrop().transform(transformation).into(icon);
    }
}
