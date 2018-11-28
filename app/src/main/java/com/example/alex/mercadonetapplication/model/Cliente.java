package com.example.alex.mercadonetapplication.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@Entity(tableName = "cliente_table")
public class Cliente implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;
    private String nome;
    private String dtaNasc;
    private String email;
    private String senha;

    public Cliente(String nome, String dtaNasc, String email, String senha) {
        this.nome = nome;
        this.dtaNasc = dtaNasc;
        this.email = email;
        this.senha = senha;
    }
    public Cliente() {}


    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public String getNome() {return nome;}
    public void setNome (String nome){this.nome=nome;}

    public String getDtaNasc() {return dtaNasc;}
    public void setDtaNasc (String dtaNasc){this.dtaNasc=dtaNasc;}

    public String getEmail() {return email;}
    public void setEmail (String email){this.email=email;}

    public String getSenha() {return senha;}
    public void setSenha (String senha){this.senha=senha;}

    public long getId() {return id;}
    public void setId (long id){this.id=id;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nome);
        dest.writeString(dtaNasc);
        dest.writeString(email);
        dest.writeString(senha);
    }


    protected Cliente(Parcel in) {
        id = in.readLong();
        nome = in.readString();
        dtaNasc = in.readString();
        email = in.readString();
        senha = in.readString();
    }
}