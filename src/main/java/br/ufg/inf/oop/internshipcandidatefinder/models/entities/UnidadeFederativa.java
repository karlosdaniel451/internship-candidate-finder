package br.ufg.inf.oop.internshipcandidatefinder.models.entities;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public enum UnidadeFederativa {
    ACRE("AC"), ALAGOAS("AL"), AMAPA("AP"), AMAZONAS("AM"), BAHIA("BA"), CEARA("CE"),
    DISTRITO_FEDERAL("CE"), ESPIRITO_SANTO("ES"), GOIAS("GO"), MARANHAO("MA"), MATO_GROSSO("MT"),
    MATO_GROSSO_DO_SUL("MS"), MINAS_GERAIS("MG"), PARA("PA"), PARAIBA("PA"), PARANA("PR"),
    PERNAMBUCO("PE"), PIAUI("PI"), RIO_DE_JANEIRO("RJ"), RIO_GRANDE_DO_NORTE("RN"),
    RIO_GRANDE_DO_SUL("RS"), RONDONIA("RO"), RORAIMA("RR"), SANTA_CATARINA("SC"), SAO_PAULO("SP"),
    SERGIPE("SE"), TOCANTINS("TO");

    public final String sigla;

    UnidadeFederativa(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public static UnidadeFederativa fromSigla(String sigla) {
        for (UnidadeFederativa uf: UnidadeFederativa.values()) {
            if (uf.sigla.equalsIgnoreCase(sigla)) {
                return uf;
            }
        }
        throw new IllegalArgumentException(String.format("No enum constant %s", sigla));
    }
}
