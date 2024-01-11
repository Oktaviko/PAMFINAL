package com.example.pamfinal.data

import com.google.firebase.firestore.FirebaseFirestore

interface UserContainer {
    val pendaftarRepository: PendaftarRepository
    val rumahsakitRepository: RumahSakitRepository
    val kartuRepository : KartuRepository
}

class PendaftarContainer : UserContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    override val pendaftarRepository: PendaftarRepository by lazy {
        PendaftarRepositoryImpl(firestore)
    }
    override val rumahsakitRepository: RumahSakitRepository by lazy {
        RumahSakitRepositoryImpl(firestore)
    }
    override val kartuRepository: KartuRepository by lazy {
        KartuRepositoryImpl(firestore)
    }

}