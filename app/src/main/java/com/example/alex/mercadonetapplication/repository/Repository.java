package com.example.alex.mercadonetapplication.repository;


import android.content.Context;


public class Repository {
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    //private CategoriaRepository categoriaRepository;

    public Repository(Context context){
        clienteRepository = new ClienteRepository(context);


    }

    public ClienteRepository getClienteRepository(){
        return clienteRepository;
    }

    public ProdutoRepository getProdutoRepository(){
        return produtoRepository;
    }



}
