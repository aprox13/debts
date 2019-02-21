package com.ifkbhit.debts;

import com.ifkbhit.debts.data.Person;

import java.util.List;

public interface MainViewer {
    void setData(List<Person> data);
    void showToast(String message);
    void openPersonDetail(Person person);
}
