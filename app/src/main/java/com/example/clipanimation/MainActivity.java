package com.example.clipanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.clipanimation.animations.CircleClipAnimation;
import com.example.clipanimation.animations.DroidClipAnimation;
import com.example.clipanimation.animations.LeftToRightClipAnimation;
import com.example.clipanimation.animations.TopToBottomClipAnimation;
import com.example.clipanimation.animations.ClipAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.clipAnimationImageView)
    ClipAnimationImageView clipAnimationImageView;
    @Bind(R.id.radioButtonTransformation)
    RadioGroup radioButtonTransformation;
    @Bind(R.id.buttonShow)
    Button buttonShow;
    @Bind(R.id.buttonHide)
    Button buttonHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clipAnimationImageView.show(getClipAnimation());
            }
        });

        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clipAnimationImageView.hide(getClipAnimation());
            }
        });
    }

    private ClipAnimation getClipAnimation() {
        switch (radioButtonTransformation.getCheckedRadioButtonId()) {
            default:
            case R.id.radioButtonCircle:
                return new CircleClipAnimation();
            case R.id.radioButtonLeftToRight:
                return new LeftToRightClipAnimation();
            case R.id.radioButtonTopToBottom:
                return new TopToBottomClipAnimation();
            case R.id.radioButtonDroid:
                return new DroidClipAnimation();
        }
    }
}
