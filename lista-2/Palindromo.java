import java.util.Scanner;

    public class Palindromo {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite uma palavra ou frase para verificar se é um palíndromo:");
            String txt = scanner.nextLine();

            Palindromo palindromo = new Palindromo(txt);

            if (palindromo.verificar()) {
                System.out.println("É um palíndromo.");
            } else {
                System.out.println("Não é um palíndromo.");
            }
            
            scanner.close();
        }

    private String txt;

    public Palindromo() {
        this.txt = "";
    }

    public Palindromo(String txt) {
        this.txt = txt;
    }

    public String gettxt() {
        return txt;
    }

    public void settxt(String txt) {
        if (txt != null) {
            this.txt = txt;
        }
    }

    public boolean verificar() {
        String txtSemEspaco = this.txt.replaceAll("\\s+", "").toLowerCase();
        int tamanho = txtSemEspaco.length();
        for (int i = 0; i < tamanho / 2; i++) {
            if (txtSemEspaco.charAt(i) != txtSemEspaco.charAt(tamanho - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
}
    //https://www.w3schools.com/java/java_constructors.asp
    //https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Global_Objects/String/charAt
    // https://www.baeldung.com/string/replace-all