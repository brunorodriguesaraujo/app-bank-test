package br.com.brunorodrigues.app_bancario_teste.data.util

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "user_preferences")

@Singleton
class DataStoreUtil @Inject constructor(@ApplicationContext val context: Context) {

    suspend fun saveString(key: String, value: String) {
        val dateStoreKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[dateStoreKey] = value
        }
    }

    suspend fun readString(key: String): String? {
        val dateStoreKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[dateStoreKey]
    }

}