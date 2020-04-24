package jp.hosty.roomsample

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by ijichiyoshihito on 2019-07-01.
 */
class NotificationTypeConverter {

    @TypeConverter
    fun fromNotificationType(value: NotificationType): String {
        return value.name.toLowerCase(Locale.ENGLISH)
    }

    @TypeConverter
    fun toNotificationType(value: String): NotificationType {
        return NotificationType.fromName(value)
    }
}
