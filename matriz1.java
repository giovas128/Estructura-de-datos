import java.util.Scanner;

public class matriz1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa un numero");
        int n = teclado.nextInt();
        char[][] mat = new char[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i>=j) {
                    mat[i][j] = 'x';
                }
                 else{
                    mat[i][j] = ' ';
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
