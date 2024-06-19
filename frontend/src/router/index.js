import { createRouter, createWebHistory } from 'vue-router'

//导入组件
import LoginVue from '@/views/Login.vue'
import LayoutVue from '@/views/Layout.vue'

import FormVue from '@/views/book/BookForm.vue'
import BookVue from '@/views/book/BookManage.vue'

import UserInfoVue from '@/views/user/UserInfo.vue'

//定义路由关系
const routes = [
    { path: '/login', component: LoginVue },
    {
        path: '/', component: LayoutVue, redirect:'/login', children: [
            { path: '/form', component: FormVue },
            { path: '/book', component: BookVue },
            { path: '/user/info', component: UserInfoVue }
        ]
    }
]

//创建路由器
const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

//导出路由
export default router
