function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined)
        url = window.createObjectURL(file)
    else if (window.URL != undefined)
        url = window.URL.createObjectURL(file)
    else if (window.webkitURL != undefined)
        url = window.webkitURL.createObjectURL(file);
    return url;
}

function photoCompress(file, w, objDiv) {
    var ready = new FileReader();
    ready.readAsDataURL(file);
    ready.onload = function () {
        var re = this.result;
        canvasDataURL(re, w, objDiv)
    }
}

function canvasDataURL(path, obj, callback) {
    var img = new Image();
    img.src = path;
    img.onload = function () {
        var that = this;
        var w = that.width,
            h = that.height,
            scale = w / h;
        w = obj.width || w;
        h = obj.height || (w / scale);
        var quality = 0.7;
        var canvas = document.createElement('canvas');
        var ctx = canvas.getContext('2d');
        var anw = document.createAttribute("width");
        anw.nodeValue = w;
        var anh = document.createAttribute("height");
        anh.nodeValue = h;
        canvas.setAttributeNode(anw);
        canvas.setAttributeNode(anh);
        ctx.drawImage(that, 0, 0, w, h);
        if (obj.quality && obj.quality <= 1 && obj.quality > 0) {
            quality = obj.quality;
        }
        const base64 = canvas.toDataURL('image/jpeg', quality);
        callback(base64);
    }
}

function convertBase64UrlToBlob(urlData) {
    var arr = urlData.split(','), mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
    while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
    }
    return new Blob([u8arr], {type: mime});
}