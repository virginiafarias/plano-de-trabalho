$(document).ready(function() {
	
	//$("#grid-data").bootgrid();
	loadTable();
	$('#periodicidade').change(function(event) {
		
		loadTable();
		
	});
	
	
});

function loadTable() {
	$.ajax({
		url: '/plano-trabalho/atividade/dia/listar.json',
		type: "GET",
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