package com.example.shail.main_mine.grid;

import android.content.Context;
import android.view.View;

import com.example.shail.main_mine.C_flow;


public abstract class abstarctbase extends View {
    private int value;
    private boolean isBomb;
    private boolean isRevealed;
    private boolean isClicked;
    private boolean isFlagged;

    private int x , y;
    private int position;

    public abstarctbase(Context context ){
        super(context);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value)
    {
        isBomb = false;
        isRevealed = false;
        isClicked = false;
        isFlagged = false;

        if( value == -1 )
        {
            isBomb = true;
        }

        this.value = value;
    }
    public void setRevealed()
    {
        isRevealed = true;
        invalidate();
    }


    public boolean isBomb()
    {
        return isBomb;
    }

    public void setBomb(boolean bomb)
    {
        isBomb = bomb;
    }

    public boolean isRevealed()
    {
        return isRevealed;
    }


    public boolean isClicked()
    {
        return isClicked;
    }

    public void setClicked() {
        this.isClicked = true;
        this.isRevealed = true;

        invalidate();
    }

    public boolean isFlagged()
    {
        return isFlagged;
    }

    public void setFlagged(boolean flagged)
    {
        isFlagged = flagged;
    }

    public int getXPos()
    {
        return x;
    }

    public int getYPos()
    {
        return y;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition( int x , int y
    ){
        this.x = x;
        this.y = y;

        this.position = y * C_flow.w + x;

        invalidate();
    }

}


/**Orignally created by Marcell and then based on the code modified by shail 2017. 10. 19..
 *
 */


