package com.example.alex.mercadonetapplication.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.alex.mercadonetapplication.DAO.ClienteDAO;
import com.example.alex.mercadonetapplication.database.ClienteRoomDatabase;
import com.example.alex.mercadonetapplication.model.Cliente;

public class ClienteRepository {
    private ClienteDAO mClienteDAO;
    public  static Cliente cliente;

    public ClienteRepository(Context context){
        ClienteRoomDatabase db = ClienteRoomDatabase.getDatabase(context);
        mClienteDAO = db.clienteDAO();
  
    }

    public Cliente clientePorEmail(String email){
        return mClienteDAO.loadClienteByEmail(email);
    }

    public void insert(Cliente cliente){
        new insertAsyncTask(mClienteDAO).execute(cliente);
    }

    public void update(Cliente cliente){
        new updateAsyncTask(mClienteDAO).execute(cliente);
    }

    public Cliente loadClienteByEmail (String email){
        return mClienteDAO.loadClienteByEmail(email);
    }


    public Cliente loadClienteByPassword (String email, String senha){
        return mClienteDAO.loadClienteByPassword(email, senha);
    }

    private static class insertAsyncTask extends AsyncTask<Cliente,Void, Void> {
        private ClienteDAO mAsyncTaskDAO;
        insertAsyncTask(ClienteDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Cliente...params) {
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<Cliente,Void, Void> {
        private ClienteDAO mAsyncTaskDAO;
        updateAsyncTask(ClienteDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Cliente...params) {
            mAsyncTaskDAO.update(params[0]);
            return null;
        }
    }
}
