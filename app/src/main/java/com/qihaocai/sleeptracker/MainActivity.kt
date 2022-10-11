package com.qihaocai.sleeptracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


val SleepList : MutableList<SleepEntity> = ArrayList()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val adapter = Adapter(SleepList)

        var itemList = findViewById<RecyclerView>(R.id.itemList)

        val button = findViewById<Button>(R.id.button)


//        lifecycleScope.launch {
//            (application as SleepApplication).db.SleepDao().getAll().collect { databaseList ->
//                databaseList.map { mappedList ->
//
//                    SleepList.addAll(listOf(mappedList))
//                    adapter.notifyDataSetChanged()
//
//
//                }
//            }
//        }

        lifecycleScope.launch {
            (application as SleepApplication).db.SleepDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    SleepEntity(
                        entity.Hours,
                        entity.Date

                    )
                }.also { mappedList ->
                    SleepList.clear()
                    SleepList.addAll(mappedList)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        itemList.adapter = adapter



        itemList.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            itemList.addItemDecoration(dividerItemDecoration)
        }

        button.setOnClickListener{
            intent = Intent(this, AddSleep::class.java)
            startActivity(intent)
        }


//        itemList.adapter = adapter
//        itemList.layoutManager = LinearLayoutManager(this)

    }

//    override fun onDestroy() {
//        super.onDestroy()
//        lifecycleScope.launch(Dispatchers.IO) {
//            (application as SleepApplication).db.SleepDao().deleteAll()
//            (application as SleepApplication).db.SleepDao().insertAll(
//                List.map {
//                SleepEntity(
//
//                )
//                }
//            )
//        }
//
//    }



//    override fun onResume() {
//        super.onResume()
//
//        var itemList = findViewById<RecyclerView>(R.id.itemList)
//
//        var Adapter = Adapter(this, SleepList)
//
//        lifecycleScope.launch {
//            (application as SleepApplication).db.articleDao().getAll().collect { databaseList ->
//                databaseList.map { entity ->
//                    DisplaySleep(
//                        entity.Hours,
//                        entity.Date
//                    )
//                }.also { mappedList ->
//                    SleepList.clear()
//                    SleepList.addAll(mappedList)
//                    Adapter.notifyDataSetChanged()
//                }
//            }
//        }
//
//        itemList.adapter = Adapter
//        itemList.layoutManager = LinearLayoutManager(this)
//    }

}

