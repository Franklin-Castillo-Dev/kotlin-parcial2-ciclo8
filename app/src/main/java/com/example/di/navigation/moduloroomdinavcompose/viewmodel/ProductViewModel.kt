package com.example.di.navigation.moduloroomdinavcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.di.navigation.libdbtwo.model.entity.User
import com.example.di.navigation.libdbtwo.repository.UserRepository
import com.example.libdbthree.model.entity.Product
import com.example.libdbthree.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository): ViewModel()  {

    private val _info= MutableStateFlow<String?>(null)
    val info=_info.asStateFlow()


    val allProducts: Flow<List<Product>> = repository.allProducts

    fun insert(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(product)
    }

    fun delete(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(product)
    }

    class ProductViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ProductViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


    companion object{
        private const val TAG="UserViewModel"
    }

}