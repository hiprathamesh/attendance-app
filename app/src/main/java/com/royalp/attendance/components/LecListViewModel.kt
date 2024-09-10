package com.royalp.attendance.components

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LecListViewModel: ViewModel() {
    private var _lecList = MutableStateFlow<List<LectureCardList>>(emptyList())
    var lecList = _lecList.asStateFlow()

    init {
        getLecList()
    }

    fun getLecList(){
        val db = Firebase.firestore
        db.collection("lecture-cards")
            .addSnapshotListener{value, error ->
                if(error != null){
                    return@addSnapshotListener
                }
                if(value != null){
                    _lecList.value = value.toObjects(LectureCardList::class.java)
                }
            }
    }
}