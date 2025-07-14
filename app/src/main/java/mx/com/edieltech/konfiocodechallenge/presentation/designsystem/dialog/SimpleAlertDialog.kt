package mx.com.edieltech.konfiocodechallenge.presentation.designsystem.dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SimpleAlertDialog(
    dialogTitle: String,
    dialogText: String,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    confirmButtonText: String = "Aceptar",
    dismissButtonText: String? = null,
    onDismissAction: (() -> Unit)? = null
){
    AlertDialog(
        title = {
            Text(
                text = dialogTitle,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        text = {
            Text(
                text = dialogText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = onConfirmation
            ) {
                Text(
                    text = confirmButtonText,
                    modifier = Modifier.then(
                        if (dismissButtonText == null) Modifier.fillMaxWidth()
                        else Modifier
                    ),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        dismissButton = dismissButtonText?.let { dismissText ->
            {
                TextButton(
                    onClick = {
                        onDismissAction?.invoke()
                        onDismissRequest()
                    }
                ) {
                    Text(
                        text = dismissText,
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    )
}