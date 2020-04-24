package jp.hosty.roomsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(
                this, RoomSampleDatabase::class.java, "room_sample_database.db")
                .fallbackToDestructiveMigration()
                .build()
        val notificationDao = database.notificationDao()

        main_add_button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) { // 非同期処理
                val lastId = notificationDao.selectLastId()
                val state = NotificationState(lastId + 1, NotificationType.GOOD, "いいねをもらいました")
                notificationDao.insert(state)

                GlobalScope.launch(Dispatchers.Main) {  // main thread
                    Toast.makeText(this@MainActivity, "データ追加しました", Toast.LENGTH_SHORT).show()
                }
            }
        }

        main_display_button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) { // 非同期処理
                val states = notificationDao.selectAll()
                GlobalScope.launch(Dispatchers.Main) {  // main thread
                    main_text.text = states.toString()
                }
            }

            // LiveDataだとデータに変更があった場合即時反映される
//            notificationDao.selectAllWithLiveData().observe(this, Observer {
//                main_text.text = it.toString()
//            })
        }
    }
}

