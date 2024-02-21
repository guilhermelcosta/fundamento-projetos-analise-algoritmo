import javax.management.InvalidAttributeValueException;

public class Pessoa {

    private final int id;

    private final String nome;

    public Pessoa(int id, String nome) throws InvalidAttributeValueException{
        if(id<=0 || nome.length()<2)
            throw new InvalidAttributeValueException("Atributos inválidos para a pessoa");
        this.id = id;
        this.nome = nome;
    }

    /**
     * Igualdade de pessoas: duas pessoas são iguais se têm o mesmo id. A tentativa de comparar objetos de outras classes gera resposta falsa
     * @param o Objeto (Pessoa) a ser comparado com este
     * @return TRUE caso o id das pessoas seja igual, FALSE caso contrário ou em tentativa de comparação com objetos de outras classes.
     */
    @Override
    public boolean equals(Object o){
        try{
            Pessoa outra = (Pessoa)o;
            return this.id == outra.id;
        }catch (ClassCastException cex){
            return false;
        }
    }

    /**
     * Representação em string: "NNNN - id XXX" , sendo NNNN o nome da pessoa e XXX seu id
     * @return Uma string com a especificação acima.
     */
    public String toString(){
        return this.nome + " - id "+this.id;
    }
}
