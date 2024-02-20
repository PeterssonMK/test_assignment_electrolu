package com.example.electrolux_assignment.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.electrolux_assignment.domain.entity.FabricItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for managing the state of selected item in the fabrics list.
 *
 * This ViewModel is responsible for keeping track of the selected fabric item
 * in the fabrics list. It provides a [selectedItem] State representing the
 * currently selected fabric item, and a [onSelectedStateChange] function for
 * ensuring only 1 item is selected.
 *
 * @property _selectedItem The private mutable state representing the selected fabric item.
 * @property selectedItem The internal State representing the currently selected fabric item.
 */
@HiltViewModel
class FabricsListViewModel @Inject constructor() : ViewModel() {

    private val _selectedItem = mutableStateOf<FabricItemEntity?>(null)
    val selectedItem: State<FabricItemEntity?> = _selectedItem

    fun onSelectedStateChange(item: FabricItemEntity) {
        if (_selectedItem.value == item) {
            _selectedItem.value = null
        } else {
            _selectedItem.value = item
        }
    }
}