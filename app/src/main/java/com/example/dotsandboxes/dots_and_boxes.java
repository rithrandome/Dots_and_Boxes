package com.example.dotsandboxes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;



public class dots_and_boxes extends View {

    Paint paint;


    public dots_and_boxes(Context context) {

        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(700,700,300,paint);
        canvas.drawCircle(700,1500,300,paint);

    }
}
