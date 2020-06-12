package br.com.empresa.buscawebservicecep.view;

import br.com.empresa.buscawebservicecep.model.Logradouro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author robson
 * Codigo de consumo para API CepAperto
 */
public class Api {

    private static int response;

    public static String getJSONFromAPI(String url) {
        String retorno = "";
        try {
            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection conexao;
            InputStream is;

            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.setRequestProperty("User-Agent", "CepAberto");
            conexao.setRequestProperty("Accept", "application/json");
            conexao.setRequestProperty("Authorization", "Token token=SEU_TOKEN");
            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                is = conexao.getInputStream();
                response = conexao.getResponseCode();
            } else {
                is = conexao.getErrorStream();
                response = conexao.getResponseCode();
            }
            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    private static String converterInputStreamToString(InputStream is) {
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {
                buffer.append(linha);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        try {
            Logradouro oLogradouro = new Logradouro();

            String cep = "40010000";
            String json;
            json = Api.getJSONFromAPI("http://www.cepaberto.com/api/v3/cep?cep=" + cep);

            if (response == 200) {
                JSONObject obj = new JSONObject(json);
                JSONObject obj2 = obj.getJSONObject("cidade");
                JSONObject obj3 = obj.getJSONObject("estado");
                
                //Dados de coordenadas
                if (!obj.isNull("altitude")) {
                    oLogradouro.setAltitude(String.valueOf(obj.getInt("altitude")));
                }
                if (!obj.isNull("latitude")) {
                    oLogradouro.setLatitude(obj.getString("latitude"));
                }
                if (!obj.isNull("longitude")) {
                    oLogradouro.setLongitude(obj.getString("longitude"));
                }

                //Endereço                
                if (!obj.isNull("cep")) {
                    oLogradouro.setCep(obj.getString("cep"));
                }
                if (!obj.isNull("logradouro")) {
                    oLogradouro.setLogradouro(obj.getString("logradouro"));
                }
                if (!obj.isNull("bairro")) {
                    oLogradouro.setBairro(obj.getString("bairro"));
                }

                //Município
                if (!obj2.isNull("ddd")) {
                    oLogradouro.setDdd(String.valueOf(obj2.getInt("ddd")));
                }
                if (!obj2.isNull("ibge")) {
                    oLogradouro.setIbge(obj2.getString("ibge"));
                }
                if (!obj2.isNull("nome")) {
                    oLogradouro.setNomeCidade(obj2.getString("nome"));
                }

                //UF
                if (!obj3.isNull("sigla")) {
                    oLogradouro.setUF(obj3.getString("sigla"));
                }
            }

            System.out.println("Código de Resposta: " + response + "\nDados da consulta: \n" + oLogradouro.toString());
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

}
