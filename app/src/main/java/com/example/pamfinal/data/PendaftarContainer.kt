package com.example.pamfinal.data

import com.google.firebase.firestore.FirebaseFirestore

interface UserContainer {
    val pendaftarRepository: PendaftarRepository
}

class PendaftarContainer : UserContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    override val pendaftarRepository: PendaftarRepository by lazy {
        PendaftarRepositoryImpl(firestore)
    }

}
interface AppContainer {
    val rumahSakitrepository: Rumah_SakitRepository
}

class rumahSakitContainer : AppContainer {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    override val rumahSakitrepository: Rumah_SakitRepository by lazy {
        Rumah_SakitRepositoryImpl(firestore)
    }
}


