package br.com.empresa.buscawebservicecep.model;

/**
 *
 * @author robson
 */
public class Logradouro {

    private String cep;
    private String logradouro;
    private String bairro;
    private String nomeCidade;
    private String UF;
    private String ddd;
    private String ibge;
    private String altitude;
    private String latitude;
    private String longitude;

    public Logradouro() {
        this.cep = "faltante";
        this.logradouro = "faltante";
        this.bairro = "faltante";
        this.nomeCidade = "faltante";
        this.UF = "faltante";
        this.ddd = "faltante";
        this.ibge = "faltante";
        this.altitude = "faltante";
        this.latitude = "faltante";
        this.longitude = "faltante";
    }

    public Logradouro(String cep, String logradouro, String bairro, String nomeCidade, String UF, String ddd, String ibge, String altitude, String latitude, String longitude) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.nomeCidade = nomeCidade;
        this.UF = UF;
        this.ddd = ddd;
        this.ibge = ibge;
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String toString() {
        return "Cep: " + getCep()
                + "\nLogradouro: " + getLogradouro()
                + "\nBairro: " + getBairro()
                + "\nCidade: " + getNomeCidade()
                + "\nUF: " + getUF()
                + "\nDDD: " + getDdd()
                + "\nIBGE: " + getIbge()
                + "\nAltitude: " + getAltitude()
                + "\nLatitude: " + getLatitude()
                + "\nLongitude: " + getLongitude();

    }
}
