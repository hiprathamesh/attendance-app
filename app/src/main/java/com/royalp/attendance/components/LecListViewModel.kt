package com.royalp.attendance.components

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.*

class LecListViewModel : ViewModel() {
    private var _lecList1 = MutableStateFlow<List<LectureCardList>>(emptyList())
    private var _lecList2 = MutableStateFlow<List<LectureCardList>>(emptyList())

    private val db = Firebase.firestore

    init {
        getLecList()
    }

    private fun getLecList() {
        viewModelScope.launch {
            val today = getCurrentDay()
            val tomorrow = getNextDay(today)

            val scheduleRef = db.collection("schedule")
            val lectureCardsRef = db.collection("lecture-cards")

            // Fetch today's schedule
            val todaySchedule = scheduleRef.document(today).get().await()
            val todayLectures = fetchLectures(todaySchedule, lectureCardsRef)

            // Fetch tomorrow's schedule
            val tomorrowSchedule = scheduleRef.document(tomorrow).get().await()
            val tomorrowLectures = fetchLectures(tomorrowSchedule, lectureCardsRef)

            _lecList1.value = todayLectures
            _lecList2.value = tomorrowLectures
        }
    }

    var lecList1 = _lecList1.asStateFlow()
    var lecList2 = _lecList2.asStateFlow()


    private suspend fun fetchLectures(
        scheduleDoc: DocumentSnapshot,
        lectureCardsRef: CollectionReference
    ): List<LectureCardList> {
        val lectures = mutableListOf<LectureCardList>()
        for (i in 1..6) {
            val lectureId = "${scheduleDoc.id}$i"
            val lecture = lectureCardsRef.document(lectureId).get().await()
            lecture.toObject(LectureCardList::class.java)?.let { lectures.add(it) }
        }
        return lectures
    }

    private fun getCurrentDay(): String {
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> "monday"
            Calendar.TUESDAY -> "tuesday"
            Calendar.WEDNESDAY -> "wednesday"
            Calendar.THURSDAY -> "thursday"
            Calendar.FRIDAY -> "friday"
            else -> "monday" // Default to Monday for weekend
        }
    }

    private fun getNextDay(currentDay: String): String {
        return when (currentDay) {
            "monday" -> "tuesday"
            "tuesday" -> "wednesday"
            "wednesday" -> "thursday"
            "thursday" -> "friday"
            "friday" -> "monday"
            else -> "tuesday" // If current day is Friday, next is Monday
        }
    }

    companion object {
        @Suppress("unused")
        fun createLec(classDetails: Map<String, String>, documentId: String) {
            val db = Firebase.firestore
            val lec = hashMapOf(
                "status" to 2,
                "name" to classDetails["name"],
                "short" to classDetails["short"],
                "code" to classDetails["code"],
                "start" to classDetails["start"],
                "end" to classDetails["end"],
                "prof" to classDetails["prof"],
            )

            db.collection("lecture-cards")
                .document(documentId)
                .set(lec)
                .addOnSuccessListener {
                    Log.d("document", "Document created with ID: $documentId")
                }
        }
    }
}