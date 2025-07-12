package mx.com.edieltech.konfiocodechallenge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KonfioCodeChallengeApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}