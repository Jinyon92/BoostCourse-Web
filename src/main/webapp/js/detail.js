document.addEventListener('DOMContentLoaded', function () {
    init();
});

function init() {
    /* product load */
    product.fetchApi();

    /* Tap Event */
    tap.tabEvent();
}

let tap = {
    tabEvent : function() {
        let moreElement = document.querySelectorAll('.bk_more');
        moreElement.forEach(el => {
            el.addEventListener('click', this.moreTab.bind(this, moreElement));
        })
    },

    /* 펼쳐보기, 접기 click시 */
    moreTab : function(element) {
        document.querySelector('.store_details').classList.toggle('close3');
        element.forEach(el => {
            if(el.style.display === 'none'){
                el.style.display = '';
            } else {
                el.style.display = 'none';
            }
        });
    }
};

let product = {
   fetchApi : function() {
       const displayInfoId = document.location.href.split('id=')[1];
       const apiUrl = `api/products/${displayInfoId}`;

       fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            this.loadImage(data.productImages, data.displayInfo);
            this.loadComments(data.comments);
            this.loadAvgScore(data.averageScore);
            this.addUrlReviewMore(displayInfoId);
        })
   },

   loadAvgScore : function(avgScore) {
       const score = avgScore.toFixed(1);
       document.querySelector('.text_value').firstElementChild.innerText = score;
       const starScore = score * 20;
       document.querySelector('.graph_value').style.width = `${starScore}%`;
   },

   /* 이미지 불러오기 */
   loadImage : function(productImagesData, displayInfoData) {
       let container = document.querySelector('.visual_img');
       document.querySelector('.num.off').firstElementChild.innerText = productImagesData.length;
       document.querySelector('.dsc').innerText = displayInfoData.productContent;

       productImagesData.forEach(image => {
           image.description = displayInfoData.productDescription;
           const resultHTML = this.imageTemplate(image);
           container.innerHTML += resultHTML;
       });
   },

   imageTemplate : function(data) {
       const imageTemplate = document.querySelector('#imageTemplate').innerText;
       const bindTemplate = Handlebars.compile(imageTemplate);
       return bindTemplate(data);
   },

   addUrlReviewMore : function(displayInfoId){
       const reviewMore = document.querySelector('.btn_review_more');
       reviewMore.href = `review?id=${displayInfoId}`;
   },

   /* 예매자 한줄평 첫 로딩 화면 불러오기 */
   loadComments : function(commentsData) {
       const joinCount = document.querySelector('.green');
       const commentCount = commentsData.length;
       joinCount.innerText = `${commentCount}건`;

       if(commentsData.length === 0) return;
       
       let container = document.querySelector('.list_short_review');
       const showCommentCount = 3;
       for(let i=0; i<showCommentCount; i++){
           const resultHTML = this.commentsTemplate(commentsData[i]);
           container.innerHTML += resultHTML;
       }
   },

   commentsTemplate : function(comment){
       const date = new Date(comment.createDate);
       let [year, month, day] = [
           date.getFullYear(),
           date.getMonth() + 1,
           date.getDate()
       ];
       
       if(month < 10) month = `0${month}`;
       if(day < 10) day = `0${day}`;

       comment.score = comment.score.toFixed(1);
       comment.createDate = `${year}.${month}.${day}. 방문`;
       
       const commentTemplate = document.querySelector('#commentTemplate').innerText;
       const bindTemplate = Handlebars.compile(commentTemplate);
       return bindTemplate(comment);
   }
};