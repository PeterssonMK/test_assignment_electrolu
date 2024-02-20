package com.example.electrolux_assignment.domain.entity

import java.util.UUID

/**
 * Represents a Fabric item with the associated properties.
 * @property id unique identifier of the fabric item.
 * @property title name-type of the fabric
 * @property description description of what the fabric item encompasses
 * @property icon icon prompting fabric type
 * @property isEnabled indicates whether fabric item is available for choice
 */
data class FabricItemEntity(
    val id: UUID = UUID.randomUUID(),
    val title: Int,
    val description: Int,
    val icon: Int,
    val isEnabled: Boolean
)
