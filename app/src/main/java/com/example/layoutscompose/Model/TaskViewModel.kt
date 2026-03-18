package com.example.layoutscompose.Model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TaskViewModel : ViewModel() {

    private val calendar = Calendar.getInstance()

    // 🔹 TÍTULO
    private val _titulo = MutableStateFlow("")
    val titulo: StateFlow<String> = _titulo

    fun updateTitulo(value: String) {
        _titulo.value = value
    }


    private val _status = MutableStateFlow("Não Concluído")
    val status: StateFlow<String> = _status

    fun updateStatus(value: String) {
        _status.value = value
    }


    private val _prioridade = MutableStateFlow("Média")
    val prioridade: StateFlow<String> = _prioridade

    fun updatePrioridade(value: String) {
        _prioridade.value = value
    }


    private val _date = MutableStateFlow(formatDate())
    val date: StateFlow<String> = _date


    private val _time = MutableStateFlow(formatTime())
    val time: StateFlow<String> = _time

    fun updateDate(year: Int, month: Int, day: Int) {
        calendar.set(year, month, day)
        _date.value = formatDate()
    }

    fun updateTime(hour: Int, minute: Int) {
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        _time.value = formatTime()
    }

    fun reset() {
        _titulo.value = ""
        _status.value = "Não Concluído"
        _prioridade.value = "Média"
    }

    private fun formatDate(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(calendar.time)
    }

    private fun formatTime(): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(calendar.time)
    }
}