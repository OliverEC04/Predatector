package com.example.predatector.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstandroidapp.components.drawer.DrawerMenu
import com.example.predatector.repository.PredatorRepository
import com.example.predatector.ui.theme.PredatectorTheme

class PredatorDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val predator = PredatorRepository.getAllPredators().first()

        setContent {
            PredatectorTheme {
                Greeting(
                    name = predator.name,
                    PredatorInfo = predator.PredatorInfo,
                    imageId = predator.imageId,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, PredatorInfo: List<String>, imageId: Int, modifier: Modifier) {
    val context = LocalContext.current
    val imagePainter: Painter? = if (imageId != -1) painterResource(imageId) else null

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ){
        Text("Predator name:", fontSize = 24.sp)
        Text(text = "$name", fontSize = 24.sp, fontWeight = FontWeight.Black, color = Color.Black, modifier = Modifier.padding(bottom = 20.dp))
        imagePainter?.let {
            Image(
                painter = it,
                contentDescription = name,
                modifier = Modifier
                    .fillMaxSize()
                    .height(300.dp)
                    .padding(bottom = 20.dp)
            )
        }

        Card (modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)) {
            Column {
                Text("Predator info:")
                PredatorInfo.forEach { predatorsInfo ->
                    Text("# $predatorsInfo")
                }
            }
        }
    }
}
