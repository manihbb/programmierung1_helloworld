public class Potenz {
    static void main(){
        int n = 5;

        int aktuellerExponent = 0;
        while(aktuellerExponent <= n){
            System.out.println(Math.pow(2, aktuellerExponent));
            aktuellerExponent = aktuellerExponent + 1;
        }

    }
}