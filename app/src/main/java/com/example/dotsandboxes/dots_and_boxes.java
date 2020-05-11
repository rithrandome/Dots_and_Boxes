package com.example.dotsandboxes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;



public class dots_and_boxes extends View {

    Paint paint1, paint;
//    Bitmap b;
//    Matrix m;
    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    //private Paint blackPaint = new Paint();
    //private boolean[][] cellChecked;
    int width = getWidth();
    int height = getHeight();
    DisplayMetrics metrics = this.getResources().getDisplayMetrics();
    int Width = metrics.widthPixels;
    int Height = metrics.heightPixels;


    public dots_and_boxes(Context context) {

        super(context);
        paint1 = new Paint();
        paint = new Paint();
    }


//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        paint.setColor(Color.RED);
//        canvas.drawBitmap(b,m,paint);
//        canvas.drawCircle(500,500,400,paint);
//    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
        calculateDimensions();
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumRows() {
        return numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        int extra_h,extra_w;
        if (numColumns < 1 || numRows < 1) {
            return;
        }

        cellWidth = Width / numColumns;
        cellHeight = Height / numRows;

        if(cellWidth < cellHeight) {
            cellHeight = cellWidth;
            extra_h = (Height / cellHeight) - numRows ;
        }
        else
            cellWidth = cellHeight;

        //cellChecked = new boolean[numColumns][numRows];

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);

        if (numColumns == 0 || numRows == 0) {
            return;
        }

//        for (int i = 0; i < numColumns; i++) {
//            for (int j = 0; j < numRows; j++) {
//                if (cellChecked[i][j]) {
//
//                    canvas.drawRect(i * cellWidth, j * cellHeight,
//                            (i + 1) * cellWidth, (j + 1) * cellHeight,
//                            paint);
//                }
//            }
//        }

        for (int i = 1; i < numColumns; i++) {
            canvas.drawLine(i * cellWidth, 0, 10, Height, paint);

        }

        for (int i = 1; i < numRows; i++) {
            canvas.drawLine(0, i * cellHeight, Width, i * cellHeight, paint);
        }

        for(int i = 0; i< numColumns; i++){
            for(int j = 0; j < numRows; j++){
                canvas.drawCircle(i * cellWidth, j*cellHeight, 10, paint);
            }
        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            int column = (int)(event.getX() / cellWidth);
//            int row = (int)(event.getY() / cellHeight);
//
//            cellChecked[column][row] = !cellChecked[column][row];
//            invalidate();
//        }
//
//        return true;
//    }
}
