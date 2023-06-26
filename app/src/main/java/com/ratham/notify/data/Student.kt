package com.ratham.notify.data
/**
Created by Patrice Mulindi (email:mulindipatrice00@gmail.com) on 26/06/2023
 **/
data class Student (
    val name : String,
    val id: String,
    val password: String,
)

val students = listOf(
    Student(name = "A", id = "CCS/00008/019", password = "student_A"),
    Student(name = "B", id = "CCS/00015/019", password = "student_B"),
    )