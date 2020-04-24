package jp.hosty.roomsample

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [NotificationState::class],
    version = 1
)
@TypeConverters(value = [NotificationTypeConverter::class])
abstract class RoomSampleDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao

}
