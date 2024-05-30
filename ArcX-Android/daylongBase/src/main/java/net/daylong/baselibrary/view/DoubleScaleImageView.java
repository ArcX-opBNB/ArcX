package net.daylong.baselibrary.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class DoubleScaleImageView extends ImageView implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    private boolean isFirst = false;
    private float doubleScale;
    private Matrix mScaleMatrix;
    private float defaultScale;
    private int mLastPinterCount;
    private float mLastX;
    private float mLastY;
    private int mTouchSlop;
    private boolean isCanDrag;
    private boolean isCheckLeft;
    private boolean isCheckTop;
    private GestureDetector mGestureDetector;
    public DoubleScaleImageView(Context context) {
        this(context, null);
    }
    public DoubleScaleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DoubleScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScaleMatrix = new Matrix();
        setScaleType(ScaleType.MATRIX);
        setOnTouchListener(this);
        
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                float x = e.getX();
                float y = e.getY();
                if (getScale() < doubleScale) {
                    mScaleMatrix.postScale(doubleScale / getScale(), doubleScale / getScale(), x, y);
                }
                else {
                    mScaleMatrix.postScale(defaultScale / getScale(), defaultScale / getScale(), x, y);
                }
                setImageMatrix(mScaleMatrix);
                return super.onDoubleTap(e);
            }
        });
    }
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    @SuppressWarnings("deprecation")
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    @Override
    public void onGlobalLayout() {
        if (!isFirst) {
            
            int width = getWidth();
            int height = getHeight();
            
            Drawable drawable = getDrawable();
            if (drawable == null) { return; }
            int imageWidth = drawable.getIntrinsicWidth();
            int imageHeight = drawable.getIntrinsicHeight();
            float scale = 1.0f;
            
            if (imageWidth > width && imageHeight < height) {
                scale = width * 1.0f / imageWidth;
            }
            
            if (imageWidth < width && imageHeight > height) {
                scale = height * 1.0f / imageHeight;
            }
            
            if ((imageWidth > width && imageHeight > height) || (imageWidth < width && imageHeight < height)) {
                scale = Math.min(width * 1.0f / imageWidth, height * 1.0f / imageHeight);
            }
            
            defaultScale = scale;
            doubleScale = defaultScale * 2;
            
            int dx = width / 2 - imageWidth / 2;
            int dy = height / 2 - imageHeight / 2;
            mScaleMatrix.postTranslate(dx, dy);
            mScaleMatrix.postScale(defaultScale, defaultScale, width / 2, height / 2);
            setImageMatrix(mScaleMatrix);
            isFirst = true;
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (mGestureDetector.onTouchEvent(event)) { return true; }
        float x = 0;
        float y = 0;
        int pointerCount = event.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            x += event.getX(i);
            y += event.getY(i);
        }
        x /= pointerCount;
        y /= pointerCount;
        if (mLastPinterCount != pointerCount) {
            isCanDrag = false;
            mLastX = x;
            mLastY = y;

        }
        mLastPinterCount = pointerCount;
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - mLastX;
                float dy = y - mLastY;
                isCanDrag = isMove(dx, dy);
                if (isCanDrag) {
                    RectF rectf = getMatrixRectf();
                    if (null != getDrawable()) {
                        isCheckLeft = isCheckTop = true;
                        if (rectf.width() < getWidth()) {
                            dx = 0;
                            isCheckLeft = false;
                        }
                        if (rectf.height() < getHeight()) {
                            dy = 0;
                            isCheckTop = false;
                        }
                        mScaleMatrix.postTranslate(dx, dy);
                        checkTranslateWithBorder();
                        setImageMatrix(mScaleMatrix);
                    }
                }
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mLastPinterCount = 0;
                break;
        }
        return true;
    }
    /**

     * @description：

     */
    private void checkTranslateWithBorder() {
        RectF rectf = getMatrixRectf();
        float delX = 0;
        float delY = 0;
        int width = getWidth();
        int height = getHeight();
        if (rectf.top > 0 && isCheckTop) {
            delY = -rectf.top;
        }
        if (rectf.bottom < height && isCheckTop) {
            delY = height - rectf.bottom;
        }
        if (rectf.left > 0 && isCheckLeft) {
            delX = -rectf.left;
        }
        if (rectf.right < width && isCheckLeft) {
            delX = width - rectf.right;
        }
        mScaleMatrix.postTranslate(delX, delY);
    }
    
    private boolean isMove(float x, float y) {
        return Math.sqrt(x * x + y * y) > mTouchSlop;
    }
    /**

     * @description：

     */
    private RectF getMatrixRectf() {
        Matrix matrix = mScaleMatrix;
        RectF recft = new RectF();
        if (getDrawable() != null) {
            recft.set(0, 0, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            matrix.mapRect(recft);
        }
        return recft;
    }

    
    private float getScale() {
        float values[] = new float[9];
        mScaleMatrix.getValues(values);
        return values[Matrix.MSCALE_X];
    }
}