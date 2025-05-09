package com.example.mykotlin.viewModeDemo
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//列表
@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedChange: (WellnessTask, Boolean) -> Unit,
    onClose: (WellnessTask) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = list, key = { it.id }) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedChange(task, checked) },
                onClose = { onClose(task) }
            )
        }
    }
}

//列表中的单个组件
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

//定义viewModel
class WellnessViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<WellnessTask>()
    val tasks: List<WellnessTask> get() = _tasks

    init {
        //1、同步
//        _tasks.addAll(getWellnessTasks())

        // 2、异步模拟网络请求或数据库操作
        viewModelScope.launch {
            val fetchedTasks = getWellnessTasks()
            _tasks.addAll(fetchedTasks)
        }
    }

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        val index = _tasks.indexOf(task)
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(checked = checked)
        }
    }

    fun remove(task: WellnessTask) {
        _tasks.remove(task)
    }

    // 1、同步
//    private fun getWellnessTasks() = List(30) { i ->
//        WellnessTask(i, "Task #$i")
//    }
    // 2、异步模拟网络请求或数据库操作
    private suspend fun getWellnessTasks(): List<WellnessTask> {
        kotlinx.coroutines.delay(5000)
        return List(30) { i -> WellnessTask(i, "Task #$i") }
    }
}

//定义数据模型类
data class WellnessTask(val id: Int, val label: String,var checked: Boolean = false)