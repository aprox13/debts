package com.ifkbhit.debts.recycler;

import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerViewAdapterBase<T> extends RecyclerView.Adapter<ViewWrapper> {

    private List<T> items = new ArrayList<>();


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public final ViewWrapper onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("BaseAdapter", "OnCreateViewHolder");
        return new ViewWrapper(onCreateItemView(parent, viewType));
    }

    protected abstract IBindableView onCreateItemView(ViewGroup parent, int viewType);


    public void onBindViewHolder(@NonNull ViewWrapper holder, int position) {
        holder.getView().bind(getItemByPosition(position));
    }

    public T getItemByPosition(int position) {
        if (position < 0 || position >= items.size()) {
            return null;
        }
        return items.get(position);
    }
}