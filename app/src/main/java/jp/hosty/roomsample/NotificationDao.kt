package jp.hosty.roomsample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by ijichiyoshihito on 2019-07-01.
 */
@Dao
interface NotificationDao {

    // アイテム追加
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(state: NotificationState)

    // 複数のアイテム追加
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(states: List<NotificationState>)

    // idを指定して取得
    @Query("SELECT * FROM notification WHERE id = :id LIMIT 1")
    fun select(id: String): NotificationState

    // 最後のid取得
    @Query("SELECT id FROM notification ORDER BY id DESC LIMIT 1")
    fun selectLastId(): Int

    // 全てのアイテム取得
    @Query("SELECT * FROM notification")
    fun selectAll(): List<NotificationState>

    // 全てのアイテム取得 LiveData
    @Query("SELECT * FROM notification")
    fun selectAllWithLiveData(): LiveData<List<NotificationState>>

    // データを全て削除
    @Query("DELETE FROM notification")
    fun deleteAll()
}
