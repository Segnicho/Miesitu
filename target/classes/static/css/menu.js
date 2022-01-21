const menu_icon = document.querySelector(".menu"); 
const menu = document.querySelector('.header__links');
// const currentPage = window.location.pathname
// const pages = document.querySelectorAll('.header__links__ul__li')


// for (let i = 0; i < pages.length; i++) {
//     link = pages[i].getAttribute("page")
//     if(currentPage == "/" || currentPage ==""){
//         page = document.querySelector('.index')
//         page.classList.toggle("header__topnav__left__socialMediaIcons__links--active")
//         break;
//     }
//     if (link == currentPage){
//         pages[i].classList.toggle("header__topnav__left__socialMediaIcons__links--active")
//         break;
//     }
// }


menu_icon.addEventListener('click', (e)=>{
    menu_icon.classList.toggle('open');
    menu.classList.toggle('show');
    menu.classList.toggle('hide');
    menu.classList.remove('initial')
})

