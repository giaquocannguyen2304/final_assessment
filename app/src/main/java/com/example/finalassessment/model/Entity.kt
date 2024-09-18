package com.example.finalassessment.model
import kotlinx.parcelize.Parcelize
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler

@Parcelize
data class Entity(
    val courseCode: String,
    val courseName: String,
    val credits: Int,
    val description: String,
    val instructor: String
)  : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    companion object : Parceler<Entity> {

        override fun Entity.write(parcel: Parcel, flags: Int) {
            parcel.writeString(courseCode)
            parcel.writeString(courseName)
            parcel.writeInt(credits)
            parcel.writeString(description)
            parcel.writeString(instructor)
        }

        override fun create(parcel: Parcel): Entity {
            return Entity(parcel)
        }
    }
}