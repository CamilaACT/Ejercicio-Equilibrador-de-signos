// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        // Usuario ingresa
        int opcionMenu = 0;
        while (opcionMenu!=3){
            System.out.println("1.Buscar equilibrio y orden");
            System.out.println("2.Buscar equilibrio");
            System.out.println("3.Salir");
            Scanner scs= new Scanner(System.in);
            opcionMenu= scs.nextInt();

            switch(opcionMenu) {
                case 1://Utiliza pila porque se fija en el orden de los símbolos y verifica que sea concordante la posicion de apertur y cierre
                    System.out.println("--Busqueda equilibrio y Orden--");
                    System.out.println("Ingrese la expresión a evaluar:");
                    String s=scs.next();
                    int indice=0;
                    Stack<String> stk = new Stack<>();
                    for(int i=0;i<s.length();i++){
                        if(s.charAt(i)=='{'|| s.charAt(i)=='(' ||s.charAt(i)=='[')
                        {
                            stk.push(String.valueOf(s.charAt(i)));
                        }
                        else{
                            indice=i;
                            break;
                        }
                    }

                    System.out.println("Tamanio pila: "+stk.size());
                    int tamanioString=s.length();
                    System.out.println("Tamanio String: "+ tamanioString);
                    int tamanioBusqueda= tamanioString-indice;
                    System.out.println("Tamanio Busqueda: "+tamanioBusqueda);
                    int tamanioPila=stk.size();

                    if (tamanioPila==tamanioBusqueda){
                        for(int i=0; i<tamanioBusqueda;i++){
                            String aux= stk.pop();
                            //System.out.println("Tamanio pila"+stk.size());
                            String aux1=String.valueOf(s.charAt(indice+i));
                            if (aux.equals("(")){
                                if (aux1.equals(")")){
                                    System.out.println("BIEN (");
                                }else{
                                    System.out.println("MAL (,no hay equilibrio");
                                    break;
                                }
                            }
                            if (aux.equals("[")){
                                if (aux1.equals("]")){
                                    System.out.println("BIEN [");
                                }else{
                                    System.out.println("MAL [,no hay equilibrio");
                                    break;
                                }
                            }
                            if (aux.equals("{")){
                                if (aux1.equals("}")){
                                    System.out.println("BIEN {");
                                }else{
                                    System.out.println("MAL {,no hay equilibrio");
                                    break;
                                }
                            }
                        }
                    }else{
                        System.out.println("NO hay concordancia en los simbolos, no hay equilibrio");
                    }
                    break;
                case 2://Solo verifica que haya la misma cantidad de simbolos de apertura y cierrre sin importar el orden
                    System.out.println("--Busqueda equilibrio y Orden--");
                    System.out.println("Ingrese la expresión a evaluar:");
                    String s2=scs.next();
                    int[] contadores = new int[7];
                    for (int i=0;i<s2.length();i++){
                        String letra=String.valueOf(s2.charAt(i));
                        if(letra.equals("{")){
                            contadores[0]++;
                        }
                        if(letra.equals("[")){
                            contadores[1]++;
                        }
                        if(letra.equals("(")){
                            contadores[2]++;
                        }
                        if(letra.equals(")")){
                            contadores[3]++;
                        }
                        if(letra.equals("]")){
                            contadores[4]++;
                        }
                        if(letra.equals("}")){
                            contadores[5]++;
                        }
                    }
                    contadores[6]=0;
                    if (contadores[0]==contadores[5]){
                        contadores[6]=1;
                        System.out.println("Cantidad de {} correcta");
                    }
                    if (contadores[1]==contadores[4]){
                        contadores[6]=contadores[6]+1;
                        System.out.println("Cantidad de [] correcta");
                    }
                    if (contadores[2]==contadores[3]){
                        contadores[6]=contadores[6]+1;
                        System.out.println("Cantidad de () correcta");
                    }
                    if (contadores[6]==3) {
                        System.out.println("Expresión equilibrio");
                    }else{
                        System.out.println("Expresión sin equilibrio");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }
        }

    }
}