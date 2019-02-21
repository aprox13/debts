package com.ifkbhit.debts;

import com.ifkbhit.debts.data.Person;

public class MainPresenter {

    MainViewer viewer;
    Model model;


    public MainPresenter() {
        this(null);
    }

    public MainPresenter(MainViewer viewer) {
        setViewer(viewer);
        model = new Model();
    }

    void setViewer(MainViewer viewer) {
        this.viewer = viewer;
    }

    public void showPersons() {
        viewer.setData(model.getPersons());
    }



    public void itemClick(int position, Object clickedData) {
        if(clickedData instanceof Person){
            viewer.openPersonDetail((Person) clickedData);
            //viewer.showToast(((Person) clickedData).getName());
        } else {
            viewer.showToast("Unknown item");
        }
    }
}
