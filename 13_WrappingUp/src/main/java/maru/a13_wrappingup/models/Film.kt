package maru.a13_wrappingup.models

import android.os.Parcel
import android.os.Parcelable

class Film (
        var id: String,
        var title: String
) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Film> = object : Parcelable.Creator<Film> {
            override fun createFromParcel(source: Parcel): Film = Film(source)
            override fun newArray(size: Int): Array<Film?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(title)
    }
}