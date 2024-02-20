package com.example.electrolux_assignment

import com.example.electrolux_assignment.domain.entity.FabricItemEntity
import com.example.electrolux_assignment.presentation.viewmodel.FabricsListViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class FabricsListViewModelTest {

    @Test
    fun onSelectedStateChange_should_update_selectedItem() {
        val viewModel = FabricsListViewModel()
        val fabricItemEntity = FabricItemEntity(
            title = 1, description = 1, icon = 1, isEnabled = true
        )
        viewModel.onSelectedStateChange(fabricItemEntity)

        assertEquals(fabricItemEntity, viewModel.selectedItem.value)
    }

    @Test
    fun onSelectedStateChange_should_reset_selectedItem_if_already_selected() {
        val viewModel = FabricsListViewModel()
        val fabricItemEntity = FabricItemEntity(
            title = 1, description = 1, icon = 1, isEnabled = true
        )
        viewModel.onSelectedStateChange(fabricItemEntity)
        viewModel.onSelectedStateChange(fabricItemEntity)

        assertEquals(null, viewModel.selectedItem.value)
    }

    @Test
    fun onSelectedStateChange_should_update_selectedItem_for_different_items() {
        val viewModel = FabricsListViewModel()
        val fabricItemEntity1 = FabricItemEntity(
            title = 1, description = 1, icon = 1, isEnabled = true
        )
        val fabricItemEntity2 = FabricItemEntity(
            title = 2, description = 2, icon = 2, isEnabled = true
        )
        viewModel.onSelectedStateChange(fabricItemEntity1)
        viewModel.onSelectedStateChange(fabricItemEntity2)

        assertEquals(fabricItemEntity2, viewModel.selectedItem.value)
    }

    @Test
    fun onSelectedStateChange_should_update_selectedItem_and_reset_if_called_twice_with_the_same_item() {
        val viewModel = FabricsListViewModel()
        val fabricItemEntity = FabricItemEntity(
            title = 1, description = 1, icon = 1, isEnabled = true
        )
        viewModel.onSelectedStateChange(fabricItemEntity)
        viewModel.onSelectedStateChange(fabricItemEntity)

        assertEquals(null, viewModel.selectedItem.value)
    }
}
