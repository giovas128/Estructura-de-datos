import java.util.Scanner;

public class matrices {
    public static void main(String[] args) {
        boolean estado = true;
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("¿Que desea realizar?\n"
                            +"A) Una matriz creando un triangulo rectangulo\n"
                            +"B) Una matriz creando un cuadrado\n"
                            +"C) Una matriz creando 2 triangulos en lados opuestos de arriba y hacia abajo\n"
                            +"D) Salir");
            String inciso = teclado.nextLine();
            switch(inciso){
            case "a","A":
                matriz1();
                break;
            case "b","B":
                matriz2();
                break;
            case "c","C":
                matriz3();
                break;
            case "d","D":
                estado=false;
            default:
                System.out.println("Opción no válida.");
            }
        }while(estado);
    }
    public static void matriz3(){
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
    public static void matriz2(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa un numero");
        int n = teclado.nextInt(); //INgresamos de que tamaño debe de ser la figura
        char[][] mat = new char[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i==0||j==0||(i==n-1)||(j==n-1)) {//ingresamos las coordenadas donde queremos que haya x en los lados
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
    public static void matriz1(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa un numero");
        int n = teclado.nextInt(); //INgresamos de que tamaño debe de ser la figura
        char[][] mat = new char[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i>=j) {//ingresamos las coordenadas donde queremos que haya x creando un triangulo rectangulo
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
