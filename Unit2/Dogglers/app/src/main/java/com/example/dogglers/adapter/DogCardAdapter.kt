/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int,
    private val dataset: List<Dog>
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dogglerImageView : ImageView = view.findViewById(R.id.doggler_image)
        val dogglerNameTextView : TextView = view.findViewById(R.id.doggler_name)
        val dogglerAgeTextView : TextView = view.findViewById(R.id.doggler_age)
        val dogglerHobbieTextView : TextView = view.findViewById(R.id.doggler_hobbie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        var layoutID = 0

        //Conditional deviation in order to track if its GRID or VERICAL/HORIZONTAL layout
        when(layout){
            GRID -> layoutID = R.layout.grid_list_item
            else -> layoutID = R.layout.vertical_horizontal_list_item
        }

        //create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(layoutID, parent, false)

        //return view inside of the ViewHolder
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val item = dataset[position]
        // TODO: Set the image resource for the current dog
        holder.dogglerImageView.setImageResource(item.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.dogglerNameTextView.text = item.name
        // TODO: Set the text for the current dog's age
        holder.dogglerAgeTextView.text = "Age: " + item.age
        val resources = context?.resources
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)

    }
}
