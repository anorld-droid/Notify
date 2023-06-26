package com.ratham.notify.data

/**
  Created by Patrice Mulindi (email:mulindipatrice00@gmail.com) on 26/06/2023
 **/
data class Session (
    val time: String,
    var availability: Boolean,
    val dean: Dean,
    var student: Student?
)

val sessions = listOf(
    Session(time = "Thur 10AM", availability = true, dean = dean, student = null),
    Session(time = "Fri 10AM", availability = true, dean = dean, student = null)

)