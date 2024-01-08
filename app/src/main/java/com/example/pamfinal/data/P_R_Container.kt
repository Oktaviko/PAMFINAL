package com.example.pamfinal.data

import com.google.firebase.firestore.FirebaseFirestore

interface UserContainer {
    val pendaftarRepository: PendaftarRepository
    val rsRepository : RumahSakitRepository
}

class PendaftarContainer : UserContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    override val pendaftarRepository: PendaftarRepository by lazy {
        PendaftarRepositoryImpl(firestore)
    }
    override val rsRepository: RumahSakitRepository by lazy {
        RumahSakitRepositoryImpl(firestore)
    }

}