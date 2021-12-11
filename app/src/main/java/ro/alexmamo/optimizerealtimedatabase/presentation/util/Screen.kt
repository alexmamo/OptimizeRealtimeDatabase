package ro.alexmamo.optimizerealtimedatabase.presentation.util

import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_DETAILS_SCREEN
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_NAMES_SCREEN

sealed class Screen(val route: String) {
    object ProductNamesScreen: Screen(PRODUCT_NAMES_SCREEN)
    object ProductDetailsScreen: Screen(PRODUCT_DETAILS_SCREEN)
}