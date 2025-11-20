package com.example.myarsitektur.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.myarsitektur.model.Siswa
import com.example.myarsitektur.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    //edit 1 : parameter statusUiSiswa
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit
){
    //edit 2 : items Pair
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama), second = statusUiSiswa.nama),
        Pair(first = stringResource(id = R.string.gender), second = statusUiSiswa.gender),
        Pair(first = stringResource(id = R.string.alamat), second = statusUiSiswa.alamat)
    )
}