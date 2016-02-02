package com.example.clipanimation.animations;

import android.graphics.Path;

/**
 * Created by suzukihr on 2016/02/02.
 */
public class LeftToRightClipAnimation implements ClipAnimation {
    @Override
    public Path createPath(float progress, int width, int height) {
        Path path = new Path();
        path.addRect(0, 0, width * progress, height, Path.Direction.CCW);
        return path;
    }
}
