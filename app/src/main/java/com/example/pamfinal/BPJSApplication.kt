package com.example.pamfinal

import android.app.Application
import com.example.pamfinal.data.AppContainer
import com.example.pamfinal.data.PendaftarContainer
import com.example.pamfinal.data.UserContainer

class BPJSApplication : Application(){
    lateinit var container: UserContainer

    override fun onCreate(){
        super.onCreate()

        container = PendaftarContainer()
    }
}