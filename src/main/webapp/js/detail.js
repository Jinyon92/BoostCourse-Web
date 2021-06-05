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
}

let product = {
   fetchApi : function() {
       const displayInfoId = document.location.href.split('id=')[1];
       const apiUrl = `api/products/${displayInfoId}`;

       fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            this.imageLoad(data.productImages, data.displayInfo);
        })
   },

   imageLoad : function(productImagesData, displayInfoData) {
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
   }
}