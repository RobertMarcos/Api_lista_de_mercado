package com.example.lista_mecados.models;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Lista_de_produtos")
public class lista_model implements Serializable {
    
    private  static final long  serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private UUID produto_id;

    private String nome;

    private int quantidade;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date data = new Date();

    
    
    
    public void setIdProduto(UUID produto_id){
        this.produto_id = produto_id;

    }
    
    public UUID getIdProduto(){
        return produto_id;
    }



        public void setQuantidade(int quantidade){
        this.quantidade = quantidade;

    }
    
    public int getQuantidade(){
        return quantidade;
    }


       public void setNome(String nome){
        this.nome = nome;

    }
    
    public String getNome(){
        return nome;
    }

 public void setDate(Date data){
        this.data = data;

    }
    
    public Date getDate(){
        return data;
    }


}
