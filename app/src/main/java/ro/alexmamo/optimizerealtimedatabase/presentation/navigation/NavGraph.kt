package ro.alexmamo.optimizerealtimedatabase.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ro.alexmamo.optimizerealtimedatabase.presentation.navigation.Screen.ProductDetailsScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.navigation.Screen.ProductNamesScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.ProductDetailsScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.product_names.ProductNamesScreen

@Composable
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductNamesScreen.route
    ) {
        composable(
            route = ProductNamesScreen.route
        ) {
            ProductNamesScreen(
                navController = navController
            )
        }
        composable(
            route = ProductDetailsScreen.route + "/{productId}",
            arguments = mutableStateListOf(
                navArgument("productId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailsScreen(
                navController = navController,
                productId = productId
            )
        }
    }
}