import java.utilScanner;
public class MatrixAddition{
    public static voidmain(string[args]){
        scanner se = new scanner(system.in);
        System.out.print("enter order of matrix")
        int n = sc. nextInt ();
        int [][]a = new int [n][n];
        int [][]b = new int [n][n];
        int [][]sum = new int [n][n];
        System.out.println("Enter elements of 1st matrix:");
        for ( int i=0;i<n;i++){
            for (int j = 0; j<n;j++){
                a[i][j]= sc.nextInt();
            }
        }
        System.out.println("2nd matrix");
         for ( int i=0;i<n;i++){
            for (int j = 0; j<n;j++){
                b[i][j]= sc.nextInt();
            }
         }
          for ( int i=0;i<n;i++){
            for (int j = 0; j<n;j++){
                sum[i][j]= a[i][j] + b[i][j];
            }
          }
          System.out.println("Sum:");
            for ( int i=0;i<n;i++){
            for (int j = 0; j<n;j++){
                System.out.print(sum[i][j]+"");
            }
            System.out.println();
            }
            sc.close();
            


    }
}