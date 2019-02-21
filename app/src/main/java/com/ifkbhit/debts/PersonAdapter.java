package com.ifkbhit.debts;

import android.content.Context;
import android.view.ViewGroup;

import com.ifkbhit.debts.data.Person;
import com.ifkbhit.debts.recycler.IBindableView;
import com.ifkbhit.debts.recycler.RecyclerViewAdapterBase;
import com.ifkbhit.debts.views.PersonView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;


@EBean
public class PersonAdapter extends RecyclerViewAdapterBase<Person> {


    @RootContext
    Context context;

    @Override
    protected IBindableView onCreateItemView(ViewGroup parent, int viewType) {
        return PersonView_.build(context);
    }


}
