package cn.quickits.feeder.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Issue(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "app_version") var appVersion: String,
    @ColumnInfo(name = "data") var data: String
)
