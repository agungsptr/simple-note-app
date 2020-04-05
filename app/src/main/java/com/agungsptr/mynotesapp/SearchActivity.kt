package com.agungsptr.mynotesapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.agungsptr.mynotesapp.db.DatabaseContract
import com.agungsptr.mynotesapp.db.NoteHelper
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var noteHelper: NoteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        supportActionBar?.title = "Notes"

        noteHelper = NoteHelper.getInstance(applicationContext)
        noteHelper.open()


        btn_Search.setOnClickListener {
            val q = edt_search.text.toString().trim()
            tv_search.text = search(q)
        }

    }

    private fun search(q: String): String {
        val cursor = noteHelper.queryById(q)
        cursor.moveToFirst()

        val id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
        val title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
        val desc = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
        val date = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))

        return "id: $id | title: $title | desc: $desc | date: $date"
    }

    override fun onDestroy() {
        super.onDestroy()
        noteHelper.close()
    }
}
