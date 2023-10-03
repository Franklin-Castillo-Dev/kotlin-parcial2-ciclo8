package com.example.di.navigation.moduloroomdinavcompose.compose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.di.navigation.libdbtwo.model.entity.User
import com.example.di.navigation.moduloroomdinavcompose.viewmodel.ProductViewModel
import com.example.di.navigation.moduloroomdinavcompose.viewmodel.UserViewModel
import com.example.libdbthree.model.entity.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun NewProductFormScreen(productViewModel: ProductViewModel, onClickNavigateTo:()->Unit) {

    // Instancia Producto
    var product by remember {
        mutableStateOf(Product(
            0,
            null,
            null,
            null,
            0,
            0.00))
    }


    Box(
        modifier = Modifier
            .fillMaxSize() // Esto asegura que el fondo blanco ocupe toda la pantalla
            .background(color = Color.White) // Establece el fondo blanco
    ){
        LazyColumn {
            item{

                OutlinedTextField(
                    value = product.name ?: "",
                    onValueChange = { product = product.copy(name = it) },
                    label = { Text("Nombre*") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            item {
                OutlinedTextField(
                    value = product.description ?: "",
                    onValueChange = { product = product.copy(description = it) },
                    label = { Text("Descripción*") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            item {
                OutlinedTextField(
                    value = product.urlImage ?: "",
                    onValueChange = { product = product.copy(urlImage = it) },
                    label = { Text("URL de la Imagen*") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            item {
                OutlinedTextField(
                    value = product.price?.toString() ?: "",
                    onValueChange = { product = product.copy(price = it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Precio") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }


            //Crear Objeto
            item {
                Button(
                    onClick = {
                        if(product.name != null && product.description != null && product.urlImage != null){
                            productViewModel.insert(product)
                            //Limpiamos
                            product = product.copy(name = null)
                            product = product.copy(description = null)
                            product = product.copy(urlImage = null)
                            product = product.copy(price = 0.00)

                            //regresamos
                            onClickNavigateTo()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Crear Producto")
                }
            }


            //Navegacion
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

}