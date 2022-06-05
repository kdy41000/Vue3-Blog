<template>
  <div>글쓰기</div>

  <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">글제목</label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="글제목을 입력하세요..." v-model="inputVal.listTitle">
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model="inputVal.listContent"></textarea>
</div>

 <button type="button" class="btn btn-primary" @click="onSave()">저장</button>
</template>

<script>
export default {
    name: 'blog-write',
    data(){
        return {
            inputVal : {listTitle:'',listContent:''}
        }
    },
    methods: {
        onSave:async function() {
            const listTitle = this.inputVal.listTitle;
            const listContent = this.inputVal.listContent;

            if(listTitle === '' || listTitle === null || listTitle == undefined) return alert("글제목을 입력해주세요.");
            if(listContent === '' || listContent === null || listContent == undefined) return alert("글내용을 입력해주세요.");

            let param = {};
            param.listTitle = listTitle;
            param.listContent = listContent;

            await this.$http.post('/api/v1/save', param)
            .then(res => {
                if(res > 0) {
                    alert('글이 작성되었습니다.');
                    this.$router.push("/list");
                } else {
                    alert('글쓰기 실패');
                    return;
                }
                console.log("완료",res);
            })
            .catch(err => console.log(err))
        }
    }
}
</script>

<style>

</style>