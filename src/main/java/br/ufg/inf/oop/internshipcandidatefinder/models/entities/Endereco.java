package br.ufg.inf.oop.internshipcandidatefinder.models.entities;

public class Endereco {
    private static int numberOfCreatedObjects = 0;

    private int id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String municipio;
    private UnidadeFederativa unidadeFedrativa;

    public Endereco(String cep, String logradouro, String bairro, String municipio,
                    UnidadeFederativa unidadeFedrativa) {

        Endereco.numberOfCreatedObjects = 0;

        this.id = numberOfCreatedObjects;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.municipio = municipio;
        this.unidadeFedrativa = unidadeFedrativa;
    }

    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public UnidadeFederativa getUnidadeFedrativa() {
        return unidadeFedrativa;
    }

    public void setUnidadeFedrativa(UnidadeFederativa unidadeFedrativa) {
        this.unidadeFedrativa = unidadeFedrativa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        return cep.equals(endereco.cep);
    }

    @Override
    public int hashCode() {
        return cep.hashCode();
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", municipio='" + municipio + '\'' +
                ", unidadeFedrativa=" + unidadeFedrativa +
                '}';
    }
}
