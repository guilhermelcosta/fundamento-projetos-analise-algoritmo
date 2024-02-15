import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;
import static java.time.LocalDateTime.now;

public class GeradorLog {

    /**
     * Gera log da execução
     *
     * @param cenario            cenário em análise do log
     * @param tempoPercorridoSeg tempo percorrido na execução, em segundos
     * @param tempoPercorridoMs  tempo percorrido na execução, em milissegundos
     * @param estruturaDados     estrutura de dados utilizada (ArrayList ou HashMap)
     * @throws IOException lança exceção caso ocorra erro ao executar uma função do arquivo de log
     */
    public static void gerarLog(Cenario cenario, double tempoPercorridoSeg, double tempoPercorridoMs, String estruturaDados) throws IOException {
        try {
            File arquivo = new File(Constantes.CAMINHO_ARQUIVO);

            if (arquivo.exists()) {
                try (PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true))) {
                    printWriter.println(format(Constantes.CONFIGURACAO_COLUNAS,
                            estruturaDados,
                            cenario.qtdePessoas(),
                            cenario.qtdeBuscas(),
                            tempoPercorridoSeg,
                            tempoPercorridoMs,
                            now()));
                }
            } else {
                try (PrintWriter printWriter = new PrintWriter(Constantes.CAMINHO_ARQUIVO)) {
                    printWriter.println(format(Constantes.CONFIGURACAO_COLUNAS, (Object[]) Constantes.COLUNAS));
                    printWriter.println(format(Constantes.CONFIGURACAO_COLUNAS,
                            estruturaDados,
                            cenario.qtdePessoas(),
                            cenario.qtdeBuscas(),
                            tempoPercorridoSeg,
                            tempoPercorridoMs,
                            now()));
                }
            }
        } catch (IOException e) {
            throw new IOException("Erro ao salvar o arquivo.");
        }
    }
}
