package fr.treeptik.rest.service;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.base.model.PersistentStock;
import fr.treeptik.rest.dao.StockDAO;

@Service
@Transactional
public class StockMessageServiceImpl implements StockMessageService, SessionAwareMessageListener<ObjectMessage> {

	@Autowired
	private StockDAO stockDAO;

	@Override
	public PersistentStock save(PersistentStock persistentStock) {
		return stockDAO.save(persistentStock);
	}

	@Override
	public List<PersistentStock> list() {
		return stockDAO.list();
	}

	@Override
	public void onMessage(ObjectMessage objectMessage, Session session) throws JMSException {
		PersistentStock persistentStock = (PersistentStock) objectMessage.getObject();
		save(persistentStock);
	}

}
