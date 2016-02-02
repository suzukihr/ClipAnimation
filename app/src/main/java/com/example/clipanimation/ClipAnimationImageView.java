package com.example.clipanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.clipanimation.animations.ClipAnimation;

public class ClipAnimationImageView extends ImageView {

    // animation parameters
    private int duration = 800;
    private Interpolator interpolator = new LinearInterpolator();

    // animation type
    private ClipAnimation clipAnimation;

    // progress for animation
    private float progress = 1f;

    public ClipAnimationImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (clipAnimation != null) {
            canvas.clipPath(clipAnimation.createPath(progress, getWidth(), getHeight()));
        }
        super.onDraw(canvas);
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    /**
     * getter for ObjectAnimator
     */
    public float getProgress() {
        return progress;
    }

    /**
     * setter for ObjectAnimator
     */
    public void setProgress(float progress) {
        this.progress = progress;
    }

    public void show(ClipAnimation clipAnimation) {

        this.clipAnimation = clipAnimation;

        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 0, 1f);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                setVisibility(View.VISIBLE);
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        animator.start();
    }

    public void hide(ClipAnimation clipAnimation) {

        this.clipAnimation = clipAnimation;

        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 1f, 0);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                setVisibility(View.INVISIBLE);
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        animator.start();
    }
}
