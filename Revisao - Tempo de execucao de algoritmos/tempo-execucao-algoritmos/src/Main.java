import javax.management.InvalidAttributeValueException;
import java.io.IOException;
import java.util.*;

import static java.lang.String.format;
import static java.lang.System.nanoTime;
import static util.Constantes.*;

/**
 * Aluno: Guilherme Lage da Costa
 * Matrícula: 792939
 * Data: 19 de fevereiro de 2024
 * Ambiente de realização dos testes:
 * - JDK: Java 17
 * - Processador: Ryzen 5 3600, 4.2 Ghz, 6 cores e 12 threads, 32mb de cache
 * - RAM: 16GB, 3000Ghz
 * - Sistema Operacional: Windows 11
 * - IDE: IntelliJ Ultimate
 */
public class Main {

    protected static final Random random = new Random();
    protected static final Map<Integer, Cenario> cenarios = new HashMap<>();

    public static void main(String[] args) {

        cenarios.put(1, new Cenario(DOIS_MILHOES_QUINHENTOS_MIL, VINTE_MIL));
        cenarios.put(2, new Cenario(CINCO_MILHOES, VINTE_MIL));
        cenarios.put(3, new Cenario(DEZ_MILHOES, VINTE_MIL));

//        Eu não quis criar um método genérico que aceitasse como parâmetro a estrutura de dados,
//        para evitar validação de condições em ifs durante a execução dos testes, o que poderia mascarar os resultados
        realizarTestesArrayList();
        realizarTestesHashMap();
    }

    /**
     * Realiza os testes com ArrayList
     *
     */
    private static void realizarTestesArrayList() {

        List<Pessoa> listaPessoas = new ArrayList<>();

        cenarios.forEach((integer, cenario) -> {

            int qtdePessoas = cenario.qtdePessoas();
            int qtdeBuscas = cenario.qtdeBuscas();
            long inicio = nanoTime();
//            Iniciado em 1, pois a classe Pessoa não permite id = 0
//            Preenchendo ArrayList de Pessoa
            for (int i = 1; i <= qtdePessoas; i++) {
                try {
                    listaPessoas.add(new Pessoa(i, format("Pessoa %s", i)));
                } catch (InvalidAttributeValueException e) {
                    throw new IllegalArgumentException("erro ao criar objeto Pessoa");
                }
            }
//            Realizando busca em ids aleatórios
            for (int i = 1; i <= qtdeBuscas; i++)
                listaPessoas.get(random.nextInt((qtdePessoas)));
            long fim = nanoTime();

            try {
                GeradorLog.gerarLog(cenario, converterParaSeg(inicio, fim), converterParaMs(inicio, fim), ARRAY_LIST);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        });
    }

    /**
     * Realiza os testes com HashMap
     *
     */
    private static void realizarTestesHashMap() {

        HashMap<Integer, Pessoa> hashMapPessoas = new HashMap<>();

        cenarios.forEach((integer, cenario) -> {

            int qtdePessoas = cenario.qtdePessoas();
            int qtdeBuscas = cenario.qtdeBuscas();
            long inicio = nanoTime();
//            Iniciado em 1, pois a classe Pessoa não permite id = 0
//            Preenchendo HashMap de Pessoa
            for (int i = 1; i <= qtdePessoas; i++) {
                try {
                    hashMapPessoas.put(i, new Pessoa(i, format("Pessoa %s", i)));
                } catch (InvalidAttributeValueException e) {
                    throw new IllegalArgumentException("erro ao criar objeto Pessoa", e);
                }
            }
//            Realizando busca em ids aleatórios
            for (int i = 1; i <= qtdeBuscas; i++)
                hashMapPessoas.get(random.nextInt((qtdePessoas)));
            long fim = nanoTime();

            try {
                GeradorLog.gerarLog(cenario, converterParaSeg(inicio, fim), converterParaMs(inicio, fim), HASH_MAP);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        });
    }

    /**
     * Converte tempo em nano seg para ms
     *
     * @param inicio tempo de início, em nano seg
     * @param fim    tempo de fim, em nano seg
     * @return tempo percorrido, em ms
     */
    private static double converterParaMs(double inicio, double fim) {
        return (fim - inicio) / NANO_PARA_MS;
    }

    /**
     * Converte tempo em nano seg para seg
     *
     * @param inicio tempo de início, em nano seg
     * @param fim    tempo de fim, em nano seg
     * @return tempo percorrido, em seg
     */
    private static double converterParaSeg(double inicio, double fim) {
        return (converterParaMs(inicio, fim)) / NANO_PARA_SEG;
    }
}
