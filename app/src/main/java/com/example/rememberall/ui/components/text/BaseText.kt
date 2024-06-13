package com.example.rememberall.ui.components.text

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Composable
private fun BaseText(text: String,
             modifier: Modifier = Modifier,
             color: Color = Color.Unspecified,
             fontSize: TextUnit = TextUnit.Unspecified,
             fontStyle: FontStyle? = null,
             fontWeight: FontWeight? = null,
             fontFamily: FontFamily? = null,
             letterSpacing: TextUnit = TextUnit.Unspecified,
             textDecoration: TextDecoration? = null,
             textAlign: TextAlign? = null,
             lineHeight: TextUnit = TextUnit.Unspecified,
             overflow: TextOverflow = TextOverflow.Clip,
             softWrap: Boolean = true,
             maxLines: Int = Int.MAX_VALUE,
             minLines: Int = 1,
             onTextLayout: (TextLayoutResult) -> Unit = {},
             style: TextStyle = LocalTextStyle.current)
{
    Text(text = text,
        modifier,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        maxLines,
        minLines,
        onTextLayout,
        style)
}

@Composable
fun BaseTextR(text: String,
             modifier: Modifier = Modifier,
             color: Color = Color.Unspecified,
             fontSize: TextUnit = TextUnit.Unspecified,
             fontStyle: FontStyle? = null,
             fontFamily: FontFamily? = null,
             letterSpacing: TextUnit = TextUnit.Unspecified,
             textDecoration: TextDecoration? = null,
             textAlign: TextAlign? = null,
             lineHeight: TextUnit = TextUnit.Unspecified,
             overflow: TextOverflow = TextOverflow.Clip,
             softWrap: Boolean = true,
             maxLines: Int = Int.MAX_VALUE,
             minLines: Int = 1,
             onTextLayout: (TextLayoutResult) -> Unit = {},
             style: TextStyle = LocalTextStyle.current)
{
    BaseText(text = text,
        modifier,
        color,
        fontSize,
        fontStyle,
        FontWeight.Normal,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        maxLines,
        minLines,
        onTextLayout,
        style)
}

@Composable
fun BaseTextS(text: String,
             modifier: Modifier = Modifier,
             color: Color = Color.Unspecified,
             fontSize: TextUnit = TextUnit.Unspecified,
             fontStyle: FontStyle? = null,
             fontFamily: FontFamily? = null,
             letterSpacing: TextUnit = TextUnit.Unspecified,
             textDecoration: TextDecoration? = null,
             textAlign: TextAlign? = null,
             lineHeight: TextUnit = TextUnit.Unspecified,
             overflow: TextOverflow = TextOverflow.Clip,
             softWrap: Boolean = true,
             maxLines: Int = Int.MAX_VALUE,
             minLines: Int = 1,
             onTextLayout: (TextLayoutResult) -> Unit = {},
             style: TextStyle = LocalTextStyle.current)
{
    BaseText(text = text,
        modifier,
        color,
        fontSize,
        fontStyle,
        FontWeight.SemiBold,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        maxLines,
        minLines,
        onTextLayout,
        style)
}

@Composable
fun BaseTextB(text: String,
             modifier: Modifier = Modifier,
             color: Color = Color.Unspecified,
             fontSize: TextUnit = TextUnit.Unspecified,
             fontStyle: FontStyle? = null,
             fontFamily: FontFamily? = null,
             letterSpacing: TextUnit = TextUnit.Unspecified,
             textDecoration: TextDecoration? = null,
             textAlign: TextAlign? = null,
             lineHeight: TextUnit = TextUnit.Unspecified,
             overflow: TextOverflow = TextOverflow.Clip,
             softWrap: Boolean = true,
             maxLines: Int = Int.MAX_VALUE,
             minLines: Int = 1,
             onTextLayout: (TextLayoutResult) -> Unit = {},
             style: TextStyle = LocalTextStyle.current)
{
    BaseText(text = text,
        modifier,
        color,
        fontSize,
        fontStyle,
        FontWeight.Bold,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        maxLines,
        minLines,
        onTextLayout,
        style)
}

@Preview(showBackground = true)
@Composable
fun PreviewBaseText()
{
    BaseText("Preview")
}