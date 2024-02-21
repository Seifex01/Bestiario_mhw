package com.example.bestiario_mhw.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Monster(
    @DrawableRes val avatarResourceId: Int,
    @StringRes val nombre: Int,
    @StringRes val tipo: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val descripcion: Int,
)