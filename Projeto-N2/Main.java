import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CircularLinkedList list = new CircularLinkedList();
    private static String currentFileName = null;
    private static boolean isModified = false;

    public static void main(String[] args) {
        String command;

        while (true) {
            System.out.print(":");
            command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case ":e":
                    if (parts.length > 1) {
                        loadFile(parts[1]);
                    } else {
                        System.out.println("Uso correto: :e NomeArq.ext");
                    }
                    break;
                case ":w":
                    if (parts.length > 1) {
                        saveFile(parts[1]);
                    } else {
                        saveFile();
                    }
                    break;
                case ":q!":
                    quitEditor();
                    break;
                case ":v":
                    if (parts.length == 3) {
                        markText(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    } else {
                        System.out.println("Uso correto: :v LinIni LinFim");
                    }
                    break;
                case ":y":
                    copyMarkedText();
                    break;
                case ":c":
                    cutMarkedText();
                    break;
                case ":p":
                    if (parts.length == 2) {
                        pasteText(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Uso correto: :p LinIniColar");
                    }
                    break;
                case ":s":
                    if (parts.length == 1) {
                        display();
                    } else if (parts.length == 3) {
                        display(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    } else {
                        System.out.println("Uso correto: :s [LinIni LinFim]");
                    }
                    break;
                case ":x":
                    if (parts.length == 2) {
                        removeLine(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Uso correto: :x Lin");
                    }
                    break;
                case ":xG":
                    if (parts.length == 2) {
                        removeLinesFrom(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Uso correto: :xG Lin");
                    }
                    break;
                case ":XG":
                    if (parts.length == 2) {
                        removeLinesTo(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Uso correto: :XG Lin");
                    }
                    break;
                case ":/":
                    if (parts.length == 2) {
                        searchAndDisplay(parts[1]);
                    } else if (parts.length == 3) {
                        replaceAll(parts[1], parts[2]);
                    } else if (parts.length == 4) {
                        replaceInLine(parts[1], parts[2], Integer.parseInt(parts[3]));
                    } else {
                        System.out.println("Uso correto: :/ Elemento [Elem [ElemTroca [Linha]]]");
                    }
                    break;
                case ":a":
                    if (parts.length == 2) {
                        insertAfter(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Uso correto: :a PosLin");
                    }
                    break;
                case ":i":
                    if (parts.length == 2) {
                        insertBefore(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Uso correto: :i PosLin");
                    }
                    break;
                case ":help":
                    showHelp();
                    break;
                default:
                    System.out.println("Comando não reconhecido. Use :help para ver os comandos disponíveis.");
            }
        }
    }

    private static void loadFile(String filename) {
        if (list.loadFile(filename)) {
            currentFileName = filename;
            isModified = false;
            System.out.println("Arquivo '" + filename + "' lido com sucesso!");
        } else {
            System.out.println("Falha ao ler o arquivo '" + filename + "'.");
        }
    }

    private static void saveFile(String filename) {
        if (list.saveFile(filename)) {
            currentFileName = filename;
            isModified = false;
            System.out.println("Arquivo '" + filename + "' salvo com sucesso!");
        } else {
            System.out.println("Falha ao salvar o arquivo '" + filename + "'.");
        }
    }

    private static void saveFile() {
        if (currentFileName != null) {
            saveFile(currentFileName);
        } else {
            System.out.println("Nenhum arquivo aberto para salvar. Use :w NomeArq.ext");
        }
    }

    private static void quitEditor() {
        if (isModified) {
            System.out.print("Existem modificações não salvas. Deseja salvar? (s/n): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("s")) {
                saveFile();
            }
        }
        System.out.println("Encerrando o editor...");
        scanner.close();
        System.exit(0);
    }

    private static void markText(int start, int end) {
        list.markText(start, end);
    }

    private static void copyMarkedText() {
        list.copyMarkedText();
    }

    private static void cutMarkedText() {
        list.cutMarkedText();
    }

    private static void pasteText(int position) {
        list.pasteText(position);
    }

    private static void display() {
        list.displayAll();
    }

    private static void display(int start, int end) {
        list.display(start, end);
    }

    private static void removeLine(int lineNumber) {
        list.removeLineAt(lineNumber);
    }

    private static void removeLinesFrom(int lineNumber) {
        list.removeLinesFrom(lineNumber);
    }

    private static void removeLinesTo(int lineNumber) {
        list.removeLinesTo(lineNumber);
    }

    private static void searchAndDisplay(String element) {
        list.searchAndDisplay(element);
    }

    private static void replaceAll(String oldElement, String newElement) {
        list.replaceAll(oldElement, newElement);
    }

    private static void replaceInLine(String oldElement, String newElement, int lineIndex) {
        list.replaceInLine(oldElement, newElement, lineIndex);
    }

    private static void insertAfter(int position) {
        System.out.println("Insira o conteúdo das novas linhas. Termine com uma linha contendo apenas ':a'");
        String line;
        while (!(line = scanner.nextLine()).equals(":a")) {
            list.insertLineAt(position + 1, line);
            position++;
        }
        isModified = true;
    }

    private static void insertBefore(int position) {
        System.out.println("Insira o conteúdo das novas linhas. Termine com uma linha contendo apenas ':i'");
        String line;
        while (!(line = scanner.nextLine()).equals(":i")) {
            list.insertLineAt(position, line);
            position++;
        }
        isModified = true;
    }

    private static void showHelp() {
        System.out.println("Comandos disponíveis:");
        System.out.println(":e NomeArq.ext - Abrir o arquivo de nome NomeArq.ext e armazenar cada linha em um nó da lista.");
        System.out.println(":w - Salvar a lista no arquivo atualmente aberto.");
        System.out.println(":w NomeArq.ext - Salvar a lista no arquivo de nome NomeArq.ext.");
        System.out.println(":q! - Encerrar o editor.");
        System.out.println(":v LinIni LinFim - Marcar um texto da lista da LinIni até LinFim.");
        System.out.println(":y - Copiar o texto marcado para uma lista usada como área de transferência.");
        System.out.println(":c - Recortar o texto marcado para a lista de área de transferência.");
        System.out.println(":p LinIniColar - Colar o conteúdo da área de transferência na lista, a partir da linha indicada em LinIniColar.");
        System.out.println(":s - Exibir em tela o conteúdo completo do código-fonte que consta na lista, de 20 em 20 linhas.");
        System.out.println(":s LinIni LinFim - Exibir na tela o conteúdo do código-fonte que consta na lista, da linha inicial LinIni até a linha final LinFim, de 20 em 20 linhas.");
        System.out.println(":x Lin - Apagar a linha de posição Lin da lista.");
        System.out.println(":xG Lin - Apagar o conteúdo a partir da linha Lin até o final da lista.");
        System.out.println(":XG Lin - Apagar o conteúdo da linha Lin até o início da lista.");
        System.out.println(":/ Elemento - Percorrer a lista, localizar as linhas que contém Elemento e exibir o conteúdo das linhas por completo.");
        System.out.println(":/ Elem ElemTroca - Percorrer a lista e realizar a troca de Elem por ElemTroca em todas as linhas do código-fonte.");
        System.out.println(":/ Elem ElemTroca Linha - Realizar a troca de Elem por ElemTroca na linha Linha do código-fonte.");
        System.out.println(":a PosLin - Permitir a inserção de uma ou mais linhas e inserir na lista depois da posição PosLin. O término da entrada do novo conteúdo é dado por um :a em uma linha vazia.");
        System.out.println(":i PosLin - Permitir a inserção de uma ou mais linhas e inserir na lista antes da posição PosLin. O término da entrada do novo conteúdo é dado por um :i em uma linha vazia.");
        System.out.println(":help - Apresentar na tela todas as operações permitidas no editor.");
    }
}
