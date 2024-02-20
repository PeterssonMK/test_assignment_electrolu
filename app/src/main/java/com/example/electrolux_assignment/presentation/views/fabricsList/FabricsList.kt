package com.example.electrolux_assignment.presentation.views.fabricsList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.electrolux_assignment.domain.entity.FabricItemEntity
import com.example.electrolux_assignment.presentation.views.fabricsList.components.SelectableItem
import com.example.electrolux_assignment.presentation.ui.theme.Constants
import com.example.electrolux_assignment.presentation.ui.theme.spacing
import java.util.UUID

/**
 * Composable that displays a list of fabric items.
 *
 * The FabricsList composable takes a [list] of FabricItems, a [selectedItemId]
 * representing the currently selected item, and an [onClick] lambda that is
 * invoked when a fabric item is clicked.
 *
 * @param list The list of fabric items to be displayed.
 * @param selectedItemId The unique identifier of the currently selected fabric item.
 * @param onClick Lambda function to handle item clicks via ViewModel.
 */
@Composable
fun FabricsList(
    list: List<FabricItemEntity>, selectedItemId: UUID?, onClick: (FabricItemEntity) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.medium)
            .clip(RoundedCornerShape(Constants.roundingRadius))
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        itemsIndexed(list) { index, item ->
            SelectableItem(
                model = item,
                isSelected = item.id == selectedItemId,  //selected item receives true
            ) { onClick(it) }
            if (index < list.size - 1) {
                Divider(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
                    color = MaterialTheme.colorScheme.outline,
                    thickness = Constants.dividerHeight
                )
            }
        }
    }
}