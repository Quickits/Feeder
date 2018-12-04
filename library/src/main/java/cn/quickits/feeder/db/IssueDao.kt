package cn.quickits.feeder.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface IssueDao {

    @Query(value = "SELECT * FROM issue")
    fun getIssues(): List<Issue>

}