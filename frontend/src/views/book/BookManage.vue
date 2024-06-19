<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'

import { ref } from 'vue'

//文章分类数据模型
const categorys = ref([
    {
      "id": 3,
      "name": "美食",
      "description": "my",
      "createTime": "2023-09-02 12:06:59",
      "updateTime": "2023-09-02 12:06:59"
    },
    {
      "id": 4,
      "name": "娱乐",
      "description": "yl",
      "createTime": "2023-09-02 12:08:16",
      "updateTime": "2023-09-02 12:08:16"
    },
    {
      "id": 5,
      "name": "军事",
      "description": "js",
      "createTime": "2023-09-02 12:08:33",
      "updateTime": "2023-09-02 12:08:33"
    }
])

//用户搜索时选中的分类id
const formId = ref('')

//用户搜索时选中的发布状态
const state = ref('')

//文章列表数据模型
const articles = ref([
    {
        "id": 1,
        "name": "陕西旅游攻略",
        "author": "陕西旅游攻略",
        "description": "兵马俑,华清池,法门寺,华山...爱去哪去哪...",
        "publisher": "草稿",
        "form": 1,
        "createTime": "2023-09-03 11:55:30",
        "updateTime": "2023-09-03 11:55:30"
    },
    {
        "id": 2,
        "name": "陕西旅游攻略",
        "author": "陕西旅游攻略",
        "description": "兵马俑,华清池,法门寺,华山...爱去哪去哪...",
        "publisher": "草稿",
        "form": 2,
        "createTime": "2023-09-03 11:55:30",
        "updateTime": "2023-09-03 11:55:30"
    },
    {
        "id": 3,
        "name": "陕西旅游攻略",
        "author": "陕西旅游攻略",
        "description": "兵马俑,华清池,法门寺,华山...爱去哪去哪...",
        "publisher": "草稿",
        "form": 3,
        "createTime": "2023-09-03 11:55:30",
        "updateTime": "2023-09-03 11:55:30"
    },
])

//回显文章分类
import { articleCategoryListService, articleListService,articleAddService } from '@/api/article.js'
const articleCategoryList = async () => {
    let result = await articleCategoryListService();

    categorys.value = result.data;
}

//获取文章列表数据
const articleList = async () => {

    let form_id = formId.value ? formId.value : 1

    let result = await articleListService(form_id);

    articles.value = result.data;

    for (let i = 0; i < articles.value.length; i++) {
        let article = articles.value[i];
        for (let j = 0; j < categorys.value.length; j++) {
            if (article.form === categorys.value[j].id) {
                article.form = categorys.value[j].name;
            }
        }
    }
}

articleCategoryList()
articleList();

import { QuillEditor } from '@vueup/vue-quill'
import '@vueup/vue-quill/dist/vue-quill.snow.css'
//控制抽屉是否显示
const visibleDrawer = ref(false)
//添加表单数据模型
const articleModel = ref({
    name: '',
    author: '',
    form: '',
    description: '',
    publisher: ''
})

import { useTokenStore } from '@/stores/token.js';
const tokenStore = useTokenStore();

</script>
<template>
    <el-card class="page-container">

        <!-- 搜索表单 -->
        <el-form inline>
            <el-form-item label="书籍分类：">
                <el-select placeholder="请选择" v-model="formId">
                    <el-option v-for="c in categorys" :key="c.id" :label="c.name" :value="c.id">
                    </el-option>
                </el-select>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="articleList">搜索</el-button>
                <el-button @click="formId = ''">重置</el-button>
            </el-form-item>

        </el-form>
        <el-table :data="articles" style="width: 100%">
            <el-table-column label="书籍名称" width="200" prop="name"></el-table-column>
            <el-table-column label="书籍作者" width="100" prop="author"></el-table-column>
            <el-table-column label="书籍分类" width="150" prop="form"> </el-table-column>
            <el-table-column label="书籍介绍" prop="description"></el-table-column>
            <el-table-column label="出版社" prop="publisher"></el-table-column>
            <el-table-column label="操作" width="100">
                <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary"></el-button>
                    <el-button :icon="Delete" circle plain type="danger"></el-button>
                </template>
            </el-table-column>
            <template #empty>
                <el-empty description="没有数据" />
            </template>
        </el-table>

        <!-- 抽屉 -->
        <el-drawer v-model="visibleDrawer" title="添加文章" direction="rtl" size="50%">
            <!-- 添加文章表单 -->
            <el-form :model="articleModel" label-width="100px">
                <el-form-item label="文章标题">
                    <el-input v-model="articleModel.title" placeholder="请输入标题"></el-input>
                </el-form-item>
                <el-form-item label="文章分类">
                    <el-select placeholder="请选择" v-model="formId">
                        <el-option v-for="c in categorys" :key="c.id" :label="c.name" :value="c.id">
                        </el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="文章内容">
                    <div class="editor">
                        <quill-editor theme="snow" v-model:content="articleModel.content" contentType="html">
                        </quill-editor>
                    </div>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="addArticle('已发布')">发布</el-button>
                    <el-button type="info" @click="addArticle('草稿')">草稿</el-button>
                </el-form-item>
            </el-form>
        </el-drawer>
    </el-card>
</template>
<style lang="scss" scoped>
.page-container {
    min-height: 100%;
    box-sizing: border-box;

    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
}

.editor {
    width: 100%;

    :deep(.ql-editor) {
        min-height: 200px;
    }
}
</style>