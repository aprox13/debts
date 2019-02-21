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

@EViewGroup(R.layout.take)
public class TakeItemView extends ConstraintLayout implements IBindableView {

    public TakeItemView(Context context) {
        super(context);
    }

    @ViewById
    TextView value;

    @ViewById
    ImageView icon;

    @ViewById
    TextView name;



    @Override
    public void bind(Object item) {
        if(item instanceof Operation){
            Operation operation = (Operation) item;
            value.setText(StaticUtils.toCurrencyString(operation.getValue()));
            StaticUtils.picassoSetRoundedIcon(R.drawable.ic_0, icon);
            setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public View getView() {
        return this;
    }
}
