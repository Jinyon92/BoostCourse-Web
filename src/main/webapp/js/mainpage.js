document.addEventListener('DOMContentLoaded', function () {
    init();
});

let categoryId = 0;
let preCount = 0;
let totalCount;

function init() {
    promotionApi();
    productApi("./api/products?start=0", false);
    clickedMenu();
}

function clickedBtn(btn) {
    const addProductCount = 4;

    btn.addEventListener("click", () => {
        preCount += addProductCount;
        sendProductApi(categoryId, true);
        if(preCount+addProductCount >= totalCount) {
            btn.style.display = "none";
        }
    })
}

function clickedMenu() {
    let tabMenu = document.querySelector(".event_tab_lst");
    let moreBtn = document.querySelector(".btn");

    tabMenu.addEventListener("click", (evt) => {
        preCount = 0;
        moreBtn.style.display = "block";
        let tagname = evt.target.tagName;
        if(tagname === "A" || tagname === "SPAN"){
            document.querySelector(".anchor.active").classList.remove("active");
            let dataCategoryId;
            if(tagname === "A"){
                evt.target.classList.add("active");
                dataCategoryId = evt.target.parentElement.getAttribute('data-category');
            } else if(tagname === "SPAN") {
                evt.target.parentElement.classList.add("active");
                dataCategoryId = evt.target.parentElement.parentElement.getAttribute('data-category');
            }
            categoryId = parseInt(dataCategoryId);
            sendProductApi(categoryId, false);
        }
    });

    clickedBtn(moreBtn);
}

function sendProductApi(categoryId, flag) {
    if(categoryId === 0) {
        let productUrl = `./api/products?start=${preCount}`;
        productApi(productUrl, flag);
    } else {
        let productUrl = `./api/products?start=${preCount}&categoryId=${categoryId}`;
        productApi(productUrl, flag);
    }
}

function productApi(productUrl, flag) {

    fetch(productUrl)
        .then(res => res.json())
        .then(data => {
            getCount(data);
            getItemList(data, flag);
        })
}

function getItemList(data, flag) {
    let ulEventbox = document.querySelectorAll(".lst_event_box");
    let productHTML = document
        .querySelector("#itemList")
        .innerHTML;

    let resultHTML1 = ""
    let resultHTML2 = ""
    for (let i = 0, len = data.items.length; i < len; i++) {
        if (i % 2 == 0) {
            resultHTML1 += productHTML
                .replace("{description}",data.items[i].productDescription)
                .replace("{content}", data.items[i].productContent)
                .replace("{placeName}", data.items[i].placeName)
                .replace("{productImageUrl}", data.items[i].productImageUrl);
        } else {
            resultHTML2 += productHTML
                .replace("{description}",data.items[i].productDescription)
                .replace("{content}", data.items[i].productContent)
                .replace("{placeName}", data.items[i].placeName)
                .replace("{productImageUrl}", data.items[i].productImageUrl);
        }
    }

    if (flag) {
        ulEventbox[0].innerHTML += resultHTML1;
        ulEventbox[1].innerHTML += resultHTML2;
    } else {
        ulEventbox[0].innerHTML = resultHTML1;
        ulEventbox[1].innerHTML = resultHTML2;
    }
}

function getCount(data) {
    let pink = document.querySelector(".pink");
    pink.innerHTML = data.totalCount + "개";
    totalCount = data.totalCount;
}

function promotionApi() {
    const promotionUrl = './api/promotions'

    fetch(promotionUrl)
        .then(res => res.json())
        .then(data => {
            let img_ul = document.querySelector(".visual_img");
            let imgCnt = 0;

            data.items.forEach(item => {
                    let li = document.createElement("li");
                    let img = document.createElement("img");
                    img.src = item.productImageUrl;

                    li.appendChild(img);
                    img_ul.appendChild(li);
                    imgCnt++;
                });
            img_ul.style.width = (img_ul.offsetWidth * imgCnt) + "px";
            slideShow(img_ul, imgCnt);
        });
}

function slideShow(img_ul, imgCnt) {
    let curIndex = 0;
    const imgSize = 414;
    
    setInterval(() => {
        img_ul.style.transition = "transform 2s ease-out";
        img_ul.style.transform = "translate3d(-" + imgSize * (curIndex + 1) + "px, 0px, 0px)";
        curIndex++;

        if (curIndex === imgCnt - 1) {
            curIndex = -1;
        }
    }, 2000);
}