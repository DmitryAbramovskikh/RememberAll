package com.example.rememberall.ui.note

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

private class CircleNode(var color: Color) : DrawModifierNode, Modifier.Node()
{
    override fun ContentDrawScope.draw() {
        drawCircle(color)
    }
}

@Composable
fun NoteDetailCompose(
    viewModel: NoteDetailViewModel,
    onSaveNote: () -> Unit = { },
    modifier: Modifier = Modifier
)
{
    Box()
    {
        Column(modifier = modifier) {
            OutlinedTextField(
                value = viewModel.title,
                onValueChange = { viewModel.onNoteEdit(title = it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(4.dp, 16.dp)
            )

            val textPaddingBottom = if (!viewModel.isChanged) 16.dp else 64.dp

            OutlinedTextField(
                value = viewModel.text,
                onValueChange = { viewModel.onNoteEdit(text = it) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp, 0.dp, 4.dp, textPaddingBottom)
            )
        }

        if (viewModel.isChanged) {
            Button(
                onClick = {
                    viewModel.onSave()
                    onSaveNote()
                },
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
    NoteDetailCompose(hiltViewModel())
}