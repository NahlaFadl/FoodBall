package com.example.testfoodball.di_module

import com.example.testfoodball.MainRepository
import org.koin.dsl.module

val repostoryModule= module {
    single { MainRepository( get()) }
}