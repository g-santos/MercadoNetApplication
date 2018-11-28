package com.example.alex.mercadonetapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alex.mercadonetapplication.R;
import com.example.alex.mercadonetapplication.model.Produto;

public class ProdutoActivity extends Activity {
    private TextView produtoNome;
    private TextView produtoPreco;
    private TextView produtoUnindade;
    private TextView produtoCategoria;
    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        produtoNome = findViewById(R.id.produtoNome);
        produtoPreco = findViewById(R.id.produtoPreco);
        produtoUnindade = findViewById(R.id.produtoUnidade);
        produtoCategoria = findViewById(R.id.produtoCategoria);

        produto =  getIntent().getExtras().getParcelable("Produto");
        produtoNome.setText(produto.getNome());
        produtoPreco.setText("R$ "+produto.getPreco());
        produtoUnindade.setText(produto.getUnidade());
        produtoCategoria.setText(produto.getCategoria());

    }
}
