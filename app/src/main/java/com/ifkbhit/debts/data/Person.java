package com.ifkbhit.debts.data;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.ifkbhit.debts.StaticUtils;

public class Person {

    public Person(String name, int imageId, double total, long id) {
        this.name = name;
        this.imageId = imageId;
        this.total = total;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public Spannable getState() {
        String prefix;
        int color;
        if(total > 0){
            prefix = getName() + " owe you: ";
            color = Color.parseColor("#20bf6b");
        } else if(total == 0){
            return new SpannableString( "All in balance");
        } else {
            prefix = "You owe " + getName() + ": ";
            color = Color.parseColor("#eb3b5a");
        }
        String value = StaticUtils.toCurrencyString(total);
        Spannable result = new SpannableString(prefix+value);
        result.setSpan(new ForegroundColorSpan(color), prefix.length(), prefix.length() + value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }


    private String name;
    private int imageId;
    private double total;
    private long id;


    public long getId() {
        return id;
    }
}
