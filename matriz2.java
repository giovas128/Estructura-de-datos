import java.util.Scanner;

public class matriz2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa un numero");
        int n = teclado.nextInt(); //INgresamos de que tamaño debe de ser la figura
        char[][] mat = new char[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i==0||j==0||(i==n-1)||(j==n-1)) {//ingresamos las coordenadas donde queremos que haya X
                    mat[i][j] = 'x';
                }
                 else{
                    mat[i][j] = ' ';
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(mat[i][j]);//imprimimos en pantalla la figura
            }
            System.out.println();
        }
    }
}
