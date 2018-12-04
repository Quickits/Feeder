package cn.quickits.feeder.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Issue::class], version = 1, exportSchema = false)
abstract class FeederDataBase : RoomDatabase() {

    abstract fun issueDao(): IssueDao

    companion object {
        @Volatile
        private var instance: FeederDataBase? = null

        fun getInstance(context: Context): FeederDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): FeederDataBase {
            return Room.databaseBuilder(context, FeederDataBase::class.java, "Feeder").build()
        }
    }

}