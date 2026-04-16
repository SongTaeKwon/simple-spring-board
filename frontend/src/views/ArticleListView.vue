<script setup>
import {ref} from "vue";
import {api} from "@/plugins/api.js";

const articles = ref([]);
const title = ref("");
const content = ref("");

async function fetchArticleList() {
  try {
    const res = await api.get("/articles");
    articles.value = res.data;
  } catch (e) {
  }
}

async function createArticle() {
  try {
    await api.post("/articles", {
      title: title.value,
      content: content.value,
    });
  } catch (e) {
  }
  title.value = "";
  content.value = "";
  await fetchArticleList();
}

fetchArticleList();
</script>
<template>
  <h3>게시글 목록</h3>
  <div>
    <form @submit.prevent="createArticle">
      <div>
        <label for="title">제목</label>
        <input id="title" v-model="title" type="text">
      </div>
      <br>
      <div>
        <label for="content">내용</label>
        <textarea id="content" v-model="content"/>
      </div>
      <button type="submit">등록</button>
    </form>
  </div>
  <ul>
    <li v-for="article in articles" :key="article.id">
      <RouterLink :to="`/articles/${article.id}`">{{ article.id}}번 게시글 - {{ article.title }}</RouterLink>
    </li>
  </ul>
</template>