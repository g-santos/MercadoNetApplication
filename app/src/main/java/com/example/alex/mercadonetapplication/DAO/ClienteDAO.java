package com.example.alex.mercadonetapplication.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alex.mercadonetapplication.model.Cliente;

@Dao
public interface ClienteDAO {

    @Insert
    void insert(Cliente cliente);

    @Update
    void update(Cliente cliente);

    @Query("SELECT * FROM cliente_table WHERE cliente_table.email == :email")
    Cliente loadClienteByEmail(String email);

    @Query("SELECT * FROM cliente_table WHERE cliente_table.email == :email and cliente_table.senha == :senha")
    Cliente loadClienteByPassword(String email, String senha);

    @Query("DELETE FROM cliente_table where cliente_table.senha == :senha")
    void delete(String senha);
}
