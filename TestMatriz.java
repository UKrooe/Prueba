import java.util.Arrays;
import java.util.Random;

public class TestMatriz {

    public static Random r = new Random();
    public static Matriz mat;

    public static void testConstructor() {
	Impresora.imprimeBlanco("====== Prueba constructor con n x m ======");
	int n = r.nextInt(100), m = r.nextInt(100);
	mat = new Matriz(n, m);
	try {
	    for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
		    if(mat.get(i, j) != 0.0) {
			throw new ArrayIndexOutOfBoundsException("No es cero");
		    }
		}
	    }
	} catch (ArrayIndexOutOfBoundsException aioobe) {
	    Impresora.imprimeRojo("=======Prueba fallida======");
	    Impresora.imprimeRojo(aioobe.getMessage());
	    return;
	}
	Impresora.imprimeVerde("======Prueba exitosa======");
    }

    public static void testConstructorVacio() {
	Impresora.imprimeBlanco("====== Prueba constructor vacío ======");
	mat = new Matriz();
	try {
	    for(int i = 0; i < 0; i++) {
		for(int j = 0; j < 0; j++) {
		    if(mat.get(i, j) != 0.0) {
			throw new ArrayIndexOutOfBoundsException("No es cero");
		    }
		}
	    }
	} catch (ArrayIndexOutOfBoundsException aioobe) {
	    Impresora.imprimeRojo("=======Prueba fallida======");
	    Impresora.imprimeRojo(aioobe.getMessage());
	    return;
	}
	Impresora.imprimeVerde("======Prueba exitosa======");
    }

    public static void testConstructorMatriz() {
	Impresora.imprimeBlanco("====== Prueba constructor matriz ======");
	double [][] matriz = new double[10][10];
	mat = new Matriz(matriz);
	try {
	    for(int i = 0; i < 0; i++) {
		for(int j = 0; j < 0; j++) {
		    if(mat.get(i, j) != 0.0) {
			throw new ArrayIndexOutOfBoundsException("No es cero");
		    }
		}
	    }
	} catch (ArrayIndexOutOfBoundsException aioobe) {
	    Impresora.imprimeRojo("=======Prueba fallida======");
	    Impresora.imprimeRojo(aioobe.getMessage());
	    return;
	}
	Impresora.imprimeVerde("======Prueba exitosa======");
    }

    public static void testRenglones() {
	Impresora.imprimeBlanco("====== Prueba renglones ======");
	int n = r.nextInt(100), m = r.nextInt(100);
	mat = new Matriz(n, m);
	if(mat.renglones() != n) {
	    Impresora.imprimeRojo("==== Prueba fallida ====");
	    Impresora.imprimeBlanco(" El número de renglones no es correcto");
	} else {
	    Impresora.imprimeVerde("====== Prueba exitosa ======");
	}
    }

    public static void testColumnas() {
	Impresora.imprimeBlanco("====== Prueba columnas ======");
	int n = r.nextInt(100), m = r.nextInt(100);
	mat = new Matriz(n, m);
	if(mat.columnas() != m) {
	    Impresora.imprimeRojo("====== Prueba fallida ======");
	    Impresora.imprimeBlanco(" El número de columnas no es correcto");
	} else {
	    Impresora.imprimeVerde("====== Prueba exitosa ======");
	}
    }

    public static void testTraspuesta() {
	Impresora.imprimeBlanco("====== Prueba traspuesta ======");
	mat = new Matriz(r.nextInt(10)+1, r.nextInt(10)+1);
	try { 
	    Matriz tm = mat.trasponer();
	    for(int i = 0; i < mat.renglones(); i++) {
		for(int j = 0; j < mat.columnas(); j++) {
		    if(mat.get(i, j) != tm.get(j, i)) {
			throw new ArrayIndexOutOfBoundsException("Mala transformación de trapuesta");
		    }
		}
	    }
	} catch(ArrayIndexOutOfBoundsException aioobe) {
	    Impresora.imprimeRojo("====== Prueba fallida ======");
	    return;
	}
	Impresora.imprimeVerde("====== Prueba exitosa ======");
    }

    public static void testSimetrica() {
    	Impresora.imprimeBlanco("====== Prueba simétrica ======");
	double [][] d = {{1.0, 2.0}, {2,0, 1.0}};
    	mat = new Matriz(d);
    	if(!mat.esSimetrica()) {
    	    Impresora.imprimeRojo("====== Prueba fallida ======");
    	    Impresora.imprimeBlanco("La matriz sí es simétrica");
    	    return;
    	}
	d[1][0] = 3.0;
	mat = new Matriz(d);
    	if(mat.esSimetrica()) {
    	    Impresora.imprimeRojo("====== Prueba fallida ======");
    	    Impresora.imprimeBlanco("La matriz no es simétrica");
    	    return;
    	}
    	Impresora.imprimeVerde("====== Prueba exitosa ======");
    }

    public static void testSumar() {
    	Impresora.imprimeBlanco("====== Prueba suma ======");
	double [][] d1 = {{1.0, 2.0}, {3.0, 4.0}};
	double [][] d2 = {{4.0, 3.0}, {2.0, 1.0}};
    	Matriz matA = new Matriz(d1);
    	Matriz matB = new Matriz(d2);
	matA.sumar(matB);
    	for(int i = 0; i < 2; i++) {
    	    for(int j = 0; j < 2; j++) {
    		if(matA.get(i, j) != 5.0) {
    		    Impresora.imprimeRojo("====== Prueba fallida ======");
    		    Impresora.imprimeBlanco("Está mal efectuada la suma");
    		    return;
    		}
    	    }
    	}
    	Impresora.imprimeVerde("====== Prueba exitosa ======");
    }

    public static void testMultiplicar() {
	int n = r.nextInt(10)+1, m = r.nextInt(10)+1, q = r.nextInt(10)+1;
	Matriz matA = new Matriz(n, m);
	Matriz matB = new Matriz(m, q);
	try {
	    Matriz matC = matA.multiplicar(matB);
	    if(matC.renglones() != n || matC.columnas() != q) {
		Impresora.imprimeRojo("====== Prueba fallida ======");
		return;
	    }
	    double [][] d1 = {{1.0, 2.0, 1.0},{2.0, 3.0, 1.0}};
	    double [][] d2 = {{2.0, 2.0, 4.0},{3.0, 1.0, 1.0}};
	    matA = new Matriz(d1);
	    matB = new Matriz(d2);
	    matC = matA.multiplicar(matB);
	    double [] uno = {10.0, 6.0};
	    double [] dos = {14.0, 10.0};
	    if(!Arrays.equals(matC.mat[0], uno)) {
	    	Impresora.imprimeRojo("====== Prueba fallida ======");
	    	return;
	    }
	    if(!Arrays.equals(matC.mat[1], dos)){
	    	Impresora.imprimeRojo("====== Prueba fallida ======");
	    	return;
	    }
	} catch(ArrayIndexOutOfBoundsException aioobe) {
	    Impresora.imprimeRojo("====== Prueba fallida ======");
	    Impresora.imprimeBlanco("Checa las operaciones de acceso a los renglones y columnas");
	} catch(Error e) {}
	Impresora.imprimeVerde("====== Prueba exitosa ======");
    }

    
    public static void main(String [] args) {
	testConstructor();
	System.out.println();
	testConstructorVacio();
	System.out.println();
	testConstructorMatriz();
	System.out.println();
	testRenglones();
	System.out.println();
	testColumnas();
	System.out.println();
	testTraspuesta();
	System.out.println();
	testSimetrica();
	System.out.println();
	testSumar();
	System.out.println();
	testMultiplicar();
	
    }
}

