package com.example.bestiario_mhw.model

import com.example.bestiario_mhw.R

object MonsterRepository {
    val monsters = listOf(
        Monster(R.string.Rathian, R.string.tipo_volador, R.drawable.rathian, R.string.Rathian_Descripcion),
        Monster(R.string.Diablos, R.string.tipo_volador, R.drawable.diablos, R.string.Diablos_Descripcion),
        Monster(R.string.Tigrex, R.string.tipo_volador, R.drawable.tigrex, R.string.Tigrex_Descripcion),
        Monster(R.string.Beotodus, R.string.tipo_nadador, R.drawable.beotodus, R.string.Beotodus_Descripcion),
        Monster(R.string.Teostra, R.string.tipo_anciano, R.drawable.teostra, R.string.Teostra_Descripcion),
        Monster(R.string.Kushala, R.string.tipo_anciano, R.drawable.kushala, R.string.Kushala_Descripcion),
        Monster(R.string.Velkhana, R.string.tipo_anciano, R.drawable.velkhana, R.string.Velkhana_Descripcion),
        Monster(R.string.Xeno, R.string.tipo_anciano, R.drawable.xeno, R.string.Xeno_Descripcion),
        Monster(R.string.Shara, R.string.tipo_anciano, R.drawable.shara, R.string.Shara_Descripcion),
        Monster(R.string.Nergigante, R.string.tipo_anciano, R.drawable.nergigante, R.string.Nergigante_Descripcion),
    )
}