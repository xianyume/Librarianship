import request from '@/utils/request.js'
//文章分类列表查询
export const articleCategoryListService = ()=>{
    return request.get('/form/list')
}

//文章分类添加
export const articleCategoryAddService = (categoryData)=>{
    return request.post('/form/create',categoryData)
}

//文章分类修改
export const articleCategoryUpdateService = (categoryData)=>{
   return  request.put('/form/update',categoryData)
}

//文章分类删除
export const articleCategoryDeleteService = (id)=>{
    return request.delete('/form/delete?id=' + id)
}

//文章列表查询
export const articleListService = (id)=>{
    return request.get('/book/pageInfo?formId=' + id)
}

//文章添加
export const articleAddService = (articleData)=>{
    return request.post('/book/create', articleData);

}