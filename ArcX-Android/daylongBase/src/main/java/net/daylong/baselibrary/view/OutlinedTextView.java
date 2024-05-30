package net.daylong.baselibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class OutlinedTextView extends View {
    public static OutlinedTextView create(ViewGroup viewGroup, ConstraintBuilder constraint, int size, String text) {

        OutlinedTextView numTextView = new OutlinedTextView(viewGroup.getContext(), size, text);
        numTextView.setLayoutParams(constraint.buildPayoutParams());
        viewGroup.addView(numTextView);
        return numTextView;

    }

    private Paint textPaint;
    private Paint strokePaint;
    private int size;
    private String text;

    public OutlinedTextView(Context context, int size, String text) {
        super(context);

        this.text = text;
        this.size = size;
        init(size);
    }


    private void init(int size) {
        textPaint = new Paint();
        textPaint.setTextSize(size);
        textPaint.setAntiAlias(true);
        Shader shader = new LinearGradient(0, 0, 0, getHeight(),
                new int[]{Color.parseColor("#FFF800"), Color.parseColor("#FFCE02"), Color.parseColor("#FF9700")},
                null, Shader.TileMode.CLAMP);
        textPaint.setShader(shader);

        strokePaint = new Paint();
        strokePaint.setColor(Color.parseColor("#B84B00"));
        strokePaint.setTextSize(size);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(AppUtil.getSize(1)); 
        strokePaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float textHeight = strokePaint.descent() - strokePaint.ascent();
        float x = 0; 
        float y = (getHeight() - textHeight) / 2 - strokePaint.ascent(); 
        
        drawTextWithLetterSpacing(canvas, text, x, y, strokePaint, AppUtil.getSize(1));
        drawTextWithLetterSpacing(canvas, text, x, y, textPaint, AppUtil.getSize(1));

    }


    private void drawTextWithLetterSpacing(Canvas canvas, String text, float x, float y, Paint paint, float letterSpacing) {
        float totalWidth = 0;

        for (int i = 0; i < text.length(); i++) {
            String character = String.valueOf(text.charAt(i));
            canvas.drawText(character, x + totalWidth, y, paint);
            totalWidth += paint.measureText(character) + letterSpacing;
        }

    }


}
