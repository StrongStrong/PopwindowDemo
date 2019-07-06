package com.qiangqiang.popwindowdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author shiming
 * @time 2017/5/11 19:08
 * @desc  可以动态的设置很多
 */

public class PopupMenuExtendAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mPopupItemList;
    private final LayoutInflater mInflater;

    public PopupMenuExtendAdapter(Context context, List<String> popupItemList) {
        mContext = context;
        mPopupItemList = popupItemList;
        //通过这个方法去拿到 infalter
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mPopupItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPopupItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder cache;
        if (convertView == null) {
             cache =  new ViewHolder();
            convertView = mInflater.inflate(R.layout.nim_popup_menu_list_item, null);
            cache.title = (TextView) convertView.findViewById(R.id.popup_menu_title);
            convertView.setTag(cache);
        } else {
           cache = (ViewHolder) convertView.getTag();
        }
        String item = mPopupItemList.get(position);
        cache.title.setText(item);

        // 下面代码实现数据绑定
        return convertView;
    }

    private final class ViewHolder {

        public ImageView icon;

        public TextView title;
    }

}
