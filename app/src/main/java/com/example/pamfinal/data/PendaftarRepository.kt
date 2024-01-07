package com.example.pamfinal.data

import android.content.ContentValues
import android.util.Log
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.model.Rumah_Sakit
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
interface Rumah_SakitRepository {
    fun getAll(): Flow<List<Rumah_Sakit>>
    suspend fun save(Rumah_Sakit : Rumah_Sakit): String
    suspend fun update(Rumah_Sakit : Rumah_Sakit)
    suspend fun delete(Rumah_SakitId: String)
    fun getRumah_SakitById(Rumah_SakitId: String): Flow<Rumah_Sakit>
}

class Rumah_SakitRepositoryImpl(private val firestore: FirebaseFirestore) : Rumah_SakitRepository {
    override fun getAll(): Flow<List<Rumah_Sakit>> = flow {
        val snapshot = firestore.collection("Rumah_Sakit")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val Rumah_Sakit  = snapshot.toObjects(Rumah_Sakit::class.java)
        emit(Rumah_Sakit )
    }.flowOn(Dispatchers.IO)


    override suspend fun save(Rumah_Sakit : Rumah_Sakit): String {
        return try {
            val documentReference = firestore.collection("Rumah_Sakit").add(Rumah_Sakit ).await()
            // Update the Rumah_Sakit with the Firestore-generated DocumentReference
            firestore.collection("Rumah_Sakit").document(documentReference.id)
                .set(Rumah_Sakit .copy(id_rs = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(Rumah_Sakit : Rumah_Sakit) {
        firestore.collection("Rumah_Sakit").document(Rumah_Sakit .id_rs).set(Rumah_Sakit ).await()
    }

    override suspend fun delete(Rumah_SakitId: String) {
        firestore.collection("Rumah_Sakit").document(Rumah_SakitId).delete().await()
    }

    override fun getRumah_SakitById(Rumah_SakitId: String): Flow<Rumah_Sakit> {
        return flow {
            val snapshot = firestore.collection("Rumah_Sakit").document(Rumah_SakitId).get().await()
            val Rumah_Sakit  = snapshot.toObject(Rumah_Sakit::class.java)
            emit(Rumah_Sakit !!)
        }.flowOn(Dispatchers.IO)
    }

}

