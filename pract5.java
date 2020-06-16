//Given a 2D matrix, the task is that we find maximum sum of a hour glass

/*
An hour glass is made of 7 cells
in following form.
    A B C
      D
    E F G

Input : 1 1 1 0 0 
        0 1 0 0 0 
        1 1 1 0 0 
        0 0 0 0 0 
        0 0 0 0 0 
Output : 7
Below is the hour glass with
maximum sum:
1 1 1 
  1
1 1 1

Input : 0 3 0 0 0
        0 1 0 0 0
        1 1 1 0 0
        0 0 2 4 4
        0 0 0 2 4
Output : 11
Below is the hour glass wuth
maximum sum
1 0 0
  4
0 2 4

*/


class SolutionPract5 {
    
    public int sumOfAnHourGlass(int[][] arr, int i, int j) {

        int sum = 0;

        //We sum each of the 7 cells of an hour glass
        //made of top part of 3 elements, middle part of 1 element, bottom part of 3 elements 

        sum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2]; //top elements
        sum += arr[i + 1][j + 1]; //middle element
        sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]; //bottom elements

        return sum;
        
    }

    public int maxHourGlassSum(int[][] arr) {

        int max = Integer.MIN_VALUE; //in case we have negative integer values
        int sum = 0;

        //We do the arr.length - 2 because we dont want to go past the edge of arrays
        //when we "scan" each hourglass
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                sum = sumOfAnHourGlass(arr, i, j);
                if(sum > max) //or we could just do max = Math.max(max, sum)
                max = sum;
                
            }
        }

        return max;
        
    }
}


public class pract5 {

     public static void main(String[] args) {

        //output = 7
        int mat[][] = 
        {{1, 1, 1, 0, 0}, 
        {0, 1, 0, 0, 0}, 
        {1, 1, 1, 0, 0}, 
        {0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0}};

         //output = 28
         int mat2[][] = 
         {{-9, -9, -9, 1, 1, 1}, 
         {0, -9, 0, 4, 3, 2}, 
         {-9, -9, -9, 1, 2, 3},
         {0, 0, 8, 6, 6, 0},
         {0, 0, 0, -2, 0, 0},
         {0, 0, 1, 2, 4, 0}};

        //output = 14
        int mat3[][] = 
        {{1, 1, 1, 0, 0, 0}, 
        {0, 1, 0, 0, 0, 0}, 
        {1, 1, 1, 2, 2, 2}, 
        {0, 0, 0, 0, 2, 0}, 
        {0, 0, 0, 2, 2, 2}};


        //Output = 11
        int mat4[][] = 
        {{0, 3, 0, 0, 0}, 
        {0, 1, 0, 0, 0}, 
        {1, 1, 1, 0, 0}, 
        {0, 0, 2, 4, 4}, 
        {0, 0, 0, 2, 4}};


        SolutionPract5 mysolution5 = new SolutionPract5();
        System.out.println(mysolution5.maxHourGlassSum(mat));

    }

}