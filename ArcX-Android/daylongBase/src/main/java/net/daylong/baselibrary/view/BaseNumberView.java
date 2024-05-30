package net.daylong.baselibrary.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.StringUtils;

import java.util.HashMap;

public abstract class BaseNumberView extends View {


    private HashMap<String, Bitmap> digitImages;
    private CanvasImageBean canvasImageNum;
    private CanvasImageBean canvasImageDot;
    protected CanvasImageBean canvasImageStart;
    private CanvasImageBean canvasImageEnd;

    private Paint paint;

    public BaseNumberView(Context context) {
        super(context);
        digitImages = new HashMap<String, Bitmap>();
        canvasImageNum = getImageNum();
        canvasImageDot = getImageDot();
        canvasImageStart = getImageStartsWith();
        canvasImageEnd = getImageEndWith();
        keyPrefix = getKeyPrefix();

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

    }


    public void setCanvasImageNum(CanvasImageBean canvasImageNum) {
        this.canvasImageNum = canvasImageNum;
    }


    public void setCanvasImageDot(CanvasImageBean canvasImageDot) {
        this.canvasImageDot = canvasImageDot;
    }

    public void setCanvasImageStart(CanvasImageBean canvasImageStart) {
        this.canvasImageStart = canvasImageStart;
    }


    public void setCanvasImageEnd(CanvasImageBean canvasImageEnd) {
        this.canvasImageEnd = canvasImageEnd;
    }

    /**

     *
     * @return
     */
    public abstract String getKeyPrefix();

    protected String numStr = "";
    protected String keyPrefix;
    protected long num;

    protected int left = 0; 


    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    /**

     *
     * @return
     */
    protected abstract CanvasImageBean getImageNum();


    protected abstract CanvasImageBean getImageDot();

    /**

     *
     * @return
     */
    protected CanvasImageBean getImageStartsWith() {
        return null;
    }

    /**

     *
     * @return
     */
    protected CanvasImageBean getImageEndWith() {
        return null;
    }

    private int y = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        requestLayout();
        if (TextUtils.isEmpty(numStr)) {
            return;
        }

        y = 0;
        if (canvasImageStart != null) {
            canvasImage(canvas, canvasImageStart);

            left += canvasImageStart.getRightMargin();
            y = (canvasImageStart.getHeight() - canvasImageNum.getHeight()) / 2;
        }


        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (Character.isDigit(ch)) {
                canvasNum(canvas, ch, canvasImageNum);
            } else if (ch == ',') {
                canvasNum(canvas, ch, canvasImageDot);
            }
        }

        if (canvasImageEnd != null) {
            canvasImage(canvas, canvasImageEnd);
        }


    }


    public void setNum(Long num) {
        this.num = num;
        this.numStr = StringUtils.numFormatDot(num);
        invalidate();
    }


    /**

     */
    private void canvasNum(Canvas canvas, char ch, CanvasImageBean canvasImage) {
        String keyNum = Character.toString(ch);
        Bitmap bitmap = getImageBitMap(keyNum, DrawableUtils.getDrawableByName(keyPrefix + (keyNum.equals(",") ? "comma" : keyNum)));
        if (bitmap != null) {
            drawImage(canvas, bitmap, y, canvasImage);
            left += canvasImage.getWidth();
        }
    }

    private Bitmap getImageBitMap(String key, int regId) {
        
        Bitmap bitmap;

        if (digitImages.containsKey(key)) {
            bitmap = digitImages.get(key);
            
        } else {
            bitmap = BitmapFactory.decodeResource(getResources(), regId);
            if (bitmap == null) {

                return null;
            }
            digitImages.put(key, bitmap);
        }
        return bitmap;
    }


    /**
     * @param canvas
     * @param blt

     */
    private void drawImage(Canvas canvas, Bitmap blt, int y,
                           CanvasImageBean canvasImageBean) {

        Rect src = new Rect();
        Rect dst = new Rect();
        src.left = 0;

        src.top = 0;

        src.right = blt.getWidth();

        src.bottom = blt.getHeight();


        dst.left = left;

        dst.top = y;

        dst.right = left + canvasImageBean.getWidth();
        dst.bottom = y + canvasImageBean.getHeight();


        canvas.drawBitmap(blt, null, dst, paint);

        src = null;

        dst = null;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getViewWidth(), heightMeasureSpec);
    }


    public void canvasImage(Canvas canvas, CanvasImageBean canvasImageBean) {
        if (canvasImageBean != null) {

            Bitmap imageBitMap = getImageBitMap(canvasImageBean.getImgRegId() + "", canvasImageBean.getImgRegId());
            if (imageBitMap != null) {
                drawImage(canvas, imageBitMap, y, canvasImageBean);
                this.left += canvasImageBean.getWidth();
            }

        }
    }


    /**

     *
     * @return
     */
    public int getViewWidth() {
        left = 0;
        int width = 0;

        if (TextUtils.isEmpty(numStr)) {
            return 1;
        }

        if (canvasImageStart != null) {
            width += canvasImageStart.getWidth() +   canvasImageStart.getRightMargin();;
        }

        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (Character.isDigit(ch)) {

                width += canvasImageNum.getWidth();
            } else if (ch == ',') {
                width += canvasImageDot.getWidth();
            }

        }

        if (canvasImageEnd != null) {
            width += canvasImageEnd.getWidth();
        }
        return width;
    }

    protected void clearViewContent() {
        requestLayout(); 
        invalidate(); 
        numStr = "";
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        for (Bitmap bitmap : digitImages.values()) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        digitImages.clear();
    }
}
