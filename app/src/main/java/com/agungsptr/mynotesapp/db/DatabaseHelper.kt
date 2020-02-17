package com.agungsptr.mynotesapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.agungsptr.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DATE
import com.agungsptr.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DESCRIPTION
import com.agungsptr.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import com.agungsptr.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TITLE
import com.agungsptr.mynotesapp.db.DatabaseContract.NoteColumns.Companion._ID

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbnoteapp"
        private const val DATABASE_VERSION = 1
        private val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                " ($_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $TITLE TEXT NOT NULL," +
                " $DESCRIPTION TEXT NOT NULL," +
                " $DATE TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE_NOTE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
