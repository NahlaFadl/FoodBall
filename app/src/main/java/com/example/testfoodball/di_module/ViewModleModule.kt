package com.example.testfoodball.di_module

import com.example.testfoodball.view_model.CompAndTeamViewModel
import com.example.testfoodball.view_model.CompetitionViewModel
import com.example.testfoodball.view_model.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModleModule= module {
    viewModel {
        CompetitionViewModel(mainRepository = get(), networkHelper = get())
    }

    viewModel{
        CompAndTeamViewModel(get(),get())
    }

    viewModel{
        TeamViewModel(get(),get())
    }
}