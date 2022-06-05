<template>
  <p>글번호 : {{detail.listNo}}</p>
  <p>글제목 : {{detail.listTitle}}</p>
  <p>날짜 : {{detail.listDate}}</p>
  <p>글내용 : {{detail.listContent}}</p>
  <button type="button" 
    :class="{'comment-btn-show':this.flag, 'comment-btn-hide':!this.flag}" 
    class="btn btn-primary" 
    @click="onShowComment">
    댓글보기
  </button>
  <router-view></router-view>
</template>

<script>
export default {
    name: 'blog-detail',
    data(){
        return {
            detail : {},
            flag: true
        }
    },
    methods: {
        getDetail:async function() {
            const listNo = this.$route.params.listNo;

            await this.$http.get(`/api/v1/getDetail/${listNo}`)
            .then(res => {
              console.log("detail data:",res);
              this.detail = res;

            })
            .catch(err => console.log(err))
        },
        onShowComment:function() {
            this.flag = false;
            this.$router.push(`/detail/${this.detail.listNo}/comment`);
        }
    },
    created() {
        this.getDetail();
    }
}
</script>

<style>
.comment-btn-show {
    display: block;
}
.comment-btn-hide {
    display: none;
}
</style>