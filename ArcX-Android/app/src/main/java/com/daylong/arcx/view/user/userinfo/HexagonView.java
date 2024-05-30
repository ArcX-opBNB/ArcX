package com.daylong.arcx.view.user.userinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;


public class HexagonView extends View {

    private Paint fillPaint;
    private Path path;

    private Bitmap originalBitmap; 
    private Bitmap scaledBitmap;   
    private Paint imgPaint;

    private long[] attributes;

    public HexagonView(Context context) {
        super(context);
        init();
    }


    private void init() {
        fillPaint = new Paint();
        fillPaint.setColor(Color.parseColor("#8B90FF"));
        fillPaint.setStyle(Paint.Style.FILL);
        path = new Path();
        imgPaint = new Paint();
        imgPaint.setAntiAlias(true); 
        originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_user_attribute_bg);
        scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, AppUtil.getSize(68), AppUtil.getSize(74), false);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int startX = getWidth() / 2;
        int startY = getHeight() / 2;
        int radius = AppUtil.getSize(25); 

        canvas.drawBitmap(scaledBitmap, 0, 0, imgPaint);

        if (attributes != null) {
            
            long maxNum = attributes[0];

            
            float oneSize = radius * 1.0f / maxNum;
            path.reset();
            float angleDeg = 270; 
            double angleRad = Math.toRadians(angleDeg);
            for (int j = 0; j < attributes.length; j++) {
                float size = oneSize * attributes[j];
                float x = (float) (startX + size * Math.cos(angleRad));
                float y = (float) (startY + size * Math.sin(angleRad));

                if (j == 0) {
                    path.moveTo(x, y);
                } else {
                    path.lineTo(x, y);
                }

                angleRad += Math.PI / 3;
            }

            path.close();
            canvas.drawPath(path, fillPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(AppUtil.getSize(68), AppUtil.getSize(74));

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (scaledBitmap != null && !scaledBitmap.isRecycled()) {
            scaledBitmap.recycle();
            scaledBitmap = null;
        }
        if (originalBitmap != null && !originalBitmap.isRecycled()) {
            originalBitmap.recycle();
            originalBitmap = null;
        }
    }

    public void update(long[] attributes) {
        this.attributes = attributes;
        invalidate();
    }
}
