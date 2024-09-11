package com.royalp.attendance.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.ui.theme.interFontFamily

@Composable
fun ClassDetailsButton(onCreateClass: (Map<String, String>, documentId: String) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }
    var subjectName by remember { mutableStateOf("") }
    var shortName by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var professorName by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }
    var documentId by remember { mutableStateOf("") }

    Button(onClick = { showDialog = true }) {
        Text("Create Class")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(
                text="Enter Class Details",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier
            ) },
            text = {
                Column {
                    TextField(
                        value = documentId,
                        onValueChange = { documentId = it },
                        label = { Text("Document ID") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                    TextField(
                        value = subjectName,
                        onValueChange = { subjectName = it },
                        label = { Text("Subject Name") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                    TextField(
                        value = shortName,
                        onValueChange = { shortName = it },
                        label = { Text("Short Name") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                    TextField(
                        value = code,
                        onValueChange = { code = it },
                        label = { Text("Code") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                    TextField(
                        value = professorName,
                        onValueChange = { professorName = it },
                        label = { Text("Professor Name") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                    TextField(
                        value = startTime,
                        onValueChange = { startTime = it },
                        label = { Text("Start Time") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                    TextField(
                        value = endTime,
                        onValueChange = { endTime = it },
                        label = { Text("End Time") },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val classDetails = mapOf(
                            "name" to subjectName,
                            "short" to shortName,
                            "code" to code,
                            "prof" to professorName,
                            "start" to startTime,
                            "end" to endTime
                        )
                        onCreateClass(classDetails, documentId)
                        showDialog = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}