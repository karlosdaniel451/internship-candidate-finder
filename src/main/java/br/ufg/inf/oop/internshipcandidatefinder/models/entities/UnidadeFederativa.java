package br.ufg.inf.oop.internshipcandidatefinder.models.entities;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public enum UnidadeFederativa {
    ACRE("AC", "Acre"), ALAGOAS("AL", "Alagoas"), AMAPA("AP", "Amapa"), AMAZONAS("AM", "Amazonas"),
    BAHIA("BA", "Bahia"), CEARA("CE", "Ceará"), DISTRITO_FEDERAL("DF", "Distrito Federal"),
    ESPIRITO_SANTO("ES", "Espírito Santo"), GOIAS("GO", "Goiás"), MARANHAO("MA", "Maranhão"),
    MATO_GROSSO("MT", "Mato Grosso"), MATO_GROSSO_DO_SUL("MS", "Mato Grosso do Sul"),
    MINAS_GERAIS("MG", "Minas Gerais"), PARA("PA", "Ṕará"), PARAIBA("PB", "Paraíba"),
    PARANA("PR", "Paraná"), PERNAMBUCO("PE", "Pernambuco"), PIAUI("PI", "Piauí"),
    RIO_DE_JANEIRO("RJ", "Rio de Janeiro"), RIO_GRANDE_DO_NORTE("RN", "Rio Grande do Norte"),
    RIO_GRANDE_DO_SUL("RS", "Rio Grande do Sul"), RONDONIA("RO", "Rondônia"),
    RORAIMA("RR", "Roraima"), SANTA_CATARINA("SC", "Santa Catarina"), SAO_PAULO("SP", "São Paulo"),
    SERGIPE("SE", "Sergipe"), TOCANTINS("TO", "Tocantins");

    private final String sigla;
    private final String nome;

    UnidadeFederativa(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public static UnidadeFederativa fromSigla(String sigla) throws IllegalArgumentException {
        for (UnidadeFederativa uf : UnidadeFederativa.values()) {
            if (uf.sigla.equalsIgnoreCase(sigla)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(String.format("No enum constant %s", sigla));
    }

    public static UnidadeFederativa fromNome(String nome) {
        UnidadeFederativa unidadeFederativa = null;

        for (UnidadeFederativa uf : UnidadeFederativa.values()) {
            if (uf.nome.equalsIgnoreCase(nome)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(String.format("No enum constant %s", nome));
    }

    public static String valuesToString() {
        StringBuilder valuesToString = new StringBuilder();

        Arrays.asList(values()).forEach(uf -> valuesToString.append(uf).append("\n"));

        return valuesToString.toString();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", nome, sigla);
    }
}
