package com.ifkbhit.debts.recycler;

import android.view.View;

public interface IBindableView {

    void bind(Object item);
    View getView();
}

