package com.example.conversationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.conversationcompose.ui.theme.ConversationcomposeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversationcomposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}
data class Message(val author: String, val body: String, val imageResId: Int)


@Composable
fun Conversation(messages: List<Message>) {


        Box(
            modifier = Modifier
                .fillMaxSize()

         ){
            Image(
                painter = painterResource(id = R.drawable.app2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.3f)
            )

            // LazyColumn for the message list
            LazyColumn(
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 8.dp)
            ) {
                items(messages) { message ->
                    Greeting(message)
                }
            }
        }

}




@Composable
fun Greeting(msg: Message) {
   Row(modifier = Modifier.padding(all = 8.dp)) {
       Image(
           painter = painterResource(id = msg.imageResId),
           contentDescription = null,
           modifier = Modifier
               .size(70.dp)
               .clip(CircleShape)
               .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)


       )
       Spacer(modifier = Modifier.width(8.dp))
       var isExpanded by remember { mutableStateOf(false) }
       val surfaceColor by animateColorAsState(
           if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
       )
       Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
           Text(text = msg.author,
               color = MaterialTheme.colorScheme.secondary,
               style = MaterialTheme.typography.titleSmall.copy(fontSize = 20.sp, color = Color(android.graphics.Color.parseColor("#1D2951")))
           )
           Spacer(modifier = Modifier.height(4.dp))
           Surface(shape = MaterialTheme.shapes.medium,
               shadowElevation = 1.dp,
               color = surfaceColor,
               modifier = Modifier.animateContentSize().padding(1.dp)
           ) {
               Text(
                   text = msg.body,
                   modifier = Modifier.padding(all = 4.dp),
                   maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                   style = MaterialTheme.typography.bodyMedium.copy(fontSize = 21.sp, color = Color(android.graphics.Color.parseColor("#1D2951")))
               )
           }
       }
   }
}




@Preview(name = "Dark Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview
@Composable
fun PreviewConversation() {
    ConversationcomposeTheme {
        Conversation(SampleData.conversationSample)
    }
}
