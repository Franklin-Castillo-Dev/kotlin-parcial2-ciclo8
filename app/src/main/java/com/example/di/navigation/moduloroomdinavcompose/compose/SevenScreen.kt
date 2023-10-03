package com.example.di.navigation.moduloroomdinavcompose.compose

import android.media.Image
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.di.navigation.moduloroomdinavcompose.viewmodel.ProductViewModel
import com.example.libdbthree.model.entity.Product


@Composable
fun SevenScreen(productViewModel: ProductViewModel, onClickNavigateNewForm:()->Unit, onClickNavigateTo:()->Unit) {


    val listOfProductUiState by productViewModel.allProducts.collectAsState(initial = listOf<Product>())

    Box(
        modifier = Modifier
            .fillMaxSize() // Esto asegura que el fondo blanco ocupe toda la pantalla
            .background(color = Color.White) // Establece el fondo blanco
    ){
        LazyColumn {

            item{
                Row(){
                    Button(onClick = {
                        Log.d("FormScreen DI","OnClick")
                        onClickNavigateTo()
                    }) {
                        Text(text = "Nuevo Producto DI")

                    }
                    Button(onClick = {
                        Log.d("FormScreen DI","OnClick")
                        onClickNavigateNewForm()
                    }) {
                        Text(text = "Nuevo Form Producto DI")

                    }
                }

            }

            item {
                Text("Estas en: Seven Screen")
            }
            // Add list of messages
            items(listOfProductUiState) { product ->
                Row(){
                    Text("ProductId = ${product.id } ")
                    Text("Nombre = ${product.name} ")
                }
                Row(){
                    Text("Descripcion = ${product.description} ")
                }
                Row(){
                    Text("Precio = ${product.price}")
                }
                Row(){
                    Box {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(product.urlImage)
                                .crossfade(true)
                                .build(),
                            contentDescription = "Imagen",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp, 80.dp)
                                .clip(CircleShape)
                        )

                    }
                }
                Row(){
                    Button(onClick = {
                        Log.d("Eliminar DI","OnClick")
                        productViewModel.delete(product)
                    }) {
                        Text(text = "Eliminar")

                    }
                }
                Divider()

            }

            item {
                Text("Fin")
            }
        }
    }





}