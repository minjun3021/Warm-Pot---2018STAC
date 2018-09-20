package stac.warmpot.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import stac.warmpot.R;
import stac.warmpot.adapter.ViewpagerAdapter;

public class MainActivity extends AppCompatActivity {
    //TODO 가져오기
    ViewPager viewpager;
    ViewpagerAdapter mAdapter;
    ConstraintLayout bottomnavigation;
    ConstraintLayout i1, i2, i3, i4;
    ImageView iv1, iv2, iv3, iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = findViewById(R.id.ViewPager);
        mAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        i1 = findViewById(R.id.item_1);
        i2 = findViewById(R.id.item_2);
        i3 = findViewById(R.id.item_3);
        i4 = findViewById(R.id.item_4);
        iv1 = findViewById(R.id.item_1_image);
        iv2 = findViewById(R.id.item_2_image);
        iv3 = findViewById(R.id.item_3_image);
        iv4 = findViewById(R.id.item_4_image);
        viewpager.setAdapter(mAdapter);
        bottomnavigation = findViewById(R.id.navigation_var);
        bottomnavigation.bringToFront();
        iv1.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(0);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(1);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(2);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(3);
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        iv1.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv4.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        Log.e("cu", String.valueOf(viewpager.getCurrentItem()));
                        break;
                    case 1:
                        iv4.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv2.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv1.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        Log.e("cu", String.valueOf(viewpager.getCurrentItem()));
                        break;
                    case 2:
                        iv1.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv3.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv4.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        Log.e("cu", String.valueOf(viewpager.getCurrentItem()));
                        break;
                    case 3:
                        iv1.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv4.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        Log.e("cu", String.valueOf(viewpager.getCurrentItem()));
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });


    }


}
