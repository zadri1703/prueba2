
public class HistogramaDeLetras {
    public static void main(String[] args) {
        String frase = "En un lugar de La Mancha de cuyo nombre no quiero acordarme...";

        int[] frecuencia = new int[27];

        frase = frase.toLowerCase();

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (c >= 'a' && c <= 'z') {
                frecuencia[c - 'a']++;
            }

            else if (c == 'ñ') {
                frecuencia[26]++;
            }

        }

        int frecuenciaMaxima = 0;

        for (int i = 0; i < 27; i++) {

            if (frecuencia[i] > frecuenciaMaxima) {
                frecuenciaMaxima = frecuencia[i];
            }

        }

        double factorEscala = 30.0 / frecuenciaMaxima;

        System.out.println("HISTOGRMA EN HORIZONTAL:");

        for (int i = 0; i < 26; i++) {
            char letra = (char) ('a' + i);
            int cantidad = (int) (frecuencia[i] * factorEscala);
            System.out.println(letra + ": " + "*".repeat(cantidad));
        }

        System.out.println("ñ: " + "*".repeat((int) (frecuencia[26] * factorEscala)));

        System.out.println("\nHISTOGRAMA EN VERTICAL:");
        int maxAltura = (int) (frecuenciaMaxima * factorEscala);

        for (int nivel = maxAltura; nivel > 0; nivel--) {

            for (int i = 0; i < 26; i++) {

                if ((int) (frecuencia[i] * factorEscala) >= nivel) {
                    System.out.print("* ");
                }

                else {
                    System.out.print("  ");
                }

            }

            if ((int) (frecuencia[26] * factorEscala) >= nivel) {
                System.out.print("*");
            }

            else {
                System.out.print(" ");
            }

            System.out.println();
        }

        for (int i = 0; i < 26; i++) {
            System.out.print((char) ('a' + i) + " ");
        }

        System.out.println("ñ");
    }
}