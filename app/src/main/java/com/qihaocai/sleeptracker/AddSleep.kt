package com.qihaocai.sleeptracker

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var List : MutableList<ItemTemp> = ArrayList()
class AddSleep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addsleep_layout)


        val button = findViewById<Button>(R.id.button)


        var hourss = findViewById<TextView>(R.id.Hours)
        var dates = findViewById<TextView>(R.id.Date)
        var dateET = findViewById<EditText>(R.id.DateET)
        var hoursET = findViewById<EditText>(R.id.HoursET)



        button.setOnClickListener {
            //val hidekeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

//            hidekeyboard.hideSoftInputFromWindow(button.getWindowToken(), 0)

            var hours = hoursET.text
            var date = dateET.text

            var newitem = ItemTemp(hours.toString(), date.toString())

            dateET.setText("")
            hoursET.setText("")


            List.add(newitem)

            lifecycleScope.launch(Dispatchers.IO) {
                //(application as SleepApplication).db.SleepDao().deleteAll()
                (application as SleepApplication).db.SleepDao().insert(
                    //List.map {
                    SleepEntity(
                        Hours = hours.toString(),
                        Date = date.toString()
                    )
            //}
                )
            }
            finish();
        }
    }
}
