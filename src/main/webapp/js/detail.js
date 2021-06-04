document.addEventListener('DOMContentLoaded', function () {
    init();
});

function init() {
    product.fetchApi();
}

let product = {
   fetchApi : function() {
       const displayInfoId = document.location.href.split('id=')[1];
       const apiUrl = `api/products/${displayInfoId}`;

       fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            console.log(data);
        })
   }
}