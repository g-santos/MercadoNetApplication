package com.example.alex.mercadonetapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.alex.mercadonetapplication.DAO.ClienteDAO;
import com.example.alex.mercadonetapplication.model.Cliente;

@Database(entities = {Cliente.class},version = 1)
public abstract class ClienteRoomDatabase extends RoomDatabase {
    private static volatile ClienteRoomDatabase INSTANCE;
    public abstract ClienteDAO clienteDAO();

    public static ClienteRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (ClienteRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ClienteRoomDatabase.class,"cliente_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
