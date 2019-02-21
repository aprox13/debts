package com.ifkbhit.debts;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.widget.Toast;

import com.ifkbhit.debts.data.Person;
import com.ifkbhit.debts.recycler.ClickListener;
import com.ifkbhit.debts.recycler.DividerDecorator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainViewer {


    @ViewById
    RecyclerView list;

    @Bean
    PersonAdapter adapter;

    MainPresenter presenter = null;


    @AfterViews
    void init() {

        if(presenter == null){
            presenter = new MainPresenter(this);
        } else {
            presenter.setViewer(this);
        }

        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerDecorator(new Rect(8, 5, 8, 0), this));
        list.setAdapter(adapter);
        list.addOnItemTouchListener(new ClickListener(presenter::itemClick, this));

        presenter.showPersons();
    }


    @Override
    public void setData(List<Person> data) {
        adapter.setItems(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "showToast(\""+message+"\") called");
    }

    @Override
    public void openPersonDetail(Person person) {
        Detail_.intent(this).id(person.getId()).start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.setViewer(null);
    }
}
