<script setup>
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import {api} from "@/plugins/api.js";

const route = useRoute();
const router = useRouter();
const id = route.params.id;

const title = ref();
const content = ref();

async function fetchArticle() {
  try {
    const res = await api.get(`/articles/${id}`);
    title.value = res.data.title;
    content.value = res.data.content;
  } catch (e) {
    alert("오류가 발생했습니다.");
    router.back();
  }
}

async function updateArticle() {
  try {
    await api.put(`/articles/${id}`, {
      title: title.value,
      content: content.value,
    });
    router.back();
  } catch (e) {
    alert("오류가 발생했습니다.");
  }
}

fetchArticle();
</script>

<template>
  <form @submit.prevent="updateArticle">
    <div>
      <label for="title">제목</label>
      <input id="title" v-model="title" type="text">
    </div>
    <br>
    <div>
      <label for="content">내용</label>
      <textarea id="content" v-model="content"/>
    </div>
    <button type="submit">수정</button>
  </form>
</template>

<style scoped>

</style>