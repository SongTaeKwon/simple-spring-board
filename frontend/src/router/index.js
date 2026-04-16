import {createRouter, createWebHistory} from 'vue-router'
import ArticleListView from "@/views/ArticleListView.vue";
import ArticleDetailView from "@/views/ArticleDetailView.vue";
import MainView from "@/views/MainView.vue";
import ArticleEditPage from "@/views/ArticleEditPage.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'main',
            component: MainView,
        },
        {
            path: '/articles',
            name: 'articles',
            component: ArticleListView,
        },
        {
            path: '/articles/:id',
            name: 'articleDetail',
            component: ArticleDetailView,
        },
        {
            path: '/articles/:id/edit',
            name: 'articleEdit',
            component: ArticleEditPage
        }
    ],
})

export default router
