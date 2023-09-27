package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    var order by remember { mutableStateOf(1) }

    val imageResourse = when (order) {
        1 -> R.drawable.foto1
        2 -> R.drawable.foto2
        3 -> R.drawable.foto3
        4 -> R.drawable.foto4
        5 -> R.drawable.foto5
        6 -> R.drawable.foto6
        7 -> R.drawable.foto7
        8 -> R.drawable.foto8
        9 -> R.drawable.foto9
        10 -> R.drawable.foto10
        else -> R.drawable.foto10
    }

    val titleResource = when (order) {
        1 -> R.string.paisaje
        2 -> R.string.concierto
        3 -> R.string.propuesta
        4 -> R.string.cumple
        5 -> R.string.casita
        6 -> R.string.rodada
        7 -> R.string.cumpleNando
        8 -> R.string.miradas
        9 -> R.string.electrico
        10 -> R.string.parchado
        else -> R.string.parchado
    }

    val yearResource = when (order) {
        1 -> R.string.paisaje_year
        2 -> R.string.concierto_year
        3 -> R.string.propuesta_year
        4 -> R.string.cumple_year
        5 -> R.string.casita_year
        6 -> R.string.rodada_year
        7 -> R.string.cumpleNando_year
        8 -> R.string.miradas_year
        9 -> R.string.electrico_year
        10 -> R.string.parchado_year
        else -> R.string.parchado_year
    }

    val descriptionResourse = when (order) {
        1 -> R.string.paisaje_description
        2 -> R.string.concierto_description
        3 -> R.string.propuesta_description
        4 -> R.string.cumple_description
        5 -> R.string.casita_description
        6 -> R.string.rodada_description
        7 -> R.string.cumpleNando_description
        8 -> R.string.miradas_description
        9 -> R.string.electrico_description
        10 -> R.string.parchado_description
        else -> R.string.parchado_description
    }
    /*var title by remember { mutableStateOf(R.string.denji) }
    var year by remember { mutableStateOf(R.string.denji_year) }
    var currentArtwork by remember { mutableStateOf(galeria[0]) }
    var imageResource by remember { mutableStateOf(currentArtwork) }*/

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        ArtworkTitle(
            title = R.string.vacio,
            year = R.string.codigo,
            description = R.string.name_teban
        )
        Spacer(
            modifier = modifier.size(5.dp)
        )
        ArtworkImage(
            currentArtwork = imageResourse
        )
        Spacer(
            modifier = modifier.size(5.dp)
        )
        ArtworkTitle(
            title = titleResource,
            year = yearResource,
            description = descriptionResourse
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick ={
                    if (order == 1) {
                        order = 10
                    }else{
                        order -= 1

                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_300),
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(R.string.botton_previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }

            Button(
                onClick ={
                    order = 1
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_300),
                    containerColor = colorResource(id = R.color.purple_suave)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.reload),
                    contentDescription = stringResource(R.string.boton_para_refrescar_imagenes),
                    modifier = Modifier.size(30.dp)
                )
            }
            Button(
                onClick = {
                    if (order == 10) {
                        order = 1
                    }else{
                        order+= 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_300),
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.botton_next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}



@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Surface(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(1.dp),
    ) {
        Image(
            painter = painterResource(id = currentArtwork),
            contentDescription = null,
            modifier = modifier
                .padding(40.dp)
                .fillMaxWidth()
                .shadow(elevation = 8.dp,
                    shape = MaterialTheme.shapes.large,
                    spotColor = Color.Black
                ),
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_200),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )

        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_900),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

