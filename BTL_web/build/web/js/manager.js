function tichtoanbo() {
    ochonhet = document.querySelector('#chontatca');
    if (ochonhet.checked) {
        ochon = document.querySelectorAll('#ochon');
        ochon.forEach(otich => {
            otich.checked = true;
        });
    }
}