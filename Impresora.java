public class Impresora {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void imprimeVerde(String s) {
	System.out.println(ANSI_GREEN + s + ANSI_RESET);
    }

    public static void imprimeRojo(String s) {
	System.out.println(ANSI_RED + s + ANSI_RESET);
    }

    public static void imprimeBlanco(String s) {
	System.out.println(s);
    }

    public static void main(String [] args) {
	System.out.println(ANSI_RED + "This should be a red text" + ANSI_RESET);
	System.out.println(ANSI_GREEN + "This should be a green text" + ANSI_RESET);
    }
}
