package com.cis436.project4

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLiteHelper(context : Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    var context : Context? = null

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ${TABLE_NAME}(" +
                "$ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$QUOTE TEXT," +
                "$AUTHOR TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    fun addQuote(quote : String, author : String) {
        val db = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(QUOTE, quote)
        contentValues.put(AUTHOR, author)

        db.insert(TABLE_NAME, null, contentValues)

        Log.i("Database", "Quote added from $author")
    }

    companion object {
        private const val DATABASE_NAME = "SavedQuotes.db"
        private const val TABLE_NAME = "Quotes"
        private const val ID = "ID"
        private const val QUOTE = "Quote"
        private const val AUTHOR = "Author"
    }
}