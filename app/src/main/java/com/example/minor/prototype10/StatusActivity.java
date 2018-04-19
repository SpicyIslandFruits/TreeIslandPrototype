package com.example.minor.prototype10;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.minor.prototype10.StatusActivityFragments.EquipmentFragment;
import com.example.minor.prototype10.StatusActivityFragments.ItemFragment;
import com.example.minor.prototype10.StatusActivityFragments.SkillFragment;
import com.example.minor.prototype10.StatusActivityFragments.StatusFragment;

/**
 * ほとんどの処理はフラグメントで行うのでここを編集する必要はないです
 */
public class StatusActivity extends AppCompatActivity {
    ImageButton statusButton;
    ImageButton equipmentButton;
    ImageButton skillButton;
    ImageButton itemButton;
    ImageButton backButton;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment statusFragment, equipmentFragment, skillFragment, itemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        statusButton = (ImageButton) findViewById(R.id.status_button);
        equipmentButton = (ImageButton) findViewById(R.id.equipment_button);
        skillButton = (ImageButton) findViewById(R.id.skill_button);
        itemButton = (ImageButton) findViewById(R.id.item_button);
        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
        equipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
        skillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
    }

    public void ChangeFragment(View view){
        if (view == statusButton){
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            statusFragment = new StatusFragment();
            fragmentTransaction.replace(R.id.fragment_player_info, statusFragment);
            fragmentTransaction.commit();
        }
        if (view == equipmentButton){
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            equipmentFragment = new EquipmentFragment();
            fragmentTransaction.replace(R.id.fragment_player_info, equipmentFragment);
            fragmentTransaction.commit();
        }
        if(view == skillButton){
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            skillFragment = new SkillFragment();
            fragmentTransaction.replace(R.id.fragment_player_info, skillFragment);
            fragmentTransaction.commit();
        }
        if(view == itemButton){
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            itemFragment = new ItemFragment();
            fragmentTransaction.replace(R.id.fragment_player_info, itemFragment);
            fragmentTransaction.commit();
        }
    }
}
