import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        String command;

        while (true) {
            System.out.print(":");
            command = scanner.nextLine();
            scanner.nextLine(); 
            String[] parts = command.split(" ");
            switch (parts[0]) {
                 // :e NomeArq.ext Abrir o arquivo de nome NomeArq.ext e armazenar cada linha em
                    // um nó da lista.
                case ":e":
                    if (parts.length > 1) {
                        if (list.loadFile(parts[1])) {
                            System.out.println("Arquivo '" + parts[1] + "' lido com sucesso!");
                        } else {
                            System.out.println("Arquivo '" + parts[1] + "' não existe!");
                        }
                    }
                    break;
                    // :w Salvar a lista no arquivo atualmente aberto.
                    // :w NomeArq.ext Salvar a lista no arquivo de nome NomeArq.ext.
                case ":w":
                    if (parts.length > 1) {
                        if (list.saveFile(parts[1])) {
                            System.out.println("Arquivo '" + parts[1] + "' salvo com sucesso!");
                        } else {
                            System.out.println("Falha ao salvar o arquivo '" + parts[1] + "'.");
                        }
                    }
                    break;
                    // :s Exibir em tela o conteúdo completo do código-fonte que consta na
                    // lista, de 20 em 20 linhas.
                case ":s":
                    int start = parts.length > 1 ? Integer.parseInt(parts[1]) : 1;
                    int end = parts.length > 2 ? Integer.parseInt(parts[2]) : 20;
                    list.display(start, end);
                    break;
                        // :q! Encerrar o editor. Caso existam modificações não salvas na lista,
                    // o programa deve solicitar confirmação se a pessoa usuária do
                case ":q!":
                    System.out.println("Encerrando o editor...");
                    return;
                   
                    
                    
                
                    // editor deseja salvar as alterações em arquivo antes de encerrar o
                    // editor.
                    // :v LinIni LinFim Marcar um texto da lista (para cópia ou recorte – “área de
                    // transferência”) da LinIni até LinFim. Deve ser verificado se o
                    // intervalo [LinIni, LinFim] é válido.
                    // :y Copiar o texto marcado (ver comando anterior) para uma lista
                    // usada como área de transferência.
                    // :c Recortar o texto marcado para a lista de área de transferência.
                    // :p LinIniColar Colar o conteúdo da área de transferência na lista, a partir da linha
                    // indicada em LinIniColar. Deve ser verificado se LinIniColar é
                    // válido.
                    // :s LinIni LinFim Exibir na tela o conteúdo do código-fonte que consta na lista, da
                    // linha inicial LinIni até a linha final LinFim, de 20 em 20 linhas.
                    // :x Lin Apagar a linha de posição Lin da lista.
                    // :xG Lin Apagar o conteúdo a partir da linha Lin até o final da lista.
                    // :XG Lin Apagar o conteúdo da linha Lin até o início da lista.
                    // :/ Elemento Percorrer a lista, localizar as linhas que contém Elemento e exibir
                    // o conteúdo das linhas por completo.
                    // :/ Elem ElemTroca Percorrer a lista e realizar a troca de Elem por ElemTroca em todas
                    // as linhas do código-fonte.
                    // :/ Elem ElemTroca Linha Realizar a troca de Elem por ElemTroca na linha Linha do códigofonte.
                    // :a PosLin Permitir a inserção de uma ou mais linhas e inserir na lista depois
                    // da posição PosLin. O término da entrada do novo conteúdo é
                    // dado por um :a em uma linha vazia.
                    // :i PosLin Permitir a inserção de uma ou mais linhas e inserir na lista antes
                    // da posição PosLin. O término da entrada do novo conteúdo é
                    // dado por um :i em uma linha vazia.
                    // :help Apresentar na tela todas as operações permitidas no editor.
                default:
                    System.out.println("Comando não reconhecido. Use :help para ver os comandos disponíveis.");
    
            }
            scanner.close();
        }

    }
}
