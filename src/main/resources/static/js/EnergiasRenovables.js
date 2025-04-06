function abrirModalAgregar() {
  document.getElementById('modalAgregar').classList.add('mostrar');
}

function cerrarModalAgregar() {
  document.getElementById('modalAgregar').classList.remove('mostrar');
}

function abrirModalEditar(id, titulo, descripcion, imagenUrl) {
  document.getElementById('edit-id').value = id;
  document.getElementById('edit-titulo').value = titulo;
  document.getElementById('edit-descripcion').value = descripcion;
  document.getElementById('edit-imagenUrl').value = imagenUrl;
  document.getElementById('modalEditar').classList.add('mostrar');
}

function cerrarModalEditar() {
  document.getElementById('modalEditar').classList.remove('mostrar');
}

// Cerrar modales haciendo clic fuera
window.onclick = function(event) {
  const modalAgregar = document.getElementById('modalAgregar');
  const modalEditar = document.getElementById('modalEditar');
  if (event.target === modalAgregar) cerrarModalAgregar();
  if (event.target === modalEditar) cerrarModalEditar();
}


function abrirModalDesdeAtributos(boton) {
  const id = boton.getAttribute('data-id');
  const titulo = boton.getAttribute('data-titulo');
  const descripcion = boton.getAttribute('data-descripcion');

  document.getElementById('edit-id').value = id || '';
  document.getElementById('edit-titulo').value = titulo || '';
  document.getElementById('edit-descripcion').value = descripcion || '';

  // Actualizar dinámicamente la acción del formulario
  document.getElementById('formEditar').action = "/energias/editar/" + id;

  document.getElementById('modalEditar').classList.add('mostrar');
}