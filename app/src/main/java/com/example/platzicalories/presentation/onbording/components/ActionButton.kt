package com.example.platzicalories.presentation.onbording.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.platzicalories.app.ui.theme.LocalSpacing
import com.example.platzicalories.app.ui.theme.PlatziCaloriesTheme

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall
) {
   Button(
       onClick = onClick,
       modifier = modifier,
       enabled = isEnabled,
       shape = RoundedCornerShape(100.dp)
   ) {
       Text(
           text = text,
           style = textStyle,
           color = MaterialTheme.colorScheme.onPrimary,
           modifier = Modifier.padding(LocalSpacing.current.spaceSmall)
       )
   }
}

@Preview
@Composable
private fun ActionButtonScreenPreview() {
    PlatziCaloriesTheme {
        ActionButton(
            text = "Siguiente",
            onClick = {},
            modifier = Modifier,
            isEnabled = true,
            textStyle = MaterialTheme.typography.titleSmall
        )
    }
}
