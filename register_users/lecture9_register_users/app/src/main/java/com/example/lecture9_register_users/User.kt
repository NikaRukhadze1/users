package com.example.lecture9_register_users
import android.os.Parcel
import android.os.Parcelable

class User (
    val username: String?,
    val name: String?,
    val lastname: String?,
    val age: Int,
    val address: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(name)
        parcel.writeString(lastname)
        parcel.writeInt(age)
        parcel.writeString(address)
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }
}










//
//    (val username:String, val name:String, val lastname:String, val age:Int,val address:String): Parcelable{
//        constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readString()
//        ) }