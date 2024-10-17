import java.io.*;
import java.util.*;

public class Main{
    static void DFS(int[][] Mat, int i, int j, int N){
        if(i < 0 || j < 0 || i >= N || j >= N || Mat[i][j] == 0 || Mat[i][j] == 2)
            return;

        Mat[i][j] = 2;
        DFS(Mat, i - 1, j, N);
        DFS(Mat, i, j - 1, N);
        DFS(Mat, i + 1, j, N);
        DFS(Mat, i, j + 1, N);
    }
    
    public static void main(String Args[]){
        Scanner Sc = new Scanner(System.in);
        int TC = Sc.nextInt();
        for(int t = 0; t < TC; t++){
            int N = Sc.nextInt();
            int Mat[][] = new int[N][N];
            for(int i = 0; i < N; i++){
                String row = Sc.next();
                for(int j = 0; j < N; j++){
                    Mat[i][j] = row.charAt(j) - '0';
                }
            }
            int Count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(Mat[i][j] == 1){
                        Count++;
                        DFS(Mat, i, j, N);
                    }      
                }
            }
            System.out.println(Count);
        }
        Sc.close();
    }
}