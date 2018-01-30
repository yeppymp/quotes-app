package com.yeppymp.quotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.*
import java.io.IOException
import okhttp3.OkHttpClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.quote.*
import android.content.Context
import android.view.*
import android.widget.AdapterView
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.*
import java.net.URL
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private var adapter: Any = ""
    private var love: Boolean = false
    private var id: Int = 0
    private val arrayOfQuotes = ArrayList<Quote>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter =  QuotesAdapter<Any>(this, arrayOfQuotes)
        // Attach the adapter to a ListView
        val listView = lvItems as ListView
        listView.adapter = adapter as QuotesAdapter<Any?>

        //move activity
        lvItems.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(adapter: AdapterView<*>?, v: View?, position: Int, p3: Long) {
                val item = adapter?.getItemAtPosition(position)
                println(item)

//                val intent = Intent(this@MainActivity, destinationActivity::class.java)
                //based on item add info to intent
//                startActivity(intent)
            }
        }
    }

    fun btnLove(view: View, position: Int) {
        val list = lvItems.getItemAtPosition(position) as String
        println(list)
        love = if (love) {
            btnLove.setImageResource(R.drawable.ic_favorite_border_black_24dp)
            false
        }
        else {
            btnLove.setImageResource(R.drawable.ic_favorite_red_24dp)
            true
        }
    }

    inner class QuotesAdapter<T>(context: Context, quotes: ArrayList<Quote>) : ArrayAdapter<Quote>(context, 0, quotes) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertViewVar = convertView

            val quote = getItem(position)
            if (convertViewVar == null) {
                convertViewVar = LayoutInflater.from(context).inflate(R.layout.quote, parent, false)
            }
            // Lookup view for data population
            val textQuote = convertViewVar!!.findViewById<View>(R.id.textQuote) as TextView
            val author = convertViewVar.findViewById<View>(R.id.author) as TextView
            // Populate the data into the template view using the data object
            textQuote.text = quote!!.quote
            author.text = quote.author
            // Return the completed view to render on screen
            return convertViewVar
        }
    }

    fun addQuote(view: View) {
        val url = URL("http://api.forismatic.com/api/1.0/?method=getQuote&key=457653&format=json&lang=en")
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Something wrong", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                val json = JSONObject(data)
                val newQuote = Quote(id++, json.get("quoteText") as String, json.get("quoteAuthor") as String)
                runOnUiThread {
                    (adapter as QuotesAdapter<Any?>).add(newQuote)
                }
            }
        })
    }
}
