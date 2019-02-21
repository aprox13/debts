package com.ifkbhit.debts.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifkbhit.debts.R;
import com.ifkbhit.debts.StaticUtils;
import com.ifkbhit.debts.data.Operation;
import com.ifkbhit.debts.recycler.IBindableView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


@EViewGroup(R.layout.give)
public class GiveItemView extends ConstraintLayout implements IBindableView {

    @ViewById
    TextView value;

    @ViewById
    ImageView icon;

    @ViewById
    TextView name;

    public GiveItemView(Context context) {
        super(context);
    }


    @Override
    public void bind(Object item) {
        if(item instanceof Operation){
            Operation operation = (Operation) item;
            value.setText(StaticUtils.toCurrencyString(operation.getValue()));
            StaticUtils.picassoSetRoundedIcon(R.drawable.ic_photo_camera, icon);
            setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public View getView() {
        return this;
    }
}
