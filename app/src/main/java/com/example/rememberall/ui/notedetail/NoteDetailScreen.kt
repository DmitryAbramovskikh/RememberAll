package com.example.rememberall.ui.notedetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rememberall.ui.notedetail.NoteDetailScreen

private class CircleNode(var color: Color) : DrawModifierNode, Modifier.Node()
{
    override fun ContentDrawScope.draw() {
        drawCircle(color)
    }
}

@Composable
fun NoteDetailScreen(state: NoteDetailContract.State,
                     intentHandler: (NoteDetailContract.Intent) -> Unit,
                     effectHandler: (NoteDetailContract.Effect) -> Unit)
{
    Box()
    {
        Column(modifier = Modifier) {
            OutlinedTextField(
                value = state.title,
                onValueChange = { intentHandler(NoteDetailContract.Intent.ChangeTitle(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(4.dp, 16.dp)
            )

            val textPaddingBottom = if (!state.isChanged) 16.dp else 64.dp

            OutlinedTextField(
                value = state.text,
                onValueChange = { intentHandler(NoteDetailContract.Intent.ChangeText(it)) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp, 0.dp, 4.dp, textPaddingBottom)
            )
        }

        if (state.isChanged) {
            Button(
                onClick = { intentHandler(NoteDetailContract.Intent.Save) },
                modifier = Modifier
                    .padding(16.dp, 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomCenter)
            ) {
                Text("Coхранить")
            }
        }
    }
}

@Preview
@Composable
fun PreviewNoteDetailCompose()
{
    NoteDetailScreen (NoteDetailContract.State(), {}, {})
}