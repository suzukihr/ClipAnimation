package com.example.clipanimation.animations;

import android.graphics.Path;

/**
 * Created by suzukihr on 2016/02/02.
 */
public class DroidClipAnimation implements ClipAnimation {
    @Override
    public Path createPath(float progress, int width, int height) {
        float radius = (float) (Math.sqrt(width * width + height * height) / 2f);
        float leftEyeX = width * 62.8f / 192;
        float leftEyeY = height * 73.5f / 192;
        float rightEyeX = width * 128.8f / 192;
        float rightEyeY = leftEyeY;

        Path path = new Path();
        path.addCircle(leftEyeX, leftEyeY, radius * progress, Path.Direction.CCW);
        path.addCircle(rightEyeX, rightEyeY, radius * progress, Path.Direction.CCW);
        return path;
    }
}
