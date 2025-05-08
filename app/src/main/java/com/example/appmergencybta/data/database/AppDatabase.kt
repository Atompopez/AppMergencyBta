package com.example.appmergencybta.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appmergencybta.data.database.dao.TypificationCodeDao
import com.example.appmergencybta.data.database.dao.UserCodeProgressDao
import com.example.appmergencybta.data.database.entities.TypificationCode
import com.example.appmergencybta.data.database.entities.UserCodeProgress

/**
 * Base de datos principal de la aplicación
 */
@Database(
    entities = [TypificationCode::class, UserCodeProgress::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun typificationCodeDao(): TypificationCodeDao
    abstract fun userCodeProgressDao(): UserCodeProgressDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appmergency_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
