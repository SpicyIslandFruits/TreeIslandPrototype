package com.example.minor.prototype10.StatusActivityFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.minor.prototype10.ArmorAdapter;
import com.example.minor.prototype10.Models.ArmorId;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WeaponAdapter;

import io.realm.Realm;
import io.realm.RealmResults;

/*
* view.findViewById書く
* 武器が選択されたときに、装備中武器のidに武器のidを格納し、装備中画面の文字を変更する処理を
* onItemClickの中に書く
* 詳細画面に武器のatkとスキルを表示する処理を武器クラスの中に描く、まずインターフェースを完成させる
* インターフェースの変数を使っているためインターフェース内で定義したメソッド以外使えないことに注意
* onItemClickの中にMakeDataから武器のインスタンスを作成し、詳細画面に表示させる処理を描く
* 防具についても同様
*/

public class EquipmentFragment extends Fragment {
    Realm realm;
    ListView weaponList, armorList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        return inflater.inflate(R.layout.fragment_equipment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        weaponList = (ListView) view.findViewById(R.id.weapon_list);
        armorList = (ListView) view.findViewById(R.id.armor_list);
        RealmResults<WeaponId> weaponIds = realm.where(WeaponId.class).findAll();
        RealmResults<ArmorId> armorIds = realm.where(ArmorId.class).findAll();
        WeaponAdapter weaponAdapter = new WeaponAdapter(weaponIds);
        ArmorAdapter armorAdapter = new ArmorAdapter(armorIds);
        weaponList.setAdapter(weaponAdapter);
        armorList.setAdapter(armorAdapter);

        weaponList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });

        armorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
