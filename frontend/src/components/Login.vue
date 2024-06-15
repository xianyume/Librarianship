<script setup>


</script>

<template>
  <div class="centered-box">
    <h1>Librarianship</h1>
    <el-form
        label-position="right"
        label-width="auto"
        style="max-width: 400px"
    >
      <el-form-item label="账号">
        <el-input v-model="username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="password" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onLogin">登录</el-button>
        <el-button @click="onSign">注册</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<style scoped>
.centered-box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%) scale(1.5);;
}
</style>
