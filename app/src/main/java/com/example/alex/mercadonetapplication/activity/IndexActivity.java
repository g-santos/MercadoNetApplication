package com.example.alex.mercadonetapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.alex.mercadonetapplication.R;
import com.example.alex.mercadonetapplication.model.Produto;
import com.example.alex.mercadonetapplication.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends Activity {

    private EditText editNome;
    private ProdutoRepository repository = new ProdutoRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        repository = new ProdutoRepository();
    }

    public void buscarProduto(View v) {
        editNome = findViewById(R.id.editProduto);
        String nome = editNome.getText().toString();
        Produto produto = repository.getProdutoByName(nome);
        if(produto!=null){
            callProdutoActivity(produto);
        }

    }

    public void buscarPanificadora(View c) {
        ArrayList<Produto> produtoCategoria = repository.getProdutosByCategoria("panificadora");
        callCategoriaActivity(produtoCategoria);
    }

    public void buscarAcougue(View c) {
        ArrayList<Produto> produtoCategoria = repository.getProdutosByCategoria("acougue");
        callCategoriaActivity(produtoCategoria);
    }

    public void buscarMercearia(View c) {
        ArrayList<Produto> produtoCategoria = repository.getProdutosByCategoria("mercearia");
        callCategoriaActivity(produtoCategoria);

    }

    public void callCategoriaActivity(ArrayList<Produto> produtoCategoria) {
        //Converter list produtoCategoria em String (Pq eu não fiz adapter)
        ArrayList<String> produtos = new ArrayList<String>();
        for(Produto p : produtoCategoria){
            produtos.add(p.getNome()+"\t\t\tR$ "+p.getPreco());
        }
        Intent categoriaActivity = new Intent(IndexActivity.this, CategoriaActivity.class).putStringArrayListExtra("Produtos", produtos );
        startActivity(categoriaActivity);
    }

    public void callPerfilActivity() {
        Intent perfilActivity = new Intent(IndexActivity.this, PerfilActivity.class);
        startActivity(perfilActivity);
        finish();
    }

    public void callProdutoActivity(Produto produto) {
        Intent produtoActivity = new Intent(this, ProdutoActivity.class).putExtra("Produto", produto);
        startActivity(produtoActivity);
    }

}
