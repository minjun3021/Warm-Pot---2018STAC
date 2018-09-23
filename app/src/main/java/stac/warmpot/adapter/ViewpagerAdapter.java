package stac.warmpot.adapter;

        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;

        import stac.warmpot.fragment.BookFragment;
        import stac.warmpot.fragment.PlantgrowFragment;
        import stac.warmpot.fragment.PotFragment;
        import stac.warmpot.fragment.SettingsFragment;
        import stac.warmpot.fragment.SpeakFragment;

public class ViewpagerAdapter extends FragmentPagerAdapter {

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return PotFragment.newInstance();
            case 1:
                return SpeakFragment.newInstance();
            case 2:
                return BookFragment.newInstance();
            case 3:
                return PlantgrowFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
