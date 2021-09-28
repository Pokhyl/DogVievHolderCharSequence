package com.example.dogvievholdercharsequence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogvievholdercharsequence.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
 lateinit var list: MutableList<Dog>
 lateinit var binding: ActivityMainBinding
 @Inject lateinit var foo: Foo
    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyAplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println( "!!!!!!!!$foo")
//        list = mutableListOf<Dog>(
//            Dog("Eva", 4, "york"),
//            Dog("sky", 4, "york"),
//            Dog("Barbor", 4, "york"),
//            Dog("Vasy", 4, "york"),
//            Dog("tjjkghg", 4, "york"),
//            Dog("Dog", 4, "york"),
//            Dog("Misha", 4, "york"),
//            Dog("Fruzy", 4, "york"),
//            Dog("Druzhok", 4, "york"),
//            Dog("Sarik", 4, "york"),
//            Dog("Bobik", 4, "york"),
//            Dog("ZhuZhik", 4, "york"),)
        list = foo.getDogList()
        var adapter = DogAdapter(list)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter?.filter?.filter(p0)
                return true
            }
        })
        binding.recyclerViev.adapter = adapter
        binding.recyclerViev.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}