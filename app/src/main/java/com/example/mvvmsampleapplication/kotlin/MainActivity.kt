package com.example.mvvmsampleapplication.kotlin
// Reference is taken by http://www.kotlincodes.com/kotlin/retrofit-with-kotlin/
import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsampleapplication.R
import com.example.mvvmsampleapplication.java.User
import java.util.*

class MainActivity : AppCompatActivity(), LifecycleOwner {
    lateinit var context: MainActivity
    lateinit var recylerView : RecyclerView;
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainViewModel
    lateinit var progressBar:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context=this;
        recylerView=findViewById(R.id.rv_main)
        progressBar= ProgressDialog(this)
        progressBar.setTitle("Loading..")
        progressBar.show()
        viewModel = ViewModelProviders.of(context).get(MainViewModel::class.java)
        viewModel.getResults().observe(context, userListUpdateObserver)

    }

    var userListUpdateObserver: Observer<ArrayList<DataModel>> = Observer<ArrayList<DataModel>> { userArrayList ->
        recyclerViewAdapter = RecyclerViewAdapter(context, userArrayList)
        recylerView.setLayoutManager(LinearLayoutManager(context))
        recylerView.setAdapter(recyclerViewAdapter)
        recylerView.adapter?.notifyDataSetChanged()
        progressBar.dismiss()
    }
}
