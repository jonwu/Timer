package com.wu.jonathan.timer;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimerControllers extends Fragment {

    @BindView(R.id.etTime)
    EditText etTime;
    @BindView(R.id.btSet)
    Button btSet;
    @BindView(R.id.btStart)
    Button btStart;
    @BindView(R.id.btStop)
    Button btStop;

    TimerSingleton timerSingleton = TimerSingleton.getInstance();

    public TimerControllers() {
        // Required empty public constructor
    }

    public static TimerControllers newInstance() {
        return new TimerControllers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.timer_controllers_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btSet)
    public void onClickSet(View view) {
        timerSingleton.setTime(Integer.parseInt(etTime.getText().toString()));
    }
    @OnClick(R.id.btStart)
    public void onStart(View view) {
        timerSingleton.start();
    }

    @OnClick(R.id.btStop)
    public void onStop(View view) {
        timerSingleton.stop();
    }
    @OnClick(R.id.btClear)
    public void onClear(View view) {
        timerSingleton.clear();
    }

    @Override
    public void onPause() {
        super.onPause();
        timerSingleton.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        timerSingleton.start();
    }
}
