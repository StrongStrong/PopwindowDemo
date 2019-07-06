package com.qiangqiang.popwindowdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.List;

public class PopMenu {
    private Context context;
    private List<String> datas;
    public PopupWindow popWindow;

    private View rootView;
    private PopupMenuExtendAdapter adapter;

    public PopMenu(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
        init();
    }

    private void init() {
        if (rootView == null) {
            rootView = LayoutInflater.from(context).inflate(R.layout.nim_popup_menu_layout, null);
            ListView listView = (ListView) rootView.findViewById(R.id.popmenu_listview);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
            adapter = new PopupMenuExtendAdapter(context, datas);
            listView.setAdapter(adapter);
        }
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_MENU && popWindow.isShowing()
                        && event.getAction() == KeyEvent.ACTION_DOWN) {
                    popWindow.dismiss();
                    return true;
                }
                return false;
            }
        });

        //初始化我们的popuwindow
        if (popWindow == null) {
            popWindow = new PopupWindow(context);
            popWindow.setContentView(rootView);
            popWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
            popWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
            popWindow.setTouchable(true);
            popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                }
            });
        }

    }
    public void show(View v) {
        if (popWindow == null) {
            return;
        }
        if (popWindow.isShowing()) {
            popWindow.dismiss();
        } else {

            popWindow.setFocusable(true);
            popWindow.showAsDropDown(v, 10, 10);
        }
    }

}
