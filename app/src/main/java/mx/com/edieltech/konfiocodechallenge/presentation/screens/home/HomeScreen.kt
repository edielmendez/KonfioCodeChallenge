package mx.com.edieltech.konfiocodechallenge.presentation.screens.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import mx.com.edieltech.konfiocodechallenge.R
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import mx.com.edieltech.konfiocodechallenge.presentation.common.LightAndDarkPreview
import mx.com.edieltech.konfiocodechallenge.presentation.designsystem.dialog.SimpleAlertDialog
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.components.DogList
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi.HomeEffect
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi.HomeEvent
import mx.com.edieltech.konfiocodechallenge.ui.theme.KonfioCodeChallengeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onExitApp: () -> Unit
){

    var showServiceErrorDialog by remember {
        mutableStateOf(false)
    }
    var serviceErrorMessage by remember {
        mutableStateOf("")
    }
    var showExitAppDialog by remember {
        mutableStateOf(false)
    }
    BackHandler {
        showExitAppDialog = true
    }

    LaunchedEffect(Unit) {
        viewModel.setEvent(
            event = HomeEvent.GetDogs
        )
    }
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HomeContent(
        dogList = state.dogList,
        onNavigationIconClick = {
            showExitAppDialog = true
        }
    )
    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is HomeEffect.ShowServiceError -> {
                    showServiceErrorDialog = true
                    serviceErrorMessage = effect.message
                }
            }
        }
    }
    if(showExitAppDialog){
        SimpleAlertDialog(
            dialogTitle = stringResource(R.string.exit_app_title),
            dialogText = stringResource(R.string.exit_app_message),
            onDismissRequest = {
                showExitAppDialog = false
            },
            onConfirmation = {
                showExitAppDialog = false
                onExitApp()
            },
            confirmButtonText = stringResource(R.string.confirm_button_text),
            dismissButtonText = stringResource(R.string.cancel_button_text),
            onDismissAction = {
                showExitAppDialog = false
            }
        )
    }
    if(showServiceErrorDialog){
        SimpleAlertDialog(
            dialogTitle = stringResource(R.string.exit_app_title),
            dialogText = serviceErrorMessage,
            onDismissRequest = {
                showServiceErrorDialog = false
            },
            onConfirmation = {
                showServiceErrorDialog = false
            },
            confirmButtonText = stringResource(R.string.confirm_button_text),
            dismissButtonText = stringResource(R.string.cancel_button_text),
            onDismissAction = {
                showServiceErrorDialog = false
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    dogList: List<DogModel> = emptyList(),
    onNavigationIconClick: () -> Unit = {},
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Text(stringResource(R.string.home_title))
                    }
                },
                navigationIcon = {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        "Back",
                        modifier = Modifier
                            .clickable {
                                onNavigationIconClick.invoke()
                            }
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ){
            DogList(
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 15.dp),
                dogList = dogList,
                onItemClick = {}
            )
        }
    }
}

@LightAndDarkPreview
@Composable
fun HomeContentPreview(){
    KonfioCodeChallengeTheme {
        HomeContent()
    }
}