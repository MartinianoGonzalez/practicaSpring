$(document).ready(function() {
    cargarMangas();
});

async function cargarMangas(){
    const request = await fetch('/listar', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
    });

    const mangas = await request.json();

    let listadoHTML = "";

    for (let manga of mangas){
        let mangaHTML = '<tr><th scope="row">'+manga.id+'</th><td>'+manga.nombre+'</td><td>'+manga.tomo+'</td><td>'+manga.precio+'</td></tr>';
        listadoHTML += mangaHTML;
    };

    document.querySelector("#mangas tbody").outerHTML=listadoHTML;
}

async function agregarManga() {
    let datos = {
        nombre: document.getElementById("txtNombre").value,
        tomo: parseInt(document.getElementById("txtTomo").value),
        precio: parseFloat(document.getElementById("txtPrecio").value)
    };

    if(datos.nombre.length != 0) {
        await fetch('/agregar', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        location.reload();
    } else {
        alert("El nombre no puede estar vacío.");
    }
}

async function eliminarManga() {
    let datos = {
        id: parseInt(document.getElementById("txtId").value)
    };

    const request = await fetch('/id', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const mangas = await request.json();

    if(Object.keys(mangas).length > 0) {

        await fetch('/eliminar', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        location.reload();
    } else {
        alert("El id introducido no corresponde a ningun registro existente.");
    }
}

async function actualizarManga() {
    let datos = {
        id: parseInt(document.getElementById("txtIdUpdate").value),
        nombre: document.getElementById("txtNombreUpdate").value,
        tomo: parseInt(document.getElementById("txtTomoUpdate").value),
        precio: parseFloat(document.getElementById("txtPrecioUpdate").value)
    };

    const request = await fetch('/id', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const mangas = await request.json();

    if(Object.keys(mangas).length > 0) {
        await fetch('/actualizar', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        location.reload();
    } else {
        alert("El id introducido no corresponde a ningun registro existente.");
    }
}

async function buscarMangas(){

    let datos = {
        nombre: document.getElementById("txtNombreSearch").value
    };

    const request = await fetch('/buscar', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const mangas = await request.json();

    console.log(mangas);

    let listadoHTML = "";

    for (let manga of mangas){
        let mangaHTML = '<tr><th scope="row">'+manga.id+'</th><td>'+manga.nombre+'</td><td>'+manga.tomo+'</td><td>'+manga.precio+'</td></tr>';
        listadoHTML += mangaHTML;
    };

    document.querySelector("#mangasBuscar tbody").innerHTML=listadoHTML;
}