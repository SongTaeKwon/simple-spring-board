<script setup>
import {useRoute, useRouter} from "vue-router";
import {api} from "@/plugins/api.js";
import {ref} from "vue";

const route = useRoute();
const router = useRouter();
const id = route.params.id;
const article = ref({});
const comments = ref([]);

const currentComment = ref(null);
const content = ref("");

async function createComment() {
  try {
    await api.post(`/comments`, {
      articleId: Number(id),
      content: content.value,
    });
  } catch (e) {
  }
  content.value = "";
  await fetchArticle();
}

function editComment(comment) {
  currentComment.value = comment;
  content.value = comment.content;
}

async function updateComment() {
  try {
    if (!currentComment.value) {
      return;
    }
    await api.put(`/comments/${currentComment.value.id}`, {
      content: content.value,
    });
  } catch (e) {

  } finally {
    content.value = "";
    currentComment.value = null;
    await fetchArticle();
  }
}

async function deleteComment(commentId) {

  try {
    await api.delete(`/comments/${commentId}`);
  } catch (e) {
  }
  await fetchArticle();
}

async function deleteArticle() {
  try {
    await api.delete(`/articles/${id}`);
  } catch (e) {

  }
  router.push("/articles");
}

async function fetchArticle() {
  try {
    const response = await api.get(`/articles/${id}`);
    article.value = {
      id: response.data.id,
      title: response.data.title,
      content: response.data.content,
    };
    comments.value = response.data.comments;
  } catch (e) {
  }
}

fetchArticle();
</script>

<template>
  <h3> {{ article?.title }}</h3>
  <p>{{ article?.content }}</p>

  <button @click="router.push(`/articles/${id}/edit`)">수정</button>
  <button @click="deleteArticle">삭제</button>
  <hr>
  <h4>댓글</h4>
  <form v-if="!currentComment" @submit.prevent="createComment">
    <input v-model="content" type="text">
    <button type="submit">제출</button>
  </form>
  <ol>
    <li v-for="comment in comments" :key="comment.id">
      <span v-if="currentComment === comment">
      <input v-model="content" type="text">
      <button @click="updateComment">수정</button>
      </span>
      <span v-else>{{ comment.content }}
        <button @click="editComment(comment)">수정</button>
        <button @click="deleteComment(comment.id)">삭제</button>
      </span>
    </li>
  </ol>
  <hr>
</template>

<style scoped>

</style>