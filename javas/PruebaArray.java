class PruebaArray {
    public static void main(String[] args) {
       // Declaración del array
        int[] arrayDeEnteros;
       
       // Creamos 5 espacios para enteros
       arrayDeEnteros = new int[5];

       arrayDeEnteros[0] = 1;
       arrayDeEnteros[1] = 3;
       arrayDeEnteros[2] = 5;
       arrayDeEnteros[3] = 7;
       arrayDeEnteros[4] = 9;

       System.out.println("arrayDeEnteros[0]: "
                  + arrayDeEnteros[0]);
       System.out.println("arrayDeEnteros[1]: "
                  + arrayDeEnteros[1]);
       System.out.println("arrayDeEnteros[0]: "
                  + arrayDeEnteros[2]);
      System.out.println("arrayDeEnteros[0]: "
                 + arrayDeEnteros[3]);
      System.out.println("arrayDeEnteros[0]: "
                 + arrayDeEnteros[4]);

      int[] otroArrayInt = {11, 22, 33, 44, 55, 66};

      for (int j = 0; j < otroArrayInt.length; j++){
          System.out.println("otroArray " + otroArrayInt[j]);
      }
  }
}
