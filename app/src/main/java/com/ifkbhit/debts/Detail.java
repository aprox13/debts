package com.ifkbhit.debts;

import android.widget.ImageView;
import android.widget.TextView;

import com.ifkbhit.debts.data.Person;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@EActivity(R.layout.activity_person_detail)
public class Detail extends AppCompatActivity {

    @Extra
    long id;

    @ViewById
    Toolbar toolbar;


    @ViewById
    ImageView toolbarIcon;

    @ViewById
    TextView toolbarTitle;

    @ViewById
    RecyclerView items;

    @Bean
    OperationsAdapter adapter;

    @AfterViews
    void init(){

        Model model = new Model();
        Person p = model.getPersonById(id);
        toolbar.setTitle("");
        if(p == null){
            toolbarTitle.setText("null");
            return;
        }
        toolbarTitle.setText(p.getName());
        StaticUtils.picassoSetRoundedIcon(p.getImageId(), toolbarIcon);


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setDisplayShowHomeEnabled(true);
        }


        adapter.setItems(model.getOperationsForPerson(id));
        items.setLayoutManager(new LinearLayoutManager(this));
        items.setAdapter(adapter);


    }

    @OptionsItem(android.R.id.home)
    void home(){
        onBackPressed();
    }

}
