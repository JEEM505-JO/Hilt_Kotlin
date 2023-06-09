package com.devnic.hiltkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devnic.hiltkotlin.model.modelbd.NoteModel
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Database(version = 1, entities = [NoteModel::class])
abstract class RoomDataBaseNote : RoomDatabase() {
    abstract fun daoNote(): NoteDao

}


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun providerDataBase(
        @ApplicationContext context: Context,
        dao: Lazy<NoteDao>
    ) = Room.databaseBuilder(context = context, RoomDataBaseNote::class.java, "NoteBD")
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(SupervisorJob()).launch {
                    dao.get().insertDefault()
                }
            }
        }).build()


    @Provides
    fun serviceProvidesDao(database: RoomDataBaseNote): NoteDao = database.daoNote()

}


