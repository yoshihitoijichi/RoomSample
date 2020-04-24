package jp.hosty.roomsample

import androidx.annotation.DrawableRes
import java.util.*

/**
 * Created by ijichiyoshihito on 2020-04-24.
 */
enum class NotificationType(val title: String) {
    GOOD("いいね"),
    ADMIN("運営");

    companion object {
        fun fromName(lowerName: String): NotificationType {
            return values().firstOrNull { it.name.toLowerCase(Locale.ENGLISH) == lowerName } ?: GOOD
        }
    }
}
