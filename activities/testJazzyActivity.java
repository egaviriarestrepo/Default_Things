package com.example.egaviria.defaultactivities.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.egaviria.defaultactivities.R;

public class testJazzyActivity extends FragmentActivity {

    private JazzyViewPager pager;
    private Spinner spnSelectStyle;

    private LinkedList<String> spinnerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_jazzy);

        pager = (JazzyViewPager) findViewById(R.id.jazzy_pager);
        spnSelectStyle = (Spinner) findViewById(R.id.select_style);

        // set spinner adapter
        setSpinnerAdapter();

        // set item selected event for spinner
        spnSelectStyle.setOnItemSelectedListener(onItemSelected());
    }

    private void setSpinnerAdapter() {
        spinnerList = new LinkedList<String>();

        // adding data
        spinnerList.add("Standard");
        spinnerList.add("Tablet");
        spinnerList.add("CubeIn");
        spinnerList.add("CubeOut");
        spinnerList.add("Flip");
        spinnerList.add("Stack");
        spinnerList.add("ZoomIn");
        spinnerList.add("ZoomOut");
        spinnerList.add("RotateUp");
        spinnerList.add("RotateDown");
        spinnerList.add("Accordion");

        // set adapter
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSelectStyle.setAdapter(dataAdapter);
    }

    private void setViewPagerAdapter(String style) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), style, pager);
        pager.setAdapter(adapter);
    }

    /**
     * set animation style for viewpager
     * @param effect
     */
    private void setupJazziness(TransitionEffect effect) {
        pager.setTransitionEffect(effect);
    }

    /**
     * Handle selecting item event of spinner
     * @return
     */
    private OnItemSelectedListener onItemSelected() {
        return new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //set viewpager animation style based on positon selected
                switch (position) {
                    case 0:
                        setupJazziness(TransitionEffect.Standard);
                        break;

                    case 1:
                        setupJazziness(TransitionEffect.Tablet);
                        break;

                    case 2:
                        setupJazziness(TransitionEffect.CubeIn);
                        break;

                    case 3:
                        setupJazziness(TransitionEffect.CubeOut);
                        break;

                    case 4:
                        setupJazziness(TransitionEffect.FlipHorizontal);
                        break;

                    case 5:
                        setupJazziness(TransitionEffect.Stack);
                        break;

                    case 6:
                        setupJazziness(TransitionEffect.ZoomIn);
                        break;

                    case 7:
                        setupJazziness(TransitionEffect.ZoomOut);
                        break;

                    case 8:
                        setupJazziness(TransitionEffect.RotateUp);
                        break;

                    case 9:
                        setupJazziness(TransitionEffect.RotateDown);
                        break;

                    case 10:
                        setupJazziness(TransitionEffect.Accordion);
                        break;

                    default:
                        break;
                }

                //set viewpager adapter
                String style = parent.getItemAtPosition(position).toString();
                setViewPagerAdapter(style);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        };
    }

}
