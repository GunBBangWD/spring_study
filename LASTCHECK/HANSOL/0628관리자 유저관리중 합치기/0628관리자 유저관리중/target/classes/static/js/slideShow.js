 const slideShow = document.getElementById('slideShow');
const slides = slideShow.querySelectorAll('.slides li');
const prev = slideShow.querySelector('.prev');
const next = slideShow.querySelector('.next');
let currentSlide = 0;

function goToSlide(slideIndex) {
  slides[currentSlide].classList.remove('visible');
  currentSlide = (slideIndex + slides.length) % slides.length;
  slides[currentSlide].classList.add('visible');
}

function nextSlide() {
  goToSlide(currentSlide + 1);
}

function prevSlide() {
  goToSlide(currentSlide - 1);
}

prev.addEventListener('click', prevSlide);
next.addEventListener('click', nextSlide);

// 자동 슬라이드
setInterval(() => {
  nextSlide();
}, 3000); // 슬라이드가 3초마다 변경됩니다. 시간을 늘리거나 줄이려면 숫자를 변경하세요.

// 초기화
function init() {
  slides[0].classList.add('visible');
}

init();
