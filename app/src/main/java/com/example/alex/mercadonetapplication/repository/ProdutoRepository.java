package com.example.alex.mercadonetapplication.repository;

import com.example.alex.mercadonetapplication.model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 27/11/2018.
 */

public class ProdutoRepository {

    List<Produto> produtos = new ArrayList<>();

    public ProdutoRepository() {
        produtos.add(new Produto("CAFE", "8.00", "KG", "mercearia"));
        produtos.add(new Produto("ACUCAR", "8.00", "KG", "mercearia"));
        produtos.add(new Produto("TRIGO", "8.00", "KG", "mercearia"));
        produtos.add(new Produto("ASA", "15.00", "KG", "acougue"));
        produtos.add(new Produto("FILE", "20.00", "KG", "acougue"));
        produtos.add(new Produto("BISTECA", "10.00", "KG", "acougue"));
        produtos.add(new Produto("PAO", "7.00", "PACOTE", "panificadora"));
        produtos.add(new Produto("BOLO", "8.00", "KG", "panificadora"));
        produtos.add(new Produto("SALGADO", "5.00", "UNIDADE", "panificadora"));
    }

   public Produto getProdutoByName(String nome){
        nome = nome.toUpperCase();
        for(Produto p : produtos){
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
   }

   public ArrayList<Produto> getProdutosByCategoria(String categoria){
       ArrayList<Produto> produtosCategoria = new ArrayList<Produto>();
       for(Produto p : produtos){
           if(p.getCategoria().equals(categoria)) {
               produtosCategoria.add(p);
           }
       }
       return produtosCategoria;
   }

}
