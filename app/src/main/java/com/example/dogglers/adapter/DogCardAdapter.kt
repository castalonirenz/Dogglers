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
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource

    private val myDataset = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {

        var dogName: TextView? = view!!.findViewById(R.id.dogname)
        var dogAge: TextView? = view!!.findViewById(R.id.age)
        var dogImage: ImageView? = view!!.findViewById(R.id.dog_image)
        var dogHobby: TextView? = view!!.findViewById(R.id.hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {


        //  Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val adapterLayout = when (layout) {
            // Inflate the layout
            GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }

        //  Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)



        return DogCardViewHolder(adapterLayout)





    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int)  {

        val resources = context?.resources


        val dogData = myDataset[position]
        // Set the image resource for the current dog
        holder.dogImage?.setImageResource(dogData.imageResourceId)
        // Set the text for the current dog's name
        holder.dogName?.text = dogData.name
        // Set the text for the current dog's age
        holder.dogAge?.text = resources?.getString(R.string.dog_age, dogData.age)
        // Set the text for the current dog's hobbies by passing the hobbies to the
        // R.string.dog_hobbies string constant.
        // Passing an argument to the string resource looks like:
        // resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dogHobby?.text = resources?.getString(R.string.dog_hobbies, dogData.hobbies)


    }
}


