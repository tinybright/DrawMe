package com.rafakob.drawme;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.rafakob.drawme.delegate.DrawMe;
import com.rafakob.drawme.delegate.DrawMeShapeText;

public class DrawMeTextView extends TextView {
    private DrawMe drawMe;
    private DrawMe drawMe1;
    public DrawMeTextView(Context context) {
        super(context);
        if(isInEditMode()){

        }else{
            drawMe = new DrawMeShapeText(context, this, null);
        }
    }

    public DrawMeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(isInEditMode()){

        }else{
            drawMe = new DrawMeShapeText(context, this, attrs);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(isInEditMode()){
            super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        }else{
            int[] size = drawMe.onMeasure(widthMeasureSpec, heightMeasureSpec);
            super.onMeasure(size[0], size[1]);
        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(isInEditMode()){

        }else{
            drawMe.onLayout(changed, left, top, right, bottom);
        }
    }
}
