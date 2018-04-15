package com.example.minor.prototype10;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmBaseAdapter;

public class WeaponAdapter extends RealmBaseAdapter<WeaponId> {
    Realm realm;
    PlayerInfo playerInfo;
    int weaponId;
    MakeData makeData;

    //暫定的にnameとする。
    private static class ViewHolder{
        TextView name;
    }
    public WeaponAdapter(@Nullable OrderedRealmCollection<WeaponId> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        SuperWeapon weapon;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        WeaponId weaponIdClass = adapterData.get(position);
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                playerInfo = realm.where(PlayerInfo.class).findFirst();
                weaponId = playerInfo.getWeaponId();
            }
        });
        makeData = new MakeData();
        weapon = makeData.makeWeaponFromId(weaponId);
        return null;
    }
}
