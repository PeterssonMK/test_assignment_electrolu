package com.example.electrolux_assignment.presentation.fabrics_list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.electrolux_assignment.data.datasource.FabricsDataSource
import com.example.electrolux_assignment.presentation.viewmodel.FabricsListViewModel
import com.example.electrolux_assignment.presentation.views.fabricsList.FabricsList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FabricsListTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun onClick_description_text_should_be_visible() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val mockList = FabricsDataSource().getData()
        val viewModel = FabricsListViewModel()

        composeTestRule.setContent {
            FabricsList(
                list = mockList, selectedItemId = viewModel.selectedItem.value?.id
            ) { item -> viewModel.onSelectedStateChange(item) }
        }

        for (fabricItem in mockList) {
            val titleResource = context.getString(fabricItem.title)
            val descriptionResource = context.getString(fabricItem.description)
            val selectableItem = composeTestRule.onNodeWithText(titleResource)

            selectableItem.performClick()

            val descriptionText = composeTestRule.onNodeWithText(descriptionResource)

            if (viewModel.selectedItem.value == fabricItem) {
                descriptionText.assertIsDisplayed()
            } else {
                descriptionText.assertIsNotDisplayed()
            }
        }
    }
}