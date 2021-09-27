package com.example.dogvievholdercharsequence

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.dogvievholdercharsequence.databinding.DogLayoutBinding

class DogAdapter(var list: MutableList<Dog>): RecyclerView.Adapter<DogViewHolder>(), Filterable {
    var filterList = mutableListOf<Dog>()
    init {
        filterList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = DogLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        var dogViewHolder = DogViewHolder(binding)
        return dogViewHolder
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
      var dog = filterList[position]
        holder.binding.name.text = dog.name
        holder.binding.age.text = dog.age.toString()
        holder.binding.breed.text = dog.breed
    }

    override fun getItemCount(): Int {
      return  filterList.size
    }

    override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val word: String = charSequence.toString()
                if (word.isEmpty()){
                    filterList = list
                } else{
                    var resultList = ArrayList<Dog>()
                    for (dog in list){
                        if (dog.name.toUpperCase().contains(word.toString().toUpperCase())){

                            resultList.add(dog)
                        }
                    }
                    filterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
               filterList = results?.values as MutableList<Dog>
                notifyDataSetChanged()
            }

        }
    }

}