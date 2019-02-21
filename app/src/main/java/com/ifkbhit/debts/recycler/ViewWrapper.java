package com.ifkbhit.debts.recycler;

import androidx.recyclerview.widget.RecyclerView;


public class ViewWrapper extends RecyclerView.ViewHolder {

    private IBindableView view;

    public ViewWrapper(IBindableView itemView) {
        super(itemView.getView());
        view = itemView;
    }

    public IBindableView getView() {
        return view;
    }
}