package stac.warmpot.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import stac.warmpot.R;


public class PlantgrowFragment extends Fragment {
    ImageView plant;
    ImageView src;
//    TextView t2,t3,t4,t5,t6,t7;
    public static PlantgrowFragment newInstance() {
        PlantgrowFragment fragment = new PlantgrowFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_plantgrow,container,false);
        plant=v.findViewById(R.id.grow_circle);
        src=v.findViewById(R.id.grow_image);

        plant.bringToFront();
        src.bringToFront();
        return v;
    }

}
