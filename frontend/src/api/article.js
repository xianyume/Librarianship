import request from '@/utils/request.js'
//文章分类列表查询
export const articleCategoryListService = ()=>{
    return request.get('/form/list')
}

//文章分类添加
export const articleCategoryAddService = (categoryData)=>{
    return request.post('/form',categoryData)
}

//文章分类修改
export const articleCategoryUpdateService = (categoryData)=>{
   return  request.put('/form',categoryData)
}

//文章分类删除
export const articleCategoryDeleteService = (id)=>{
    return request.delete('/form?id='+id)
}

//文章列表查询
export const articleListService = (params)=>{
   return  request.get('/book',{params:params})
}

//文章添加
export const articleAddService = (articleData)=>{
    return request.post('/book',articleData);

}