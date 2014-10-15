package br.ufc.bcq.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.bcq.model.Atividade;
import br.ufc.bcq.service.AtividadeService;

@Controller
@RequestMapping("atividade")
public class AtividadeController {
	
	@Inject
	private AtividadeService atividadeService;
	
	@RequestMapping(value = "/listar")
	public String listar(ModelMap modelMap) {
		modelMap.addAttribute("atividades", atividadeService.getAllAtividades());
		return "atividades/listar";
	}
	
	@RequestMapping(value = "/dia/listar.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Atividade> getAtividadesDiarias() {
		List<Atividade> result = atividadeService.getAtividadesDiarias(new Date());
		return result;
	}
	
	@RequestMapping(value = "/semana/listar.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Atividade> getAtividadesSemanais() {
		return atividadeService.getAtividadesSemanais(new Date());
	}
	
	@RequestMapping(value = "/mes/listar.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Atividade> getAtividadesMensais() {
		return atividadeService.getAtividadesMensais(new Date());
	}

}
