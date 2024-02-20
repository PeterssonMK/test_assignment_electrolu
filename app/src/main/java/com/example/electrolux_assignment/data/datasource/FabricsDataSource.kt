package com.example.electrolux_assignment.data.datasource

import com.example.electrolux_assignment.R
import com.example.electrolux_assignment.domain.entity.FabricItemEntity

/**
 * Datasource class providing data for fabric items.
 *
 * The FabricsDataSource class is responsible for supplying a list of FabricItems with
 * mock data representing various fabric types. Each FabricItem includes a title,
 * description, icon resource, and availability status.
 */
class FabricsDataSource {
    fun getData(): List<FabricItemEntity> {
        return listOf(
            FabricItemEntity(
                title = R.string.cotton_eco_title,
                description = R.string.cotton_eco_description,
                icon = R.drawable.cotton_eco,
                isEnabled = true
            ),
            FabricItemEntity(
                title = R.string.cottons_title,
                description = R.string.cottons_description,
                icon = R.drawable.cottons,
                isEnabled = true
            ),
            FabricItemEntity(
                title = R.string.synthetics_title,
                description = R.string.synthetics_description,
                icon = R.drawable.synthetics,
                isEnabled = true
            ),
            FabricItemEntity(
                title = R.string.mixed_title,
                description = R.string.mixed_description,
                icon = R.drawable.mixed,
                isEnabled = true
            ),
            FabricItemEntity(
                title = R.string.delicates_title,
                description = R.string.delicates_description,
                icon = R.drawable.delicates,
                isEnabled = true
            ),
            FabricItemEntity(
                title = R.string.sports_title,
                description = R.string.sports_description,
                icon = R.drawable.sport,
                isEnabled = true
            ),
            FabricItemEntity(
                title = R.string.bed_linen_title,
                description = R.string.bed_linen_description,
                icon = R.drawable.bed_linen_xl,
                isEnabled = true,
            )
        )
    }
}