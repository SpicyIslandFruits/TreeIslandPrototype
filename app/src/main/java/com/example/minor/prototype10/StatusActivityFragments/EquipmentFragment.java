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
import android.widget.TextView;

import com.example.minor.prototype10.ArmorAdapter;
import com.example.minor.prototype10.MakeData;
import com.example.minor.prototype10.Models.ArmorId;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WeaponAdapter;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;
import io.realm.RealmResults;

public class EquipmentFragment extends Fragment {
    private Realm realm;
    private RealmResults<WeaponId> weaponIds;
    private RealmResults<ArmorId> armorIds;
    private WeaponId weaponIdInstance;
    private MakeData makeData;
    private SuperWeapon weapon;
    private PlayerInfo playerInfo;
    private WeaponAdapter weaponAdapter;
    private ArmorAdapter armorAdapter;
    private ListView weaponList, armorList;
    private TextView equipedWeapon, weaponName, weaponATK, weaponSkill1, weaponSkill2, weaponSkill3;
    private TextView equipedArmor, armorName, armorDF, armorSkill1, armorSkill2, armorSkill3;
    private int weaponId, armorId;

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
        makeData = new MakeData();
        weaponList = (ListView) view.findViewById(R.id.weapon_list);
        armorList = (ListView) view.findViewById(R.id.armor_list);
        equipedWeapon = (TextView) view.findViewById(R.id.equiped_weapon);
        weaponName = (TextView) view.findViewById(R.id.weapon_name);
        equipedArmor = (TextView) view.findViewById(R.id.equiped_armor);
        weaponATK = (TextView) view.findViewById(R.id.weapon_atk);
        weaponSkill1 = (TextView) view.findViewById(R.id.weapon_skill1);
        weaponSkill2 = (TextView) view.findViewById(R.id.weapon_skill2);
        weaponSkill3 = (TextView) view.findViewById(R.id.weapon_skill3);
        weaponIds = realm.where(WeaponId.class).findAll();
        armorIds = realm.where(ArmorId.class).findAll();
        weaponAdapter = new WeaponAdapter(weaponIds);
        armorAdapter = new ArmorAdapter(armorIds);
        weaponList.setAdapter(weaponAdapter);
        armorList.setAdapter(armorAdapter);
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        weaponId = playerInfo.getWeaponId();
        weapon = makeData.makeWeaponFromId(weaponId);
        equipedWeapon.setText(weapon.getName());
        weaponATK.setText("攻撃力:"+String.valueOf(weapon.getAtk()));
        weaponSkill1.setText(weapon.getSkill1Info());
        weaponSkill2.setText(weapon.getSkill2Info());
        weaponSkill3.setText(weapon.getSkill3Info());

        weaponList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                weaponIdInstance = (WeaponId) parent.getItemAtPosition(position);
                weaponId = weaponIdInstance.getWeaponId();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        playerInfo = realm.where(PlayerInfo.class).findFirst();
                        playerInfo.setWeaponId(weaponId);
                    }
                });
                weapon = makeData.makeWeaponFromId(weaponId);
                equipedWeapon.setText(weapon.getName());
                weaponName.setText(weapon.getName());
                weaponATK.setText("攻撃力:"+String.valueOf(weapon.getAtk()));
                weaponSkill1.setText(weapon.getSkill1Info());
                weaponSkill2.setText(weapon.getSkill2Info());
                weaponSkill3.setText(weapon.getSkill3Info());
            }
        });

        armorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}