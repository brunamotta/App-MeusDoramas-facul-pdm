package com.example.meusdoramas;

public class Dorama {
    //Definição dos atributos da classe
    private long id;
    private String titulo;
    private float nota;
    private int ano;
    private String pais;
    private int numEpisodios;

    //Métodos getters e setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumEpisodios() {
        return numEpisodios;
    }
    public void setNumEpisodios(int numEpisodios) {
        this.numEpisodios = numEpisodios;
    }

    //Método constructor com definição dos valores-padrão
    public Dorama() {
        titulo = "";
        nota = 0;
        ano = 0;
        pais = "";
        numEpisodios = 0;
    }

    //Método de formatação dos dados para exibir na lista
    public String textoLista() {
        String item;
        item = getTitulo();
        item += "\t\t|\t\tNota: " + String.format("%.1f", getNota());
        item += "\nAno: " + getAno();
        item += " \t\t " + getPais();
        item += " \t\t " + getNumEpisodios() + " Episódios";
        return item;
    }
}
