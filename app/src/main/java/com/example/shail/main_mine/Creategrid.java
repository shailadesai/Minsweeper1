package com.example.shail.main_mine;

import java.util.Random;


public class Creategrid
{
    public static int[][] Createdgrid(int Bomb, int w, int h)
    {
        //random for generator
        //randon number is used to assigned the mines to the grid
        Random r = new Random();

        int[][] grid = new int[w][h];
        for (int i = 0; i < w; i++)
        {
            grid[i] = new int[h];
        }

        while (Bomb > 0)
        {
            int i = r.nextInt(w);
            int j = r.nextInt(h);

            // -1 is the bomb
            if (grid[i][j] != -1)
            {
                grid[i][j] = -1;
                Bomb--;
            }
        }
        grid = Neighbourcalculation(grid, w, h);

        return grid;
    }

   public static int[][] Neighbourcalculation(int[][] grid, final int w, final int h)
   {
        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                grid[i][j] = neighb(grid, i, j, w, h);
            }
        }

        return grid;
    }
    public static boolean Mineposition(final int[][] grid, final int i, final int j, final int w, final int h)
    //here we set mine position so that we can calucate the neighbour number using count
    {
        if (i >= 0 && j >= 0 && i < w && j < h) {
            if (grid[i][j] == -1) {
                return true;
            }
        }
        return false;
    }



    public static int neighb(final int grid[][], final int i, final int j, final int w, final int h)
        {
        if (grid[i][j] == -1)
        {
            return -1;
        }

        int count = 0;//count is initialize to zero when count number increases
            // the number allocated to cell increases and through
            // cell layout we print the count number allocated to it



        if (Mineposition(grid, i, j + 1, w, h)) count++; // top
        if (Mineposition(grid, i, j - 1, w, h)) count++; // bottom
        if (Mineposition(grid, i - 1, j, w, h)) count++; // left
        if (Mineposition(grid, i + 1, j, w, h)) count++; // right
        if (Mineposition(grid, i + 1, j + 1, w, h)) count++; // top-right
        if (Mineposition(grid, i - 1, j + 1, w, h)) count++; // top-left
        if (Mineposition(grid, i - 1, j - 1, w, h)) count++; // bottom-left
        if (Mineposition(grid, i + 1, j - 1, w, h)) count++; // bottom-right

        return count;
    }
}

/**
 * Created by shail on 10/15/2017. based on marcel code video given in reference of pdf
 */
/**
 this class is to set up grid background where bomb is allocated randomly at each cell
 then neighbours are calculated and based on bomb in the neighbouring cell
 count value increases and the number is dedicated to cell.**/
