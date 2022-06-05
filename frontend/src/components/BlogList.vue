<template>
  <table class="table table-light table-hover">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">내용</th>
            <th scope="col">날짜</th>
            <th scope="col">삭제</th>
        </tr>
    </thead>
    <tbody>
         <tr v-for="obj in list" :key="obj">
            <th scope="row">{{obj.listNo}}</th>
              <td class="mouse_cursor">
                <router-link :to="`/detail/${obj.listNo}`">
                  {{obj.listTitle}}
                </router-link>
              </td>
            <td>{{obj.listContent}}</td>
            <td>{{obj.listDate}}</td>
            <td>
                <button type="button" class="btn btn-primary" @click="onDelete(obj.listNo)">삭제</button>
            </td>
        </tr>
    </tbody>
  </table>
  <router-link to="/write">
    <button type="button" class="btn btn-primary">글입력</button>
  </router-link>
</template>

<script>
export default {
    name: 'blog-list',
    data(){
        return {
           list: []
        }
    }, 
    methods: {
        getList:async function() {
            await this.$http.get('/api/v1/getList')
            .then(res => {
                this.list = res;
            })
            .catch(err => console.log(err))
        },
        onDelete:async function(listNo) {
            console.log("listNoL",listNo);
            await this.$http.post('/api/v1/delete',listNo)
            .then(res => {
                if(res > 0) {
                    alert('삭제 되었습니다.');
                    this.getList();
                } else {
                    alert('삭제 실패');
                    return;
                }
            })
            .catch(err => console.log(err))
        }
    },  
    created() {
        this.getList();
    }
}
</script>

<style>
    .table {
        margin-top: 50px;
    }
    .mouse_cursor {
        cursor: pointer;
        text-decoration: underline;
    }
</style>