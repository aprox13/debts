package com.ifkbhit.debts;

import android.content.Context;
import android.view.ViewGroup;

import com.ifkbhit.debts.data.Operation;
import com.ifkbhit.debts.recycler.IBindableView;
import com.ifkbhit.debts.recycler.RecyclerViewAdapterBase;
import com.ifkbhit.debts.views.GiveItemView_;
import com.ifkbhit.debts.views.TakeItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class OperationsAdapter extends RecyclerViewAdapterBase<Operation> {


    @RootContext
    Context context;

    @Override
    protected IBindableView onCreateItemView(ViewGroup parent, int viewType) {


        return viewType == -1? TakeItemView_.build(context): GiveItemView_.build(context);
    }

    @Override
    public int getItemViewType(int position) {
        return getItemByPosition(position).getValue() > 0? 1: -1;
    }
}
