/**
 * Solution to exercise 8-10 from Cracking the Coding Interview, 6th edition.
 */
public class PaintFill {

    private static final int[][] GRID = {
        {2,2,2,2,2,2,2,2,2,2},
        {2,2,0,1,1,1,1,0,0,2},
        {2,2,0,1,1,1,1,0,0,2},
        {2,2,0,1,1,1,0,0,0,2},
        {2,2,0,0,0,0,0,0,0,2},
        {2,2,2,2,2,2,2,2,2,2}
    };

    public static void fill(int[][] grid, int x, int y, int newColor) {

        int color = grid[x][y];
        if (color == newColor)
            return;
        fill(grid, color, newColor, x, y);
    }

    private static void fill(int[][] grid, int oldColor, int newColor, int x, int y) {

        // Make sure we don't go out of bounds
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return;
        // The section no longer has the old color, so we stop here
        if (grid[x][y] != oldColor)
            return;
        // Fills the pixel, recursively call adjacent pixels
        grid[x][y] = newColor;
        fill(grid, oldColor, newColor, x + 1, y);
        fill(grid, oldColor, newColor, x - 1, y);
        fill(grid, oldColor, newColor, x, y + 1);
        fill(grid, oldColor, newColor, x, y - 1);
    }

    // Method to print the grid
    private static void printGrid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Before:");
        printGrid(GRID);
        System.out.println("Filling grid at (0,0)");
        fill(GRID, 0, 0, 3);
        System.out.println("After:");
        printGrid(GRID);
    }
}
