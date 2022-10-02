package ro.alexmamo.optimizerealtimedatabase.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ro.alexmamo.optimizerealtimedatabase.core.Constants.NO_VALUE
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_KEY
import ro.alexmamo.optimizerealtimedatabase.navigation.Screen.ProductScreen
import ro.alexmamo.optimizerealtimedatabase.navigation.Screen.ProductsScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.product.ProductScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.products.ProductsScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductsScreen.route
    ) {
        composable(
            route = ProductsScreen.route
        ) {
            ProductsScreen(
                navigateToProductScreen = { productKey ->
                    navController.navigate("${ProductScreen.route}/${productKey}")
                }
            )
        }
        composable(
            route = "${ProductScreen.route}/{$PRODUCT_KEY}",
            arguments = mutableStateListOf(
                navArgument(PRODUCT_KEY) {
                    type = StringType
                }
            )
        ) { backStackEntry ->
            val productKey = backStackEntry.arguments?.getString(PRODUCT_KEY) ?: NO_VALUE
            ProductScreen(
                productKey = productKey,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}