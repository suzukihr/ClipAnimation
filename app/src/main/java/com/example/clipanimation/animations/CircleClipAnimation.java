package com.example.clipanimation.animations;

import android.graphics.Path;

/**
 * Created by suzukihr on 2016/02/02.
 */
public class CircleClipAnimation implements ClipAnimation {
    @Override
    public Path createPath(float progress, int width, int height) {
        float radius = (float) (Math.sqrt(width * width + height * height) / 2f);
        float centerX = width / 2f;
        float centerY = height / 2f;

        Path path = new Path();
        path.addCircle(centerX, centerY, radius * progress, Path.Direction.CCW);
        return path;
    }
}
