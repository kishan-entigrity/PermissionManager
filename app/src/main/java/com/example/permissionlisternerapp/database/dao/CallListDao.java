package com.example.permissionlisternerapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.permissionlisternerapp.database.entity.CallListEntity;

import java.util.List;

@Dao
public interface CallListDao {

    // Query for getting all records from the CallListDao..
    @Query("SELECT * from callListEntity")
    List<CallListEntity> getCallList();

    // Query for the getting records for the only specific number..
    @Query("SELECT * from callListEntity where number=:number")
    CallListEntity checkSpecificNumber(String number);

    // Insert query for the inserting records for the incoming/outgoing/missedcalls
    @Insert
    void insertCallList(CallListEntity listEntity);

}
