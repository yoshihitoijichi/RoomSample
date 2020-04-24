package jp.hosty.roomsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters

/**
 * Created by ijichiyoshihito on 2020-04-24.
 */
@Entity(
    tableName = "notification",
    primaryKeys = ["id"]
)
data class NotificationState(
    @ColumnInfo(name = "id") val id: Int = 0,
    @TypeConverters(NotificationTypeConverter::class)
    @ColumnInfo(name = "type") val type: NotificationType,
    @ColumnInfo(name = "message") val message: String
)
