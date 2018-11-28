package com.example.alex.mercadonetapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.alex.mercadonetapplication.R;
import com.example.alex.mercadonetapplication.model.Cliente;
import com.example.alex.mercadonetapplication.repository.ClienteRepository;

public class CadastroActivity extends Activity {

    private EditText editNome;
    private EditText editDtaNascimento;
    private EditText editEmail;
    private EditText editSenha;
    private ClienteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNome);
        editDtaNascimento = findViewById(R.id.editDtaNascimento);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

    }
    public void salvarCadastro(View v){
        repository = new ClienteRepository(this);
        String email = editEmail.getText().toString();
        String nome = editNome.getText().toString();
        String dataNasc = editDtaNascimento.getText().toString();
        String senha = editSenha.getText().toString();
        Cliente cliente  = new Cliente();

        cliente.setNome(nome);
        cliente.setDtaNasc(dataNasc);
        cliente.setEmail(email);
        cliente.setSenha(senha);
       repository.insert(cliente);

        callMainActivity();
    }

    public void callMainActivity (){
        Intent mainActivity = new Intent(CadastroActivity.this,MainActivity.class);
        startActivity(mainActivity);
    }

}

