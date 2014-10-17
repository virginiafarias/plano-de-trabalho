package br.ufc.bcq.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.bcq.model.Atividade;
import br.ufc.bcq.model.AtividadeJson;
import br.ufc.bcq.service.AtividadeService;

@Controller
@RequestMapping("atividade")
public class AtividadeController {
	
	@Inject
	private AtividadeService atividadeService;
	
	@RequestMapping(value = "/listar")
	public String listar(ModelMap modelMap) {
		return "atividades/listar";
	}
	
	@RequestMapping(value = "/listar.json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Atividade> getAtividades(@RequestBody AtividadeJson json) {
		List<Atividade> atividades = atividadeService.getAtividadesByDiaAndUsuario(json.getInicio(), json.getTermino());
		return atividades;
	}

}
