package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = Color(0xffc8e6c9))
            ){
        Column (
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.weight(4f)
        ) {
            Logo()
        }

        Column (
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.weight(3f)
        ) {
            Info()
        }
    }
}

@Composable
fun Logo() {
    LogoLayout(
        stringResource(R.string.jennifer_doe),
        stringResource(R.string.android_developer_extraordinaire)
    )
}

@Composable
fun Info() {
    Row (
        modifier = Modifier.padding(bottom = 50.dp),
        horizontalArrangement = Arrangement.Center){
        Column() {
            InfoLine(Icons.Rounded.Call, stringResource(R.string.phone), stringResource(R.string._11_123_444_555_666))
            InfoLine(Icons.Rounded.Share, stringResource(R.string.share), stringResource(R.string.androiddev))
            InfoLine(Icons.Rounded.Email, stringResource(R.string.email), stringResource(R.string.jen_doe_android_com))
        }
    }
}

@Composable
fun LogoLayout(name: String, title: String, modifier: Modifier = Modifier) {

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .background(color = Color(0xff004d40))
        )
        Text(
            text = name,
            fontSize = 45.sp,
            color = Color(0xff424242),
            modifier = modifier
        )

        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff388e3c),
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Composable
fun InfoLine(imageVector: ImageVector, iconDescription: String, text: String, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.padding(bottom = 15.dp)){
        Icon(
            imageVector = imageVector,
            contentDescription = iconDescription,
            tint = Color(0xff388e3c),
            modifier = Modifier
                .weight(1.5f)
                .padding(end = 20.dp)
        )

        Text(
            text = text,
            color = Color(0xff424242),
            modifier = Modifier
                .weight(10f, false)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}
