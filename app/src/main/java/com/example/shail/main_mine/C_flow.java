package com.example.shail.main_mine;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shail.main_mine.grid.Celllayout;


public class C_flow {

    private static C_flow instance;

    public static int NummberofBomb = 10;
    public static int w = 9;
    public static int h = 9;
    public static int g = 1;
    public static int z = 0;

    public static Context context;

    private static Celllayout[][] ShailGrid = new Celllayout[w][h];
    public static View click;
    public static android.content.Context Context;

    public static C_flow getInstance() {
        if (instance == null) {
            instance = new C_flow();
        }
        return instance;
    }

    C_flow() {
    }

    public Celllayout cellposition(int position) {
        int i = position % w;
        int j = position / w;

        return ShailGrid[i][j];
    }

    public void LaunchGrid(Context context) {
        this.context = context;


        int[][] GeneratedGrid = Creategrid.Createdgrid(NummberofBomb, w, h);

        setthegrid(context, GeneratedGrid);
    }


    public static Celllayout cellposition(int i, int j) {
        return ShailGrid[i][j];
    }

    public void whenclicked(int i, int j)//when cell is clised at the given position it fectches the co-ordinate values and provide out put
    {
        if (i >= 0 && j >= 0 && i < w && j < h && !cellposition(i, j).isClicked()) {
            cellposition(i, j).setClicked();//here we are setting the clicked cell so the box get open and user can not click it again

            if (cellposition(i, j).getValue() == 0) {
                for (int it = -1; it <= 1; it++) {
                    for (int jt = -1; jt <= 1; jt++) {
                        if (it != jt) {
                            whenclicked(i + it, j + jt);

                        }
                    }
                }
            }
            if (cellposition(i,j).isFlagged()) {
                flag(i,j);


            }

            if (cellposition(i, j).isBomb()) {
                onGameLost();


            }
        }

        checkEnd();
    }


    private boolean checkEnd() {
        int bombNotFound = NummberofBomb;
        int notRevealed = w * h;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++)//here the particular flag is set at clicked position and the detail swhich we set a Creategrid class is reviedld
            {
                if (cellposition(i, j).isRevealed() || cellposition(i, j).isFlagged()) {
                    notRevealed--;
                }

                if (cellposition(i, j).isFlagged() && cellposition(i, j).isBomb()) {
                    bombNotFound--;
                }
            }
        }

        if (bombNotFound == 0 && notRevealed == 0)// if the bomb is not found when particular position is clicked and the reveled part is zero then user wins
        {
            Toast.makeText(context, "You won this level", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    private void setthegrid(final Context context, final int[][] grid) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (ShailGrid[i][j] == null) {
                    ShailGrid[i][j] = new Celllayout(context, i, j);
                }
                ShailGrid[i][j].setValue(grid[i][j]);
                ShailGrid[i][j].invalidate();
            }
        }
    }

    public static void onGameLost() {
        // if the user click on bom the user losses the game and the ever other bomb is reviled
        Toast.makeText(context, " You Lost the Game ", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                cellposition(i, j).setRevealed();
            }
        }

    }

    public void flag(int i, int j) {
        boolean isFlagged = cellposition(i, j).isFlagged();
        cellposition(i, j).setFlagged(!isFlagged);
        cellposition(i, j).invalidate();
    }
}



/**
 * Created by shail on 10/15/2017. based on marcel code video given in reference of pdf
 */
