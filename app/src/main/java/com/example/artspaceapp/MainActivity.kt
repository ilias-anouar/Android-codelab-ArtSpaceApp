package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}


@Composable
fun Button(modifier: Modifier = Modifier, actionAction:()-> Unit, @StringRes label: Int){
    Button(onClick = actionAction , modifier
        .size(width = 100.dp, height = 50.dp)
        .padding(horizontal = 20.dp)) {
        Text(text = stringResource(label), fontSize = 15.sp)
    }
}



@Composable
fun ArtSpaceLayout(){

    val min = 0
    val max = 4

    var index by remember {
        mutableIntStateOf(0)
    }

    val imgResource = when (index){
        0-> painterResource(R.drawable.capsule_616x353)
        1-> painterResource(R.drawable.kameo_screen_03_t)
        2-> painterResource(R.drawable._17xwsvpl6l)
        else-> painterResource(R.drawable._00px_e3_2013__9020973991_)
    }
    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 30.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Image(painter = imgResource, contentDescription = "img", modifier = Modifier
            .padding(15.dp)
            .fillMaxHeight())
        Column (modifier = Modifier.safeDrawingPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = stringResource(R.string.app_name), fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(text = stringResource(R.string.app_name), fontSize = 10.sp)
        }
        Spacer(modifier = Modifier.size(100.dp))
        Row (modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.Bottom) {
            Button(actionAction = { if (index > min) { index-- }}, label = R.string.previous)
            Button(actionAction = { if (index < max) { index++ }}, label = R.string.next)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}