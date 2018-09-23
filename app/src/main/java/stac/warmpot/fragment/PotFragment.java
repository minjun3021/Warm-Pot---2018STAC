package stac.warmpot.fragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import stac.warmpot.R;


public class PotFragment extends Fragment {
    TextView t1,t2,t3;
    ConstraintLayout constraintLayout;
    public static PotFragment newInstance() {
        PotFragment fragment = new PotFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pot, container, false);
        t1=v.findViewById(R.id.pot_t1);
        t2=v.findViewById(R.id.pot_t2);
        t3=v.findViewById(R.id.pot_t3);

        constraintLayout=v.findViewById(R.id.pot_layout);
        constraintLayout.bringToFront();

        return v;
    }

}
