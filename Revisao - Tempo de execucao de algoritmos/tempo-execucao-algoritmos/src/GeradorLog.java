import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;
import static java.time.LocalTime.now;
import static util.Constantes.*;

public class GeradorLog {

    public static void gerarLog(Cenario cenario, double tempoPercorridoSeg, double tempoPercorridoMs, String estruturaDados) throws IOException {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);

            if (arquivo.exists()) {
                try (PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true))) {
                    printWriter.println(format(CONFIGURACAO_COLUNAS,
                            estruturaDados,
                            cenario.qtdePessoas(),
                            cenario.qtdeBuscas(),
                            tempoPercorridoSeg,
                            tempoPercorridoMs,
                            now()));
                }
            } else {
                try (PrintWriter printWriter = new PrintWriter(CAMINHO_ARQUIVO)) {
                    printWriter.println(format(CONFIGURACAO_COLUNAS, (Object[]) COLUNAS));
                    printWriter.println(format(CONFIGURACAO_COLUNAS,
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
