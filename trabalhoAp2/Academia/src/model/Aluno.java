package model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String plano;
    private String cpf;

    public Aluno(String nome, int idade, double peso, double altura, String plano, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.cpf = cpf;
    }

    public Aluno(int id, String nome, int idade, double peso, double altura, String plano, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.cpf = cpf;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPlano(){
        return plano;
    }

    public void setPlano(String plano){
        this.plano = plano;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
