package com.example.alex.mercadonetapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.mercadonetapplication.DAO.ClienteDAO;
import com.example.alex.mercadonetapplication.R;
import com.example.alex.mercadonetapplication.model.Cliente;
import com.example.alex.mercadonetapplication.repository.ClienteRepository;

public class PerfilActivity extends Activity {

    private TextView clientId;
    private EditText editNome;
    private EditText editDtaNascimento;
    private EditText editEmail;
    private EditText editSenha;
    private Cliente cliente;
    private ClienteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editNome = findViewById(R.id.editNome);
        editDtaNascimento = findViewById(R.id.editDtaNascimento);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

        repository = new ClienteRepository(this);
        carregarCliente();

    }

    public void carregarCliente (){

        Cliente client = ClienteRepository.cliente;
        editEmail.setText(client.getEmail());
        editNome.setText(client.getNome());
        editDtaNascimento.setText(client.getDtaNasc());
        editSenha.setText(client.getSenha());
    }
    public void alterarCadastro(View v){
        cliente = new Cliente();
        cliente.setId(ClienteRepository.cliente.getId());
        cliente.setNome(editNome.getText().toString());
        cliente.setDtaNasc(editDtaNascimento.getText().toString());
        cliente.setEmail(editEmail.getText().toString());
        cliente.setSenha(editSenha.getText().toString());
        repository.update(cliente);

        callMainActivity();

    }

        public void voltar(View v){


        callMainActivity();

    }

    public void callMainActivity (){
        Intent mainActivity = new Intent(PerfilActivity.this,MainActivity.class).putExtra("cliente", cliente);;
        startActivity(mainActivity);
        finish();
    }




}

