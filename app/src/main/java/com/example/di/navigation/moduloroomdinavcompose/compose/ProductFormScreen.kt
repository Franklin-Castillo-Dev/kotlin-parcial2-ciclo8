package com.example.di.navigation.moduloroomdinavcompose.compose

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.di.navigation.libdbtwo.model.entity.User
import com.example.di.navigation.moduloroomdinavcompose.viewmodel.ProductViewModel
import com.example.di.navigation.moduloroomdinavcompose.viewmodel.UserViewModel
import com.example.libdbthree.model.entity.Product

@Composable
fun ProductFormScreen(productViewModel: ProductViewModel, onClickNavigateTo:()->Unit) {
    LazyColumn {
        item{

            Button(onClick = { productViewModel.insert(
                Product(
                    0,name="Producto",price=3.85, description = "Barco Sunny",
                    urlImage = "https://onepiece.store/wp-content/uploads/2021/12/genuine-bandai-anime-one-piece-original-thousand-sunny-boat-wano-pirate-ship-figure-pvc-action-figure-toys-collectible-model-8-300x300.jpg",
                    image = 0)
                    )
            },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Añadir Registro")
            }

        }
        item{
            Button(onClick = {
                Log.d("FormScreen DI","OnClick")
                onClickNavigateTo()
            }) {
                Text(text = "Volver a Listado")

            }
        }
    }
}