package com.hankkin.jetpack_note.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.hankkin.jetpack_note.data.Component
import com.hankkin.jetpack_note.data.AppDatabase
import com.hankkin.jetpack_note.utils.COMPONENT_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class SeedDatabaseWorker (
    context: Context,
    workerParams: WorkerParameters
): CoroutineWorker(context, workerParams) {

    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(COMPONENT_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Component>>() {}.type
                    val plantList: List<Component> = Gson().fromJson(jsonReader,plantType)
                    val database = AppDatabase.getInstance(applicationContext)
                    database.homeDao().insertAll(plantList)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }
}