package com.gb.dictionary.model.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModelImages(

    @Expose
    val imageUrl: String? = null
) : Parcelable