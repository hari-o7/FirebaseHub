@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.firebasehub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasehub.R
import com.example.firebasehub.ui.theme.BgColor
import com.example.firebasehub.ui.theme.Primary
import com.example.firebasehub.ui.theme.TextColor
import com.example.firebasehub.ui.theme.componentShapes

@Composable
fun NormalTextComponent(
    value: String,
    fontSize: TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontColor: Color = Color.Black
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontStyle = FontStyle.Normal
        ),
        color = fontColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun UnderlinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun TextFieldComponent(labelValue: String, imageVector: ImageVector) {

    var textValue by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clip(componentShapes.small),
        value = textValue,
        onValueChange = {
            textValue = it
        },
        label = {
            Text(text = labelValue)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),

        keyboardOptions = KeyboardOptions.Default,
        keyboardActions = KeyboardActions.Default,

        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = null, tint = Color.Gray)
        }


    )

}


@Composable
fun PasswordTextFieldComponent(labelValue: String, imageVector: ImageVector) {

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clip(componentShapes.small),
        value = password,
        onValueChange = {
            password = it
        },
        label = {
            Text(text = labelValue)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardActions = KeyboardActions.Default,

        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = null, tint = Color.Gray)
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else
                Icons.Filled.VisibilityOff

            val description = if (passwordVisible.value) {
                stringResource(R.string.hide_password)
            } else
                stringResource(R.string.show_password)

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)

            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()


    )

}

@Composable
fun CheckBoxComponent(value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
    ) {
        val checkedState by remember {
            mutableStateOf(false)
        }

        Checkbox(
            checked = checkedState,
            onCheckedChange = {
                checkedState != checkedState
            }
        )
        Text(
            text = value,
            textAlign = TextAlign.Justify,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxComponentPreview() {
    CheckBoxComponent(value = "By continuing you accept our Privacy Policy and Terms of Use")
}

@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
                .background(
                    color = Primary,
                    //brush = Brush.horizontalGradient(listOf(Primary, TextColor)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.W600
            )

        }

    }
}

@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

        Text(
            text = "or",
            fontSize = 14.sp,
            color = TextColor,
            modifier = Modifier.padding(10.dp)
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}

@Composable
fun ClickableTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText = if (tryingToLogin) "Already have an account? " else "Don't have an account yet?"
    val loginText = if (tryingToLogin) " Login" else " Register"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }

    }

    ClickableText(
        text = annotatedString,
        onClick = {
            annotatedString.getStringAnnotations(it, it)
                .firstOrNull()?.also { span ->
                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }

        },
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.W400,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
    )
}
