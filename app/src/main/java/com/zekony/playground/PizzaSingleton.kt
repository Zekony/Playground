package com.zekony.playground

import android.content.Context


abstract class PizzaSingleton {

    companion object {
        @Volatile
        private var INSTANCE: PizzaSingleton? = null

        fun getInstance(context: Context): PizzaSingleton {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Pizza.Builder().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}