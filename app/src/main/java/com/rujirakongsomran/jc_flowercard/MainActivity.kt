package com.rujirakongsomran.jc_flowercard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rujirakongsomran.jc_flowercard.model.Flower
import com.rujirakongsomran.jc_flowercard.ui.theme.JC_FlowerCardTheme
import com.rujirakongsomran.jc_flowercard.ui.theme.pink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_FlowerCardTheme {

            }
        }
    }
}

@Composable
fun FlowerCard(flower: Flower) {
    val helveticaFamily = FontFamily(
        Font(
            R.font.helvetica_neue_medium,
            FontWeight.Medium
        )
    )
    Card(
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(10.dp)
            .width(180.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_pink_rose_bouquet),
                contentDescription = "Flower Image",
                modifier = Modifier.size(140.dp)
            )
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = flower.name,
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 16.sp,
                            fontFamily = helveticaFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Text(
                        text = "$${String.format("%.2f", flower.price)}",
                        style = TextStyle(
                            color = pink,
                            fontSize = 16.sp,
                            fontFamily = helveticaFamily,
                            fontWeight = FontWeight.Medium,
                        )
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.background(
                        color = pink,
                        shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Icon",
                        tint = Color.White,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowerCardPreview() {
    JC_FlowerCardTheme() {
        FlowerCard(
            Flower("Rose", 300.20)
        )
    }
}