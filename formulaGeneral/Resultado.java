package formulaGeneral;

public class Resultado{
	public static double[] f(int a, int b, int c)throws Exception{
		double[] resultados = new double[2];
		double potencia = Math.pow(b,2);
		double r1 = -4 * a * c;
		double r2 = potencia + r1;
		double raiz = Math.sqrt(r2);
		double r3 = b * -1;
		double r4 = 2 * a;

		resultados[0] = (r3 + raiz) / r4;  // X1
        resultados[1] = (r3 - raiz) / r4;  // X2

        return resultados;
	}
}