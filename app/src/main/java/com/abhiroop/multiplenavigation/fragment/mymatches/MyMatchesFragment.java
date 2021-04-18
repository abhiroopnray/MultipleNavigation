package com.abhiroop.multiplenavigation.fragment.mymatches;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abhiroop.multiplenavigation.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class MyMatchesFragment extends Fragment {

    private MyMatchesViewModel mViewModel;
    private static final Random RANDOM = new Random();
    private LineGraphSeries<DataPoint> series;
    private int lastX = 0;

    public static MyMatchesFragment newInstance() {
        return new MyMatchesFragment();
    }

    private MyMatchesFragment myMatchesFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(MyMatchesViewModel.class);
        View root = inflater.inflate(R.layout.my_matches_fragment, container, false);
        setupGraphView(root);
        /*final TextView textView = root.findViewById(R.id.tv);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    private void setupGraphView(View view) {
        GraphView graph = (GraphView) view.findViewById(R.id.graph);
        graph.setBackgroundColor(getContext().getColor(R.color.white));
        // data
        series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);
        // customize a little bit viewport
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(10);
        viewport.setScrollable(true);
    }

    private void addEntry(){
        series.appendData(new DataPoint(lastX++, RANDOM.nextDouble() * 10d), true, 100 );

    }

    @Override
    public void onResume() {
        super.onResume();
        /*new Thread(new Runnable() {

            @Override
            public void run() {
                // we add 100 new entries
                for (int i = 0; i < 100; i++) {
                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            addEntry();
                        }
                    });

                    // sleep to slow down the add of entries
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        // manage error ...
                    }
                }
            }
        }).start();*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MyMatchesViewModel.class);
        // TODO: Use the ViewModel
    }

}