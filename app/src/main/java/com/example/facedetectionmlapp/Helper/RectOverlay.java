package com.example.facedetectionmlapp.Helper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.google.android.gms.samples.vision.face.facetracker.ui.camera.GraphicOverlay;



public class RectOverlay extends com.google.android.gms.samples.vision.face.facetracker.ui.camera.GraphicOverlay.Graphic {

    private int mRectColor = Color.RED;
    private float mStrokeWidth = 3.0f;
    private Paint mRectPaint;
    private GraphicOverlay graphicOverlay;
    private Rect rect;


    public RectOverlay(GraphicOverlay graphicOverlay, Rect rect) {
        super(graphicOverlay);
        mRectPaint = new Paint();
        mRectPaint.setColor(mRectColor);
        mRectPaint.setStyle(Paint.Style.STROKE);
        mRectPaint.setStrokeWidth(mStrokeWidth);

        this.graphicOverlay = graphicOverlay;
        this.rect = rect;

        postInvalidate();


    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(rect);
        rectF.left = translateX(rect.left);
        rectF.right = translateX(rect.right);
        rectF.top = translateX(rect.top);
        rectF.bottom = translateX(rect.bottom);

        canvas.drawRect(rectF,mRectPaint);

    }
}
