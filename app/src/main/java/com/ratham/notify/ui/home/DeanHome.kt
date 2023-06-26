package com.ratham.notify.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ratham.notify.ui.components.VerticalGrid
import com.ratham.notify.ui.components.NotifyDivider
import com.ratham.notify.data.Session
import com.ratham.notify.data.sessions
import com.ratham.notify.ui.components.NotifyScaffold
import com.ratham.notify.ui.components.NotifySurface
import com.ratham.notify.ui.theme.NotifyTheme
import kotlinx.coroutines.CoroutineScope
import kotlin.math.max



@Composable
fun DeanHome(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavHostController) {

    NotifyScaffold(
        topBar = {
            HomeTopBar(
                coroutineScope = coroutineScope,
                scaffoldState = scaffoldState
            )
        },
        content = {
            LazyColumn {
                item {
                    HomeContent(sessions = sessions, navController)
                }
            }
        }
    )
}

@Composable
private fun HomeTopBar(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
) {
    Column(
        modifier = Modifier.statusBarsPadding()
    ) {
        TopAppBar(
            backgroundColor = NotifyTheme.colors.uiBackground,
            contentColor = NotifyTheme.colors.textSecondary,
            elevation = 5.dp, // No shadow needed

            title = {
                Text(
                    text = "Sessions",
                    style = MaterialTheme.typography.h5,
                    color = NotifyTheme.colors.textSecondary,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f)
                        .align(Alignment.CenterHorizontally)
                )
            },
        )
        NotifyDivider()
    }
}

@Composable
private fun HomeContent(sessions: List<Session>, navController: NavHostController) {
    Column(modifier = Modifier.padding(1.dp)) {
        VerticalGrid(Modifier.padding(horizontal = 1.dp)) {
            sessions.forEach { session ->
                HomeItem(
                    modifier = Modifier.padding(3.dp),
                    session = session,
                    navController = navController
                )
            }
        }
        Spacer(Modifier.height(2.dp))
    }
}

private val MinImageSize = 134.dp
private val SessionCardShape = RoundedCornerShape(10.dp)
private const val SessionNameProportion = 0.55f

@Composable
private fun HomeItem(
    modifier: Modifier = Modifier,
    session: Session,
    gradient: List<Color> = NotifyTheme.colors.gradient2_3,
    navController: NavHostController
) {
//    Layout(
//        modifier = modifier
//            .aspectRatio(1.45f)
//            .shadow(elevation = 2.dp, shape = SessionCardShape)
//            .clip(SessionCardShape)
//            .background(Brush.horizontalGradient(gradient))
//            .clickable { navigateToSessionDetail(sessionId = session.id, navController = navController) },
//        content = {
//            Text(
//                text = session.name,
//                style = MaterialTheme.typography.subtitle1,
//                color = NotifyTheme.colors.textSecondary,
//                modifier = Modifier
//                    .padding(4.dp)
//                    .padding(start = 8.dp)
//            )
//            SessionImage(
//                imageUrl = session.imageUrl,
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//    ) { measurables, constraints ->
//        // Text given a set proportion of width (which is determined by the aspect ratio)
//        val textWidth = (constraints.maxWidth * SessionNameProportion).toInt()
//        val textPlaceable = measurables[0].measure(Constraints.fixedWidth(textWidth))
//
//        // Image is sized to the larger of height of item, or a minimum value
//        // i.e. may appear larger than item (but clipped to the item bounds)
//        val imageSize = max(MinImageSize.roundToPx(), constraints.maxHeight)
//        val imagePlaceable = measurables[1].measure(Constraints.fixed(imageSize, imageSize))
//        layout(
//            width = constraints.maxWidth,
//            height = constraints.minHeight
//        ) {
//            textPlaceable.placeRelative(
//                x = 0,
//                y = (constraints.maxHeight - textPlaceable.height) / 2 // centered
//            )
//            imagePlaceable.placeRelative(
//                // image is placed to end of text i.e. will overflow to the end (but be clipped)
//                x = textWidth,
//                y = (constraints.maxHeight - imagePlaceable.height) / 2 // centered
//            )
//        }
//    }
}


@Composable
private fun NavigationIcon(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ"

//    NotifySurface(
//        color = Color.LightGray,
//        shape = CircleShape,
//        modifier = Modifier
//            .padding(8.dp)
//            .size(40.dp)
//    ) {
//
//        Image(
//            painter = rememberImagePainter(
//                data = imageUrl,
//                builder = {
//                    crossfade(true)
//                    placeholder(drawableResId = R.drawable.placeholder)
//                }
//            ),
//            modifier = Modifier
//                .clickable(onClick = {
////                    scope.launch {
////                        scaffoldState.drawerState.open()
////                    }
//                })
//                .fillMaxSize()
//                .background(
//                    color = Color.Transparent,
//                    shape = CircleShape
//                ),
//            contentDescription = "Navigation Drawer",
//            contentScale = ContentScale.Crop,
//        )
//
//    }

}

@Composable
private fun SessionImage(
    imageUrl: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    NotifySurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
    }
}
