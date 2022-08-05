package ro.alexmamo.optimizerealtimedatabase.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ro.alexmamo.optimizerealtimedatabase.core.Constants.NO_PRODUCT_KEY
import ro.alexmamo.optimizerealtimedatabase.core.Constants.PRODUCT_KEY
import ro.alexmamo.optimizerealtimedatabase.navigation.Screen.ProductDetailsScreen
import ro.alexmamo.optimizerealtimedatabase.navigation.Screen.ProductListScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.ProductDetailsScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.product_list.ProductListScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductListScreen.route
    ) {
        composable(
            route = ProductListScreen.route
        ) {
            ProductListScreen(
                navigateToProductDetails = { productKey ->
                    navController.navigate("${ProductDetailsScreen.route}/${productKey}")
                }
            )
        }
        composable(
            route = "${ProductDetailsScreen.route}/{$PRODUCT_KEY}",
            arguments = mutableStateListOf(
                navArgument(PRODUCT_KEY) {
                    type = StringType
                }
            )
        ) { backStackEntry ->
            val productKey = backStackEntry.arguments?.getString(PRODUCT_KEY) ?: NO_PRODUCT_KEY
            ProductDetailsScreen(
                productKey = productKey,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}