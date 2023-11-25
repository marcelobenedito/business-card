package com.github.marcelobenedito.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.marcelobenedito.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFd2e8d4)
                ) {
                    BusinessCard(
                        name = "Marcelo Benedito",
                        title = "Android Developer Extraordinaire",
                        phoneNumber = "+99 (999) 999 999 999",
                        socialMedia = "@marcelobenedito",
                        email = "marcelo.benedito@android.com",
                        image = R.drawable.android_logo
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    phoneNumber: String,
    socialMedia: String,
    email: String,
    image: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BusinessCardMainInfo(
            name = name,
            title = title,
            image = image,
            modifier = Modifier.weight(8f)
        )
        BusinessCardContactInfo(
            phoneNumber = phoneNumber,
            socialMedia = socialMedia,
            email = email,
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
fun BusinessCardMainInfo(
    name: String,
    title: String,
    image: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(Color(0xFF073042))
                        .size(100.dp)
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "$name's photo",
                    )
                }
            }
            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Light,
                    fontSize = 40.sp
                )
            }
            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color(0xFF006d3b)
                )
            }
        }
    }
}

@Composable
fun BusinessCardContactInfo(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .padding(top = 8.dp)
            ) {
                Icon(
                    Icons.Rounded.Phone,
                    tint = Color(0xFF006d3b),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(
                    text = phoneNumber,
                    fontSize = 15.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .padding(top = 16.dp)
            ) {
                Icon(
                    Icons.Rounded.Share,
                    tint = Color(0xFF006d3b),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                )
                Text(
                    text = socialMedia,
                    fontSize = 15.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .padding(top = 16.dp)
            ) {
                Icon(
                    Icons.Rounded.Email,
                    tint = Color(0xFF006d3b),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(
                    text = email,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFd2e8d4)
        ) {
            BusinessCard(
                name = "Marcelo Benedito",
                title = "Android Developer Extraordinaire",
                phoneNumber = "+99 (999) 999 999 999",
                socialMedia = "@marcelobenedito",
                email = "marcelo.benedito@android.com",
                image = R.drawable.android_logo
            )
        }
    }
}