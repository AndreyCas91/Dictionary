package com.gb.dictionary.model.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel (
    @Expose
    val text: String
): Parcelable