package com.example.electrolux_assignment.presentation.views.fabricsList.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.electrolux_assignment.domain.entity.FabricItemEntity
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.wear.compose.material.ContentAlpha
import com.example.electrolux_assignment.R
import com.example.electrolux_assignment.presentation.ui.theme.spacing
/**
 * Composable representing a selectable item in a list, such as a fabric item.
 *
 * The SelectableItem composable displays information about the [model] (FabricItem)
 * in a Row layout. If item is selected, it expands verically and shows description and icon indicating
 * the selected state.
 * The appearance may be adjusted based on the availability
 * of the item, and it responds to clicks through the provided [onClick] lambda.
 *
 * @param model The data model representing the item to be displayed.
 * @param isSelected Indicates whether the item is currently selected.
 * @param titleStyle The TextStyle for the title text.
 * @param descriptionStyle The TextStyle for the description text when the item is selected.
 * @param allPadding The overall padding applied to the entire item.
 * @param horizontalPadding The horizontal padding applied to certain elements within the item.
 * @param verticalPadding The vertical padding applied to certain elements within the item.
 * @param onClick Lambda function to handle clicks on the item.
 */
@Composable
fun SelectableItem(
    model: FabricItemEntity,
    isSelected: Boolean,
    titleStyle: TextStyle = MaterialTheme.typography.titleMedium,
    descriptionStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    allPadding: Dp = MaterialTheme.spacing.medium,
    horizontalPadding: Dp = MaterialTheme.spacing.medium,
    verticalPadding: Dp = MaterialTheme.spacing.medium,
    onClick: (FabricItemEntity) -> Unit
) {
    Row(
        modifier = Modifier
            .alpha(if (model.isEnabled) 1f else ContentAlpha.disabled) //change appearance if disabled
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .clickable { onClick(model) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(allPadding),
            painter = painterResource(id = model.icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = verticalPadding)
        ) {
            Text(
                text = stringResource(id = model.title),
                style = titleStyle,
                color = MaterialTheme.colorScheme.onPrimary
            )
            if (isSelected) {
                Text(
                    modifier = Modifier.padding(top = MaterialTheme.spacing.xsmall),
                    text = stringResource(id = model.description),
                    style = descriptionStyle,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
        if (isSelected) {
            Icon(
                modifier = Modifier.padding(horizontal = horizontalPadding),
                painter = painterResource(id = R.drawable.is_selected_light),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}
