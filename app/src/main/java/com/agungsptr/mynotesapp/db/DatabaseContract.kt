package com.agungsptr.mynotesapp.db

import android.net.Uri
import android.provider.BaseColumns
import android.service.notification.Condition.SCHEME

internal class DatabaseContract {

    companion object{
        const val AUTHORITY = "com.dicoding.picodiploma.mynotesapp"
        const val SCHEME = "content"
    }

    internal class NoteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "note"
            const val _ID = "_id"
            const val TITLE = "title"
            const val DESCRIPTION = "description"
            const val DATE = "date"

            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}