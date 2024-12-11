package controller;

import java.net.URL;
import java.util.ResourceBundle;
import model.Aluno;


public class FichaController extends TelaRespostaController {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Ini");
    }

    public String toString(Aluno aluno) {
        return(
            "Nome: " + aluno.getNome() +
            "\nIdade: " + aluno.getIdade() + " anos" +
            "\nPeso: " + aluno.getPeso() + "kg" +
            "\nAltura: " + aluno.getAltura() + "cm" +
            "\nPlano: " + aluno.getPlano() +
            "\nNível: " + aluno.getNivel() +
            "\nCPF: " + aluno.getCpf()
        );
    }
}
