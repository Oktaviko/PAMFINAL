package com.example.pamfinal.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val PendaftarRepository: PendaftarRepository
}

class PendaftarContainer : AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    override val PendaftarRepository: PendaftarRepository by lazy {
        PendaftarRepositoryImpl(firestore)
    }

}

