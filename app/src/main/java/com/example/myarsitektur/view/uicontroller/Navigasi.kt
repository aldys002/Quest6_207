package com.example.myarsitektur.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myarsitektur.view.FormSiswa
import com.example.myarsitektur.view.TampilSiswa
import com.example.myarsitektur.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    //edit 1 : parameter viewModel
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavController = rememberNavController()
){
    Scaffold { isiRuang->
        //edit2 : tambahkan variabel uiState
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,

            modifier = Modifier.padding(paddingValues = isiRuang)
        ){
            //edit3 : tambahkan variabel uiState
            val konteks = LocalContext.current
            FormSiswa(
                //edit4 : parameter pilihanJK dan onSumbitButtonClicked
                pilihanJK = JenisK.map {id -> konteks.resources.getString(id)},
                onSubmitButtonClicked = {
                    viewModel.setSiswa(it)
                    navController.navigate(route = Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name){
            TampilSiswa(
                //edit5 : parameter statusUiSiswa
                statusUiSiswa = uiState.value,
                onBackButtonClicked = {cancelAndBackToFormulir(navController)}
            )
        }
    }
}
private fun cancelAndBackToFormulir(
    navController: NavController
) {
    navController.popBackStack(route = Navigasi.Formulir.name, inclusive = false)
}