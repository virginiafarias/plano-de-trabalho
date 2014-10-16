$(document).ready(function() {
	
	moment.locale('pt-br');
	
	loadTaskByDay(moment());
	
	$('#periodo-dia span#before').click(function(event) {
		var date = moment($('#current-data').val()).add(-1, 'days');
		loadTaskByDay(date);
	});
	
	$('#periodo-dia span#after').click(function(event) {
		var date = moment($('#current-data').val()).add(1, 'days');
		loadTaskByDay(date);
	});
	
	$('#periodicidade').change(function(event) {
		var periodicidade = $(this).val().trim();
		if(periodicidade == 'dia') {
			$('#periodo-dia span#before').click(function(event) {
				var date = moment($('#current-data').val()).add(-1, 'days');
				loadTaskByDay(date);
			});
			
			$('#periodo-dia span#after').click(function(event) {
				var date = moment($('#current-data').val()).add(1, 'days');
				loadTaskByDay(date);
			});
		} else if(periodicidade == 'semana') {
			var inicio = moment($('#current-data').val()).startOf('week');
			var termino = moment($('#current-data').val()).endOf('week');
			loadTaskByWeek(inicio, termino);
			
			$('#periodo-semana span#before').click(function(event) {
				var inicio = moment($('#current-data').val()).add(-1, 'weeks').startOf('week');
				var termino = moment($('#current-data').val()).add(-1, 'weeks').endOf('week');
				loadTaskByWeek(inicio, termino);
			});
			
			$('#periodo-semana span#after').click(function(event) {
				var inicio = moment($('#current-data').val()).add(1, 'weeks').startOf('week');
				var termino = moment($('#current-data').val()).add(1, 'weeks').endOf('week');
				loadTaskByWeek(inicio, termino);
			});
		} else if(periodicidade == 'mes') {
			var inicio = moment($('#current-data').val()).startOf('month');
			var termino = moment($('#current-data').val()).endOf('month');
			loadTaskByMonth(inicio, termino);
			
			$('#periodo-mes span#before').click(function(event) {
				var inicio = moment($('#current-data').val()).add(-1, 'months').startOf('month');
				var termino = moment($('#current-data').val()).add(-1, 'months').endOf('month');
				loadTaskByMonth(inicio, termino);
			});
			
			$('#periodo-mes span#after').click(function(event) {
				var inicio = moment($('#current-data').val()).add(1, 'months').startOf('month');
				var termino = moment($('#current-data').val()).add(1, 'months').endOf('month');
				loadTaskByMonth(inicio, termino);
			});
		}
	});
	
});

function loadTaskByDay(data) {
	$('div#periodo-semana').css('display', 'none');
	$('div#periodo-mes').css('display', 'none');
	$('div#periodo-dia').css('display', 'block');
	
	$('label#periodo-dia').text(moment(data).format("DD/MM/YYYY"));
	$('#current-data').val(data);
	$('#current-periodicidade').val('dia');
	var json = {
		"inicio" : data,
		"termino" : data
	};
	$.ajax({
		url: '/plano-trabalho/atividade/listar.json',
		type: "POST",
		data: JSON.stringify(json),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success: function(result) {
			loadBootgrid(result);
		},
		error: function(error) {
			alert('ERROR: ' + error);
		}
	});
}

function loadTaskByWeek(inicio, termino) {
	$('div#periodo-mes').css('display', 'none');
	$('div#periodo-dia').css('display', 'none');
	$('div#periodo-semana').css('display', 'block');
	
	$('label#periodo-semana').text(moment(inicio).format("DD/MM/YYYY") + " a " +  moment(termino).format("DD/MM/YYYY"));
	$('#current-data').val(inicio);
	$('#current-periodicidade').val('semana');
	var json = {
		"inicio" : inicio,
		"termino": termino
	};
	$.ajax({
		url: '/plano-trabalho/atividade/listar.json',
		type: "POST",
		data: JSON.stringify(json),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success: function(result) {
			loadBootgrid(result);
		},
		error: function(error) {
			alert('ERROR: ' + error);
		}
	});
}

function loadTaskByMonth(inicio, termino) {
	$('div#periodo-semana').css('display', 'none');
	$('div#periodo-dia').css('display', 'none');
	$('div#periodo-mes').css('display', 'block');
	
	$('label#periodo-mes').text(moment(inicio).format("MMMM") + " / " +  moment(inicio).format("YYYY"));
	$('#current-data').val(inicio);
	$('#current-periodicidade').val('mes');
	var json = {
		"inicio" : inicio,
		"termino": termino
	};
	$.ajax({
		url: '/plano-trabalho/atividade/listar.json',
		type: "POST",
		data: JSON.stringify(json),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success: function(result) {
			loadBootgrid(result);
		},
		error: function(error) {
			alert('ERROR: ' + error);
		}
	});
}

function loadBootgrid(result) {
	$("#atividades")
		.bootgrid({
			labels: {
	            all: "Todos",
	            infos: "Mostrando {{ctx.start}} - {{ctx.end}} de {{ctx.total}}",
	            loading: "Carregando...",
	            noResults: "Nenhum resultado encontrado!",
	            refresh: "Atualizar",
	            search: "Buscar"
	        },
	        columnSelection: false,
	        formatters: {
	        	"acoes": function(column, row)
	        	{
	        	return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-pencil\"></span></button> " +
	        	"<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-trash-o\"></span></button>";
	        	}
	        	}
		})
		.bootgrid("clear")
		.bootgrid("append", result);
}
