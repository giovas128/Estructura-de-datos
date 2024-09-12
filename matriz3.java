import java.util.Scanner;

public class matriz3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa un numero");
        int n = teclado.nextInt(); //INgresamos de que tamaño debe de ser la figura
        char[][] mat = new char[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i==j||i+j==n-1) {//una condicion para que las x sean diagonales de forma invertida
                    mat[i][j] = 'x';
                }else if(i==0||i==n-1){//donde las x se muestran en un diagonal
                    mat[i][j] = 'x';
                }else if (i < j && i + j < n - 1) { //rellena la parte superior de x contando que hay diagonales creando un triangulo donde se rellena
                    mat[i][j] = 'x';
                }else if (i > j && i + j > n - 1) { //rellena la parte inferior de x contando que hay diagonales creando un triangulo donde se rellena
                    mat[i][j] = 'x'; 
                }else{
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
