document.addEventListener('DOMContentLoaded', function () {
    init();
});

function init() {
    /* 예매자 한출평 전체 load */
    comment.fetchApi();
}

let comment = {
    fetchApi : function() {
        const displayInfoId = document.location.href.split('id=')[1];
        const apiUrl = `api/products/${displayInfoId}`;

        fetch(apiUrl)
            .then(res => res.json())
            .then(data => {
                this.loadComments(data.comments, data.displayInfo.productDescription);
                this.loadAvgScore(data.averageScore);
                this.addUrlBackPage(displayInfoId);
            });
    },

    addUrlBackPage : function(displayInfoId) {
        const backButton = document.querySelector('.btn_back');
        backButton.href = `detail?id=${displayInfoId}`;
    },

    loadComments : function(commentsData, productDescription) {
        const joinCount = document.querySelector('.green');
        const commentCount = commentsData.length;
        joinCount.innerText = `${commentCount}건`;
 
        if(commentsData.length === 0) return;
        
        let container = document.querySelector('.list_short_review');
    
        commentsData.forEach(comment => {
            comment.productDescription = productDescription;
            const resultHTML = this.commentsTemplate(comment);
            container.innerHTML += resultHTML;
        });
        
    },

    loadAvgScore : function(avgScore) {
        const score = avgScore.toFixed(1);
        document.querySelector('.text_value').firstElementChild.innerText = score;
        const starScore = score * 20;
        document.querySelector('.graph_value').style.width = `${starScore}%`;
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
}