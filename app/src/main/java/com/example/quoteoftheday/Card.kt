import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteoftheday.Quote
import com.example.quoteoftheday.ui.theme.CardColor


@Composable
fun Card(quote: Quote,modifier: Modifier) {  
    Column(
        modifier=modifier
            .clip(RoundedCornerShape(8.dp))
            .shadow(elevation = 4.dp)
            .background(CardColor)
            .padding(28.dp)

    ) {
        Text(
            text = quote.quote,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                bottom = 24.dp
            )
            )
        Text(
            text = quote.author,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}