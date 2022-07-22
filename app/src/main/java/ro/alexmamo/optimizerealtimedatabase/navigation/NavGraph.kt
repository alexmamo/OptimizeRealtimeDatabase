package ro.alexmamo.optimizerealtimedatabase.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            route = "${ProductDetailsScreen.route}/{productKey}",
            arguments = mutableStateListOf(
                navArgument("productKey") {
                    type = StringType
                }
            )
        ) { backStackEntry ->
            val productKey = backStackEntry.arguments?.getString("productKey") ?: ""
            ProductDetailsScreen(
                productKey = productKey,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}