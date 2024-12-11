package model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private String dia = "A";
    private int id;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String plano;
    private String nivel;
    private String cpf;
    private String treino;

    public Aluno(String nome, int idade, double peso, double altura, String plano, String nivel, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.nivel = nivel;
        this.cpf = cpf;
        this.treino = new TreinoAplicado(nivel).treinoDoDia();
    }

    public Aluno(int id, String nome, int idade, double peso, double altura, String plano, String nivel, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.nivel = nivel;
        this.cpf = cpf;
        this.treino = new TreinoAplicado(nivel).treinoDoDia();
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTreino() {
        return this.treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
