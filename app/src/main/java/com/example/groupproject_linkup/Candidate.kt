package com.example.groupproject_linkup

import android.os.Parcel
import android.os.Parcelable
data class Candidate(var candidatename: String="",
                     var description:String="",
                     var address:String="",
                     var email:String="",
                     var experience:String="",
                     var image: String="",
                     var postdesc: String="",
                     var postimg: String="",
                     var title: String="" ): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(candidatename)
        parcel.writeString(description)
        parcel.writeString(address)
        parcel.writeString(email)
        parcel.writeString(experience)
        parcel.writeString(image)
        parcel.writeString(postdesc)
        parcel.writeString(postimg)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0 // Typically 0 unless special handling is needed
    }

    companion object CREATOR : Parcelable.Creator<Candidate> {
        override fun createFromParcel(parcel: Parcel): Candidate {
            return Candidate(parcel)
        }

        override fun newArray(size: Int): Array<Candidate?> {
            return arrayOfNulls(size)
        }
    }
}