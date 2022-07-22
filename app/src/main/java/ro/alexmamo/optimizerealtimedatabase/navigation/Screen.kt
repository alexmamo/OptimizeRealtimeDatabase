package ro.alexmamo.optimizerealtimedatabase.navigation

import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_DETAILS_SCREEN
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_LIST_SCREEN

sealed class Screen(val route: String) {
    object ProductListScreen: Screen(PRODUCT_LIST_SCREEN)
    object ProductDetailsScreen: Screen(PRODUCT_DETAILS_SCREEN)
}