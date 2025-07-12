package mx.com.edieltech.konfiocodechallenge.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import mx.com.edieltech.konfiocodechallenge.presentation.common.LightAndDarkPreview
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.fakedata.FakeDog
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.fakedata.FakeDogList
import mx.com.edieltech.konfiocodechallenge.ui.theme.KonfioCodeChallengeTheme

@Composable
fun DogList(
    modifier: Modifier = Modifier,
    dogList: List<DogModel>,
    onItemClick: (DogModel) -> Unit
){
    LazyColumn(
        modifier = modifier
    ) {
        items(dogList){ dog ->
            DogItem(
                dog = dog,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
fun DogItem(
    modifier: Modifier = Modifier,
    dog: DogModel,
    onItemClick: (DogModel) -> Unit
){
    Box(
        modifier = modifier.padding(top = 30.dp)
            .wrapContentHeight(),
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(dog.image)
                .build(),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.4f)
                .aspectRatio(486f / 729f)
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    onItemClick.invoke(dog)
                }.zIndex(1f),
            contentScale = ContentScale.Fit
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 10.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 10.dp
                ))
                .background(MaterialTheme.colorScheme.onBackground),
            horizontalArrangement = Arrangement.End
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.5f)
                    .padding(top = 10.dp, end = 20.dp, bottom = 10.dp)
            ) {
                Text(
                    text = dog.name,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = dog.description,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 18.sp
                )
                Text(
                    text = "Almost ${dog.age} years",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}

@LightAndDarkPreview
@Composable
fun DogItemPreview(){
    KonfioCodeChallengeTheme {
        DogItem(
            modifier = Modifier.fillMaxWidth(),
            dog = FakeDog,
            onItemClick = {}
        )
    }
}

@LightAndDarkPreview
@Composable
fun DogListPreview(){
    KonfioCodeChallengeTheme {
        DogList(
            modifier = Modifier.fillMaxWidth(),
            dogList = FakeDogList,
            onItemClick = {}
        )
    }
}