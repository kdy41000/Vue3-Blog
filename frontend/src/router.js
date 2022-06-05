import { createWebHistory, createRouter } from 'vue-router';
import BlogHome from './components/BlogHome';
import BlogList from './components/BlogList';
import BlogDetail from './components/BlogDetail';
import BlogWrite from './components/BlogWrite';
import AuthorPage from './components/AuthorPage';
import CommentPage from './components/CommentPage';


const routes = [
    {
        path: "/",
        name: 'BlogHome',
        component: BlogHome,
    },
    {
        path: "/list",
        name: 'BlogList',
        component: BlogList,
    },
    {
        path: "/detail/:listNo",
        name: 'BlogDetail',
        component: BlogDetail,
        children : [
            {
                path: "author",
                component: AuthorPage
            },
            {
                path: "comment",
                component: CommentPage
            }
        ]
    },
    {
        path: "/write",
        name: 'BlogWrite',
        component: BlogWrite,
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;