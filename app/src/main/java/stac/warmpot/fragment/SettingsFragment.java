package stac.warmpot.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import stac.warmpot.R;
import stac.warmpot.activity.LoginActivity;
import stac.warmpot.activity.MainActivity;
import stac.warmpot.activity.connect;


public class SettingsFragment extends Fragment implements View.OnClickListener {
    MainActivity mainActivity= (MainActivity) getActivity();
    ConstraintLayout c1,c2,c3;
    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_settings, container, false);

        c1=v.findViewById(R.id.layout_logout);
        c2=v.findViewById(R.id.layout_mypot);
        c3=v.findViewById(R.id.layout_parent);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.layout_logout:
                mainActivity.SharedDelete();
                Log.e("logout","gg");

                break;
            case R.id.layout_mypot:
                Log.e("mypot","gg");
                break;
            case R.id.layout_parent:
                Log.e("parent","gg");
                break;
        }
    }
}
