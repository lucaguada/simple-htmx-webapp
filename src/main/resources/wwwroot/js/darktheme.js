//Toggle mode
const element = document.getElementById('theme-button');
const body = document.querySelector('body');

element.addEventListener('click', () => {
  if (body.classList.contains('text-gray-700')) {
    element.innerHTML = "☀️";
    body.classList.remove('text-gray-700');
    body.classList.add('text-gray-300');
    body.classList.remove('bg-gray-100');
    body.classList.add('bg-gray-900');
  } else {
    element.innerHTML = "🌙";
    body.classList.remove('text-gray-300');
    body.classList.add('text-gray-700');
    body.classList.remove('bg-gray-900');
    body.classList.add('bg-gray-100');
  }
});
