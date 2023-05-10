package com.example.billiradball;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class Billiard extends View {

    ShapeDrawable mBall;
    int cx= 50;
    int cy= 50;
    final int radius = 50;


    int dir_x =1;
    int dir_y =1;
    int screen_w = Resources.getSystem().getDisplayMetrics().widthPixels;
    int screen_H = Resources.getSystem().getDisplayMetrics().heightPixels;

    int step_x = 5;
    int step_y = 15;

    public Billiard(Context context) {
        super(context);
        mBall = new ShapeDrawable(new OvalShape());
        mBall.getPaint().setColor(Color.MAGENTA);
        //mBall.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);

        if (cx <= radius)
            dir_x = 1;
        if (cx >= screen_w-radius)
            dir_x =-1;
        if (cy <= radius)
            dir_y = 1;
        if (cy >= screen_H-radius)
            dir_y =-1;

        cx = cx+ dir_x * step_x;
        cy = cy+dir_y * step_y;

        mBall.setBounds(cx-radius, cy-radius, cx+radius, cy+radius);
        mBall.draw(canvas);
        invalidate();



    }
}
