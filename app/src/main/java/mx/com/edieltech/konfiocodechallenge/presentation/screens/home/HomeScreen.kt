package mx.com.edieltech.konfiocodechallenge.presentation.screens.home

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mx.com.edieltech.konfiocodechallenge.R
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import mx.com.edieltech.konfiocodechallenge.presentation.common.LightAndDarkPreview
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.components.DogList
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.fakedata.FakeDogList
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi.HomeEvent
import mx.com.edieltech.konfiocodechallenge.ui.theme.KonfioCodeChallengeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
){
    LaunchedEffect(Unit) {
        viewModel.setEvent(
            event = HomeEvent.GetDogs
        )
    }
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HomeContent(
        dogList = state.dogList
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    dogList: List<DogModel> = emptyList(),
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
                            .clickable {}
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