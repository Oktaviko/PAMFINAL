package com.example.pamfinal.data

import com.google.firebase.firestore.FirebaseFirestore

interface UserContainer {
    val pendaftarRepository: PendaftarRepository
    val rsRepository : Rumah_SakitRepository
}

class PendaftarContainer : UserContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    override val pendaftarRepository: PendaftarRepository by lazy {
        PendaftarRepositoryImpl(firestore)
    }
    override val rsRepository: Rumah_SakitRepository by lazy {
        Rumah_SakitRepositoryImpl(firestore)
    }

}