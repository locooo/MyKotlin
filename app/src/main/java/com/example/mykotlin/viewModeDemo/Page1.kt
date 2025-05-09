package com.example.mykotlin.viewModeDemo

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun Page1(navController: NavController) {
    // 创建一个 ViewModel 实例，并自动与当前 Composable 生命周期关联。
    // 这意味着在配置更改（例如旋转屏幕）时，该 ViewModel 不会被销毁。
    val wellnessViewModel: WellnessViewModel = viewModel()

    // 渲染任务列表 UI，传入任务列表、选中状态变更处理函数和删除任务处理函数。
    WellnessTasksList(
        list = wellnessViewModel.tasks, // 从 ViewModel 获取当前任务列表。

        // 当用户点击 Checkbox 改变选中状态时，调用 ViewModel 的 changeTaskChecked 方法。
        onCheckedChange = { task, checked ->
            wellnessViewModel.changeTaskChecked(task, checked)
        },

        // 当用户点击关闭按钮时，调用 ViewModel 的 remove 方法删除任务。
        onClose = { task ->
            wellnessViewModel.remove(task)
        }
    )
}

