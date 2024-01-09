package com.example.pamfinal.data

import android.content.ContentValues
import android.util.Log
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.model.RumahSakit
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await


interface PendaftarRepository {
    fun getAll(): Flow<List<Pendaftar>>
    suspend fun save(pendaftar: Pendaftar): String
    suspend fun update(pendaftar: Pendaftar)
    suspend fun delete(pendaftarId: String)
    fun getPendaftarById(pendaftarId: String): Flow<Pendaftar>
}

class PendaftarRepositoryImpl(private val firestore: FirebaseFirestore) : PendaftarRepository {
    override fun getAll(): Flow<List<Pendaftar>> = flow {
        val snapshot = firestore.collection("Pendaftar")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val pendaftar = snapshot.toObjects(Pendaftar::class.java)
        emit(pendaftar)
    }.flowOn(Dispatchers.IO)


    override suspend fun save(pendaftar: Pendaftar): String {
        return try {
            val documentReference = firestore.collection("Pendaftar").add(pendaftar).await()
            // Update the Pendaftar with the Firestore-generated DocumentReference
            firestore.collection("Pendaftar").document(documentReference.id)
                .set(pendaftar.copy(nik = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(pendaftar: Pendaftar) {
        firestore.collection("Pendaftar").document(pendaftar.nik).set(pendaftar).await()
    }

    override suspend fun delete(pendaftarId: String) {
        firestore.collection("Pendaftar").document(pendaftarId).delete().await()
    }

    override fun getPendaftarById(pendaftarId: String): Flow<Pendaftar> {
        return flow {
            val snapshot = firestore.collection("Pendaftar").document(pendaftarId).get().await()
            val pendaftar = snapshot.toObject(Pendaftar::class.java)
            emit(pendaftar!!)
        }.flowOn(Dispatchers.IO)
    }

}
interface RumahSakitRepository {
    fun getAll(): Flow<List<RumahSakit>>
    suspend fun save(rumahsakit: RumahSakit): String
    suspend fun update(rumahsakit: RumahSakit)
    suspend fun delete(rumahsakitId: String)
    fun getRumahSakitById(rumahsakitId: String): Flow<RumahSakit>
}

class RumahSakitRepositoryImpl(private val firestore: FirebaseFirestore) : RumahSakitRepository {
    override fun getAll(): Flow<List<RumahSakit>> = flow {
        val snapshot = firestore.collection("RumahSakit")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val rumahsakit = snapshot.toObjects(RumahSakit::class.java)
        emit(rumahsakit)
    }.flowOn(Dispatchers.IO)


    override suspend fun save(rumahsakit: RumahSakit): String {
        return try {
            val documentReference = firestore.collection("RumahSakit").add(rumahsakit).await()
            // Update the Pendaftar with the Firestore-generated DocumentReference
            firestore.collection("RumahSakit").document(documentReference.id)
                .set(rumahsakit.copy(id_rs = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(rumahsakit: RumahSakit) {
        firestore.collection("RumahSakit").document(rumahsakit.id_rs).set(rumahsakit).await()
    }

    override suspend fun delete(rumahsakitId: String) {
        firestore.collection("RumahSakit").document(rumahsakitId).delete().await()
    }

    override fun getRumahSakitById(rumahsakitId: String): Flow<RumahSakit> {
        return flow {
            val snapshot = firestore.collection("Pendaftar").document(rumahsakitId).get().await()
            val pendaftar = snapshot.toObject(RumahSakit::class.java)
            emit(pendaftar!!)
        }.flowOn(Dispatchers.IO)
    }

}

