package stac.warmpot.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int i) {
                Log.e("asdf", String.valueOf(i));
                switch (i) {
                    case 0:
                        iv1.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        break;
                    case 1:
                        iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv2.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv1.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        break;
                    case 2:
                        iv2.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        iv3.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv4.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        break;
                    case 3:
                        iv4.setBackgroundTintList(ColorStateList.valueOf(0xff2EEC7E));
                        iv3.setBackgroundTintList(ColorStateList.valueOf(0xffa1a1a1));
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });


    }


}
