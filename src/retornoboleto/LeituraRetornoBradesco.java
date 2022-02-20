/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static retornoboleto.LeituraRetorno.FORMATO_DATA;

/**
 *
 * @author compo
 */
public class LeituraRetornoBradesco implements LeituraRetorno {

    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArquivo) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArquivo[0]));
        boleto.setCodBanco(vetorLinhaArquivo[1]);
        boleto.setAgencia(vetorLinhaArquivo[2]);
        boleto.setContaBancaria(vetorLinhaArquivo[3]);

        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArquivo[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetorLinhaArquivo[5], FORMATO_DATA_HORA));

        boleto.setCpfCliente(vetorLinhaArquivo[6]);
        boleto.setValor(Double.parseDouble(vetorLinhaArquivo[7]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArquivo[8]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArquivo[9]));
        return boleto;
    }
}
