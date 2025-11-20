package com.example.myarsitektur.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    //edit1 : parameter pilihanJK dan onSubmitButtonClicked
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    //edit2 : tambahkan 4 variabel dibawh ini
    var txtNama by rememberSaveable { mutableStateOf(value = "") }
    var txtAlamat by rememberSaveable { mutableStateOf(value = "") }
    var txtGender by rememberSaveable { mutableStateOf(value = "") }
    val listData : MutableList<String> = mutableListOf(txtNama,txtGender, txtAlamat)}

}