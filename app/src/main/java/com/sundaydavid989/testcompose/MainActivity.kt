package com.sundaydavid989.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.sundaydavid989.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                NoteIntegration()
                // ShowIncrement()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteIntegration(){
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_200)),
                onClick =
                {
                    if (name.isNotBlank()){
                        names = names + name
                        name = ""
                    }
                }) {
                Text(text = "Add")
            }
        }

        LazyColumn{
            items(names){ currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }
}

//@Composable
//fun ShowIncrement() {
//    var count by remember {
//        mutableStateOf(0)
//    }
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                modifier = Modifier
//                    .padding(8.dp, 8.dp, 0.dp),
//                textAlign = TextAlign.Center,
//                fontSize = 30.sp,
//                text = count.toString()
//            )
//            Button(
//                modifier = Modifier
//                    .padding(8.dp, 8.dp, 0.dp),
//                onClick = {
//                    count++
//                }) {
//                Text(text = "Click me")
//            }
//        }
//    }
//}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    LazyColumn(
//        horizontalAlignment = Alignment.Start,
//        verticalArrangement = Arrangement.Top,
//        modifier = modifier
//            .fillMaxSize()
//            .padding(8.dp)
//    ) {
//        items(10) {i->
//            Text(
//                text = "Hello $name!",
//                modifier = modifier,
//                color = Color.Blue,
//                fontSize = 30.sp
//            )
//
//            Text(
//                text = "Hello tester",
//                modifier = modifier,
//                color = Color.Red,
//                fontSize = 30.sp,
//                textAlign = TextAlign.Center
//            )
//
//            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_background),
//                contentDescription = "An Image"
//            )
//
//            Icon(
//                modifier = Modifier
//                    .size(100.dp),
//                imageVector = Icons.Default.Favorite,
//                contentDescription = "love"
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestComposeTheme {
        NoteIntegration()
        // ShowIncrement()
    }
}