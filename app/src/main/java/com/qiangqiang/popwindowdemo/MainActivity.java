package com.qiangqiang.popwindowdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> menuItemList;
    private ImageButton menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopwindow();
            }
        });

    }

    PopMenu popupMenu;

    private void initPopwindow() {
        if (popupMenu == null) {
            menuItemList = new ArrayList<>();
            popupMenu = new PopMenu(this, menuItemList);
        }
        menuItemList.clear();
        menuItemList.addAll(getMoreMenuItems());
        popupMenu.show(menu);
    }

    private List<String> getMoreMenuItems() {
        List<String> datas = new ArrayList<>();
        datas.add("asdfasdfasdfasdf");
        datas.add("asdfasdfasdfasdf");
        datas.add("asdfasdfasdfasdf");

        return datas;
    }
}
