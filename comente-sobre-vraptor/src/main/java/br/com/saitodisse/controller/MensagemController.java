package br.com.saitodisse.controller;

import br.com.caelum.vraptor.Resource;
import br.com.saitodisse.dao.DefaultMensagemDao;

@Resource
public class MensagemController {
	private final DefaultMensagemDao _defaultMensagemDao;

	public MensagemController(DefaultMensagemDao defaultMensagemDao) {
		_defaultMensagemDao = defaultMensagemDao;
	}
}
