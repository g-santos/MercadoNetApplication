package com.example.alex.mercadonetapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alex.mercadonetapplication.R;
import com.example.alex.mercadonetapplication.model.Cliente;
import com.example.alex.mercadonetapplication.repository.ClienteRepository;
import com.facebook.stetho.Stetho;

public class MainActivity extends Activity {

    private EditText editEmail;
    private EditText editSenha;
    private ClienteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        repository = new ClienteRepository(this);
    }

    public void login(View v) {

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        if (email.isEmpty() && senha.isEmpty()) {
            Toast.makeText(this, "LOGIN INVÁLIDO", Toast.LENGTH_SHORT).show();
        } else {
            Cliente client = repository.loadClienteByPassword(email, senha);
            if (client != null) {
                ClienteRepository.cliente = client;
                callIndexActivity();
            } else {
                Toast.makeText(this, "LOGIN INVÁLIDO", Toast.LENGTH_SHORT).show();
            }

        }


    }

    public void cadastrar(View v) {
        Intent cadastrarActivity = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(cadastrarActivity);
        finish();
    }

    public void callIndexActivity() {
        Intent indexActivity = new Intent(MainActivity.this, IndexActivity.class);
        startActivity(indexActivity);
        finish();
    }
}
