$('#excluirModal').on('show.bs.modal', function(event) {

	var button = $(event.relatedTarget);
	var codigo = button.data('codigo');
	var nome = button.data('nome');

	var modal = $(this);
	var form = modal.find('form');
	// var action = form.attr('action');
	var action = form.data('url-base');

	modal.find('.modal-body #nome').text(nome);
	modal.find('.modal-body #codigo').text(codigo);

	if (!action.endsWith('/')) {
		// action ='';
		// action += '/clientes/';
		action += '/';
	}

	form.attr('action', action + codigo);

});

/**
 *
 * forma atual quando um documento html estiver preparado
 * $(function () {
 * 
 * });
 */

$(document).ready(function() {
	
	$('[rel="tooltip"]').tooltip();
	
	$('[alt="tooltip"]').tooltip(); // Dos campos e-mail e telefone
	// $('#currency').maskMoney({decimal:',',thousands:'.',allowZero:'true'});
	
	$('#currency').mask('000.000,00', {
		reverse : true
	});
	
	$('#datepicker').datepicker({
		format : 'dd/mm/yyyy',
		// startDate: '-3d',
		language : 'pt-BR',
		autoclose : 'true',
		todayHighlight : 'true',
		orientation : 'bottom'
	});
	
	$('#phone').mask('(00) 0000-00009');

	$('.js-mudanca-sexo').on('click', function(event) {
		
		event.preventDefault();

		var button = $(event.currentTarget);
		var buttonUrl = button.attr('href');
		var buttonCodigo = button.data('codigo');      

		var response = $.ajax({
			 url: buttonUrl,
			 method: 'PUT'
			});	
		
		response.done(function (e){

			$('[data-role='+buttonCodigo+']').text(e);
			$('[data-role='+buttonCodigo+']').toggleClass('label-primary label-info');	
			button.hide();
			
		});

		response.fail(function (e){
			alert('Problema de comunicação');
			console.log('Problema de comunicação');
		});		
		
	});

	
	//$('#data_table').DataTable();
	
	
});

/**
 * Se não usar no java script pode usar direto no HTML
 * 
 * =========Bootstrap datepicker=========
 * 
 * data-provide="datepicker" 
 * data-date-format="dd/mm/yyyy"
 * data-date-language="pt-BR" 
 * data-date-autoclose="true"
 * data-date-today-highlight="true" 
 * data-date-orientation="bottom"
 * 
 * =========Jquery maskMoney=========
 * 
 * data-affixes-stay="true" 
 * data-prefix="R$ " 
 * data-thousands="."
 * data-decimal=","
 * 
 */
