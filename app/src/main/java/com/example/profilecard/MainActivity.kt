package com.example.profilecard //name of our package

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //skips parenthesis, since no parameters are used.
            ProfileCardTheme {
                // A surface container using the 'background' color from the theme
                val teal_200 = Color(0xFF03DAC5)
                Surface(
                    modifier = Modifier
                        //.background(color = androidx.compose.ui.graphics.Color.LightGray)
                        .fillMaxSize() //makes background fill entire screen.
                        .padding(16.dp), //applies padding (space inside container) around entire layout.
                    color = teal_200, //sets background color.
                    //color = MaterialTheme.colorScheme.background //original background.
                    //color = Color.Green //built in way to add color.
                ) {
                    ProfileCard() //calls function
                }
            }
        }
    }
}

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    //Column stacks components vertically.
    Column(
        verticalArrangement = Arrangement.Center, // centers content vertically on screen.
        horizontalAlignment = Alignment.CenterHorizontally, //centers content horizontally.
        modifier = modifier
            .fillMaxSize() //makes sure column fills entire screen (Surface) space. (not just children space).
    ) {
        ProfileCardImage() //calls function
        Spacer(modifier = Modifier.height(8.dp)) //adds space between components.
        ProfileCardText() //calls function
    }
}

@Composable
fun ProfileCardImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.gimli) //calls painterResource and passes gimli as an argument. Assigns returned value to variable.
    Image(
        painter = image,
        contentDescription = "circular puppy image", // used for TalkBack, Google on screen reader.
        modifier = modifier
            .clip(CircleShape) // makes image round.
            .size(250.dp) // image size.
            .fillMaxWidth() // ensures image looks good on different screen sizes.
    )
}

@Composable
fun ProfileCardText(modifier: Modifier = Modifier) {
    //Column stack elements vertically.
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.my_name),
            fontSize = 50.sp,
            lineHeight = 100.sp,
            fontWeight = FontWeight.Bold, //makes text bold
            color = androidx.compose.ui.graphics.Color.Blue,
            textAlign = TextAlign.Center, //aligns text to center
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        //adds space between elements. .dp pixels per screen inch, adapts to screen size. (not hardcode size.)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
        text = stringResource(R.string.my_bio),
        fontSize = 30.sp,
        lineHeight = 40.sp,
        color = androidx.compose.ui.graphics.Color.Gray,
        textAlign = TextAlign.Center //aligns text to center
    )
    }
}

//for preview
@Preview(showBackground = true)
//@Composable, used for displaying, not needed for functions that don't display.
@Composable
fun GreetingPreview() {
    ProfileCardTheme {
        ProfileCard()
    }
}