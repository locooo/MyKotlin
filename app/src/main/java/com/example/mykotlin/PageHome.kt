package com.example.mykotlin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//@Preview(showBackground = true)/**/
@Composable
fun PageHome(navController: NavController) {
    Column(modifier = Modifier
        .padding( 4.dp)
        .verticalScroll(rememberScrollState())) {
        MyRemember()
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //普通跳转
            navController.navigate(RouteConfig.ROUTE_PAGE_ONE)
        }) {
            Text(
                text = "跳转页面1",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //普通跳转
            navController.navigate(RouteConfig.ROUTE_PAGE_TEST)
        }) {
            Text(
                text = "跳转页面Test",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MyRemember() {
    // 方式1：
    val stateKind1 = remember { mutableIntStateOf(1) }
    // 方式2：属性委托（官方推荐）  组件内部管理状态
    var stateKind2 by remember { mutableIntStateOf(2) }
    // 方式3：解构写法（官方原生解构）
    val (count, setCount) = remember { mutableIntStateOf(3) }
    Column {
        Button(onClick = { stateKind1.intValue += 1; }) {
            Text(stateKind1.intValue.toString())
        }

        Button(onClick = { stateKind2 += 1; }) {
            Text(stateKind2.toString())
        }

        Button(onClick = { setCount(count + 1) }) {
            Text("$count")
        }
    }

}