package com.wu.jonathan.timer;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimerDisplay extends Fragment implements TimerSingleton.View {


    @BindView(R.id.tvDisplay)
    TextView tvDisplay;

    TimerSingleton timerSingleton = TimerSingleton.getInstance();
    @BindView(R.id.ivSurprise)
    ImageView ivSurprise;

    public TimerDisplay() {
        // Required empty public constructor
    }

    public static TimerDisplay newInstance() {
        return new TimerDisplay();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.timer_display_fragment, container, false);
        ButterKnife.bind(this, view);
        timerSingleton.setView(this);
        Picasso.with(getActivity()).load("http://trendingcurrentevents.com/wp-content/uploads/2017/02/who-did-it-better-spongebob-lady-gaga-superbowl.jpg").into(ivSurprise);

        return view;
    }

    @Override
    public void onSet(int time) {
        tvDisplay.setText("" + time);
    }

    @Override
    public void onToast(int time) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getActivity(), time + " seconds", duration);
        toast.show();
    }

    @Override
    public void showMeme() {
        ivSurprise.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideMeme() {
        ivSurprise.setVisibility(View.GONE);
    }

}
