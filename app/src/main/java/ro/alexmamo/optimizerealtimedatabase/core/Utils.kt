package ro.alexmamo.optimizerealtimedatabase.core

import android.util.Log
import ro.alexmamo.optimizerealtimedatabase.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception?) {
            Log.d(TAG, e?.message ?: e.toString())
        }
    }
}