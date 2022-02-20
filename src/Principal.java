
import retornoboleto.LeituraRetornoBancoBrasil;
import retornoboleto.LeituraRetornoBradesco;
import retornoboleto.ProcessarBoletos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author compo
 */
public class Principal {

    public static void main(String[] args) {
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());

        String nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");

        processador.processar(nomeArquivo);

        nomeArquivo = Principal.class.getResource("bradesco-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");
        
        processador.setLeituraRetorno(new LeituraRetornoBradesco());
        processador.processar(nomeArquivo);

    }
}
