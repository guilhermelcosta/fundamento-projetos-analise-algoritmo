import static java.lang.String.format;

public class Constantes {

    public static final int UM = 1;

    public static final int DOIS = 2;

    public static final int TRES = 3;

    public static final int QUATRO = 4;

    public static final int VINTE_MIL = 20000;

    public static final int QUARENTA_MIL = 40000;

    public static final int DOIS_MILHOES_QUINHENTOS_MIL = 2500000;

    public static final int CINCO_MILHOES = 5000000;

    public static final int DEZ_MILHOES = 10000000;

    public static final String ARRAY_LIST = "ARRAY_LIST";

    public static final String HASH_MAP = "HASH_MAP";

    public static final String CONFIGURACAO_COLUNAS = "%-25s | %-25s | %-25s | %-25s | %-25s | %-25s";

    public static final String[] COLUNAS = {
            "Estrutura armazenamento", "Quantidade pessoas", "Quantidade buscas", "Tempo percorrido (Seg)", "Tempo percorrido (Ms)", "Data de execução"
    };

    public static final String CAMINHO_ARQUIVO = "logs/exec-log.txt";

    public static final double NANO_PARA_MS = 1_000_000d;

    public static final double NANO_PARA_SEG = 1_000d;

    public static final String MSG_ERRO_ARQUIVO = format("erro ao salvar o arquivo no caminho: %s", Constantes.CAMINHO_ARQUIVO);

    public static final String MSG_ERRO_PESSOA = "erro ao criar objeto Pessoa";

    public static final String NOME = "Nome";
}
