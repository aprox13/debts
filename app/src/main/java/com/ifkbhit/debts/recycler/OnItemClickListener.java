package com.ifkbhit.debts.recycler;

public interface OnItemClickListener {
    default void onItemDoubleClick(int position, Object clickedData){}
    void onItemClick(int position, Object clickedData);
    default void onItemLongClick(int position, Object clickedData){}

}
