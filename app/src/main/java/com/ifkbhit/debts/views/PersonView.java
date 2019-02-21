package com.ifkbhit.debts.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifkbhit.debts.R;
import com.ifkbhit.debts.StaticUtils;
import com.ifkbhit.debts.data.Person;
import com.ifkbhit.debts.recycler.IBindableView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

@EViewGroup(R.layout.person)
public class PersonView extends CardView implements IBindableView {


    @ViewById
    ImageView icon;

    @ViewById
    TextView name;

    @ViewById
    TextView state;

    public PersonView(Context context) {
        super(context);
    }


    @Override
    public void bind(Object item) {
        if (item instanceof Person) {
            Person person = (Person) item;

            name.setText(person.getName());
            state.setText(person.getState());
            StaticUtils.picassoSetRoundedIcon(person.getImageId(), icon);
            setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public View getView() {
        return this;
    }
}
