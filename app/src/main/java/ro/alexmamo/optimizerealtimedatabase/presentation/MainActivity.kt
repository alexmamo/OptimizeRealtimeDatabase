package ro.alexmamo.optimizerealtimedatabase.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.optimizerealtimedatabase.presentation.product_details.ProductDetailsScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.product_names.ProductNamesScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.util.Screen.ProductDetailsScreen
import ro.alexmamo.optimizerealtimedatabase.presentation.util.Screen.ProductNamesScreen

@AndroidEntryPoint
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
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
    }
}