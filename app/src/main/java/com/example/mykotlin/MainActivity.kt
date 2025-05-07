package com.example.mykotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mykotlin.ui.theme.MyKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyRemember()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyRemember(){
    // 方式1：操作 MutableIntState 对象  需要将状态传递给其他组件
    val stateKind1 = remember { mutableIntStateOf(1) }

    //需要导入
//    import androidx.compose.runtime.getValue
//    import androidx.compose.runtime.setValue
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

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyKotlinTheme {
//        Greeting("Android")
//    }
//}