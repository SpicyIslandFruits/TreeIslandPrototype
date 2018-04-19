package com.example.minor.prototype10;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.WeaponId;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class WeaponAdapter extends RealmBaseAdapter<WeaponId> {
    private static class ViewHolder{
        TextView weaponName;
    }
    public WeaponAdapter(@Nullable OrderedRealmCollection<WeaponId> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.weaponName = convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        WeaponId weaponId = adapterData.get(position);
        viewHolder.weaponName.setText(weaponId.getName());
        return convertView;
    }
}
