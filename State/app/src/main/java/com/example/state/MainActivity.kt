package com.example.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.state.ui.theme.Black
import com.example.state.ui.theme.StateTheme

class MainActivity : ComponentActivity() {
    private val text = LoremIpsum(100).values.first()
    private val text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum at eros nec ipsum viverra efficitur ac vitae odio. Ut turpis lacus, malesuada eget orci quis, porttitor dictum ipsum. Aliquam ac mi elementum, fermentum ex ut, consequat orci. Duis hendrerit leo neque, ac tincidunt magna pretium quis. Quisque rhoncus metus leo, eu cursus sem lobortis id. Nunc consequat feugiat mauris at consequat. Donec vel odio sit amet arcu porttitor venenatis. Suspendisse mauris turpis, luctus et feugiat eget, congue eu arcu. Pellentesque accumsan urna faucibus, dapibus est eu, pharetra erat. Vestibulum pulvinar libero nec ipsum sodales, sit amet efficitur orci euismod. Sed. "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            StateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    FirstScreen()
                    Column(modifier = Modifier.padding(16.dp)) {
                        ExpandableCard(title = "Lorem Ipsum", body = text2)

                    }
//                    SplitScreen()
//                    ExpandableCard(title = "Title")
//                    Text(text = text2)
                }
//            }
        }
    }
}

// Stateless
@Composable
fun ScreenContent(name: String, onNameChange: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Name")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Words),

    )
}

// Stateful
@Composable
fun FirstScreen() {
    var name by remember { mutableStateOf("") }

    ScreenContent(
        name = name,
        onNameChange = { name = it }
    )
}

@Composable
fun ExpandableCard(title: String, body: String) {
    var expanded by remember { mutableStateOf(false) }

    Card (modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ){
        Column (modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center){
            Text(text = title, textAlign = TextAlign.Left,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Normal, color = Black
            )
            if(expanded) {
                Column (modifier = Modifier.paddingFromBaseline(35.dp)) {
                    Text(text = body, textAlign = TextAlign.Justify,
                        style = MaterialTheme.typography.bodyLarge)
                }

                Column( modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(onClick = { expanded = !expanded}) {
                        Icon(imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Collapse")
                    }
                }
            } else {
                Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                    IconButton(onClick = { expanded = !expanded}) {
                        Icon(imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand")
                    }
                }

            }
        }
    }
}

// Basear-se nela
@Composable
fun ExpandableCard(title: String) {

    var expanded by remember { mutableStateOf (false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = { expanded = !expanded })
    ) {
        Column {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(8.dp).weight(2f)
                )
                Icon(imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand")
            }
            if (expanded) {
                Text(
                    text = "Content Sample for Display on Expansion of Card",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun SplitScreen() {
    Row {

        Column(modifier = Modifier
            .fillMaxHeight()
            .width(360.dp)
            .background(MaterialTheme.colorScheme.error)
            ) {
            Text(text = "Hello World!")
        }

        // Half of the screen
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(vertical = 460.dp)
        ) {
            Text(text = "Hello World!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateTheme {
        ExpandableCard(title = "Title")
    }
}