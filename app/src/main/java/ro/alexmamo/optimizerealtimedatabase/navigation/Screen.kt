package ro.alexmamo.optimizerealtimedatabase.navigation

import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_SCREEN
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCTS_SCREEN

sealed class Screen(val route: String) {
    object ProductsScreen: Screen(PRODUCTS_SCREEN)
    object ProductScreen: Screen(PRODUCT_SCREEN)
}