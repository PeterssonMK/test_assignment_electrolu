package com.example.electrolux_assignment.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.electrolux_assignment.data.datasource.FabricsDataSource
import com.example.electrolux_assignment.presentation.views.fabricsList.FabricsList
import com.example.electrolux_assignment.presentation.viewmodel.FabricsListViewModel
import com.example.electrolux_assignment.presentation.ui.theme.Constants
import com.example.electrolux_assignment.presentation.ui.theme.ElectroluxAssignmentTheme
class MainActivity : ComponentActivity() {

    // Repository providing mock data for fabric items
    private val fabricsDataSource = FabricsDataSource()
    // List of fabric items obtained from the FabricsRepo
    private val mockList = fabricsDataSource.getData()
    // ViewModel responsible for managing the state of the fabrics list (selected item)
    private val viewModel: FabricsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElectroluxAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface
                ) {
                    Column {
                        //Spacer that imitates nav bar's zone
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(Constants.topPlaceholderHeight)
                        )
                        //Column representing a list of fabrics
                        FabricsList(
                            list = mockList, selectedItemId = viewModel.selectedItem.value?.id
                        ) { item -> viewModel.onSelectedStateChange(item) }
                    }
                }
            }
        }
    }
}

