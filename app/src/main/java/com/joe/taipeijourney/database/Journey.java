package com.joe.taipeijourney.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * author: Joe Cheng
 */
@Entity
public class Journey {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    String id;

    @NonNull
    @ColumnInfo(name = "remark")
    String remark;

    public Journey(String id, @NonNull String remark)
    {
        this.id = id;
        this.remark = remark;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getRemark() {
        return remark;
    }
}
