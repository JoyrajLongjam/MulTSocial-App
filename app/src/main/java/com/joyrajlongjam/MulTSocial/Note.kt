package com.joyrajlongjam.MulTSocial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name="text")val Text:String)
         {
    @PrimaryKey(autoGenerate = true)var id=0
}