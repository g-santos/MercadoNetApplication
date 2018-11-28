package com.example.alex.mercadonetapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.alex.mercadonetapplication.R;
import com.example.alex.mercadonetapplication.model.Produto;
import com.example.alex.mercadonetapplication.repository.ProdutoRepository;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class CategoriaActivity extends Activity {
    private ListView listCategoria;
    private EditText editNome;
    private ProdutoRepository repository = new ProdutoRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        listCategoria = findViewById(R.id.listCategoria);
        ArrayList<String> produtos = getIntent().getStringArrayListExtra("Produtos");
        listCategoria.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produtos));
    }

}
