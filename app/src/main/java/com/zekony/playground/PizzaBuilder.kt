package com.zekony.playground

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


open class Pizza(
    private val chosenBun: Bun? = Bun.NotSpecified,
    private val cheese: Boolean? = false,
    private val onions: Boolean? = false
): PizzaSingleton() {

    class Builder(
        private val chosenBun: Bun = Bun.NotSpecified,
        private val cheese: Boolean = false,
        private val onions: Boolean = false
    ) {

        fun chooseBun(bun: Bun): Builder {
            return Builder(chosenBun = bun)
        }

        fun addCheese(): Builder {
            return Builder(cheese = true)
        }

        fun addOnions(): Builder {
            return Builder(onions = true)
        }

        fun build(): Pizza = Pizza(chosenBun, cheese, onions)

    }
}

enum class Bun(@StringRes private val textRes: Int) {
    NotSpecified(0),
    WheatBread(R.string.wheat_bread),
    WhiteBread(R.string.white_bread),
    ItalianHerbCheese(R.string.italian_herb),
    MaltedRye(R.string.malted_rye),
    PlainWrap(R.string.plain_wrap),
    GlutenFreeWrap(R.string.gluten_free),
    MultigrainWrap(R.string.multigrain);

    val text: String
        @Composable
        get() = stringResource(id = textRes)
}