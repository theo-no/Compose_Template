package com.example.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.domain.model.RepoDto
import com.example.presentation.navigation.Screen
import com.example.presentation.viewmodel.SearchReposViewModel

//collectAsStateWithLifecycle 찾아보기
private const val TAG = "SearchReposScreen 차선호"
@Composable
fun SearchReposScreen(
    viewModel: SearchReposViewModel = hiltViewModel(),
    navController: NavController
){
    val reposState = viewModel.exampleRepos.collectAsState()


    val constraintSet = ConstraintSet{
        val textTitle = createRefFor("textTitle")
        val layoutSearch = createRefFor("layoutSearch")
        val listRepos = createRefFor("listRepos")

        constrain(textTitle){
            top.linkTo(parent.top, margin = 4.dp)
            start.linkTo(parent.start, margin = 4.dp)
            end.linkTo(parent.end, margin = 4.dp)
        }
        constrain(layoutSearch){
            top.linkTo(textTitle.bottom, margin = 4.dp)
            start.linkTo(textTitle.start)
            end.linkTo(textTitle.end)
        }
        constrain(listRepos){
            top.linkTo(layoutSearch.bottom, margin = 4.dp)
            start.linkTo(textTitle.start)
            end.linkTo(textTitle.end)
        }
    }

    ConstraintLayout(
        constraintSet
    ) {
        Text(
            text = "Repository 검색",
            fontSize = 32.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.layoutId("textTitle")
        )
        Box(
            modifier = Modifier.layoutId("layoutSearch")
        ) {
            SearcyLayout(
                text = viewModel.userName.value,
                onTextChange = { viewModel.setUserName(it) },
                viewModel = viewModel,
            )
        }
        Box(
            modifier = Modifier.layoutId("listRepos")
        ){
            LazyColumn(
                modifier = Modifier.padding(8.dp)
            ) {
                items(reposState.value) {
                    CardRepo(
                        repo = it,
                        onClick = {
//                            navController.navigate(Screen.RepoInfo.route)
                            navController.navigate(Screen.RepoInfo.route+viewModel.userName.value+"/"+it.name)
                        }
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearcyLayout(
    text: String,
    onTextChange: (String) -> Unit,
    viewModel: SearchReposViewModel
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            viewModel.getUserRepos(text)
        }) {
            Text("입력")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardRepo(repo: RepoDto, onClick: () -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(4.dp),
        onClick = onClick
    ) {
        val constraintSet = ConstraintSet {
            var textName = createRefFor("textName")
            var textGitUrl = createRefFor("textGitUrl")
            var textHtmlUrl = createRefFor("textHtmlUrl")

            constrain(textName){
                start.linkTo(parent.start, margin = 8.dp)
                top.linkTo(parent.top)
            }
            constrain(textGitUrl){
                start.linkTo(textName.end, margin = 4.dp)
                top.linkTo(textName.top)
                bottom.linkTo(textName.bottom)
            }
            constrain(textHtmlUrl){
                start.linkTo(textName.start)
                top.linkTo(textName.bottom, margin = 4.dp)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            }
        }

        ConstraintLayout(
            constraintSet,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextName(
                text = repo.name,
                modifier = Modifier
                    .layoutId("textName")
            )
            TextUrl(
                text = repo.gitUrl,
                modifier = Modifier.layoutId("textGitUrl")
            )
            TextUrl(
                text = repo.htmlUrl,
                modifier = Modifier.layoutId("textHtmlUrl")
            )
        }
    }
}

@Composable
fun TextName(text: String, modifier: Modifier){
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun TextUrl(text: String, modifier: Modifier){
    Text(
        text = text,
        color = Color.Gray,
        fontSize = 8.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CardRepoPreview(){
    CardRepo(repo = RepoDto(1,"name","htmlUrl","url","gitUrl"), onClick = {})
}

@Preview(showBackground = true)
@Composable
fun SearchReposScreenPreview(){
    SearchReposScreen(navController = rememberNavController())
}