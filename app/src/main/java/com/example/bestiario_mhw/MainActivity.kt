package com.example.bestiario_mhw

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bestiario_mhw.model.Monster
import com.example.bestiario_mhw.model.MonsterRepository.monsters
import com.example.compose.Bestiario_mhwTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bestiario_mhwTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BestiarioApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestiarioApp() {
    Scaffold(
        topBar = {
            BestiarioTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(monsters) {
                Spacer(modifier = Modifier.height(8.dp))
                Column(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(horizontal = 16.dp)
                        ) {
                    MonsterCard(
                        monster = it,
                        modifier = Modifier

                    )
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestiarioTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(//modifier.size(R.dimen.size_alto_barra),

        title = {
            Row(modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
                //Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.monster_hunter_logo),
                    contentDescription = null)
            }
        },
        modifier = modifier
    )
}


@Composable
fun MonsterCard(
    monster: Monster,
    modifier: Modifier
){
    var expanded by remember { mutableStateOf(true) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )
    Card(
        modifier = modifier
            .fillMaxWidth()

    ) {
        Column(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .background(color = color),


            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier,
                verticalAlignment = Alignment.CenterVertically,
            ){
                MonsterAvatar(monster.avatarResourceId)
                Spacer(modifier = Modifier.weight(1f))
                InfoBase(monster = monster)
                Spacer(modifier = Modifier.weight(5f))
                botonMostrarMas(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded){
                infoOculta(
                    monster = monster,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
fun InfoBase(monster: Monster) {
    Column (
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = LocalContext.current.getString(monster.nombre),
            style = MaterialTheme.typography.displayMedium,

        )

        Text(
            text = LocalContext.current.getString(monster.tipo),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun MonsterImage(@DrawableRes imageResId: Int) {
    Image(

        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .width(dimensionResource(R.dimen.image_size))
            //.padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.large)

    )
}

@Composable
fun MonsterAvatar(@DrawableRes avatarResourceId: Int
    ) {

    Image(
        painter = painterResource(id = avatarResourceId),
        contentDescription = null,
        modifier = Modifier
            //.padding(8.dp)

            .size(dimensionResource(R.dimen.size_minimum))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),

    )
}

@Composable
fun monsterDescription(
    @StringRes descripcion: Int,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .padding(16.dp)
    ){

        Text(
            text = stringResource(R.string.Descripcion),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(id = descripcion),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Composable
private fun botonMostrarMas(

    expanded: Boolean,
    onClick:() -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun infoOculta(
    monster: Monster,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(true) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    )

    Column (
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {
        MonsterImage(monster.imageResourceId)
        monsterDescription(monster.descripcion)
    }
}

@Preview(showBackground = true)
@Composable
fun BestiarioAppPreview() {
    Bestiario_mhwTheme(useDarkTheme = false) {
        BestiarioApp()
    }
}

@Preview(showBackground = true)
@Composable
fun BestiariodARKAppPreview() {
    Bestiario_mhwTheme(useDarkTheme = true) {
        BestiarioApp()
    }
}



