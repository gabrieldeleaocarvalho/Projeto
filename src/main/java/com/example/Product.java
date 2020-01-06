package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String console;
    private double valor;
    private int jogos;
    private int controles;

    protected Product() {}
    public Product(String console, 
    double valor, int jogos, int controles) {
        this.console = console;
        this.valor = valor;
        this.jogos = jogos;
        this.controles = controles;
    }
    
    /**
     * @return the console
     */
    public String getConsole() {
        return this.console;
    }
    /**
     * @param console the console to set
     */
    public void setConsole(String console) {
        this.console = console;
    }

    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getJogos() {
        return this.jogos;
    }
    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getControles(){
        return this.controles;
    }
    public void setControle(int controles){
        this.controles = controles;
    }
}