/**
 * Clase para trabajar con matrices
 */

 public class Matriz{
    public double [][] mat;

    private int renglon, columna;
    
    /**
     * Constructor por omisión, crea una matriz de 10 * 10 asignando el valor 0 a cada elemento.
     */
    public Matriz(){
      //Escribe aquí tu código
      this.mat = new double [10][10];
    }

    /**
     * Constructor de una matriz de n*m elementos, con el valor 0 en cada elemento
     * si alguno de los parámetros es negativo, se envía un mensaje de error
     * @param n -- la cantidad de renglones
     * @param m -- tamaño de los renglones
     */
    public Matriz(int n, int m){
      //Escribe aquí tu código
      if(n<0 || m<0){
        System.out.println("El valor es negativo");
      }
      this.mat = new double [n][m];
    }

    /**
     * Constructor que crea una matriz a partir de un arreglo de dos dimensiones
     * @param m -- arreglo de dos dimensiones
     */
    public Matriz (double [][] m){
      //Escribe aquí tu código
      this.mat = m;
    }

    /**
     * Constructor que crea una matriz a partir de otra
     * @param m -- matriz que se copiará
     */
    public Matriz(Matriz m){
      //Escribe aquí tu código
      this.mat = m.mat;
    }

    public double get(int i, int j) {
      //Escribe aquí tu código
      return mat[i][j];
    }

    /**
     * Método para obtener la cantidad de renglones de la matriz
     * @return int -- el número de renglones de la matriz
     */
    public int renglones(){
      //Escribe aquí tu código
      renglon = mat.length;
      return renglon;
    }

    /**
     * Método para obtener el número de columnas de la matriz
     * @return int -- el número de columnas de la matriz
     */
    public int columnas(){
      //Escribe aquí tu código
      columna = mat[0].length;
      return columna;
    }

    /**
     * Método para obtener la matriz transpuesta de la matriz original de n*m
     * @return Matriz -- la matriz transpuesta de la original
     */
    public Matriz trasponer(){

      double [][] aux = new double[columnas()][renglones()];
      Matriz matAux = new Matriz(aux);

      return matAux;
    }

    /**
     * Método para determinar si la matriz cuadrada es simétrica
     * @return boolean -- true si es simétrica, false en otro caso
     */
    public boolean esSimetrica(){
      //Escribe aquí tu código
      for (int i = 0; i < renglones(); i++) {
        for (int j = 0; j < columnas(); j++) {
          if(mat[i][j] != mat[j][i]){
            return false;
          }
        }
      }
      return true;
    }

    /**
     * Método para calcular la suma de dos matrices de igual tamaño, en caso de
     * no tener el mismo tamaño mandar un error
     * @param m -- Matriz que será sumada a la que llama al método.
     */
    public void sumar(Matriz m){
      //Escribe aquí tu código
      double suma [][] = new double [renglones()][columnas()];

      if(renglones() == m.renglones() && columnas() == m.columnas()){
        for (int i = 0; i < renglones(); i++) {
          for (int j = 0; j < columnas(); j++) {
            suma[i][j] = mat[i][j] + m.get(i, j) ;
          }
        }
      }else{
      System.out.println("Las matrices no son iguales");
      }
    }

    /**
     * Método para calcular la multiplicación de dos matrices
     * @param m -- Matriz que será sumada a la que llama al método
     * @return Matriz -- El producto de las dos matrices
     */
    public Matriz multiplicar(Matriz m){
      //Escribe aquí tu código
      return null;
    }
}
