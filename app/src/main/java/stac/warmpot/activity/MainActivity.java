package stac.warmpot.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;


import java.util.ArrayList;

import stac.warmpot.FragmentUtils;
import stac.warmpot.R;
import stac.warmpot.fragment.BookFragment;
import stac.warmpot.fragment.PlantgrowFragment;
import stac.warmpot.fragment.PotFragment;
import stac.warmpot.fragment.SettingsFragment;
import stac.warmpot.fragment.SpeakFragment;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> fragments;
    FrameLayout frameLayout;
    PotFragment potFragment;
    SpeakFragment speakFragment;
    BookFragment bookFragment;
    SettingsFragment settingsFragment;
    PlantgrowFragment plantgrowFragment;


    ConstraintLayout bottomnavigation;
    ConstraintLayout i1, i2, i3, i4;
    ImageView iv1, iv2, iv3, iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments=new ArrayList<>();

        potFragment=new PotFragment();
        speakFragment=new SpeakFragment();
        bookFragment=new BookFragment();
        settingsFragment=new SettingsFragment();
        plantgrowFragment=new PlantgrowFragment();

        frameLayout=findViewById(R.id.FrameLayout);
        i1 = findViewById(R.id.item_1);
        i2 = findViewById(R.id.item_2);
        i3 = findViewById(R.id.item_3);
        i4 = findViewById(R.id.item_4);
        iv1 = findViewById(R.id.item_1_image);
        iv2 = findViewById(R.id.item_2_image);
        iv3 = findViewById(R.id.item_3_image);
        iv4 = findViewById(R.id.item_4_image);

        bottomnavigation = findViewById(R.id.navigation_var);
        bottomnavigation.bringToFront();
        fragments.add(potFragment);
        fragments.add(speakFragment);
        fragments.add(bookFragment);
        fragments.add(settingsFragment);
        fragments.add(plantgrowFragment);
        final FragmentUtils fragmentUtils=new FragmentUtils(R.id.FrameLayout,fragments);
        iv1.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
        fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(),0,new Bundle());
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setStatusBarColor(0xff2eec7e);
                iv1.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv4.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(),0,new Bundle());
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setStatusBarColor(0xff2eec7e);
                iv4.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv2.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv1.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(),1,new Bundle());
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setStatusBarColor(0xff2eec7e);
                iv1.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv3.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                iv4.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(),2,new Bundle());
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setStatusBarColor(0xfffafafa);
                iv1.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                iv4.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(),3,new Bundle());
            }
        });


    }


}
