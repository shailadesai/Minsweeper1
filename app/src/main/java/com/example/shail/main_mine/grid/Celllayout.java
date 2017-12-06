package com.example.shail.main_mine.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.example.shail.main_mine.C_flow;

import com.example.shail.main_mine.R;


/**
 * Created by shail on 10/17/2017.
 */


public class Celllayout extends abstarctbase implements View.OnClickListener , View.OnLongClickListener {


    public Celllayout(Context context, int x, int y)
    {
        super(context);

        setPosition(x, y);//setting up cell position

        setOnClickListener(this);//pointing on clisck listner
        setOnLongClickListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    public void onClick(View v)
    {
        C_flow.getInstance().whenclicked(getXPos(), getYPos());
    }

    @Override
    public boolean onLongClick(View v)
    {
       C_flow.getInstance().flag(getXPos(), getYPos());

        return true;
    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        revil(canvas);

        if (isFlagged())
        {
            flag(canvas);
        }
        else if (isRevealed() && isBomb() && !isClicked())
        {
            normalbomb(canvas);
        } else
            {
            if (isClicked())
            {
                if (getValue() != -1)
                {
                    number(canvas);
                } else {
                    bombphuto(canvas);
                }
            }
            else
            {
                revil(canvas);
            }
        }
    }

    private void bombphuto(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);

        paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawText("*", 35, 75, paint);
    }

    private void flag(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        canvas.drawText("F", 9, 28, paint);
    }

    private void revil(Canvas canvas)
    {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.az);
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
    }

    private void normalbomb(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLUE);
        paint.setTextSize(80);
        canvas.drawText("*", 35, 75, paint);

    }

    private void number(Canvas canvas)
    {

        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);

        paint.setColor(Color.GREEN);
        paint.setTextSize(45);

        switch (getValue())
        {
            case 0:
                canvas.drawText("0", 20, 40, paint);
                break;
            case 1:
                canvas.drawText("1", 20, 40, paint);
                break;
            case 2:
                canvas.drawText("2", 20, 40, paint);
                break;
            case 3:
                canvas.drawText("3", 20, 40, paint);
                break;
            case 4:
                canvas.drawText("4", 20, 40, paint);
                break;
            case 5:
                canvas.drawText("5", 20, 40, paint);
                break;
            case 6:
                canvas.drawText("6", 20, 40, paint);
                break;
            case 7:
                canvas.drawText("7", 20, 40, paint);
                break;
            case 8:
                canvas.drawText("8", 20, 40, paint);
                break;
        }

    }
}