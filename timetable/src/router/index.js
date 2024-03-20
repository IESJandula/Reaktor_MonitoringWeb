import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TeacherView from '../views/TeacherView.vue';
import ConvivenciaView from '@/views/ConvivenciaView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/horarios',
      name: 'welcome page',
      component: HomeView
    },
    {
      path: '/horarios/profesores',
      name: 'profesores',
      component: TeacherView
    },
    {
      path: '/horarios/convivencia',
      name: 'convivencia',
      component: ConvivenciaView
    }
  ]
})

export default router
