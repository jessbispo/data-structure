public class Colision {

    public static void main(String[] args) {
      double x1 = 0; double y1 = 0; double r1 = 5;  
      double x2 = 0;  double y2 =  11; double r2 = 5;

      if(haColisaoEntreCirculos(x1, y1, r1, x2, y2, r2)){
        System.out.println("true");
      }  else {
        System.out.println("false");
    }
      

    };

    public static boolean haColisaoEntreCirculos(double x1, double y1, double r1, double x2, double y2, double r2) {
        double distanciaCentros = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double raios = r1 + r2;

        if (distanciaCentros <= raios){
            return true;
        }
        return false;
    }
}

//the method(?) @SuppressWarnings("unused") is used when the method will not be used, to avoid warning

// https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection