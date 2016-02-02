package com.example.clipanimation.animations;

import android.graphics.Path;

/**
 * Created by suzukihr on 2016/02/02.
 */
public interface ClipAnimation {
    Path createPath(float progress, int width, int height);
}
