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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author compo
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArquivo) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArquivo[0]));
        boleto.setCodBanco(vetorLinhaArquivo[1]);

        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArquivo[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArquivo[3], FORMATO_DATA).atTime(0, 0, 0));

        boleto.setCpfCliente(vetorLinhaArquivo[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArquivo[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArquivo[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArquivo[7]));
        return boleto;
    }
}
