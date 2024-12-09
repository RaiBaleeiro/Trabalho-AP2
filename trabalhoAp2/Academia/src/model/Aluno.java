package model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String objetivo;

    public Aluno(String nome, int idade, double peso, double altura, String objetivo) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    // Getters e Setters

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public double getPeso(){
        return peso;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }

    public double getAltura(){
        return altura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public String getObjetivo(){
        return objetivo;
    }

    public void setObjetivo(String objetivo){
        this.objetivo = objetivo;
    }
}
